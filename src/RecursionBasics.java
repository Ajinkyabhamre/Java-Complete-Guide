import java.util.Arrays;

public class RecursionBasics {

//----------------------------------------------------------------------------------------------------------
    static String Digits[] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",};
    public static void printDigits(int n){
        if (n == 0) {
            return ;
        }
    int lastdigit = n % 10 ;
    printDigits(n / 10);
    System.out.print(Digits[lastdigit] + " ");
    }
//----------------------------------------------------------------------------------------------------------

//print till n in decreasing order
    public static void printDec(int n){
        if (n == 1) {
            System.out.print(n + " ");
            return ;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

//print till n in increasing order
    public static void printInc(int n){
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

//print factorial of a number 
public static int printFact(int n){
    if (n == 0) {
        return 1;
    }
        int fact = n *  printFact(n - 1);
    return fact;

    }

//print sum till num n
public static int printSum(int n){
    if (n == 1) {
        return 1;
    }
    int sum = n + printSum(n - 1);
    return sum;
}

//write a program to find index of nth fib number
public static int nthFib(int n){
        if (n == 0 || n == 1) {
            return n ;
        }
    int fibNm1 = nthFib(n - 1);
    int fibNm2 = nthFib(n - 2);
    int fibNth = fibNm1 + fibNm2 ;

    return fibNth;

}

//write a program to return boolean value whether array is sorted or not !
public static boolean isSorted(int array[], int i){ //TC = SC = O(n)
    //Base Case
    if (i == array.length - 1 ) {
        return true;
    }

    if(array[i] > array[i + 1]){
    return false;
    }
    return isSorted(array, i + 1);

    }

//write a program to find index of first occurence
    public static int firstOcc(int array[], int i, int key){
        if (i == array.length) {
            return -1;
        }
        if(array[i] == key){
            return i;
        }
        return firstOcc(array, i + 1, key);
    }
   
//write a program to find index of last occurence
   public static int lastOcc(int array[], int i, int key){
    if (i == array.length) {
        return -1;
    }
    // first check in later part of an array
    int isFound = lastOcc(array, i + 1, key);

    if(isFound == -1 && array[i] == key){
        return i;
    }
    return isFound;
}

//print X^n --> TC = O(n)
    public static int xPower(int x, int n){
    if (n == 0) {
        return 1;
    }
        int y = xPower(x, n - 1);
        int ans = x * y ;
        return ans;
    }


// Optimised X^n --> TC = O(log n)
public static int optimisedPower(int x, int n){
        if (n == 0) {
            return 1 ;
        }
    int halfPower = optimisedPower(x, n/2) ;
        //x^n = x^n/2 * x^n/2 ---> 2^4 = 2^2 * 2^2
    int halfPowerSq = halfPower * halfPower ;
    //odd cases
    if (n % 2 != 0) {
            //x^n = x * x^n/2 * x^n/2 ---> 2^5 = 2 * 2^2 * 2^2
        halfPowerSq = halfPowerSq * x ;
    }
    return halfPowerSq ;
}
 
//Tiling Problem   
public static int tilingWays(int n){
    //base case --->
    if (n == 0 || n == 1) {
        return 1;                 // one way in this situation
    }

    //verticle
    int fnm1 = tilingWays(n - 1);
    //horizontal
    int fnm2 = tilingWays(n - 2);

    int totalWays = fnm1 + fnm2 ;
    return totalWays;
}

//Remove Duplicates in string
public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]){
//base
if (idx == str.length()) {
    System.out.println(newStr);
    return ;
}
//kaam
int idxMap = str.charAt(idx) - 'a' ; //finding char index in map array

 if (map[idxMap] == true) {
   newStr.append(str.charAt(idx)); 
   map[idxMap] = false;
 }
removeDuplicate(str, idx + 1, newStr, map);

 newStr.toString(); //convert string builder to string 
}

//find Total no. of ways friends can pair or stay single
public static int friendsPair(int n){
//Base Case - 
if (n == 1 || n == 2) {
    return n ;
}
    //choice
    //single -
    int fnm1 = friendsPair(n - 1);

    //pair
    int fnm2 = friendsPair(n - 2);
    int pairways = (n - 1) * fnm2;

    int totalWays = fnm1 + pairways ;
    return totalWays ;
}
   
//print all binary strings of size (n) without consecutive "1's"
public static void printposblStr(int n, int lastdigit, String str){
//base case
if (n == 0) {
    System.out.println(str);
    return ;
}

//kaam
printposblStr(n - 1, 0, str+"0");
if (lastdigit == 0) {
    printposblStr(n - 1, 1, str+"1");
}

}


//HW
//Q.1.
//For a given integer array of size N.You have to find all the occurrences (indices) of a given element(Key)
//and print them. Use a recursive function to solve this problem 

//Sample Input: arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2},key = 2
//Sample Output: 1 5 7 8

public static void printindexofKey(int arr[], int i, int key){
    //base
    if (i == arr.length ) {
        return ;
    }
    //kaam
    if (key == arr[i]) {
        System.out.print(i + " ");
    }
    //recurssion
    printindexofKey(arr, i + 1, key);
}

//my solution --> not recommended, check recommended soln in other class .
public static void printEnglish( String str, StringBuilder sb, int i){

if (i == str.length()){ 
    System.out.println(sb);
    return ;
}  
//kaam
char ch = str.charAt(i);

switch (ch) {
    case '0':
        sb.append("Zero ");
        break;
        case '1':
        sb.append("One ");
        break; 
        case '2':
        sb.append("Two ");
        break; 
        case '3':
        sb.append("Three ");
        break;
         case '4':
        sb.append("Four ");
        break; 
        case '5':
        sb.append("Five ");
        break; 
        case '6':
        sb.append("Six ");
        break;
         case '7':
        sb.append("Seven ");
        break;
         case '8':
        sb.append("Eight ");
        break;
     
    default:
    sb.append("Nine ");
        break;
}

printEnglish(str, sb, i + 1);

}


//Write a program to find Length of a String using Recursion.
public static int lengthofString(String str){
        //base
        if (str.length() == 0) {
            return 0 ;
        }
       //kaam

        return lengthofString(str.substring(1)) + 1;


}


//Q.4.
//print count of all substring starting & ending with same character
//We are given a string S,we need to find the count of all contiguous substrings starting and ending 
//with the same character.
//Sample Input 1: 
//S = "abcab" 
//Sample Output 1: 7 
//There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca, bcab, c, ca, cab, a, ab, b 
//Out of the above substrings,there are 7 substrings: a, abca, b, bcab, c, a and b. 
//So, only 7 contiguous substrings start and end with the same character.
//Sample Input 2: S = "aba"
//Sample Output 2: 4
// The substrings are a, b, a and aba.

public static int countSubstrings(String str, int i, int j, int n){
if (n == 1) {
    return 1 ;
}
if (n <= 0) {
    return 0; 
}

int count = countSubstrings(str, i + 1, j, n - 1) 
            + countSubstrings(str, i, j - 1, n - 1)
            - countSubstrings(str, i + 1, j - 1, n - 2);

            if (str.charAt(i) == str.charAt(j)) {
                count++ ;
            }

            return count ;
}

public static void towerOfHanoi(int n, String src, String helper, String dest){
    if(n==1) {
        System.out.println("transfer disk "+n+"from "+src+" to "+dest);
        return;
    }
    
    //transfer top n-1 from src to helper usingdest as 'helper'
    towerOfHanoi(n-1,src,dest,helper);
    
    //transfer nth from src to dest
    System.out.println("transfer disk "+n+"from "+src+" to "+helper);
    
    //transfer n-1 from helper to dest using srcas 'helper'
    towerOfHanoi(n-1,helper,src,dest);
}








    public static void main(String[] args) {
        // int n = 5;
        
        // printDec(n);
        
        // printInc(n);    
        
        // System.out.println(printFact(n)); // TC = SC = O(n)
        
        // System.out.println("Total sum of first "+n+ " natural nums is "+printSum(n)); // TC = SC = O(n)
        
        // System.out.println(nthFib(n));

        // int arr[] = {1,2,3,4,5};
        // System.out.println(isSorted(arr, 0));

        // int arr[] = {8,3,6,9,5,10,2,5,3};
        // System.out.println(firstOcc(arr, 0, 5));
        // System.out.println(lastOcc(arr, 0, 5));

        //System.out.println(xPower(2, 30));
        //System.out.println(optimisedPower(2, 30));

        // tiling prob ---> amazon
        //System.out.println(tilingWays(4));


// Remove duplicate chars from string
    // StringBuilder newStr = new StringBuilder();
    // boolean map[] = new boolean[26];
    // String str = "appnnacollege";
    // for (int i = 0; i < str.length(); i++) {

    // int idxMap =  str.charAt(i) - 'a'; //type conversion in expression (a - a = 0)
    // if (map[idxMap] != true) {
    //     map[idxMap] = true;
    // }
    // }

    //     removeDuplicate(str, 0, newStr, map);


//Friends pairing problem
    // System.out.println(friendsPair(16));

//print all binary strings of size (n) without consecutive "1's"
    // printposblStr(3, 0, "");

//-----------------------------------------------------------------------------------------------------
//Q.1.
    // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
    // int key = 2 ;
    // printindexofKey(arr, 0, key);

//Q.2. 
    // int n = 2010;
    // String str = String.valueOf(n);
    // System.out.println(str);
    // printEnglish(str, new StringBuilder(), 0);

//Q.2. 
//recomended soln -
    //printDigits(1234);

//Q.3. 
//System.out.println("length of the string is " + lengthofString("Ajinkya"));

//Q.4.
// String Str = "abcab";
// int n = Str.length();
// System.out.println(countSubstrings(Str, 0, n - 1, n));

//Q.5.
int n = 4;
towerOfHanoi (n, "A", "B", "C");


    }
}


