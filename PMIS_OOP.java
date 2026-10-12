//Date: 08/10/2026 : Thursday
class Car{
    String color;
    String Brand;
    int speed;

    Car(String color, String Brand,int speed){
        this.color = color;
        this.Brand = Brand;
        this.speed = speed;
    }

    void displayInfo(){
        System.out.println("Color: "+color+ ", Brand: "+Brand+ ", speed: "+speed+" Km/hr");
    }
    void accelerate(int incr){
        int incrementedSpeed = incr;
        speed += incrementedSpeed;

        System.out.println("Increased Speed is :"+speed+" Km/hr");
    }
}
public class Main{
    public static void main(String[] args) {
        Car c1 = new Car("Blue","BMW",360);
        c1.displayInfo();
        c1.accelerate(50);
    }
}

//Bank Management System
//Ex.1] 1st way
/* import java.util.Scanner;

class Bank{
    int deposit, withdraw;
    void deposit(int balance,int deposit){
        this.deposit = deposit;
        if(balance<10000){
            System.out.println("NEED TO DEPOSIT SOME AMOUNT.CANNOT WITHDRAW");
            int totalAmount = balance + deposit;
            System.out.println("Amount after deposit: "+totalAmount);
        }
    }
    void withdraw(int balance,int withdraw){
        this.withdraw = withdraw;
        if(balance>10000){
            System.out.println("CAN WITHDRAW AMOUNT.");
            int remainingAmount = balance + withdraw;
            System.out.println("Amount after withdraw: "+remainingAmount);
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = sc.nextInt();
        Bank b1 = new Bank();
        b1.deposit(balance,5000);
        b1.withdraw(balance,5000);
        sc.close();
    }
} */
//Ex.1] 2nd way

class BankAccount{
    String accountHolder;
    double balance;

    BankAccount(String accountHolder , double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount){
        balance += amount;
        System.out.println("Deposited Amount: "+amount);
        System.out.println("Balance after deposit: "+balance);
    }
    void withdraw(double amount){
        if(balance>amount){
            balance-=amount;
            System.out.println("Amount withdrawn: "+amount);
            System.out.println("Balance after withdraw: "+balance);
        }else{
            System.out.println("Insufficient Balance .Given Amount cannot be withdrawn.");
        }
    }
    void displayInfo(String accountHolder, double balance){
        System.out.println("AccountHolder name : "+accountHolder);
        System.out.println("Account Balance: "+balance);
    }
}

public class Main{
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("Shreya",100000);
        BankAccount b2 = new BankAccount("Aarya",250000);
        b1.deposit(50000);
        b2.withdraw(50000);
        b1.displayInfo("Shreya",100000);
    }
}
//Problem Set 1 : Ex.1]The Campus Coffee Cart Wallet

/* class CoffeeWallet{
    String customerName;
    double balance;

    CoffeeWallet(String customerName, double balance){
        this.customerName = customerName;
        this.balance = balance;
    }
    void addFunds(double amount){
        balance += amount;
        System.out.println("Added Rs.: "+amount);
        System.out.println("Balance: "+balance);
    }
    void purchase(double amount){
        if(amount>balance){
            balance-= amount;
            System.out.println("Purchase Successful!");
            System.out.println("Amount deducted: "+amount);
            System.out.println("Balance: "+balance);
        }else{
            System.out.println("Insufficient Balance!");
        }
        void displayInfo(){
            System.out.println("Customer Name: "+customerName+" | Balance: "+balance);
        }
    }
}
public class Main{
    public static void main(String[] args) {
        CoffeeWallet c1 = new CoffeeWallet("Shreya",10000);
        c1.displayInfo();
        c1.addFunds(200);
        c1.purchase(150); 
        c1.purchase(amount:800);
        c1.displayInfo();
        
    }
}
 */
//Problem Set 1] Ex. 2]The Academy Admissions Portal

/* class StudentProfile{
    String fullName;
    int studentID;
    double finalScore;

    StudentProfile(String fullName, int studentID, double finalScore){
       //Entrance exam takers
       this.fullName = fullName;
       this.studentID = studentID;
       this.finalScore = finalScore;
    }

    StudentProfile(String fullName, int studentID ){
       //Direct Walk-ins
       this.fullName = fullName;
       this.studentID = studentID;
       this.finalScore = 0.0;
    }

    char getGrade(){
        if(finalScore>=90){
            return 'A';
        }else if(finalScore>=75){
            return 'B';
        }else if(finalScore>=50){
            return 'C';
        }else{
            return 'F';
        }
    }
    void printReportCard(){
        System.out.println("Name: "+fullName);
        System.out.println("Student ID: "+studentID);
        System.out.println("Final Score: "+finalScore);
        System.out.println("Grade: "+getGrade());
        System.out.println("------------------------");
    }
}
public class Main{
    public static void main(String[] args) {
       //Exam taker
       StudentProfile s1 = new StudentProfile("Shreya",1,94.00);
       //Walk-ins
       StudentProfile s2 = new StudentProfile("Null",2);
       s1.printReportCard();
       s2.printReportCard();
    }
} */
// Problem Set 2 :Ex.1] Employee Management (Encapsulation & Constructors)

