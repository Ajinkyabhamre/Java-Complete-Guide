import java.util.*;

public class Functions2 {

//------------------------------------------------------------------
//Function overloading
public static int sum(int a, int b){
    return a + b;
}    
public static float sum(float a, float b) // The parameters DataType Or No. of param should be different
{
    return a + b;
}
public static int sum(int a, int b,int c){
    return ((a + b)); // It doesnt matter what the returnType is !

}
//------------------------------------------------------------------
// write a function to check whether the number is Prime or Not
public static boolean isPrime(int num){
if (num == 2) {
    //corner case
    return true;
}
for (int i = 2; i <= num - 1; i++) {
        if(num%i == 0){
        return false;
        }
    }
        return true;
}

//------------------------------------------------------------------
//write a function to print range of prime numbers

public static void primeRange(int num1){
    for (int i = 2; i <= num1; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
    }
}

//------------------------------------------------------------------
//Convert Binary to Decimal
public static int bitoDec(int num1){
int dec= 0;
int power = 0 ;
while(num1 > 0 ){
    int lastdigit = num1 % 10;
    dec = dec + (lastdigit * (int)Math.pow(2,power));
    power++;
    num1 = num1/10;
}
    return dec;
}
//------------------------------------------------------------------
//Convert Decimal to Binary
public static int decToBin(int num){
    int bin = 0;
    int power = 0;
    while(num > 0){
        int rem = num % 2;
        bin = bin + rem * (int)Math.pow(10, power);
        power++;
        num = num/2;
    }
    return bin;
} 
//------------------------------------------------------------------
//Q.1 Write a Java method to compute the averageof three numbers..

public static int avgOfNum(int n1, int n2, int n3){
int result = (n1+n2+n3)/3;

return result;
}
//------------------------------------------------------------------------------------------------------------------------------------
//Write a method named isEven that accepts an int argument.The method should return true if the argument 
// is even, or false otherwise. Also write a program to test your method.


public static boolean isEven(int n){
if (n%2 == 0) {
    return true;
}else{
    return false;
}

}

//------------------------------------------------------------------------------------------------------------------------------------
//palindrom - 

public static boolean palindrom(int n){
int reverse = 0;
int mynum = n;
while (n > 0) {
    int lastdigit = n % 10;
    reverse = reverse * 10 + lastdigit;
    n = n / 10;
}
if (mynum == reverse) {
    return true;
}else{
    return false;
}
}


//------------------------------------------------------------------------------------------------------------------------------------
// write a program to get sum of each integer in that digit :

public static int sumOfDigit(int num){
int sumOfnum = 0;
while (num > 0) {
    int lastdigit = num % 10;
    sumOfnum = sumOfnum + lastdigit;
    num = num/10;
}
return sumOfnum;


}

public static void main(String[] args) {
//Function Overloading - Params DataType/No.of params should be different

    // System.out.println(sum(1,2));
    // System.out.println(sum(1.2f,2.3f));
    // System.out.println(sum(2,3,3));

//------------------------------------------------------------------
//2. check if num is Prime Or Non-Prime

// System.out.println(isPrime(2));

//------------------------------------------------------------------

//3. print range of primes
//primeRange(20);

//------------------------------------------------------------------
//4. Convert Binary number to decimal number

// int result = bitoDec(110);
// System.out.println(result);


//------------------------------------------------------------------
//5. Convert Decimal to Binary
// int result = decToBin(5);
// System.out.println(result);


//------------------------------------------------------------------
//Q.1
// int result = avgOfNum(1, 2, 3);
// System.out.println(result);

//------------------------------------------------------------------
//Q.2
// boolean result = isEven(5);
// System.out.println(result);


//------------------------------------------------------------------
//Q.3.

// boolean result = palindrom(321);
// System.out.println(result);

//------------------------------------------------------------------------------------------------------------------------------------
//Q.4.
// int sum = sumOfDigit(121);
// System.out.println(sum);

}
}
