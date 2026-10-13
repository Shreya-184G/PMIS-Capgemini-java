// 13/10/2026 : Tuesday

//Exception Handling in Java
//Ex.1]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 30;
        int b = 0;

        try {
            int result = a/b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero.Divide by zero Arithmetic Exception.");
        }
    }
}
 */
//Ex.2]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 30;
        int b = 0;

        try {
            int result = a/b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero. Divide by zero Arithmetic Exception.");
        }
        System.out.println("Program continues...");
    }
} */
//Ex.3]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 30;
        int b = 0;

        try {
            int result = a/b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero. Divide by zero Arithmetic Exception.");
            System.out.println(e.getMessage());
        }
       
    }
} 
 */
//Ex.4]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 30;
        int b = 0;

        try {
            int result = a/b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero. Divide by zero Arithmetic Exception.");
            System.out.println("Arithmetic Exception. "+e.getMessage());
        }
       
    }
}  */
//Ex.5]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        
        try {
            int result = 10/0;
            System.out.println(result);
            int[] numbers = {10,20,30};
            System.out.println(numbers[5]);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Array Index");
        }catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero. Divide by zero Arithmetic Exception.");
        }
       
    }
} 
 */
//Ex.6]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        
        try {   
            int[] numbers = {10,20,30};
            System.out.println(numbers[5]);
            int result = 10/0;
            System.out.println(result);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Array Index");
        }catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero. Divide by zero Arithmetic Exception.");
        }
    }
} 
 */
//Ex.7]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        
        try {   
            int[] numbers = {10,20,30};
            System.out.println(numbers[5]);
            int result = 10/0;
            System.out.println(result);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Array Index");
        }catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero. Divide by zero Arithmetic Exception.");
        }
    }
}  */
//Using finally keyword
//Ex.8]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        
        try {   
            int result = 10/5;
            System.out.println(result);

        }catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero. Divide by zero Arithmetic Exception.");
        }finally{
            System.out.println("Finally Block executed.");
        }

    }
}  */
//Using throw keyword
//Ex.9]

/* import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        
        System.out.print("Enter Age: ");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if(age < 0){
            throw new IllegalArgumentException(
               "Age cannot be negative"
            );
        }
        System.out.println("Age: "+age);

    }
}  */
//throws keyword
//Ex.10]
/* import java.io.*;
public class ExceptionHandling {
    static void readFile() throws IOException{
        FileReader file = new FileReader("data.text");
        System.out.println("File opened.");
    }
    public static void main(String[] args) {
        try{
            readFile();
        }catch(IOException e){
            System.out.println("Could not find the file");
        }
    }
}  */
//Ex.11]
/* public class ExceptionHandling {
    public static void main(String[] args) {
        
       int balance = 5000;
       int withdrawal = 7000;
       try {
           if(withdrawal > balance){
                throw new IllegalArgumentException(
                    "Insufficient balance."
                );
            } 
            balance-= withdrawal;
            System.out.println("Withdrawal was successful");
            System.out.println("Remaining Balance: "+balance);
       }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
       }
       System.out.println("Program completed.");
    }
} 
 */
//Task 1:Problem Statement:

/* Write a program that takes two integer inputs from the user and calculates their division. 
If the second number is zero, handle the resulting ArithmeticException gracefully and 
print an error message instead of crashing. */

/* import java.util.Scanner;

public class ExceptionHandling{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1: ");
        int a = sc.nextInt();
        System.out.println("Enter num2: ");
        int b = sc.nextInt();

        try {
            int result = a/b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
            System.out.println("ArithmeticException"+e.getMessage());
        }
    }
} */

