import java.util.* ;

public class DividenConquer {

    public static void printArray(int array[]){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

//MergeSort
    public static void mergeSort(int arr[], int si, int ei){
        //base
        if (si >= ei) {
            return ;
        }
        
        //kaam
        int mid = si + (ei - si) / 2 ;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        //0 to 3 => 4 elements, 4 to 6 => 3 elements, so 6 - 0 + 1 = 7 elements in total 
        int temp[] = new int[ei - si + 1];
        int i = si ; // iterator for left
        int j = mid + 1 ; // iterator for right
        int k = 0; //iterator for temp[]

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i] ;
                i++ ; k++ ;
            }else{
                temp[k] = arr[j] ;
                j++ ; k++ ; 
            }
        }
        //remaining left elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        //remaining right elements
        while (j <= ei) {
            temp[k++] = arr[j++] ;
        }

        for ( k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }



    }
    
//QuickSort
    public static void quickSort(int arr[], int si, int ei){

    //base
    if (si >= ei) {
        return ;
    }
    //will return sorted index of pivot    
     int pivIdx = partition(arr, si, ei);
    
    //sort left side of pivot
    quickSort(arr, si, pivIdx - 1);
    //sort righth side of pivot
    quickSort(arr, pivIdx + 1, ei); 
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei] ; 
        int i = si - 1 ;
        for (int j = si; j < ei; j++) {
            if (arr[j] < pivot) {
                i++ ;
                int temp = arr[j] ;
                arr[j] = arr[i] ;
                arr[i] = temp ; 
            }
        }
        i++ ;
        int temp = pivot ;
        arr[ei] = arr[i] ;
        arr[i] = temp ;
        return i ; 
    }

//Q.Search in rotated sorted array - Modified Binary Search
    public static int searchinRotsort(int arr[], int target, int si, int ei){
        //base
        if (si > ei) { //Invalid Condition
            return -1 ;             
        }

        //kaam
        int mid = si + (ei - si) / 2 ;
        
        //Best Case
        if (arr[mid] == target) {
            return mid ;
        }
    
        if (arr[si] <= arr[mid]) {
           //case 1
           if (arr[si] <= target && target <= arr[mid] ) {
            return searchinRotsort(arr, target, si, mid - 1);
         }
         else{
           return  searchinRotsort(arr, target, mid, ei);
         }
        }

        else{
            //case 2
            if (arr[mid] <= target && target <= arr[ei]) {
            return  searchinRotsort(arr, target, mid + 1, ei) ;
            }else{
                return searchinRotsort(arr, target, si, mid - 1) ;
            }
        }
      

    }
    
//Q.H.W - Same above prob. with iteration method
    public static int searchwithIter(int arr[],int tar, int si, int ei){
        int mid = si + (ei - si) / 2 ;
        if (arr[mid] == tar) {
            return mid ;
        }
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) {
                for (int i = si; i <= mid; i++) {
                    if (arr[i] == tar) {
                        return i ;
                    }
                }
            }else{
                for (int i = mid + 1; i < ei; i++) {
                    if (arr[i] == tar) {
                        return i ;
                    }
                }
            }
        }else{
            if (arr[mid] <= tar && tar <= arr[ei]) {
                for (int i = mid; i < ei; i++) {
                    if (arr[i] == tar) {
                        return i ;
                    }
                }
            }else{
                for (int i = si; i < mid - 1; i++) {
                    if (arr[i] == tar) {
                        return i ;
                    }
                } 
            }

            }
            return -1 ;


    }
    
//--------------------------------------------------------------------------------------------------------
//Q. Apply Mergesort to sort an array of Strings.(Assume that all the characters in all the Strings are
// in lowercase).
//Sample Input 1: arr = { "sun", "earth", "mars", "mercury"}
//Sample Output 1: arr = { "earth", "mars", "mercury","sun"}

public static String[] stringmergeSort(String arr[], int low, int high){
    //base
    if (low == high) {
        String [] A = {arr[low]} ;
        return A; 
    }

    int mid = low + (high - low) / 2 ;
    String[] array1 = stringmergeSort(arr, low, mid) ;
    String[] array2 = stringmergeSort(arr, mid+ 1, high) ;

    String[] array3 = mergeStringarr(array1, array2);

    return array3;
}

public static String[] mergeStringarr(String[] array1, String[] array2){

        int m = array1.length ;
        int n = array2.length ;
        String[] temp = new String[m + n] ;

        int idx = 0 ;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (isAlphabeticallysmaller(array1[i], array2[j])) {
                temp[idx] = array1[i];
                i++; idx++ ;
            }else{
                temp[idx] = array2[j];
                j++; idx++; 
            }
        }

        while (i < m) {
            temp[idx] = array1[i];
            i++ ; idx++ ;
        }

        while (j < n) {
            temp[idx] = array2[j];
            j++; idx++ ;
        }

        return temp;
}

