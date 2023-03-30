import java.util.*;
public class PatternsII {
    public static void main(String[] args) {
    
//------------------------------------------------------------------------------------------------------------------------------------
//1. 
        // *****
        // *   *
        // *   *
        // *   *
        // *****

    //   int n = 5;
    //   for (int i = 1; i <= n; i++) {
    //     for (int j = 1; j <= n; j++) {
    //         if (i==1 || i == n || j==1 || j==n) {
    //         System.out.print("*");
                
    //         } else {
    //             System.out.print(" ");
    //         }
            
    //     }
    //     System.out.println();
    //   }

//------------------------------------------------------------------------------------------------------------------------------------
//2. Inverted & Rotated Half Pyramid
//     *
//    **
//   ***
//  ****

// int n = 6;
// for (int i = 1; i <= n; i++) {
//     for (int j = n; j > i; j--) {
//         System.out.print(" ");
//     }
//     for (int k = 1; k <= i; k++) {
//         System.out.print("*");
//     }
//     System.out.println();
// }
 
//------------------------------------------------------------------------------------------------------------------------------------
//3.cInverted Half-Pyramid Pattern with Numbers

    // 1 2 3 4 5 
    // 1 2 3 4 
    // 1 2 3 
    // 1 2 
    // 1 

// int n = 5;
// for (int i = 1; i <= n; i++) {
//     int count = 1 ;
//     for (int j = n; j >= i; j--) {
//         System.out.print(count+ " ");
//         count++;
//     }
//     System.out.println();
// }


//------------------------------------------------------------------------------------------------------------------------------------
//4. Floyed's Triangle
    // 1 
    // 2 3 
    // 4 5 6 
    // 7 8 9 10 
    // 11 12 13 14 15

// int n = 5;
// int count = 1;
// for (int i = 1; i <= n; i++) {
//     for (int j = 1; j <= i; j++) {
//         System.out.print(count + " ");
//         count++;
//     }
//     System.out.println();
// }

//------------------------------------------------------------------------------------------------------------------------------------
//5. 
    // 1 
    // 0 1 
    // 1 0 1 
    // 0 1 0 1 
    // 1 0 1 0 1 

    // int n = 5;
    // for (int i = 1; i <= n; i++) {
    //     for (int j = 1; j <= i; j++) {
    //         if ((i+j)%2 == 0) {
    //             System.out.print("1 ");
    //         }else{
    //         System.out.print("0 ");
    //         }
    //     }
    //     System.out.println();
    // }


//------------------------------------------------------------------------------------------------------------------------------------
//6. ButterFly Pattern
    // *      *
    // **    **
    // ***  ***
    // ********
    // ********
    // ***  ***
    // **    **
    // *      *

    // int n = 4;
    // for (int i = 1; i <= n; i++) {
    //         for (int j = 1; j <= i; j++) {
    //             System.out.print("*");
    //         }
            
    //         for (int j = 1; j <= 2*(n - i); j++) {
    //             System.out.print(" ");
    //         }

    //         for (int k = 1; k <= i; k++) {
    //             System.out.print("*");
    //         }
    //         System.out.println();
    // }
    // for (int i = n; i >= 1; i--) {
    //     for (int j = 1; j <= i; j++) {
    //         System.out.print("*");
    //     }
        
    // for (int j = 1; j <= 2*(n - i); j++) {
    // System.out.print(" ");
    // }
    //     for (int k = 1; k <= i; k++) {
    //         System.out.print("*");
    //     }
    //     System.out.println();  
    // }

//------------------------------------------------------------------------------------------------------------------------------------
//7. Rhombus Pattern
    //     * * * * * 
    //    * * * * * 
    //   * * * * * 
    //  * * * * * 
    // * * * * * 

    //     int n = 5;
    // for (int i = 1; i <= n; i++) {
    //     for (int j = n; j >=i ; j--) {
    //         System.out.print(" ");
    //     }
    //     for (int j = 1; j <= n; j++) {
    //         System.out.print("* ");
    //     }
    //     System.out.println();
    // }

//------------------------------------------------------------------------------------------------------------------------------------
//8. Hollow Rhombus
    //     * * * * * 
    //    *       * 
    //   *       * 
    //  *       * 
    // * * * * * 

    //     int n = 5;
    // for (int i = 1; i <= n; i++) {
    //     for (int j = n; j >=i ; j--) {
    //         System.out.print(" ");
    //     }
    //     for (int j = 1; j <= n; j++) {
    //         if (i == 1 || i == n || j == 1 || j == n) {
    //             System.out.print("* ");
    //         } else {
    //             System.out.print("  ");
    //         }
            
    //     }
    //     System.out.println();
    // }


//------------------------------------------------------------------------------------------------------------------------------------
//9. Diamond Pattern

//           * 
//         * * * 
//       * * * * * 
//     * * * * * * * 
//   * * * * * * * * * 
//   * * * * * * * * * 
//     * * * * * * * 
//       * * * * * 
//         * * * 
//           * 

    // int n = 5;
    // for (int i = 1; i <= n; i++) {
    //     for (int j = n; j >= i; j--) {
    //         System.out.print("  ");
    //     }for (int j = 1; j <= i; j++) {
    //         System.out.print("* ");
    //     }
    //     for(int j = 2; j<=i; j++ ){
    //         System.out.print("* ");
    //     }
    //     System.out.println();
    // }
    // for (int i = n; i >= 1; i--) {
    //     for (int j = n; j >= i; j--) {
    //         System.out.print("  ");
    //     }for (int j = 1; j <= i; j++) {
    //         System.out.print("* ");
    //     }
    //     for(int j = 2; j<=i; j++ ){
    //         System.out.print("* ");
    //     }
    //     System.out.println(); 
    // }

//------------------------------------------------------------------------------------------------------------------------------------
//10.
    //        1 
    //       2 2 
    //      3 3 3 
    //     4 4 4 4 
    //    5 5 5 5 5 


    // int n = 5; 
    // int count = 1;
    // for (int i = 1; i <= n; i++) {
    
    //     for (int j = n; j >= i; j--) {
    //         System.out.print("  ");
    //     }
    //     for (int m = 1; m <= i; m++) {
    //         System.out.print(" ");
    //     }
    //     for (int k = 1; k <= i; k++) {
    //         System.out.print(count + " ");
        
    //     }
    
    //     count++;
    //     System.out.println();
    // }

//------------------------------------------------------------------------------------------------------------------------------------
//11.
//Pallindromic Pattern with Numbers
//           1 
//         2 1 2 
//       3 2 1 2 3 
//     4 3 2 1 2 3 4 
//   5 4 3 2 1 2 3 4 5 

    // int n = 5;
    // int count = 0;
    // for (int i = 1; i <= n ; i++) {
    //     for (int j = n; j >= i; j--) {
    //         System.out.print("  ");

    //     }
    //     for (int j = i; j >= 1; j--) {
    //         System.out.print(j + " ");
        
    //     }
    //     for (int j = 2; j <= i ; j++) {
    //         System.out.print(j + " ");
    //     }
    //     System.out.println();
    // }


//------------------------------------------------------------------------------------------------------------------------------------




}
}
