import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
//         System.out.print("Hello, World!\n");
//         System.out.println("Hello Ajinkya\n");

//         System.out.println("* * * *");
//         System.out.println("* * *");
//         System.out.println("* *");
//         System.out.println("*\n");

//         int a = 5;
//         int b = 10;
// System.out.println(a);
// System.out.println(b);

// String name = "TONY STARK";
// System.out.println(name);

// // variable values can be changed.
// a = 50;
// System.out.println(a);

 //sum of two numbers

    // int c = 5;
    // int d = 10;
    // int sum = c+d;
    // System.out.println("sum is " + sum);

// take input from user 
    //  Scanner sc = new Scanner(System.in);
    // String input = sc.next();
    // System.out.println(input);

//use nextLine to print next line also
    // String name = sc.nextLine();
    // System.out.println(name);

// use nextInt to take input as a number
        // int number = sc.nextInt();
        // System.out.println(number);

//use nextFloat to take input as a float
        // float price = sc.nextFloat();
        // System.out.println(price);

// take value from user & then add

        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int sum = a + b ;
        // System.out.println("sum of a & b is "+sum);

// Area of Circle

        // float rad = sc.nextInt();
        // float area = (3.14f * rad * rad);
        // System.out.println(area);

//--------------------------------------------------------------------------------------------------

//QNA
//In a program,input 3 numbers: A,B and C. You have to output the average of these 3 numbers.

    // Scanner sc  = new Scanner(System.in);
    // int a = sc.nextInt();
    // int b = sc.nextInt();
    // int c = sc.nextInt();
    // int avg =( a + b + c )/3 ;
    // System.out.println(avg);

//--------------------------------------------------------------------------------------------------
//(side ^2) --> area of square

    // Scanner sc = new Scanner(System.in);
    // int side = sc.nextInt();
    // int Area = (side * side);
    // System.out.println("Area of square is "+Area);

//--------------------------------------------------------------------------------------------------
/*Enter cost of 3 items from the user (using float data type)-a pencil,a pen and an eraser.
 You have to output the total cost of the items back to the user as their bill.
 (Add on : You can also try adding 18% gst tax to the items in the bill as an advanced problem)
 */

    // Scanner sc = new Scanner(System.in);
    // float pencil = sc.nextFloat();
    // float pen = sc.nextFloat();
    // float eraser = sc.nextFloat();

    // float total = (pencil + pen + eraser) + ((pencil + pen + eraser) * 18/100);
    // System.out.println(total);

//--------------------------------------------------------------------------------------------------

// byte b = 4;
// char c = 'a';
// short s = 512;
// int i = 1000;
// float f = 3.14f;
// double d = 99.9954;
// int result = (int)((f *b ) + ( i % c) - ( d * s));
// System.out.println(result);

//--------------------------------------------------------------------------------------------------
    
// int $ = 24;
// System.out.println($);
//--------------------------------------------------------------------------------------------------
//pre-increment ++a --> first value of a will change -> then assign it to a. (1.value change 2.value use)

// int a = 10;
// int b = ++a;
// System.out.println(a);
// System.out.println(b);
//--------------------------------------------------------------------------------------------------
//post-increment a++ --> 1. value use 2. value change

// int a = 10;
// int b = a++;
// System.out.println(a);
// System.out.println(b);
// -------------------------
// int a = 10;
// int b = ++a;
// System.out.println(a);
// System.out.println(b);

//--------------------------------------------------------------------------------------------------
//see the output -
//1.
// int x =2, y= 5;
// int exp1 = (x * y / x);
// int exp2 = (x * (y/x));

// System.out.println(exp1 + ',');
// System.out.println(exp2);

//2.
int x = 200, y = 50, z = 100;
if(x > y && y > z){
    System.out.println("Hello");
}
if(z > y && z < x){
    System.out.println("Java");
}
if((y+200) < x && (y+150) < z){
    System.out.println("Hello Java");
}
//3.
// int x, y, z;
// x = y = z = 2;
// x += y;
// y -= z;
// z /= (x + y);
// System.out.println(x + " " + y + " " + z);
//4.
// int x = 9, y = 12;
// int a = 2, b = 4, c = 6;
// int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
// System.out.println(exp);

//--------------------------------------------------------------------------------------------------
}
}
