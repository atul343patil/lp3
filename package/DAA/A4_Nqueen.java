public class A4_Nqueen {

    public static boolean isSafe(char board[][], int row, int col){
        //vertical up

        for(int i=row-1; i>=0; i--){
            if(board[i][col]== 'Q'){
                return false;
            }
        }

        // digonal left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
           if(board[i][j]== 'Q'){
                return false;
            } 
        }

        // digonal right up

        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
           if(board[i][j]== 'Q'){
                return false;
            } 
        }

        return true;

    }

    public static void nqueens(char board[][], int row){
        //base case
        if(row==board.length){
            printBoard(board);
            count++;
            return;
        }
        //column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                nqueens(board, row+1);//function call
                board[row][j]='.';// backtracking step
            }
        }
    }
    public static void printBoard(char board[][]){
        System.out.println("------------Chess Board--------------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        int n=4;
        char board[][] = new char[n][n];
        //intialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        nqueens(board, 0);

        System.out.println("Total ways of possible solution of n-queens : " + count);
    }
}

/*
 import java.util.Scanner;

public class A4_Nqueen {

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nqueens(char board[][], int row) {
        // base case
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueens(board, row + 1); // recursive call
                board[row][j] = '.'; // backtracking step
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("------------Chess Board--------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of board (N): ");
        int n = sc.nextInt();

        char board[][] = new char[n][n];

        // initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // take user input for first queen position
        System.out.print("Enter row of first queen (1 - " + n + "): ");
        int row = sc.nextInt() - 1;
        System.out.print("Enter column of first queen (1 - " + n + "): ");
        int col = sc.nextInt() - 1;

        // place first queen manually
        board[row][col] = 'Q';

        // start solving from next row
        nqueens(board, 0);

        System.out.println("Total ways of possible solution of n-queens : " + count);
    }
}

 */