/* class Employee{
    //Private fields (Encapsulation)
    private int id;
    private String name;
    private double salary;
    //Getters
    public Employee(int id,String name, double salary){
        this.id = id;
        this.name = name;
        if(salary >=0){
            this.salary = salary;
        }else{
            this.salary = 0.0;
        }
    }
    //3.Getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    //4.Setter with validation
    public void setSalary(double salary){
        if(salary>=0){
            this.salary = salary;
        }else{
            System.out.println("Error: Salary cannot be negative.");
        }
    }
    //5.Business Logic Method
    public void giveRaise(double percent){
        if(percent > 0){
            double raiseAmount = this.salary * (percent / 100.0);
            this.salary += raiseAmount;
            System.out.println(name+" received a "+percent+" % raise. New Salary: Rs. "+this.salary);
        }else{
            System.out.println("Raise percentage must be positive");
        }  
    }
}
public class Main{
    public static void main(String[] args){
        Employee emp = new Employee(101,"Shreya",1200000.00);
        System.out.println("Initial Salary: "+emp.getSalary());
        //Apply raise
        emp.giveRaise(8);
        emp.setSalary(-25000);
        //Final check
        System.out.println("Final Verified Salary: "+emp.getSalary());
    }
} */
//Problem Set 2 :Ex.2] Vehicle Toll System (Inheritance & Polymorphism)
/* //1. Base Class
class Vehicle{
    protected String registrationNumber;

    public Vehicle(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public double calculateToll(){
        return 50.0; //Base Toll
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }
}
//2. Child Class 1 : Car

class Car extends Vehicle{
    public Car(String registrationNumber){
        super(registrationNumber); //Calls Vehicle's constructor
    }
    @Override 
    public double calculateToll(){
        return 50.0 + 20.0; //Flat Toll for cars = 70.0
    }
}

//Child Class 2: Truck

class Truck extends Vehicle{
    private int axles;

    public Truck(String registrationNumber, int axles){
        super(registrationNumber);
        this.axles = axles;
    }
    @Override 
    public double calculateToll(){
        return 100.0 + (axles * 50.0);//Base + per axle charge
    }
}
//4. Test Runner

public class Main{
    public static void main(String[] args) {
        Vehicle car = new Car("MH-04-SG-1234");
        Vehicle truck = new Truck("MH-11-PQ-1804",4);

        System.out.println("Vehicle: "+car.getRegistrationNumber()+" | Toll Due: Rs. "+car.calculateToll());
        System.out.println("Vehicle: "+truck.getRegistrationNumber()+" | Toll Due: Rs. "+truck.calculateToll());
    }
} 
    Time Complexity: O(1) and Space Complexity: O(1)
    */

//Homework :
//Ex.1] Abstraction

/* abstract class PaymentGateway{
    void printReceipt(){
        System.out.println("Receipt generated.");
    }
    abstract void processPayment(double amount);
}

class UPIPayment extends PaymentGateway{
    @Override
    void processPayment(double amount){
        System.out.println("Processing Rs.: "+amount+ " via UPI QR Code");
    }
}

class CreditCardPayment extends PaymentGateway{
    @Override 
    void processPayment(double amount){
        System.out.println("Processing Rs.: "+amount+" via Card Swipe and OTP.");
    }
}

public class Abstraction{
    public static void main(String[] args) {
        PaymentGateway payment = new UPIPayment();
        payment.processPayment(100.00);
        payment.printReceipt();
        PaymentGateway payment1 = new CreditCardPayment();
        payment1.processPayment(100.00);
        payment1.printReceipt();
    }
} 

//Time Complexity: O(1) and Space Complexity: O(1)
*/

//Date : 09/10/2026 : Friday

//[1] Single Inheritance
/* class Animal{
    void eat(){
        System.out.println("This Animal eats Food.");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("The Dog barks.");
    }
}
public class Main{
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();
        myDog.bark();
    }
}
 */
//[2] Multi-level Inheritance

