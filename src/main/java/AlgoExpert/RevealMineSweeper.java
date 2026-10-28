package AlgoExpert;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

/*
* Given an input string and a dictionary of words,
segment the input string into a space-separated
sequence of dictionary words if possible. For
example, if the input string is "applepie" and
dictionary contains a standard set of English words,
then we would return the string "apple pie" as output.
* */
public class RevealMineSweeper {

   public static void main(String[] args){

        RevealMineSweeper rms = new RevealMineSweeper();
        String[][] board = new String[][]{new String[]{"H", "H"}};
        int row = 0;
        int col = 0;
        rms.revealMinesweeper(board, row, col);
   }

    public String[][] revealMinesweeper(String[][] board, int row, int col) {
        // Write your code here.
        if(board[row][col].equals("M")){
            board[row][col]="X";
            return board;
        }else if(board[row][col].equals("H")){
            fanout(board, row, col);
        }
        return board;
    }//revealMinesweeper

    void fanout(String[][] board, int row, int col){
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{row, col});
        while(!stack.isEmpty()){
            Integer[] cell = stack.pop();
            int x = cell[0];
            int y = cell[1];
            addNeighborsAndUpdateCell(stack, board, x, y);
        }//while
        return;
    }//fanout

    void addNeighborsAndUpdateCell(Stack<Integer[]> stack, String[][] board, int row, int col){
        int mines = 0;
        if(row>0 && board[row-1][col].equals("M")){
            mines++;
        }else if(row>0 && col<board[0].length-1 && board[row-1][col+1].equals("M")){
            mines++;
        }else if(col<board[0].length-1 && board[row][col+1].equals("M")){
            mines++;
        }else if(row<board.length-1 && col<board[0].length-1 && board[row+1][col+1].equals("M")){
            mines++;
        }else if(row<board.length-1 && board[row+1].equals("M")){
            mines++;
        }else if(row<board.length-1 && col>0 && board[row+1][col-1].equals("M")){
            mines++;
        }else if(col>0 && board[row][col-1].equals("M")){
            mines++;
        }else if(row>0 && col>0 && board[row-1][col-1].equals("M")){
            mines++;
        }

        if(mines>=0){
            board[row][col]=String.valueOf(mines);
        }

        if(row>0 && board[row-1][col].equals("H")){
            stack.push(new Integer[]{row-1, col});
        }else if(row>0 && col<board[0].length-1 && board[row-1][col+1].equals("H")){
            stack.push(new Integer[]{row-1, col+1});
        }else if(col<board[0].length-1 && board[row][col+1].equals("H")){
            stack.push(new Integer[]{row, col+1});
        }else if(row<board.length-1 && col<board[0].length-1 && board[row+1][col+1].equals("H")){
            stack.push(new Integer[]{row+1, col+1});
        }else if(row<board.length-1 && board[row+1].equals("H")){
            stack.push(new Integer[]{row+1, col});
        }else if(row<board.length-1 && col>0 && board[row+1][col-1].equals("H")){
            stack.push(new Integer[]{row+1, col-1});
        }else if(col>0 && board[row][col-1].equals("H")){
            stack.push(new Integer[]{row, col-1});
        }else if(row>0 && col>0 && board[row][col-1].equals("H")) {
            stack.push(new Integer[]{row, col - 1});
        }
    }

}
