import java.util.*;

public class arrayPrac {

    public static int binarySearch(int array[], int key){
    int start = 0, end = array.length - 1 ;
    while (start <= end) {
        int mid = (start + end)/ 2;
        if (array[mid] == key) {
            return mid;
        }if (array[mid] < key) {
            start = mid + 1;
        } else {
            end = mid - 1;            
        }
    }
    return -1;
    }

    public static void reverseArray(int array[]){
    int start = 0, end = array.length - 1, temp = 0;
    while (start <= end) {
        temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        start++;
        end--;
    }
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
    System.out.println();
    }
    
    public static void printPairs(int array[]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (j > i) {
                System.out.print("("+array[i]+", "+array[j]+")");
                    
                }
            }
            System.out.println();
        }
    }
    
    public static void subArrays(int array[]){
        //{1,-2,6,-1,3}
        int totalSub = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
            System.out.println();
            for (int j = i + 1; j < array.length; j++) {
            int sum = 0;

                for (int k = i; k <= j; k++) {
                System.out.print(array[k]+" ");
                    sum += array[k];
                }
                if (maxNum <= sum) {
                    maxNum = sum;
                }
                totalSub++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("max sum of an subarray is : "+ maxNum);
    }

    public static void prefixSum(int num[]){
        int prefixArray[] = new int[num.length];
        prefixArray[0] = num[0];
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + num[i];
        }
        int prefixSum = 0;
        for (int start = 0; start < prefixArray.length; start++) {
            for (int end = 0; end < prefixArray.length; end++) {
                prefixSum = start == 0 ? prefixArray[end] : prefixArray[end] - prefixArray[start - 1];
            }
        }
        System.out.println("max sum of array is : "+ prefixSum);
    }
   
   public static void kadanesAlgo(int array[]){
    int currSum = 0;
    int negSum = 0;
    int negMax = Integer.MIN_VALUE;
    int maxSum = Integer.MIN_VALUE;
      boolean flag = false;
    
    for (int i = 0; i < array.length; i++) {
        currSum = currSum + array[i];
        if (currSum < 0) {
            currSum =  0;
        }
        maxSum = Math.max(maxSum, currSum);

        //corner case - if all elements are negative in an array.
        if (array[i] > 0) {
            flag = true;
        }
         if(flag != true){
            negSum += array[i];
            negMax = Math.max(negMax, negSum);
        }
    }
        if (flag != true) {
            System.out.println("maximum sum of subarray is : " + negMax);
        }else {
                System.out.println("maximum sum of subarray is : "+ maxSum);

        }
   }
   
   public static int  trappingRainwater(int num[]){
//write logic on paper --> and code it !

//calculate auxilary left max
    int auxLeftmax[] = new int[num.length];
    int leftboundry = num[0];
    for (int i = 0; i < auxLeftmax.length; i++) {
        auxLeftmax[i] = Math.max(leftboundry, num[i]);
        if(leftboundry < auxLeftmax[i]){
            leftboundry = auxLeftmax[i];
        }
    }
//calculate auxilary right max
    int auxRightmax[] = new int[num.length];
    int rightboundry = num[num.length - 1];
    for (int i = num.length - 1; i >= 0; i--) {
        auxRightmax[i] = Math.max(rightboundry, num[i]);
        if (rightboundry < auxRightmax[i]) {
            rightboundry = auxRightmax[i];
        }
    }
    int volume = 0;
//loop
    for (int i = 0; i < num.length; i++) {
       int waterLvl = Math.min(auxLeftmax[i], auxRightmax[i]);
        volume += ((waterLvl - num[i]) * 1);
    }
    return volume;
   }
    
   public static int maxProfit(int array[]){
    int bp = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;

for (int i = 0; i < array.length; i++) {
    int sp = array[i];
    bp = Math.min(bp, array[i]);
    int profit = (sp - bp);
    maxProfit = Math.max(maxProfit, profit);
}
return maxProfit;
   }
   
//---------------------------------------------------------------------------------------------------
public static boolean checkifRepeat(int array[]){
    int checkPt = array[0];
for (int i = 1; i < array.length; i++) {
    if (checkPt == array[i]) {
        return true;
    }else{
        checkPt = array[i];
    }
}
return false;
}

//---------------------------------------------------------------------------------------------------
//find minimum num in array - O(log n)
public static int minSearch(int[] nums){
int left = 0;
int right = nums.length - 1;
while(left < right){
int mid = left + (right - left)/2;
if (mid > 0 && nums[mid - 1] > nums[mid]) {
    return mid;
}else if(nums[left] < nums[mid] && nums[mid] > nums[right] ){
 left = mid + 1;
}else{
    right = mid - 1;
}



}
return left;

}

