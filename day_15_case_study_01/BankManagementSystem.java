
import java.sql.*;
import java.util.Scanner;

public class BankManagementSystem {

    static final String URL =
            "jdbc:mysql://localhost:3306/bankdb";
    static final String USER = "root";

    // Replace with your MySQL password
    static final String PASSWORD = "MySQLpassword";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD)) {

                System.out.println("MySQL connected successfully!");

                while (true) {
                    System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
                    System.out.println("1. Create Account");
                    System.out.println("2. View All Accounts");
                    System.out.println("3. Search Account");
                    System.out.println("4. Update Account");
                    System.out.println("5. Delete Account");
                    System.out.println("6. Exit");
                    System.out.print("Enter choice: ");

                    int choice = readInt();

                    switch (choice) {
                        case 1 -> createAccount(con);
                        case 2 -> viewAccounts(con);
                        case 3 -> searchAccount(con);
                        case 4 -> updateAccount(con);
                        case 5 -> deleteAccount(con);
                        case 6 -> {
                            System.out.println("Thank you!");
                            return;
                        }
                        default -> System.out.println("Invalid choice!");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found. Check the JAR file.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // CREATE
    static void createAccount(Connection con) throws SQLException {
        System.out.print("Enter holder name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine().trim();

        System.out.print("Enter opening balance: ");
        double balance = readDouble();

        if (name.isEmpty() || phone.isEmpty() || balance < 0) {
            System.out.println("Invalid details!");
            return;
        }

        String sql = "INSERT INTO accounts "
                + "(holder_name, phone, balance) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setDouble(3, balance);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    System.out.println("Account created! Account number: "
                            + rs.getInt(1));
                }
            }
        }
    }

    // READ ALL
    static void viewAccounts(Connection con) throws SQLException {
        String sql = "SELECT * FROM accounts ORDER BY account_no";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            boolean found = false;

            while (rs.next()) {
                found = true;
                printAccount(rs);
            }

            if (!found) {
                System.out.println("No accounts found.");
            }
        }
    }

    // READ ONE
    static void searchAccount(Connection con) throws SQLException {
        System.out.print("Enter account number: ");
        int id = readInt();

        String sql = "SELECT * FROM accounts WHERE account_no = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    printAccount(rs);
                } else {
                    System.out.println("Account not found.");
                }
            }
        }
    }

    // UPDATE
    static void updateAccount(Connection con) throws SQLException {
        System.out.print("Enter account number: ");
        int id = readInt();

        System.out.print("Enter new name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter new phone: ");
        String phone = sc.nextLine().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            System.out.println("Name and phone cannot be empty.");
            return;
        }

        String sql = "UPDATE accounts SET holder_name = ?, phone = ? "
                + "WHERE account_no = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0
                    ? "Account updated successfully."
                    : "Account not found.");
        }
    }

    // DELETE
    static void deleteAccount(Connection con) throws SQLException {
        System.out.print("Enter account number: ");
        int id = readInt();

        System.out.print("Confirm deletion (yes/no): ");
        String confirm = sc.nextLine().trim();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        String sql = "DELETE FROM accounts WHERE account_no = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0
                    ? "Account deleted successfully."
                    : "Account not found.");
        }
    }

    static void printAccount(ResultSet rs) throws SQLException {
        System.out.println("----------------------------");
        System.out.println("Account No: " + rs.getInt("account_no"));
        System.out.println("Name: " + rs.getString("holder_name"));
        System.out.println("Phone: " + rs.getString("phone"));
        System.out.println("Balance: " + rs.getBigDecimal("balance"));
        System.out.println("----------------------------");
    }

    static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }

    static double readDouble() {
        while (true) {
            try {
                double amount =
                        Double.parseDouble(sc.nextLine().trim());

                if (Double.isFinite(amount) && amount >= 0) {
                    return amount;
                }
            } catch (NumberFormatException e) {
                // Ask again
            }
            System.out.print("Enter a valid non-negative amount: ");
        }
    }
}
