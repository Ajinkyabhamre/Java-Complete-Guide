public class DP1 {
//normal recurssion
    // public static int fib(int n){
    //     if (n == 0 || n == 1) {
    //         return n ;
    //     }
    //     int a = fib(n - 1);
    //     int b = fib(n - 2);
    //     return a + b;
    // }

    public static int fib(int n, int[] f){ //TC = O(n+1) = O(n)
        if (n == 0 || n == 1) {
            return n ;
        }
      if (f[n] != 0) { //fib(n) is already calculated. (memoization)
        return f[n];
      }
      f[n]  = fib(n - 1, f) + fib(n - 2, f);
      return f[n]; 
       
    }

    public static int fibTab(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1; 
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // public static int knapSack(int[] val, int[] wt, int W, int n){
    //     if (W == 0 ||  n == 0) {
    //         return 0;
    //     }

    //     if(wt[n-1] <= W){
    //     //include
    //     int ans1 = val[n - 1] + knapSack(val, wt, W - wt[n - 1], n - 1);
    //     int ans2 = knapSack(val, wt, W, n - 1);
    //     return Math.max(ans1, ans2);
    //     }else{
    //         return knapSack(val, wt, W, n - 1);
    //     }
    // }
    public static int knapSack(int[] val, int[] wt, int W, int n, int dp[][]){ //O(n *  W)
        if (W == 0 ||  n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if(wt[n-1] <= W){
        //include
        int ans1 = val[n - 1] + knapSack(val, wt, W - wt[n - 1], n - 1, dp);
        int ans2 = knapSack(val, wt, W, n - 1, dp);
        dp[n][W] =  Math.max(ans1, ans2);
        return  dp[n][W];
    }else{
        dp[n][W] =  knapSack(val, wt, W, n - 1, dp);
        return  dp[n][W];
        }
    }
public static int lcs(String str1, String str2){
    int n = str1.length();
    int m = str2.length();
    int dp[][] = new int[n+1][m+1];
    for (int i = 0; i < n+1; i++) {
        dp[i][0] = 0 ;
    }
    for (int j = 0; j < m+1; j++) {
        dp[0][j] = 0 ;
    }

    for (int i = 1; i < n+1; i++) {
        for (int j = 1; j < m+1; j++) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                dp[i][j] = dp[i-1][j-1] + 1;
            }else{
                int ans1 = dp[i-1][j];
                int ans2 = dp[i][j-1];
                dp[i][j] = Math.max(ans1, ans2);
            }
        }   
    }
    return dp[n][m];
}
    public static void strConv(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int lcsNum = lcs(str1, str2);
        int deletion = n - lcsNum;
        int insertion = m - lcsNum;
System.out.println("insertion: " + insertion + " & " + " deletion: " + deletion);

    }

    public static int catalanOF(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
    return dp[n];
    }
    public static void main(String[] args) {
        // int n = 5;
        // int[] f = new int[n + 1]; // 0, 0, 0, 0 ...  memoization
        // System.out.println(fib(5, f));
        // System.out.println(fibTab(n));


// 0-1 KnapSack
// int[] val = {15, 14, 10, 45, 30};
// int[] wt = {2,5,1,3,4};
// int W = 7;
// int dp[][] = new int[val.length + 1][W + 1];
// for (int i = 0; i < dp.length; i++) {
//     for (int j = 0; j < dp[0].length; j++) {
//         dp[i][j] = -1 ;
//     }
// }
// System.err.println(knapSack(val, wt, W, val.length, dp));


//String conversion - //convert str1 to str2 with only insertion and deletion operation
// String str1 = "abc";
// String str2 = "abc";

// strConv(str1, str2);



//Catalan's Numbers

System.out.println(catalanOF(40));



    }
}
