import java.util.*;

public class Functions {
//1. 
    public static void printHelloWorld(){
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
    }

//2. addition function
public static int calculateSum(int num1, int num2) // parameters or formal parameters
{
int add = num1 + num2;
return add;
}
//3. swap two numbers
public static void swapNumbers(int num1, int num2){
int temp = num1;
num1 = num2;
num2 = temp;
System.out.println(" a  is: "+num1);
System.out.println(" b  is: "+num2);
}
//4. Product of two numbers
public static int productOfab(int num1, int num2){
int mul = num1 * num2 ;
return mul;
}
//5. Factorial of a number
public static int fact(int num1){
    int fact = 1;
    for (int i = 1; i <= num1; i++) {
        fact = fact * i;

    }
    return fact;
}

    public static void main(String[] args) {
//1.
        //printHelloWorld();
//------------------------------------------------------------------
//2.
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int sum =  calculateSum(a, b); // arguments or actual parameters
        // System.out.println("Sum of a & b is: "+sum);
//------------------------------------------------------------------
//3.
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // swapNumbers(a, b); // arguments or actual parameters
        
//------------------------------------------------------------------
//4.
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int product = productOfab(a, b);
        // System.out.println("product of a & b is: "+product);

//------------------------------------------------------------------
//5.
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int result = fact(n);
        // System.out.println("Factorial of "+ n + " is: "+result);


//------------------------------------------------------------------
//6.
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int r = sc.nextInt();
        // int bincoe = fact(n)/(fact(r) * fact(n - r));
        // System.out.println("Binomial Coeff of given "+n+" and "+ r+" is "+bincoe);

//------------------------------------------------------------------


    }
}
