import java.util.ArrayList;
import java.util.Collections;

public class arrlist {

 

public static void swapInt(ArrayList<Integer> list, int idx1, int idx2){
      int temp = list.get(idx1) ;
      list.set(idx1, list.get(idx2));
      list.set(idx2, temp);
      
    }


public static int mostWater(ArrayList<Integer> height){
        int maxWater = 0;
        //brute force   -  O(n^2)
        for (int i = 0; i < height.size(); i++) {
            for (int j = 0; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i ;
                int currWater = ht * width ;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater ;
    }


//2-Pointer approach
public static int mostWater2(ArrayList<Integer> height){
int lp = 0; int rp = height.size() - 1 ; int maxArea = 0;
while (lp < rp) {
    int ht = Math.min(height.get(lp), height.get(rp));
    int width = rp - lp ;
    int area = ht * width ;
    maxArea = Math.max(maxArea, area);

    if (height.get(lp) < height.get(rp)) {
        lp++ ;
    }else{
        rp -- ;
    }
}
return maxArea ;

}

public static boolean pairSum(ArrayList<Integer> list, int target){
int lp = 0 ; int rp = list.size() - 1 ; 
    while(lp != rp){

        if (list.get(lp) + list.get(rp) == target) {
            return true ;
        }

        if (list.get(lp) + list.get(rp) < target) {
            lp++ ;
        }else{
            rp -- ;
        }

    }

    return false ;
}

//sorted - rotated
public static boolean pairSum2(ArrayList<Integer> list, int target){
int bp = - 1 ;
int n = list.size();
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i) > list.get(i + 1)) {    //breaking point
            bp = i ;
            break;
        }
    }
int lp = bp + 1 ; //smallest
int rp = bp;      //largest
    while (lp != rp) {
        if (list.get(lp) + list.get(rp) == target) {
            return true ;
        }
        if (list.get(lp) + list.get(rp) < target) {
            lp = (lp + 1) % n ;     //Modular Arithmatic formula
        }else{
            rp = (n + rp - 1) % n ;
        }
    }

return false ;

}

//-----------------------------------------------------------------------------------------------

public static boolean monotonic(ArrayList<Integer> list){
    boolean inc = true ;
    boolean dec = true ;
for (int i = 0; i < list.size() - 1; i++) {
    if (list.get(i) > list.get(i + 1)) {
        inc =  false;
    }
    if (list.get(i) < list.get(i + 1)) {
        dec = false;
    }
}

return inc || dec ;

}


public static ArrayList<Integer> lonelyNums (ArrayList<Integer> list){
    //[10, 6, 5, 8, 11]
    ArrayList<Integer> output = new ArrayList<>();
    for (int i = 1; i < list.size() - 1; i++) {
        if ((list.get(i - 1) + 1) < list.get(i) && (list.get(i+1)) > list.get(i) + 1) {
            output.add(list.get(i));
        }
    }

    if (list.size() == 1) {
        output.add(list.get(0));
    }

    if (list.size() > 1) {
        if (list.get(0) + 1  < list.get(1) ) {
            output.add(list.get(0));
        }

        if (list.get(list.size()-2) + 1 < list.get(list.size()-1)) {
            output.add(list.get(list.size()-1));
        }
    }

    return output ;


}


public static int mostfreq(ArrayList<Integer> list, int key){

    int arr[] = new int[1000];
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == key) {
            arr[list.get(i + 1) - 1]++ ;
        }
    }

    int max = Integer.MIN_VALUE;
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i] ;
            ans = i + 1 ;
        }
    }
    return ans ;

}

public static ArrayList<Integer> beautifulArr(int n){

ArrayList<Integer> beautArr = new ArrayList<>();

for (int i = 1; i <= n; i++) {
   int odd = (2 * i) - 1 ;
   if (odd <= n) {
    beautArr.add(odd);
   }
}
for (int i = 1; i <= n; i++) {
    int even = 2 * i ;
    if (even <= n) {
        beautArr.add(even);
    }
}

return beautArr ;

}


