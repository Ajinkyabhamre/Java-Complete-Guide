import java.util.*;

public class Matrices{
    
    public static boolean search(int matrix[][], int key){
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if (matrix[i][j] == key) {
                   System.out.println("element found at ("+ i+" , "+ j+")");
                   return true;
                }
            }
        }
        return false;
    }

//---------------------------------------------------------------------------------------------------------

    public static void printSpiral(int matrix[][]){
    int startRow = 0;
    int startCol = 0;
    int endRow = matrix.length - 1;
    int endCol = matrix[0].length - 1;

    while (startRow <= endRow && startCol <= endCol) {
        
        //top
        for (int j = startCol; j <= endCol; j++) {
            System.out.print(matrix[startRow][j] + " ");
        }

        //right
        for (int i = startRow+1; i <= endRow; i++) {
            System.out.print(matrix[i][endCol]+ " ");
        }
        //bottom
        for (int j = endCol - 1; j >= startCol; j--) {
            //special condition 
            if (startRow == endRow) {
                break;
            }
            System.out.print(matrix[endRow][j]+ " ");
        }
        //left
        for (int i = endRow - 1; i >= startRow+1; i--) {
             //special condition 
             if (startCol == endCol) {
                break;
            }
            System.out.print(matrix[i][startCol]+ " ");
        }
        
        System.out.println();
        
        startRow++;
        endRow--;
        startCol++;
        endCol--;
    }
}

public static int diagonalSum(int matrix[][]){

// brute force --> TC = O(n^2)

// int sum = 0;
// for (int i = 0; i < matrix.length; i++) {
//     for (int j = 0; j < matrix[0].length; j++) {
//         if (i == j) {
//             sum += matrix[i][j];
//         }else if(i+j == matrix.length - 1){
//             sum += matrix[i][j];
//         }
//     }
// }
// return sum;

//---------------------------------------------------------------
// TC = O(n)
int sum = 0;
for (int i = 0; i < matrix.length; i++) {
    
    //primary diagonal
    sum += matrix[i][i];
    
    //secondary diagonal ---> i+j = n - 1 ---> j = n - 1 - i
    //below if condition is for n is odd so values of diagonal overlap
    if (i != matrix.length - 1 - i) { 
        sum += matrix[i][matrix.length - 1 - i];
    }
    
   }
    
 return sum;

}

public static boolean staircaseSearch(int matrix[][], int key){
// TC = O(n + m) --> whichever gratest n or m

//start from top right corner 
    // int row = 0; int col = matrix[0].length - 1;
    //     while (row < matrix.length && col >= 0) {
    //         if (key == matrix[row][col]) {
    //             System.out.println("key found at position ("+row+", "+col+")");
    //             return true;
    //             } else if(key < matrix[row][col]){
    //                 col --;
    //                 }else{
    //                     row++;
    //                     }
            

    //     }    

//start from bottom left corner 
int row = matrix.length - 1; int col = 0;
    while (row >= 0 && col < matrix[0].length) {
        if (key == matrix[row][col]) {
            System.out.println("key found at position ("+row+", "+col+")");
            return true;
        } else if(key < matrix[row][col]){
            row--;

        }else{
            col++;
        }
    }
    
    System.out.println("key not found !");
    return false;

}

public static int noOfsevens(int matrix[][]){
    int count = 0;
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 7) {
            count++;
        }
    }
}
return count;
    
}

public static int sumofSecondrow(int matrix[][]){
int sum = 0;

for (int j = 0; j < matrix.length; j++) {
    sum += matrix[1][j];
}
return sum;

}

public static void print(int matrix[][]){
for (int i = 0; i < matrix.length; i++) {
  for (int j = 0; j < matrix[0].length; j++) {

    System.out.print(matrix[i][j]+" ");
  }
System.out.println();
}
System.out.println();
}

//---------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        //int matrix[][] = new int[3][3];
        
        // matrix.length is total rows & matrix[0].length is total columns
        //int n = matrix.length ; int m = matrix[0].length;
        
        //input
        // Scanner sc = new Scanner(System.in);
        // for(int i = 0; i< n; i++){
        //     for(int j = 0; j< m; j++){
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        //output
        // for(int i = 0; i< n; i++){
        //     for(int j = 0; j< m; j++){
        //         System.out.print(matrix[i][j] + " "); 
        //     }
        //     System.out.println();
        // }
//---------------------------------------------------------------------------------------------------------

        // find a specific element in 2D Array
        // boolean result = search(matrix, 5);
        // System.out.println(result);

//---------------------------------------------------------------------------------------------------------

        // print spiral
        // int TwoD[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // printSpiral(TwoD);

//---------------------------------------------------------------------------------------------------------
// int diagonalmatrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
// int result = diagonalSum(diagonalmatrix);
// System.out.println("result of diagonal sum is "+result);


//---------------------------------------------------------------------------------------------------------

// int staircaseMatrix[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
// int key = 33;
// boolean result = staircaseSearch(staircaseMatrix, key);
// System.out.println(result);

//---------------------------------------------------------------------------------------------------------
//Q . Print the number of 7’s that are in the 2d array.
//Example :Input - int[][] array = { {4,7,8},{8,8,7} };   Output - 2

    // int array[][] = { {4,7,8},{8,8,7} };
    // int result = noOfsevens(array);
    // System.out.println("No. of 7's are " + result);

//---------------------------------------------------------------------------------------------------------
//Q.Print out the sum of the numbers in the second row of the “nums” array.
//  Example :Input - int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
//  Output - 18

    // int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
    // int totalSum = sumofSecondrow(nums);
    // System.out.println("total sum of second row is "+totalSum);

//---------------------------------------------------------------------------------------------------------
//Q. Write a program to Find Transpose of a Matrix

int matrix[][] = { {4,7,8},{8,8,7} };
int row = 2; int col = 3;

int transpose[][] = new int[col][row];
for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
        transpose[j][i] = matrix[i][j];
    }
}
print(matrix);
print(transpose);

    }
}