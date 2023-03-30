import java.util.Arrays;
import java.util.*;

public class BasicSorting {
   
    public static void printArray(int array[]){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
            System.out.println();
    }

//---------------------------------------------------------------------------------------------------------
//bubble sorting ---> TC = O(n^2)
    public static void bubbleSort(int array[]){
       
        // loop for no. of [turns --> n - 1] ---> for array size of n.
        for (int turn = 0; turn < array.length - 1; turn++) {
            
            //loop for [further cycles ---> n - 1 - turn] ---> for array size of n.
            for (int i = 0; i < array.length - 1 - turn; i++) {
                
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
//---------------------------------------------------------------------------------------------------------
//selection sorting ---> TC = O(n^2)
    public static void selectionSort(int array[]){
// outer loop to swap positions ---> small first
    for (int i = 0; i < array.length - 1; i++) {
    
    int minPos = i;
   
    // inner loop to change position of small number index to the starting indexes
    for (int j = i + 1; j < array.length ; j++) {
        if (array[minPos] > array[j]) {
            //array[minPos] > array[j] ------> for descending order of output
            minPos = j;
        }
    }
        //swap
        int temp = array[minPos];
        array[minPos] = array[i];
        array[i] = temp;

    }
        
    }

//---------------------------------------------------------------------------------------------------------
//insertion sorting ---> TC = O(n^2)
public static void insertionSort(int array[]){

    for (int i = 1; i < array.length; i++) {
        int curr = array[i];
        int prev = i - 1;
        while (prev >= 0 && array[prev] > curr) {
            array[prev + 1] = array[prev];
            prev -- ;
        }
        array[prev+1] = curr;
    }
}
//---------------------------------------------------------------------------------------------------------
//Counting Sort
public static void countingSort(int array[]){

    //find range
    int largest = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
        largest = Math.max(largest, array[i]);
    }

    //create array count at count frequency
    int count[] = new int[largest + 1];
    for (int i = 0; i < array.length; i++) {
        count[array[i]]++;
    }

    //sorting
    int j = 0;
    for (int i = 0; i < count.length; i++) {
        while (count[i] > 0) {
            array[j] = i;
            j++;
            count[i]--;

        }
    }
}
//---------------------------------------------------------------------------------------------------------
//Q. 
//1. bubble sort -> decending order
    public static void bubbledecSort(int arr[]){
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int i = 0; i < arr.length - 1 - turn; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
//2. selection sort----> desc order
public static void selectdecSort(int arr[]){
    for (int i = 0; i < arr.length - 1; i++) {
        int minPos = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[minPos] < arr[j]) {
                minPos = j;
            }
        }

                //swap
                int temp = arr[minPos];
                arr[minPos] = arr[i];
                arr[i] = temp;
    }
}
//3.  Insertionsort - desc order
public static void insertiondecSort(int arr[]){
    for (int i = 1; i < arr.length; i++) {
        int curr = arr[i];
        int prev = i - 1;

        while (prev >= 0 && arr[prev] < curr) {
            arr[prev + 1] = arr[prev];
            prev --;
        }
        arr[prev + 1] = curr;

    }
}
//4. Counting sort - dec order
public static void  countingdescSort(int arr[]){


    //find range
    int largest = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        largest = Math.max(largest, arr[i]);
    }

    //create array count at count frequency
    int count[] = new int[largest + 1];
    for (int i = 0; i < arr.length; i++) {
        count[arr[i]]++;
    }

    //sorting
    int j = 0;
    for (int i = count.length -1; i >=0; i--) {
        while (count[i] > 0) {
            arr[j] = i;
            j++;
            count[i]--;

        }
    }
}

//---------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        int nums[] = {5, 4, 1, 3, 2};

        //bubbleSort(nums);

       // selectionSort(nums);

        insertionSort(nums);

//---------------------------------------------------------------------------------------------------------

//Inbuilt sorting method ---> O(nlogn)
//      Arrays.sort(nums, 0, 3);

//---------------------------------------------------------------------------------------------------------
    //Counting Sort (TC = O(n + range))
    
    // int array[] = {1,4,1,3,2,4,3,7};
    // countingSort(array);
    // printArray(array);

//---------------------------------------------------------------------------------------------------------
       
  //  printArray(nums);

//---------------------------------------------------------------------------------------------------------
//Q. Use the following sorting algorithms tosort an array in DESCENDING order 
    // a.Bubble Sort
    // b.Selection Sort
    // c.Insertion Sort
    // d.Counting Sort
//You can use this array as an example :[3,6,2,1,8,7,4,5,3,1]

int arr[] = {3,6,2,1,8,7,4,5,3,1};

//bubbledecSort(arr);

//selectdecSort(arr);

//insertiondecSort(arr);

//countingdescSort(arr);

//printArray(arr);


//---------------------------------------------------------------------------------------------------------


        
    }
}
