import java.util.*;

public class Arrays {
// call by refernce Vs call by value: 
    public static void update(int marks[], int unchangable){
        unchangable = 10;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }

    }

//---------------------------------------------------------------------------------------------------------
//Linear Search
    public static int linearSearch(int numbers[], int key){
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) 
                return numbers[i];

           
        }
        return -1;
    }


    public static int linearSearchMenu(String menu[], String choice){
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == choice) {
                return i;
            }
        }
        return -1;

            }

//---------------------------------------------------------------------------------------------------------
// get Largest value from given array.

    public static int getLargest(int numbers[]){
        int largest = Integer.MIN_VALUE;     // (- infinity) --> smallest possible value
        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }
    return largest;
    }

//---------------------------------------------------------------------------------------------------------
//Binary Search

public static int binarySearch(int array[], int key){
int start = 0;
int end = array.length - 1;

while (start <= end) {
    int mid = (start + end)/2 ;
    if (array[mid] == key) {
        return mid;
    }
    if (array[mid] < key) {
        
        start = mid + 1;
    }else{
        
        end = mid - 1;
    }
}


   return -1; 
}

//---------------------------------------------------------------------------------------------------------
// Reverse Array

    public static void reverseArray(int array[]){
    int first = 0;
    int last = array.length - 1;

    while(array[first] < array[last]){
    int temp = array[last];
    array[last] = array[first];
    array[first] = temp;

    first++;
    last--;
    }
    }

//---------------------------------------------------------------------------------------------------------
//print Pairs of an array

    public static void printPairs(int array[]){
        int tp = 0;
        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            for (int j = i + 1; j < array.length; j++) {
                System.out.print("("+ curr+ ", "+array[j] +"), ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total pairs are " + tp);

    }

//---------------------------------------------------------------------------------------------------------
//print sub-arrays - basic method with TC = O(n^3)

    public static void printSubarrays(int array[]){
        int maxSum = Integer.MIN_VALUE;
    
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i]+ " ");
        for (int j = i+1; j < array.length; j++) {
            int currSum = 0;
            for (int k = i; k <= j; k++) {
            
                System.out.print(array[k]+",");
                currSum += array[k];
                
            }
            System.out.print(" ");
            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }
        System.out.println();
    }
    System.out.println("max addition of subarray is: "+maxSum);
    }

//---------------------------------------------------------------------------------------------------------
//print sub-arrays MaxSum - Prefix Array method
    public static void prefixSubarrays(int array[]){
    
    int currSum =0, maxSum = Integer.MIN_VALUE;
    int prefix[] = new int[array.length];
    prefix[0] = array[0];
    //make a new prefix array
    for (int i = 1; i < array.length  ; i++) {
        prefix[i] = prefix[i-1] + array[i];
    }
    // for (int i = 0; i < array.length ; i++) {
    //    System.out.print(prefix[i]+" ");
    // }
    for (int start = 0; start < array.length; start++) {
        
        for (int end = start + 1; end < array.length; end++) {
             
         currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
         
            System.out.print(" ");

            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }
        System.out.println();
    }
    System.out.println("max addition of subarray is: "+maxSum);
  
    }
//---------------------------------------------------------------------------------------------------------
//print sub-arrays MaxSum - kadane's algorithm method ---> TC = O(n)

public static void kadaneSubarray(int array[]){
    int currSum = 0, maxSum = Integer.MIN_VALUE;
for (int i = 0; i < array.length; i++) {
    currSum = currSum + array[i];
    if (currSum < 0 ) {
        currSum = 0;
    }
    
   maxSum = Math.max(currSum, maxSum); 
}
System.out.println("maximum sum of subarray is: "+maxSum);
}
//---------------------------------------------------------------------------------------------------------
//trapped rainwater algorithm ----> TC = O(n)

public static int trappedRainwater(int height[]){
    int n = height.length;
    // calculate leftmax boundry ---> auxilary array
    int leftMax[] = new int[n];
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(height[i], leftMax[i - 1]);

    }
// calculate rightmax boundry ---> auxilary array
    int rightMax[] = new int[n];
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(height[i], rightMax[i+1]);
    }


    int trappedWater = 0;
//loop
    for (int i = 0; i < n; i++) {
    //formula------>waterlevel = min(leftmax bound, rightmax bound)
        int waterlevel = Math.min(leftMax[i], rightMax[i]);
        trappedWater += waterlevel - height[i];

    }
return trappedWater;

}

//---------------------------------------------------------------------------------------------------------

