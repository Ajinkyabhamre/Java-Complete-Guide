import java.util.*;
public class loops {
    public static void main(String [] args){
    //while loo
    // print hello world 100 times.

    // int value = 0;
    // while (value < 10) {
    //     System.out.println("Hello World !");
    //     value++;
    // }
    // System.out.println("hello world is printed 10 times");
//------------------------------------------------------------------------------------------
//print numbers from 1 to 10.
    // int value =1;
    // while (value <= 10) {
    //     System.out.print(value + " ");
    //     value++;
    // }
//------------------------------------------------------------------------------------------
//print numbers from 1 to n.
    // Scanner sc = new Scanner(System.in);              
    // int range = sc.nextInt();
    // int counter = 1;
    // while (counter <= range) {
    //     System.out.print(counter + " " );
    //     counter++;
    // }
    // System.out.println();

//------------------------------------------------------------------------------------------
//print sum of n natural numbers
// Scanner sc = new Scanner(System.in);
// int range = sc.nextInt();
// int count = 1;
// int sum = 0;
// while (count <= range) {
//      sum += count;
//     count++;
// }
// System.out.println(sum);
//------------------------------------------------------------------------------------------
//for loop --> print Square with *.
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    // for (int i = 1; i <= n; i++) {
    // System.out.println("* * * *");
    
    // }


//------------------------------------------------------------------------------------------
//print a reverse of a number

// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// while (num > 0) {
//         int lastdigit = num %10;
//         System.out.print(lastdigit );
//         num = num/10;    
//     }
// System.out.println();

//------------------------------------------------------------------------------------------
// reverse a given number
// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// int rev = 0;
// while (num > 0) {
//     int lastdigit = num % 10; 
//     rev = ( rev * 10 ) + lastdigit;
//         num = num/10;
// }
// System.out.println(rev);

//------------------------------------------------------------------------------------------
//do-while loop
    // int counter = 1;
    // do {
    //     System.out.println("Hello World");
    //     counter++;
    // } while (counter <= 3);


//------------------------------------------------------------------------------------------
//Break Statement

    // for (int i = 0; i <= 5; i++) {
    //     if (i == 3) {
    //         break;
    //     }
    //     System.out.println(i);
    // }

    // System.out.println("I am out of this loop !");

//------------------------------------------------------------------------------------------
//Q. break out of program if user enters multiple of 10

    // Scanner sc = new Scanner(System.in);
    // int num;
    // do {
    //System.out.println("Enter your number: ");    
    //      num = sc.nextInt();
    //     if((num%10) == 0)
    // break;
    //     System.out.println(num);
        
    // } while (true);

    // System.out.println("I'm OUT");

//------------------------------------------------------------------------------------------
// what is continue ?

    // for (int i = 0; i <= 5; i++) {
    //     if (i == 3) {
    //         continue;
    //     }
    //     System.out.println(i);
    // }

//------------------------------------------------------------------------------------------
// print entered numbers by users, skip multiples of 10
    // Scanner sc = new Scanner(System.in);

    // do {
    //     int num = sc.nextInt();
    //     if(num % 10 ==0)
    //     continue;
    //     System.out.println("Entered num is " + num);
    // } while (true);
//------------------------------------------------------------------------------------------
//check a number if its prime or not
    // Scanner sc = new Scanner(System.in);
    // int num = sc.nextInt();

    // if(num == 2){
    //     System.out.println("n is prime");
    // }else{
    //     boolean isPrime = true;
    //     for (int i = 2; (i <= num - 1); i++) {
    //         // more optimised way would be = (int i = 2; i < Math.sqrt(n); i++)
    //         if (num % i == 0) {
    //             isPrime = false;
    //         }
    //     }
    //     if (isPrime == true) {
    //         System.out.println("n is Prime");
    //     }else{
    //         System.out.println("n is not Prime");
    //     }
    // }


//------------------------------------------------------------------------------------------
//Q. Write a program that reads a set of integers, and then prints the sum of the even and odd integers
    // Scanner sc = new Scanner(System.in);
    // int n = 1;
    // int EvenSum = 0;
    // int OddSum = 0;
    // while(n > 0){
    //      n  = sc.nextInt();
    //      if(n == 1)
    //      OddSum += n;
    //     else if(n%2 == 0){
    //          EvenSum += n;
    //     }else{
    //         OddSum += n;
    //     }
    // System.out.println("Even Sum is : "+ EvenSum);
    // System.out.println("Odd Sum is : "+OddSum);

    // }

//------------------------------------------------------------------------------------------
//Q. Write a program to find the factorial of any number entered by the user.
Scanner sc = new Scanner(System.in);
int num = sc.nextInt();
int fact = 1;
for (int i = 1; i <= num; i++) {
    fact = fact * i;
}
System.out.println("Factorial of " + num + " is " + fact);


//------------------------------------------------------------------------------------------
//Q. Write a program to print the multiplication table of a number N, entered by the user.
    // Scanner sc = new Scanner(System.in);
    // int num = sc.nextInt();
    // for (int i = 1; i <= 10 ; i++) {
    //     System.out.println(num + " * " +i + " = "+ num * i  );
    // }


//------------------------------------------------------------------------------------------


  }
}
