import java.util.* ;

public class backTracking {

public static void printArray(int arr[]){
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
System.out.println();
}

public static void changeArr(int arr[], int i, int value){
//base-case
if (i == arr.length ) {
   printArray(arr);
   return ;
}
    //kaam
    arr[i] = value ;
    changeArr(arr, i + 1, value + 1); //func call statement
    arr[i] = arr[i] - 2 ;             //backtracking step
}

public static void findSubsets(String str, String ans, int i){
//Base case
if (i == str.length()) {
       
        if (ans.length() == 0) {
             //null condition
            System.out.println("null");
        }else{
            //print each subset
            System.out.println(ans + " ");
        }

    return;
}

//Recursion
//Yes Case -
findSubsets(str, ans+str.charAt(i), i + 1);

//No Case -
findSubsets(str, ans, i + 1);

}

public static void findPermutations(String str, String ans){

//Base Case
if (str.length() == 0) {
    System.out.println(ans);
    return;
}
//Recurssion - O( n x n! )
for (int i = 0; i < str.length(); i++) {
    char curr = str.charAt(i);
    String newStr = str.substring(0, i) + str.substring( i+1);
    findPermutations(newStr, ans + curr);
}


}

//N-Queens
static int totalWays = 0;
public static boolean checkPos(char board[][], int row, int col){

//vertical up
for (int i = row - 1; i >= 0; i--) {
    if (board[i][col] == 'Q') {
        return false;
    }
}
//left vertical side
for (int i = row - 1, j = col - 1; i >=0 && j>=0; i--, j--) {
    if (board[i][j] == 'Q') {
        return false;
    }
}

//right vertical side
for (int i = row - 1, j = col + 1; i >=0 && j < board.length; i--, j++) {
    if (board[i][j] == 'Q') {
        return false;
    }
}

return true ;


}

public static void nQueens(char board[][], int row){
    //base case
if (row == board.length) {
    printBoard(board);
    totalWays++;
    return;
}
    //recurssion
    for (int j = 0; j < board.length; j++) {
        if(checkPos(board, row, j)){
            board[row][j] = 'Q';
            nQueens(board, row + 1);
            board[row][j] = 'X';
        }
       
    }
}

public static void printBoard(char board[][]){
    System.out.println("------------chess board------------");
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
            System.out.print(board[i][j] + " ");
        }
    System.out.println();

    }
}
public static void printBoard(int board[][]){
    System.out.println("------------chess board------------");
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
            System.out.print(board[i][j] + " ");
        }
    System.out.println();

    }
}

//grid ways
public static int gridWays(int x, int y, int n, int m){ //TC = 2^n+m 

//Base case
if (x == n - 1 && y == m - 1) {
    return 1 ;
}
//corner case
else if (x == n || y == n) { //boundry cross case
    return 0 ;
}
//recurssion
int w1 = gridWays(x+1, y, n, m);
int w2 = gridWays(x, y+1, n, m);
return w1 + w2 ;

}

public static int fact(int a){
    //base case
if (a == 0) {
    return 1 ;
}
    //recursion
  return fact(a - 1) * a ;
}
public static int gridWays2(int n, int m){

    int numerator = n - 1 + m - 1;
    int deno1 = (n - 1);
    int deno2 = (m - 1);
    int totalWays = fact(numerator)/(fact(deno1)* fact(deno2)) ;

    return totalWays ;
//    return fact(n - 1 + m - 1)/ fact(n - 1) * fact(m - 1) ;
}


public static boolean isSafe(int sudoku[][], int row, int col, int digit){

//col
for (int i = 0; i <= 8; i++) {
    if (sudoku[i][col] == digit) {
        return false ;
    }
}

//row
for (int j = 0; j <= 8; j++) {
    if (sudoku[row][j] == digit) {
        return false ;
    }
}

//grid
int startRow = (row/3) * 3 ;
int startCol = (col/3) * 3 ;

for (int i = startRow; i < startRow + 3; i++) {
    for (int j = startCol; j < startCol + 3; j++) {
        if(sudoku[i][j] == digit){
            return false;
        }
    }
}

return true ;
}

public static boolean solveSudoku(int sudoku[][], int row, int col){

//Base Case
if (row == 9) {
    return true ;
}

//Recurssion
int nextRow = row ; int nextCol = col + 1 ;
if (col + 1 == 9) {
    nextRow = row + 1;
    nextCol = 0;
}

if (sudoku[row][col] != 0) {
   return solveSudoku(sudoku, nextRow, nextCol) ;
}

for (int digit = 1; digit <= 9; digit++) {
    if(isSafe(sudoku, row, col, digit)){
    sudoku[row][col] = digit ;
    if(solveSudoku(sudoku, nextRow, nextCol)){ //sol exist
        return true ;
    }
    sudoku[row][col] = 0; 

    }
}

return false ;

}

public static void printSudoku(int sudoku[][]){
    System.out.println("------------sudoku-------------");
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            System.out.print(sudoku[i][j] + " ");
        }
        System.out.println();
    }
}
//Rat in Maze
public static boolean RatinMaze(int maze[][] ){
int N = maze.length;
int sol[][] = new int[N][N];
if(solveMaze(maze, 0, 0, N, sol) == false){
    System.out.println("solution doesn't exists !");
    return false ;
}
printBoard(sol);
return true ;
   
}