public static int buyandSellstocks(int price[]){
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < price.length; i++) {
        if (buyPrice < price[i]) {
            int profit = price[i] - buyPrice;
            maxProfit = Math.max(maxProfit,profit);
        }else{

            buyPrice = price[i];
        }
    }
    return maxProfit;
}



//---------------------------------------------------------------------------------------------------------

public static boolean checkifTwice(int nums[]){
    for (int i = 0; i < nums.length; i++) {
       for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true;
            } 
       }
    }
    return false;


}


public static void findtargetIndex(int nums[]){

    int first = 0;
    int pivot = 3;
    while (nums[first] < nums[pivot]) {
        int temp = nums[pivot];
        nums[pivot] = nums[first];
        nums[first] = temp;

        first++;
        pivot++;
    }
}
//---------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        // int marks[] = new int[50];
        // int moremarks[] = {4,5,6};
        // String fruits[] = {"mango", "apple", "grapes"};

        // System.out.println("First position of moremarks array is " +moremarks[0]);
        // System.out.println("First position of fruits array is " + fruits[1]);


//---------------------------------------------------------------------------------------------------------
//1. call by refernce Vs call by value: 
//changed value in a outer function of a variable is not considered in main() function - call by value.
//changed value in a outer function of a array is considered in main() function - call by reference.

    // int marks[] = {97, 98, 99};
    // int unchangable = 5;
    // update(marks, unchangable);
    // System.out.println(unchangable);

    // for (int i = 0; i < marks.length; i++) {
    //     System.out.print(marks[i]+ " ");
    // }
 
//---------------------------------------------------------------------------------------------------------
//2. Linear Search - Time Complexity = O(n)

    // int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
    // int key = 10;

    // int index = linearSearch(numbers, key);
    // if (index == -1) {
    //     System.out.println("Index not found");
    // } else {
    // System.out.println("key is "+ index);
    //     }

//---------------------------------------------------------------------------------------------------------
//H.W - Linear Search for Menu-Card

    // String menu[] = {"Sandwich", "Chole-bhature", "Samosa", "maggie"};
    // String choice = "Samosa";
    // int choiceNum = linearSearchMenu(menu, choice);
    // if (choiceNum == -1) {
    //     System.out.println("This option is not available !");
    // } else {
    //     System.out.println("Your choice is present at index " + choiceNum);
    // }


//---------------------------------------------------------------------------------------------------------
//3. get largest value from a give array

    // int numbers[] = {1,27,37,42,5,16,17};
    // int largestNum  = getLargest(numbers);
    // System.out.println(largestNum);
 

//---------------------------------------------------------------------------------------------------------
//4. Binary Search

// int array[] = {1,3,4,6,7,8,9,23,45,65};
// int key = 45;

// int result = binarySearch(array, key);

// System.out.println("The key is at index: " + result);

//---------------------------------------------------------------------------------------------------------
//5. Reverse an array --> TC = O(n), SC = O(1) 

    // int array[] = {2,4,6,8,10,12,14};
    // reverseArray(array);

    // for (int i = 0; i < array.length; i++) {
    //     System.out.print(array[i] + " ");
    // }
    
    // System.out.println();

//---------------------------------------------------------------------------------------------------------
// print pairs of an array

    // int array[] = {2,4,6,8,10};
    // printPairs(array);

//---------------------------------------------------------------------------------------------------------
// print subarrays

//int array[] = {2,4,6,8,10};
// printSubarrays(array);
//------------------------------

// int array[] ={1,-2,6,-1,3};
// prefixSubarrays(array);

//------------------------------
    // int array[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    // kadaneSubarray(array);
//---------------------------------------------------------------------------------------------------------
//Q. trapped rainwater problem 
// int height[] = {4,2,0,6,3,2,5};

// int trappedWater = trappedRainwater(height);
// System.out.println(trappedWater);

//---------------------------------------------------------------------------------------------------------
//Q. You are given an array prices where pricesli] is the price of a given stock
// on the ith day. You want to maximize your profit by choosing a single day to
// buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you
// cannot achieve any profit, return 0.

    // int price[] = {7,1,5,3,6,4};
    // int maxProfit = buyandSellstocks(price);
    // System.out.println(maxProfit);


//---------------------------------------------------------------------------------------------------------
//Given an integer array nums, return true if any value appears at least twice 
// in the array, and return false if every element is distinct

    // int nums[] = {1,2,3,4};
    // boolean result = checkifTwice(nums);
    // System.out.println(result);

//---------------------------------------------------------------------------------------------------------
// int nums[] = {0,1,2,4,5,6,7};
//  findtargetIndex(nums);
//  for (int i = 0; i < nums.length; i++) {
// System.out.print(nums[i]+" ");
    
 //}



} 
}
