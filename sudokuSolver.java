import java.util.*;

public class sudokuSolver {
    public static boolean isSafe( int sudoku[][], int row, int col, int digit){
        for(int i=0 ; i<=8 ; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        for(int j=0 ; j<=8 ; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        for(int i=sr ; i<sr+3 ; i++){
            for(int j=sc ; j<sc+3 ; j++){
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuu(int sudoku[][], int row, int col){
        if (row == 9){
            return true;
        }
        int nextRow = row;
        int nextCol = col+1;
        if(col+1 == 9){
            nextRow = row + 1;
            nextCol = 0;
        }
        if(sudoku[row][col] != 0){
            return sudokuu(sudoku, nextRow, nextCol);
        }
        for (int digit=1; digit<=9 ; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if (sudokuu(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void print(int sudoku[][]) {
        for(int i=0 ; i<=8 ; i++){
            for(int j=0 ; j<=8 ; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        
        
    }
    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        //int sudoku[][] = new int[9][9];
        //System.out.print("Enter the sudoku puzzle in the form of 9x9 matrix")
        // for(int i=0 ; i<sudoku.length ; i++){                                   // USER INPUT
        //     for(int j=0 ; j<sudoku[0].length ; j++){           
        //         matrix[i][j] = sc.nextInt();
        //     }
        //}
        int sudoku[][] = {  {0,0,8,0,0,0,0,0,0},
                            {4,9,0,1,5,7,0,0,2},
                            {0,0,3,0,0,4,1,9,0},
                            {1,8,5,0,6,0,0,2,0},                      
                            {0,0,0,0,2,0,0,6,0},                        // SYSTEM INPUT
                            {9,6,0,4,0,5,3,0,0},
                            {0,3,0,0,7,2,0,0,4},
                            {0,4,9,0,3,0,0,5,7},
                            {8,2,7,0,0,9,0,1,3}  };


        if(sudokuu(sudoku, 0, 0) == true ){
            System.out.println("The solution exists and is as follows : ");
            print(sudoku);
        }
        else{
            System.out.println("Solution does'nt exists");
        }
    }    
}
