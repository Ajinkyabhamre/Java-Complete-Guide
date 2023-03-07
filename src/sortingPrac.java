import java.util.Arrays;

public class sortingPrac {
//print array - 
public static void printArray(int array[]){
for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] +" ");
}
System.out.println();
}

    public static void bubbleSort(int array[]){
        for (int turn = 0; turn < array.length - 1; turn++) {
        // if array is already sorted then this swap will help get bext TC
           boolean swap = false;
           
            for (int j = 0; j < array.length - 1 - turn; j++) {
               
                if (array[j]> array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swap= true;
                }
            }
            if (!swap) {
                break;
            }
            
        }
        printArray(array);
    }
   
   public static void selectionSort(int array[]){
    for (int i = 0; i < array.length - 1; i++) {
        int minPos = i;
        for (int j = i + 1; j < array.length ; j++) {
            if (array[minPos] > array[j]) {
                minPos = j;
            }
        }
        //swap
        int temp = array[minPos];
        array[minPos] = array[i];
        array[i] = temp;

    }
    printArray(array);
   }
   
    public static void insertionSort(int array[]){
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int prev = i - 1;
            while (prev >= 0 && array[prev] > curr) {
                array[prev + 1] = array[prev];
                prev--;
            }
            array[prev + 1] = curr;
        }
        printArray(array);
    }
    
    public static void countingSort(int nums[]){
        //find largest num
      int largest = Integer.MIN_VALUE;
      for (int i = 0; i < nums.length; i++) {
        largest = Math.max(largest, nums[i]);
      }
      //create frequencyArray = largest + 1
      int freq[] = new int[largest + 1];
      for (int i = 0; i < nums.length; i++) {
        freq[nums[i]]++;
      }
      //sorting
      int j = 0;
      for (int i = 0; i < freq.length; i++) {
        while (freq[i] > 0) {
            nums[j] = i;
            j++;
            freq[i]--;
        }
      }

      printArray(nums);
      
    }
    
    public static void decbubbleSort(int nums[]){
        for (int turn = 0; turn < nums.length - 1; turn++) {
            for (int i = 0; i < nums.length - 1 - turn; i++) {
                if (nums[i] < nums[i+1]) {
                    int temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        printArray(nums);
    }
    
    public static void decselectionSort(int nums[]){
        for (int i = 0; i < nums.length - 1; i++) {
            int maxPos = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[maxPos] < nums[j]) {
                    maxPos = j;
                }
            }
            int temp = nums[maxPos];
            nums[maxPos] = nums[i];
            nums[i] = temp;
        }
        printArray(nums);
    }
    
    public static void decinsertionSort(int nums[]){
    for (int i = 1; i < nums.length; i++) {
    int curr = nums[i];
    int prev = i - 1;
    while (prev >= 0 &&  nums[prev] < curr) {
        nums[prev + 1] = nums[prev];
        prev -- ;

    }
    nums[prev + 1] = curr;

    }
     printArray(nums);
    }
    
    public static void deccountingSort(int nums[]){
        // find largest number
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }

        //create count array
        int count[] = new int[largest + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                count[nums[i]]++;
            }
        }
        //sorting
        int j = 0;
        for (int i = count.length - 1; i >=1; i--) {
            while (count[i] > 0) {
                nums[j] = i;
                j++;
                count[i]--;
            }
        }
        printArray(nums);
    }
    
    
    public static void main(String[] args) {
        //int arr[] = {5,4,1,3,2};
        //int array[] ={1,2,3,4,5};
       // bubbleSort(arr);

       //selectionSort(arr);

       //insertionSort(arr);

       //inbuilt arrays 
        //    Arrays.sort(arr, 0, 4);
        //    printArray(arr);
    
    // int nums[] = {1,4,1,3,2,4,3,7};
    // countingSort(nums);

int nums[] = {3,6,2,1,8,7,4,5,3,1};

// decbubbleSort(nums);

// decselectionSort(nums);

//decinsertionSort(nums);

deccountingSort(nums);









    }
}
