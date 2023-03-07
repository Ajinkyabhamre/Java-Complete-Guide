import java.util.*;

public class bitManipulation {

    public static void oddOreven(int num){
        int bitMask = 1;
        if ((num & bitMask) == 0) {
            //even
            System.out.println("num is even ! ");

        }else{
            //odd
            System.out.println("num is odd ! ");
        }
    }
  
  public static int getIthBit(int num, int i){
    int bitMask = (1 << i);
    if ((num & bitMask) == 0) {
        return 0;
    }else{
        return 1;
    }
  }
  
  public static int setIthBit(int num, int i){
    int bitMask = (1<<i);
   return  num | bitMask;
        
  } 
  
  public static int clearIthBit(int num, int i){
    int bitMask = ~(1<<i);
    return (num & bitMask);
  }
  
  public static int updateIthBit(int num,int i, int bitnum){
    if (bitnum == 0) {
       return clearIthBit(num, i);
    }else{
       return setIthBit(num, i);
    }
  }
  
  public static int clearlastIbits(int num, int i){
    int bitMask = (~0) << i ;
    return num & bitMask ;

  }
  
  public static int clearBitsinRange(int num, int i, int j){
    int a = (~0) << (j + 1);
    int b = (1 << i) - 1;
    int bitMask = a | b ;

    return (num & bitMask);
  }
  
  public static boolean isPowerofTwo(int n){
    return (n & (n - 1)) == 0;
  }

  public static int countSetBits(int n){
    int count = 0;
    while (n > 0) {
        if ((n & 1) != 0) {
            count++ ;
        }
        n = n >> 1; 
    }
    return count ;
}

  public static int fastExpo(int a, int n){
    int ans = 1;
    while (n > 0) {
        //check LSB of n and right shift
        if ((n & 1) != 0) {
            ans = ans * a;
        }
        a = a * a;
        n = n >> 1;
    }
    return ans;
  }

  public static void swapNums(int x, int y){
    x = x ^ y;
    y = x ^ y;
    x = x ^ y;
    System.out.println("x is "+ x + " and y is "+ y );
  }

  public static void addOnetoInt(int x){
    System.out.println(x  + " + " + " 1 = " + -(~x) );
  }

  public static void main(String[] args) {
    
// Binary AND (&) operator - (use only single symbol - &)
     System.out.println((5 & 6));

// Binary OR (|) operator - (use only single symbol - (|))
    System.out.println((5 | 6));
    
//Binary XOR (^) operator - (use only single symbol  - (^))
    System.out.println((5^6));
    
//Binary 1's complement
    System.out.println(~0);
    
//Binary Left Shift ( a << b)
    System.out.println( 5 << 2 );
    
//Binary Right Shift ( a >> b )
    System.out.println( 6 >> 1);
    
//Q. check if num is odd or even
    // oddOreven(3);
    // oddOreven(11);
    // oddOreven(14);

//Q. Get ith bit in a number (bin num)

    // System.out.println(getIthBit(10, 2));

//Q. Set ith Bit --> make the ith bit = 1

//System.out.println(setIthBit(10, 2));

//Q. Clear the ith bit
//System.out.println(clearIthBit(10, 1));

//Q. Update ith bit
//System.out.println(updateIthBit(10,2,1));

//Q. clear last i bits
//System.out.println(clearlastIbits(15, 2));
  
//Q. clear range of bits
//System.out.println(clearBitsinRange(10, 2, 4));

//Q. check if number is a power of 2 !
//System.out.println(isPowerofTwo(8));

//Q. Count total set bits in a number --> google, amazon
//System.out.println(countSetBits(15));

//Q. Fast exponentiation
//System.out.println(fastExpo(3, 5));

//Q. Swap two numbers without using third variable
//swapNums(5, 6);

//Q.Add 1 to an integer using Bit Manipulation
// -x = ~x + 1 ==> -~x = x + 1

//addOnetoInt(5);

//Q.Convert uppercase characters to lowercase using bits
    // for (char ch = 'A'; ch <= 'Z'; ch++) {
    //     System.out.print((char)(ch | ' '));
    // }

    }
}