//passing paramerters through this func
public static int search(int nums[], int target){
int min = minSearch(nums);
//find in sorted left
if(nums[min] <= target && target <= nums[nums.length-1]){
     return search(nums, min, nums.length-1, target); 
    } 
//find in sorted right 
else{ 
    return search(nums,0,min,target); 
}
}

//find target using binary search
public static int search(int nums[],int left, int right,  int target){
while(left <= right){
    int mid = left + (right - left)/2;
    if (nums[mid] == target) {
        return mid ;
    } if (mid < target) {
        left = mid + 1;
    }else{
        right = mid - 1 ;
    }
}
return -1;
}

//---------------------------------------------------------------------------------------------------
   
public static int maximumProfit(int nums[]){
    int sp =0;
    int maxprofit = Integer.MIN_VALUE;
    int bp = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
        sp = nums[i];
        bp = Math.min(bp, nums[i]);
    int profit = sp - bp;
    maxprofit = Math.max(maxprofit, profit);
    
    }
    return maxprofit;
}


//---------------------------------------------------------------------------------------------------
public static int trapped(int nums[]){
    
    //left max - auxilary array
    int auxLeftmax[] = new int[nums.length];
    int leftboundry = nums[0];
    for (int i = 0; i < auxLeftmax.length; i++) {
    auxLeftmax[i] = Math.max(leftboundry, nums[i]);  
    if (leftboundry < auxLeftmax[i]) {
        leftboundry = auxLeftmax[i];
    }      
    }
    //right max - auxilary array
    int auxRightmax[] = new int[nums.length];
    int rightboundry = nums[nums.length - 1];
    for (int i = nums.length - 1; i >= 0; i--) {
    auxRightmax[i] = Math.max(rightboundry, nums[i]);  
    if (rightboundry < auxRightmax[i]) {
        rightboundry = auxRightmax[i];
    }      
    }

    //calculate volume of trapped water
    int trappedwater = 0;

    for (int i = 0; i < nums.length; i++) {
        int waterLvl = Math.min(auxLeftmax[i], auxRightmax[i]);
        trappedwater += (waterLvl - nums[i]) * 1;

    }
    return trappedwater;
    
 
}





public static void main(String[] args) {

//binary search

    // int num[] = {2,4,6,8,10,12,14};
    // int key = 10;
    // int index = binarySearch(num, key);
    // if (index != -1) {
    //     System.out.println("key is present at index :" + index);
    // } else {
    //     System.out.println("key is absent in this array");
    // }

//Reverse an array - 
    // int num[] = {2,4,6,8,10};
    // reverseArray(num);

//Pairs in array - 
// (2, 4)(2, 6)(2, 8)(2, 10)
// (4, 6)(4, 8)(4, 10)
// (6, 8)(6, 10)
// (8, 10)

    // int num[] = {2, 4, 6, 8, 10};
    // printPairs(num);

//print subArrays - 

    // int num[] = {2, 4, 6, 8, 10};
    // subArrays(num);

//print maximum of subArray - 
    // int num[] = {1,-2,6,-1,3};
    // subArrays(num);

//prefix array - max sum of subarray
    // int num[] ={1,-2,6,-1,3};
    // prefixSum(num);

//kadane's Algorithm
    // int num[] = {-2,-3,-4,-1,-2,-1,-5,-3};
    // kadanesAlgo(num);


//trapping Rainwater algorithm

    // int num[] = {4,2,0,6,3,2,5};
    // int volume = trappingRainwater(num);
    // System.out.println("volume of trapped Rain-water is : "+ volume);

//Best time to buy & sell a stock
    // int stockprices[] = {7, 1, 5, 3, 6, 4};
    // int profit = maxProfit(stockprices);
    // System.out.println("maximum profit is : " + profit);

//H W
//Q1. 
    // int nums[] = {1,2,3,4,5,6};
    // boolean result = checkifRepeat(nums);
    // if (result) {
    //     System.out.println("repeat digits are present");
    // }else{
    //     System.out.println("distinct digits are present");
    // }

//Q.2

    // int nums[] = {4,5,6,7,0,1,2};
    // int index = search(nums, 6);
    // System.out.println("taget is at index : "+ index);

//Q3. find max profit using buying and selling a stock
    // int nums[] = {7, 1, 5, 3, 6, 4};
    // int maxprofit = maximumProfit(nums);
    // System.out.println("maximum profit is : "+ maxprofit);


//Q.4 trapping rainwater - QnA
    // int heights[] = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
    // System.out.println("volume of trapped water is : "+trapped(heights));





}    
}