public ArrayList<Integer> beautifulArray(int n) {
    ArrayList<Integer> res = new ArrayList<>();
    divideConque(1,1,res,n);
    return res;
}
private void divideConque(int start, int increment, ArrayList<Integer> res, int n) {
    if(start + increment > n) {
        res.add(start);
        return;
    }
    divideConque(start, 2 * increment,res,n);
    divideConque(start + increment, 2 * increment, res, n);
}


    public static void main(String[] args) {
        //ArrayList is a part of Java collection framework
        //Classname objectname = new Classname();
        ArrayList<Integer> list1 = new ArrayList<>() ;
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        //add element
        list1.add(1);       // O(1)
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list1.add(1, 10);   // O(n)
        System.out.println(list1);

        //Get Operation     - O(1)
        int getNum = list1.get(3);
        System.out.println("getOperation "+ getNum);

        //Delete Operation   - O(n)
        list1.remove(2);
        System.out.println(list1);

        //Set Element at index  - O(n)
        list1.set(0, 10);
        System.out.println(list1);

        //Contains
        System.out.println(list1.contains(2));
        System.out.println(list1.contains(11));


        list2.add("A");       // O(1)
        list2.add("B");  
        list2.add("C");  
        list2.add("D");  
        //size() function - It's a method (func), not a property like .length
        System.out.println(list1.size());

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
        System.out.println();

        //Reverse Print - O(n)
        for (int i = list2.size() - 1; i >= 0; i--) {
            System.out.print(list2.get(i) + " ");
        }
        System.out.println();

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(5);
        list4.add(9);
        list4.add(6);
        list4.add(8);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list4.size(); i++) {
            // if (max < list4.get(i)) {
            //     max = list4.get(i);
            // }
            max = Math.max(max, list4.get(i));
        }
        System.out.println("maximum number is "+ max);

        //swap 2 numbers in arraylist
        int idx1 = 1, idx2 = 3 ;
       System.out.println(list4);
        swapInt(list4,idx1, idx2);
        System.out.println("swapped - "+list4);


        //inbuilt method to sort arraylist
        Collections.sort(list4);
        System.out.println("sorted - " + list4);

        //reverse order
        Collections.sort(list4, Collections.reverseOrder()); //Parameter 2 is a Comparator Func.
        System.out.println("desc order - "+list4);

//Multi-Dimensional ArrayList
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        // ArrayList<Integer> row1 = new ArrayList<>();
        // row1.add(1); row1.add(2); row1.add(3);
        // mainList.add(row1);

        // ArrayList<Integer> row2 = new ArrayList<>();
        // row2.add(4); row2.add(5); row2.add(6);
        // mainList.add(row2);

        // System.out.println("print MainList");
        // for (int i = 0; i < mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for (int j = 0; j < currList.size(); j++) {
        //         System.out.print(currList.get(j));
        //     }
        //     System.out.println();
        // }

        // System.out.println(mainList);



        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> l1 =new ArrayList<>();
        ArrayList<Integer> l2 =new ArrayList<>();
        ArrayList<Integer> l3 =new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
            l1.add(i * 1);
            l2.add(i * 2);
            l3.add(i * 3);
        }
        mainList.add(l1);
        mainList.add(l2);
        mainList.add(l3);

       for (int i = 0; i < mainList.size(); i++) {
         ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
       }

//Container with most water
ArrayList<Integer> height = new ArrayList<>();
//{1,8,6,2,5,4,8,3,7}
height.add(1);
height.add(8);
height.add(6);
height.add(2);
height.add(5);
height.add(4);
height.add(8);
height.add(3);
height.add(7);

//brute force approach
System.out.println("maximum water stored in a container " + mostWater(height));

//2-Pointer approach
System.out.println("maximum water stored in a container " + mostWater2(height));

//Pair Sum - 2Pointer approach
ArrayList<Integer> list = new ArrayList<>();
list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
int target = 5 ;
System.out.println(pairSum(list, target));


//Pair Sum Advanced - 
ArrayList<Integer> pairList = new ArrayList<>();
int tar = 16 ;
pairList.add(11);
pairList.add(15);
pairList.add(6);
pairList.add(8);
pairList.add(9);
pairList.add(10);


System.out.println(pairSum2(pairList, tar));

//-----------------------------------------------------------------------------------------------
//Q1. Monotonic ArrayList

// ArrayList<Integer> monoArray = new ArrayList<>();
// monoArray.add(1);
// monoArray.add(3);
// monoArray.add(2);
// System.out.println("mono "+monotonic(monoArray));


//Q2.Lonely Numbers in ArrayList

// ArrayList<Integer> lonelyArray = new ArrayList<>();
// lonelyArray.add(10);
// lonelyArray.add(6);
// lonelyArray.add(5);
// lonelyArray.add(8);
// lonelyArray.add(11);
// System.out.println("lonely nums are  " + lonelyNums(lonelyArray));

//Q3. Most Frequent Number following Key
ArrayList<Integer> Mostfreqkey = new ArrayList<>();
int key = 1 ;
Mostfreqkey.add(1);
Mostfreqkey.add(100);
Mostfreqkey.add(200);
Mostfreqkey.add(1);
Mostfreqkey.add(100);

System.out.println(mostfreq(Mostfreqkey, key));

//Beautiful ArrayList
System.out.println(beautifulArr(10));
System.out.println(beautifulArr(10));

    }
}
