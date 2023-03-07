import java.util.*;

public class matrixPrac {

    public static boolean search(int matrix[][], int key){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               if (matrix[i][j] == key) {
                System.out.println("key found at index : ( "+ i+", "+j+" )");
                return true;
               }
            }
        }
        System.out.println("key not found !");
        return false;
    }

    public static void largeNsmall(int matrix[][]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > largest) {
                    largest = Math.max(largest,  matrix[i][j]);
                } if (matrix[i][j] < smallest) {
                    smallest = Math.min(smallest, matrix[i][j]); 
                }
            }
        }
        System.out.println("largest value in matrix is : "+ largest);
        System.out.println("smallest value in matrix is : "+ smallest);
    }
   
    public static void inputMatrix(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
      Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    
    public static void outputMatrix(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
      Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");            
            }
            System.out.println();
        }
    }
    
    public static void spiralMatrix(int matrix[][]){
    int n = matrix.length;
    int m = matrix[0].length;

    int startRow =0;
    int endRow = n - 1;
    int startCol = 0;
    int endCol = m - 1;
        while (startRow <= endRow && startCol < endCol) {
            //top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            //right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            //bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                System.out.print(matrix[endRow][j] + " ");
            }
            //left
            for (int i = endRow - 1; i >= startRow+1; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        System.out.println();

 
    }
   
   public static int diagonalSum(int matrix[][]){
    //brute force - TC = O(n^2)
        // int sum = 0;
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         if (i == j) {
        //             sum += matrix[i][j];
        //         }else if( i + j == matrix.length - 1){
        //             sum += matrix[i][j];
        //         }
        //     }
        // }
        // return sum;

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            //primary diagonal
             sum += matrix[i][i];
            //secondary diagonal
            if (i != matrix.length - 1 - i) { // for odd matrix conditions
            sum += matrix[i][matrix.length - 1 - i];
            }

        }
        return sum;
   }
   
   public static boolean staircaseSearch(int matrix[][], int key){
    
    int row = 0, col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
        if (key == matrix[row][col]) {
            System.out.println("element found at index : ("+row+", "+col+" )");
            return true;
        }else if(key < matrix[row][col]){
            col--;
        }else{
            row++;
        }
    }
    System.out.println("Element not found in the given matrix !");
    return false;
   }
   
   public static boolean staircaseSearch2(int matrix[][], int key){
    int row = matrix.length - 1, col = 0;
    while (row >= 0 && col < matrix.length ) {
        if (matrix[row][col] == key) {
            System.out.println("element found at index : ("+row+", "+col+" )");
            return true;
        }else if(key < matrix[row][col]){
            row--;
        }else{
            col++;
        }
    }
    System.out.println("Element not found in the given matrix !");
    return false;
   }
   
   public static void printMatrix(int matrix[][]){
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
   }
//---------------------------------------------------------------------------

   public static void main(String[] args) {
        // int matrix[][] = new int[3][3];
        // int n = matrix.length; int m = matrix[0].length;

//search(matrix, 5);


//largeNsmall(matrix);
// int matrix[][] = new int[4][4];
// inputMatrix(matrix);


//spiralMatrix(matrix);


// int diagonalSum = diagonalSum(matrix);
// System.out.println("sum of diagonal elements is : "+ diagonalSum);


// int nums[][] = {{10,20,30,40},
//                 {15,25,35,45},
//                 {27,29,37,48},
//                 {32,33,39,50}
//                 };

// staircaseSearch2(nums, 35);
//---------------------------------------------------------------------------

//QnA
//1.
    // int nums[][] = {{4,7,8},
    //                 {8,8,7}}; 
    // int count = 0;
    // for (int i = 0; i < nums.length; i++) {
    //     for (int j = 0; j < nums[0].length; j++) {
    //         if (nums[i][j] == 7) {
    //             count++;
    //         }
    //     }
    // }
    // System.out.println(count+ " times number '7' ocuured in matrix ! ");

//2.
// int nums[][] = {{1,4,9},
//                 {11,4,3},
//                 {2,2,3}
//                };
//     int sum = 0;
//     for (int i = 1; i < nums.length - 1; i++) {
//         for (int j = 0; j < nums.length; j++) {
//             sum += nums[i][j];
//         }
//     }
//     System.out.println(sum);

//3.
//find transpose of matrix

    // int matrix[][] = {{2,3,7}, 
    //                   {5,6,7}};
    // int row = 2, col = 3;
    // printMatrix(matrix);
    // System.out.println();

    // int transpose[][] = new int[col][row];
    // for (int i = 0; i < row; i++) {
    //     for (int j = 0; j < col; j++) {
    //         transpose[j][i] = matrix[i][j];
    //     }
    // }
    // printMatrix(transpose);

    }    
    }