/* class ElectronicDevices{
    void poweron(){
        System.out.println("Device power on.");
    }
}
// Child Class 1
class MobilePhone extends ElectronicDevices{
    void makecall(){
        System.out.println("Make a call.");
    }
}
//Child Class 2
class SmartPhone extends MobilePhone{
    void browse(){
        System.out.println("Browse Data.");
    }
}

public class Main{
    public static void main(String[] args) {
        SmartPhone samsung = new SmartPhone();
        samsung.makecall();
        samsung.browse();
        samsung.poweron();
    }
} */

//[3] Hierarchical Inheritance
//common parent class
/* class Shape{
    String color = "Blue";
}
//child class 1
class Circle extends Shape{
    void drawCircle(){
        System.out.println("Draw a "+color+ " Circle.");
    }
}

class Rectangle extends Shape{
    void drawRectangle(){
        System.out.println("Draw a "+color+" Rectangle.");
    }
}

public class Main{
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Rectangle r1 = new Rectangle();
        c1.drawCircle();
        r1.drawRectangle();
    }
} */
//[4] Multiple Inheritance Issue : Resolution is Interfaces

/* interface Mother{
    void message();
}
interface Father{
    void message();
}

class Child implements Mother,Father{
    @Override 
    public void message(){
        System.out.println("Grateful to Mom and Dad!");
    }
}

public class Main{
    public static void main(String[] args) {
        Child c = new Child();
        c.message();
        Mother m = new Child();
        c.message();
        Father f = new Child();
        f.message();
    }
} */
//Ex.1] super() keyword
/* class Employee{
    double salary = 30000;
}
class Manager extends Employee{
    double salary = 60000;
    void displaySalary(){
        System.out.println("Manager Salary: "+salary);
        System.out.println("Employee Salary: "+super.salary);
    }
}
public class Main{
    public static void main(String[] args) {
        Manager m = new Manager();
        m.displaySalary();
    }
}
*/
//Ex.2] super() keyword

/* class Animal{
    void eats(){
        System.out.println("Animal eats.");
    }
}
class Dog extends Animal{
    void eats(){
        System.out.println("Dog eats.");
        super.eats();
    }
} 
public class Main{
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eats();
    }
} 
*/
//Ex.3] Bank Management System
/* class BankAccount{
    String accountHolder;

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    void displayDetails(){
        System.out.println("Accountholder Name: "+accountHolder);
    }
}
class SavingsAccount extends BankAccount{
    double interestRate = 4.5;

    SavingsAccount(String accountHolder) {
        super(accountHolder);
    }
    @Override 
    void displayDetails(){
        System.out.println("Interest Rate: "+interestRate+" %");
        super.displayDetails();
    }
} 
public class Main{
    public static void main(String[] args) {
        SavingsAccount s1 = new SavingsAccount("Shreya");
        s1.displayDetails();
    }
}
*/
/* Ex.4] Problem statement:
Create a Java program using inheritance with two classes: Animal and Dog.
Requirements:
1. Create a parent class Animal with:
- A variable String name.
- A method eat() that prints "Animal is eating".
2. Create a child class Dog that extends Animal with:
- A method bark() that prints "Dog is barking".
3. In the main() method:
- Create an object of Dog.
- Assign "Tommy" to its name.
- Print the dog's name.
- Call both eat() and bark().
 */

/* class Animal{
    String name;
    void eat(){
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("Dog is barking");
        super.name = "Tommy";
        System.out.println(name);
    }
} 
public class Main{
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
} 
*/
/* Ex.5] Practice question: Employee and Manager 🧑‍💻
Problem statement
Create a Java program with a parent class Employee and a child class Manager.
1. Parent class: Employee
- Variables: String name and double salary.
- Create a constructor that initializes both variables.
- Create a method displayDetails() that prints the employee's name and salary.
2. Child class: Manager
- Inherit from Employee.
- Add a variable String department.
- Create a constructor that accepts name, salary, and department.
- Use super() to initialize the parent's variables.
- Override displayDetails() to display the employee details, department, and the message "Role: Manager".
- Use super.displayDetails() instead of printing the name and salary again.
3. Main class
Create a Manager object with these values:
- Name: "Anish"
- Salary: 50000
- Department: "IT"
Call displayDetails(). */

/* class Employee{
    String name;
    double salary;

    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    void displayDetails(){
        System.out.println("Employee's name: "+name+" | Salary: "+salary);
    }

}
class Manager extends Employee{
    String department;
    Manager(String name,double salary, String department){
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    super.name = "Shreya";
    super.salary = 100000.00;
    super.department = "IT";
    @Override 
    void displayDetails(){
        System.out.println("Employee Name: "+name+ " | Employee salary: "+salary+ " | Employee Department: "+department);
        super.displayDetails();
    }
} 
public class Main{
    public static void main(String[] args) {
        Manager m = new Manager("Shreya",100000.00,"Electronics");
        m.displayDetails();
    }
} 
*/
