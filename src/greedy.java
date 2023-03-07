import java.util.* ;
import java.util.Arrays;

public class greedy {

    static class Job{
        int deadline;
        int profit ;
        int id ;

        Job(int i, int d, int p){
            id = i ;
            profit = p;
            deadline = d ;
        }

    }

public static int maxBalancedstr(String str){
    int n = str.length(); 
    int ans = 0 ;
    int r = 0, l = 0 ;

    for (int i = 0; i < n; i++) {
        if (str.charAt(i) == 'R') {
            r++ ;
        }else if(str.charAt(i) == 'L'){
            l++ ;
        }
        if (r == l) {
            ans++ ;
        }
    }

    return ans ;
}

public static int kthOdd(int[] range, int K) {
    if (K <= 0)
    return 0;
    
    int L = range[0];
    int R = range[1];
    if ((R & 1) > 0) {
        int Count = (int) Math.ceil((R - L + 1) / 2);
        if (K > Count)
        return 0;
        else
        return (R - 2 * K + 2);
    } else {
        int Count = (R - L + 1) / 2;
        if (K > Count)
        return 0;
        else
        return (R - 2 * K + 1);
    }
}
   
public static char[] lexismallStr(int K, int N){
 char[] arr = new char[N] ;
 Arrays.fill(arr, 'a');

 for (int i = N - 1; i >= 0; i++) {
    K = K - i ;

    if (K >= 0) {
        if (K >= 26) {
            arr[i] = 'z' ;
            K = K - 26 ;
        }else{
            arr[i] = (char)(K + 97 - 1);
            K = K - (arr[i] - 'a' + 1);
        }
    }else
        break ;
        
        K = K + i ;
    
    }
    return arr ;

}

public static int buynSell(int arr[]){
int sp = 0, bp = arr[0];
int maxProfit = 0 ;
for (int i = 1; i < arr.length; i++) {
    sp = arr[i];
    int profit = sp - bp ;
    maxProfit = Math.max(maxProfit, profit);
    bp = Math.min(sp, bp);
}

return maxProfit ;
}


public static void main(String[] args) {
//Activity Selection

    //     int start[] = {1,3,0,5,8,5};
    //     int end[] = {2,4,6,7,9,9};      //sorted end time

    // //sorting - (if end is not sorted)
    //     int activities[][] = new int[start.length][3];
    //     for (int i = 0; i < start.length; i++) {
    //         activities[i][0] = i ;
    //         activities[i][1] = start[i];
    //         activities[i][2] = end[i];
    //     }
    //     //lambda function 
    //     Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));


    //     int maxAct = 0 ;
    //     ArrayList<Integer> arr  =new ArrayList<>(); 
    //     //add first task
    //     maxAct = 1 ;
    //     arr.add(activities[0][0]);
    //     int lastEnd = activities[0][2];
    //     for (int i = 1; i < end.length; i++) {
    //         if (activities[i][1] >= lastEnd) {
    //             maxAct++ ;
    //             arr.add(activities[i][0]);
    //             lastEnd = activities[i][2];
    //         }
    //     }
    //     System.out.println("Max activities are "+ maxAct);
    //     for (int i = 0; i < arr.size(); i++) {
    //         System.out.print("A"+ arr.get(i) + " ");
    //     }
    //     System.out.println();



//Fractional Knapsack

    // int val[] = {60, 100, 120};
    // int weight[] = {10, 20, 30};
    // int capacity = 50 ;

    // double ratio[][] = new double[val.length][2];
    // //0th col = index & 1st col = ratio

    // for (int i = 0; i < val.length; i++) {
    //     ratio[i][0] = i ;
    //     ratio[i][1] = val[i]/(double)weight[i];
    // }

    // //ascending order
    // Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
    // int finalVal = 0;
    // for (int i = ratio.length - 1; i >= 0; i--) {
    //     int idx = (int)ratio[i][0];
    //     if (capacity >= weight[idx]) {
    //         finalVal += val[idx];
    //         capacity -= weight[idx];
    //     }else{
    //         //include fractional item
    //         finalVal += (ratio[i][1] * capacity);
    //         capacity = 0 ;
    //         break ;
    //     }
    // }

    // System.out.println("final value = " + finalVal);

//min absolute diff of pairs
    // int A[] = {4,1,8,7};
    // int B[] = {2,3,6,5};

    // Arrays.sort(A);
    // Arrays.sort(B);

    // int minDiff = 0 ;
    // for (int i = 0; i < A.length; i++) {
    //     minDiff += Math.abs(A[i] - B[i]);
    // }

    // System.out.println("min absolute diff of pairs = " + minDiff);


//Max length chain of pairs
    // int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

    // Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    // int chainlength = 1 ;
    // int chainEnd = pairs[0][1];

    // for (int i = 1; i < pairs.length; i++) {
    //     if (pairs[i][0] > chainEnd) {
    //         chainlength++ ;
    //         chainEnd = pairs[i][1];

    //     }
    // }
    // System.out.println("Max length of chain = " + chainlength);


//Indian Coins

    // Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
    // int amount = 590; 
    // ArrayList<Integer> ans = new ArrayList<>();

    // Arrays.sort(coins, Comparator.reverseOrder());
    // int countofCoins = 0 ;
    // for (int i = 0; i < coins.length; i++) {
    //     if (coins[i] < amount) {
    //         while (coins[i] <= amount) {
    //             countofCoins++ ;
    //             ans.add(coins[i]);
    //             amount -= coins[i]; 

    //         }
    //     }
    // }
    // System.out.println("Total (min) coins used are = "+ countofCoins);
    // for (int i = 0; i < ans.size(); i++) {
    //     System.out.print(ans.get(i) + " ");
    // }
    // System.out.println();

    
//Job Sequencing problem ;
    // int jobinfo[][] = {{4,20},{1,10},{1,40},{1,30}};

    // ArrayList<Job> jobs = new ArrayList<>();
    // for (int i = 0; i < jobinfo.length; i++) {
    //     jobs.add(new Job(i, jobinfo[i][0], jobinfo[i][1]));
    // }

    // //sort jobs in descending order based on profit using lambda function
    // Collections.sort(jobs, (obj1,obj2) -> obj2.profit - obj1.profit);

    // ArrayList<Integer> seq = new ArrayList<>();
    // int time = 0;

    // for (int i = 0; i < jobs.size(); i++) {
    //     Job curr = jobs.get(i) ;
    //     if (curr.deadline > time) {
    //         seq.add(curr.id);
    //         time++ ;
    //     }
    // }

    // System.out.println("max jobs = "+ seq.size());
    // for (int i = 0; i < seq.size(); i++) {
    //     System.out.print(seq.get(i) + " ");
    // }
    // System.out.println();


//Chocola problem
    // Integer costVer[] = {2, 1, 3, 1, 4} ;
    // Integer costHor[] = {4, 1, 2} ;

    // Arrays.sort(costVer, Collections.reverseOrder());
    // Arrays.sort(costHor, Collections.reverseOrder());

    // int h = 0, v = 0 ;
    // int hp = 1, vp = 1 ;
    // int minCost = 0 ;

    // while (h < costHor.length && v < costVer.length) {
    //     if (costHor[h] >= costVer[v]) {
    //         minCost += costHor[h] * vp ;
    //         hp++ ;
    //         h++ ;
    //     }else{

    //         minCost += costVer[v] * hp ;
    //         vp++ ;
    //         v++ ;
    //     }
    // }

    // while (h < costHor.length) {
    //     minCost += costHor[h] * vp ;
    //     hp++ ;
    //     h++ ;
    // }
    // while (v < costVer.length) {
    //     minCost += costVer[v] * hp ;
    //     vp++ ;
    //     v++ ;
    // }

    // System.out.println("Min cost is = " + minCost);

//Maximum Balanced String Partitions
    // String input = "LRRRRLLRLLRL";
    // int max =  maxBalancedstr(input);
    // System.out.println("Maximum Balanced substrings are "+max);


//Kth largest odd number in a given range
    // int[] p = { -10, 10 };
    // int k = 8;
    // System.out.println(kthOdd(p, k));


//Lexicographically smallest string of length N and sum K
    // int K = 25 ; int N = 3 ;
    // char[] result = lexismallStr(K, N);
    // System.out.println(result);


//Best Time to Buy and Sell Stock
    // int arr[] = {7,6,4,3,1};
    // int profit = buynSell(arr);
    // System.out.println(profit);

//Split the given array into K sub-array







}    
}