public static boolean isRatSafe(int maze[][], int x, int y){
    int N = maze.length;
    return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
}

public static boolean solveMaze(int maze[][], int x, int y,int n, int sol[][]){
//Base
if (x == n - 1  && y == n - 1) {
    sol[x][y] = 1 ;
    return true ;
}
//recurssion
if (isRatSafe(maze, x, y)) {
    if(sol[x][y] ==1)
    return false;
    sol[x][y] = 1;
    if(solveMaze(maze, x + 1, y, n, sol)){
        return true ;
    }
    if (solveMaze(maze, x, y+1, n, sol)) {
        return true ;
    }
    sol[x][y] = 0 ;
    return false ;

}
return false ;


}


//keypad letters combinations
final static char[][]L = {{}, {}, {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
static int count = 0;

public static void letterCombinations(String D){
int len = D.length();
if (len == 0) {
    System.out.println("");
    return ;
}

bfs(0, len, new StringBuilder(), D);

}

public static void bfs(int pos, int len, StringBuilder sb, String D){
//Base Case
if (pos == len) {
    count++ ;                                           //count total solutions
    System.out.println(sb.toString());
}else{
    //recurssion
    char[] letters = L[Character.getNumericValue(D.charAt(pos))];
    for (int i = 0; i < letters.length; i++) {

        bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), D);

    }
}


}

//Knight
static int N = 8 ;
public static boolean knightsTour(){
    int[][] board = new int[8][8];
    for (int i = 0; i < board.length; i++) 
        for (int j = 0; j < board.length; j++) 
            board[i][j] = -1 ;

    int xMove[] = {2,1, -1, -2, -2, -1,1,2};
    int yMove[] = {1,2,2,1, -1, -2, -2, -1};
    board[0][0] = 0;

    if(!fillPos(0, 0, 1, xMove, yMove, board)){
        return false;
    }else{
        printBoard(board);
    }
        
    return true ;
}

public static boolean isknightSafe(int x, int y, int board[][]){
  return  (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
}
public static boolean fillPos(int x, int y, int movei, int xMove[], int yMove[], int board[][]){
    //base
    if (movei == N * N) {
        return true ;
    }
//Recuesion
for (int i = 0; i < 8; i++) {
    int next_x = x + xMove[i];
    int next_y = y + yMove[i];
    if (isknightSafe(next_x,next_y, board)) {
        board[next_x][next_y] = movei;
            if (fillPos(next_x, next_y, movei+1, xMove, yMove, board)) {
                return true ;
            }
            else{
                board[next_x][next_y] = -1 ;    //Backtracking
            }
    }

}
return false;

}

public static void main(String[] args) {
//backtracking in an array

    // int arr[] = new int[5];
    // changeArr(arr, 0, 1);
    // printArray(arr);

//find subsets using backtracking

    // String str = "abc";
    // findSubsets(str, "", 0);

//Find Permutations

    String str = "abc";
    findPermutations(str, "");

//N-Queens
    // int n = 4;
    // char board[][] = new char[n][n];
    // for (int i = 0; i < n; i++) {
    //     for (int j = 0; j < n; j++) {
    //         board[i][j] = 'X';
    //     }
    // }

    // nQueens(board, 0); 
    // System.out.println("total ways to solve n-queens is "+ totalWays);

//Grid ways
    //int n = 3, m = 3 ;
//TC = O(2^n+m)
    //System.out.println("total no. of ways are "+gridWays(0, 0, n, m));

//TC = O(n + m)
    //System.out.println(gridWays2(n, m));


//sudoku
    // int sudoku[][] = { {0, 0, 8, 0, 0, 0, 0, 0, 0},
    // {4, 9, 0, 1, 5, 7, 0, 0, 2},
    // {0, 0, 3, 0, 0, 4, 1, 9, 0},
    // {1, 8, 5, 0, 6, 0, 0, 2, 0},
    // {0, 0, 0, 0, 2, 0, 0, 6, 0},
    // {9, 6, 0, 4, 0, 5, 3, 0, 0},
    // {0, 3, 0, 0, 7, 2, 0, 0, 4},
    // {0, 4, 9, 0, 3, 0, 0, 5, 7},
    // {8, 2, 7, 0, 0, 9, 0, 1, 3}};

    // if (solveSudoku(sudoku, 0, 0)) {
    //     System.out.println("Solution exists !");
    //     printSudoku(sudoku);
    // }else{
    //     System.out.println("Solution does not exists !");
    // }


//Question 1 : Rat in a Maze

// int maze[][] =  {
// { 1, 0, 0, 0 },
// {1, 1, 0, 1 },
// { 0, 1, 0, 0 },
// { 1, 1, 1, 1 } };

// RatinMaze(maze);


//Q2. Keypad Combinations

    // letterCombinations("23");
    // System.out.println("Total combinations are "+count);


//Q3. Knight

//knightsTour();


    }
}
