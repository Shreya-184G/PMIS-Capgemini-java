
//Date: 06/10/2026
//Pattern Printing 
//Ex.1]
/* public class PatternPrinting{
    public static void main(String[] args) {
        for(int i = 1; i <=5 ; i++){
            for(int j = 1; j<=5; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
} */
//Ex.2] Right-angled Triangle

/* public class PatternPrinting{
    public static void main(String[] args) {
        int n = 4;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
 */
//Ex.3] To print hollow rectangle

/* public class PatternPrinting{
    public static void main(String[] args){
        int m = 4;
        int n= 5;

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
               if(i==1|| j ==1 || i==m|| j == n){
                System.out.print("*");
               }else{
                System.out.print(" ");
               }
            }
            System.out.println();
        }
    }
} */
//Ex.] To print inverted triangle

/* public class PatternPrinting{
    public static void main(String[] args) {
        int n = 4;
        for(int i = 1; i<=n; i++){
            for(int j = n; j>=i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
} */

//Ex.] 

/* public class PatternPrinting{
    public static void main(String[] args) {
        int n = 5;
        for(int i = 1; i<=n ; i++){
            //to print spaces
            for(int j = 1; j<=n-i; j++){
                System.out.print(" ");
            }

            //to print stars
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
 */
//Ex.]
/* 1            row =1
12              row =2           n
123             row = 3
1234            row = 4
12345           row = 5       */
/* public class PatternPrinting{
    public static void main(String[] args) {
        int n = 5;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i ; j++){
              System.out.print(j);
            }
            System.out.println();
        }
    }
} */
/* public class PatternPrinting{
    public static void main(String[] args) {
        int n = 5;
        for(int i = 1; i<=n; i++){
            for(int j = n; j>=i ; j--){
              System.out.print(i);
            }
            System.out.println();
        }
    }
} */
/* public class PatternPrinting{
    public static void main(String[] args) {
        int n = 5;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n-i+1 ; j++){
              System.out.print(j);
            }
            System.out.println();
        }
    }
} */
/* public class PatternPrinting{
    public static void main(String[] args) {
        int n=4;
        for(int i = 1; i<=n;i++){
            for(int j = 1; j<=i ; j++){
                if((i+j)%2==0){
                   System.out.print("1");
                }else{
                    System.out.print("0");
                } 
            }
            System.out.println();
        }
    }
} */

//Calculator to print Area

import java.util.Scanner;

public class PatternPrinting{
    public static void main(String[] args) {
        System.out.println("Choose the shape whose area is to be calculated:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println("1.Square 2.Rectangle 3.Triangle");
        switch(choice){
           case 1:
            System.out.println("Enter the side of Square: ");
            float side = sc.nextFloat();
            System.out.println("Area of Square: "+side*side);
            break;
            case 2:
            System.out.println("Enter the length of Rectangle: ");
            float length = sc.nextFloat();
            float breadth = sc.nextFloat();
            System.out.println("Area of Rectangle: "+length*breadth);
            break;
            case 3:
            System.out.println("Enter the base of Triangle: ");
            float base = sc.nextFloat();
            float height = sc.nextFloat();
            System.out.println("Area of Triangle: "+(0.5)*base*height);
            break;
        }

    }
}