public static boolean isAlphabeticallysmaller(String str1, String str2){
        if (str1.compareTo(str2) < 0) {
            return true ;
        }
        return false ;
}

//--------------------------------------------------------------------------------------------------------
private static int countinRange(int arr[], int num, int lo, int hi ){
    int count = 0;
    for (int i = lo; i <= hi; i++) {
        if (arr[i] == num) {
            count ++;
        }
    }
    return count ;
}

public static int findmajorEle(int arr[], int lo, int hi){
    //base Case
    if (lo == hi) {
        return arr[lo] ;
    }

    int mid = lo + (hi - lo) / 2 ;
    int left = findmajorEle(arr, lo, mid) ;
    int right = findmajorEle(arr, mid + 1, hi) ;

    if (left == right) {
    return left ;
    }

    int leftCount = countinRange(arr, left, lo, hi);
    int rightCount = countinRange(arr, right, lo, hi);
    
   return leftCount > rightCount ? arr[left] : arr[right] ;

}

//--------------------------------------------------------------------------------------------------------

public static int mergeinvCount(int arr[], int left, int mid, int right){
    int i = left; int j = mid ; int k = 0 ;
    int invCount = 0;
    int temp[] = new int[right - left + 1] ;

    while (i < mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k] = arr[i];
            i++ ; k++ ;
        }else{
            temp[k] = arr[j] ;
            invCount += mid - i ;
            j++; k++ ;
        }
    }

    while (i < mid) {
        temp[k] = arr[i] ;
        i++ ; k++ ;
    }

    while (j <= right) {
        temp[k] = arr[j];
        j++ ; k++ ;
    }

for ( i = left, k = 0; i <= right; i++, k++) {
    arr[i] = temp[k];
}

return invCount ;

}

public static int modifiedmergeSort(int arr[], int left, int right){
    int invCount = 0; 
if (right > left) {
    int mid = (left + right) / 2 ;

    invCount = modifiedmergeSort(arr, left, mid) ;
    invCount += modifiedmergeSort(arr, mid + 1, right) ;
    invCount += mergeinvCount(arr, left, mid + 1, right);

}
return invCount ;


}










    
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};        
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);

        // int arr[] = {6,3,9,8,2,5};
        // quickSort(arr, 0, arr.length - 1);
        // printArray(arr);

        // int arr[] = {4, 5, 6, 7, 0, 1, 2};
        // int target = 0;
        
        // int index = searchinRotsort(arr, target, 0, arr.length - 1);
        // System.out.println("index of given target = "+target +" is "+ index);

 //       //above prob without recursion - (for loops)
            // int index2 = searchwithIter(arr, target, 0, arr.length - 1);
            // System.out.println(index2);

//--------------------------------------------------------------------------------------------------------
//Q. Apply Mergesort to sort an array of Strings.(Assume that all the characters in all the Strings are
// in lowercase).

//Sample Input 1: arr = { "sun", "earth", "mars", "mercury"}
//Sample Output 1: arr = { "earth", "mars", "mercury","sun"}

        // String array[] = {"sun", "earth", "mars", "mercury"} ;
        // String[] resultArray = stringmergeSort(array, 0, array.length - 1);
        // for (int i = 0; i < resultArray.length; i++) {
        //     System.out.print(resultArray[i] + " ");
        // }

//Q. Given an array nums of size n, return the majority element
//The majority element is the element that appears more than ⌊n/2⌋ times.You may assume that the majority
// element always exists in the array.
//Sample Input 1: nums = [3,2,3] 
//Sample Output 1: 3
//Sample Input 2: nums = [2,2,1,1,1,2,2]
//Sample Output 2: 2

//Constraints(extra Conditions):
//  n == nums.length
//  1 <= n <= 5 * 104
// -109 <= nums[i] <= 109

// =>

int array[] = {2,2,1,1,1,2,2} ;
int majorEle = findmajorEle(array, 0, array.length - 1);
System.out.println(majorEle);


//Q. Given an array of integers. Find theInversion Countin the array. 
//Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
// If the array is already sorted then the inversion count is 0. If an array is sorted in the reverse order
// then the inversion count is the maximum. Formally, two elements a[i] and a[j] form an inversion 
//if a[i] > a[j] and i < j.
//Sample Input 1: N = 5, arr[ ] = {2, 4, 1, 3, 5}
//Sample Output 1: 3
// because it has 3 inversions -> (2, 1), (4, 1), (4, 3)


// int arr[] = {2, 4, 1, 3, 5} ;
// int count = modifiedmergeSort(arr, 0, arr.length - 1);
// System.out.println("Inversion count is " + count);


    }
}
