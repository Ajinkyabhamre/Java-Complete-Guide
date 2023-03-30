import java.util.*;
public class condStatements {
    public static void main(String[] args){
//if else
// int age = 16;
// if(age > 18)
// {
// System.out.println("adult: drive, vote"); 
// }
// if(age>13 && age<18){
//  System.out.println("teenager");
// }
// else{
//  System.out.println("not adult");
// }
//------------------------------------------------------------------

//print Odd-Even
// Scanner sc  = new Scanner(System.in);
// int value =  sc.nextInt();

// if(value % 2 == 0){
//     System.out.println("value is even");
// }else{
//     System.out.println("value is odd");
// }


//------------------------------------------------------------------
//else-if condition

        // int age = 13;
        // if (age >= 18) {
        //     System.out.println("person is Adult");
        // }
        // else if(age>=13 && age<=18){
        //     System.out.println("Person is teenager");
        // }else{
        //     System.out.println("person is child");
        // }

//----------------------------------------------------------
// print income tax for apt situation (tax calculator)

       
    //     Scanner sc = new Scanner(System.in);
    //     int income = sc.nextInt();
    //     int tax;
    //     if(income < 500000){
    //         tax = 0;
    //     }else if(income >= 500000 && income <= 1000000){
    //         tax = (int)(income * 0.2);
    //     }else{
    //         tax = (int)(income * 0.3);
            
    //     }
    // System.out.println("Your Tax is:  " + tax);


//------------------------------------------------------------------
// print largest of 3 numbers

    // Scanner sc = new Scanner(System.in);
    // int a = sc.nextInt();
    // int b = sc.nextInt();
    // int c = sc.nextInt();

    // if((a > b) && (a > c)){
    
    // System.out.println("a= "+a+" is Greater");
    
    // }else if(b > c){
    //     System.out.println("b= " +b +" is Greater");
        
    // }else{
    //     System.out.println("c = "+ c + " is Greater");
    // }
//------------------------------------------------------------------
//ternary operator

    // int number = 5;
    // String type = (number % 2 == 0) ? "even" : "odd";
    // System.out.println(type);

//------------------------------------------------------------------
//check whether the student is pass or fail
    // Scanner sc = new Scanner(System.in);
    // int marks = sc.nextInt();
    // String status = (marks > 33) ? "PASS" : "FAIL";
    // System.out.println(status);


//------------------------------------------------------------------
// Switch Statements

    // int number  = 2;

    // switch (number) {
    //     case 1:
    //         System.out.println("Samosa");
    //         break;
    //         case 2:
    //         System.out.println("burger");
    //         break;
    //         case 3:
    //         System.out.println("ice-cream");
    //         break;
    //     default:
    //     System.out.println("we wake up !");
    //         break;
    // }
//------------------------------------------------------------------
// Calculator using switch statements

// Scanner sc = new Scanner(System.in);
// int a = sc.nextInt();
// int b = sc.nextInt();
// char operator = sc.next().charAt(0);

// switch (operator) {
//     case '+':
//         System.out.println(a+b);
//         break;

//         case '-':
//         System.out.println(a-b);
//         break;

//         case '*':
//         System.out.println(a*b);
//         break;
        
//         case '/':
//         System.out.println(a/b);
//         break;
//         case '%':
//         System.out.println(a%b);
//         break;

//     default:
//     System.out.println("char not defined !");
//         break;
// }

//------------------------------------------------------------------
// Q1. Write a Java program to get a number from the user and print whether it is positive or negative
    // Scanner sc = new Scanner(System.in);
    // int num = sc.nextInt();

    // String Status = (num>0) ? "Positive" : "Negative" ; 
    // System.out.println(Status);
//------------------------------------------------------------------
//Q2. Finish the following code so that it prints You have a fever if your temperature is
// above 100 and otherwise prints You don't have a fever

// Scanner sc = new Scanner(System.in);
// int temp =  sc.nextInt();
// String Status = (temp > 100) ? "Fever" : "No Fever" ;
// System.out.println(Status);
//------------------------------------------------------------------
//Q3. Write a Java program to input week number (1-7) and print day of week name using switch case.
// Scanner sc = new Scanner(System.in);
// int weekNum = sc.nextInt();
// switch (weekNum) {
//     case 1:
//         System.out.println("Monday");
//         break;
//         case 2:
//         System.out.println("Tuesday");
//         break;
//         case 3:
//         System.out.println("Wednesday");
//         break;
//         case 4:
//         System.out.println("Thursday");
//         break;
//         case 5:
//         System.out.println("Friday");
//         break;
//         case 6:
//         System.out.println("Saturday");
//         break;
//         case 7:
//         System.out.println("Sunday");
//         break;

//     default:
//     System.out.println("wrong option is entered !");
//         break;
// }
//------------------------------------------------------------------
//What will be the value of x & y in thefollowing program:
// int a = 63, b = 36;
// boolean x = (a < b) ? true : false ;

// int y = (a>b) ? a : b;
// System.out.println(x);

//------------------------------------------------------------------
//Q5. Write a Java program that takes a year from the user and print whether that year
// is a leap year or not.
    }

}