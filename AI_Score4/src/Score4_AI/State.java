/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Vassilis
 */
public class State {

    private int[][] board;

    //Min-Max pruning
    private int a, b, value;

    //int array that contains the empty columns
    private int[] availableRows = {5, 5, 5, 5, 5, 5, 5};

    //ArrayList which contains all the subarrays of board
    private List subarrays = new ArrayList<int[][]>();

    public State(int[][] board) {
        this.board = board;
    }

    public State(int[][] board, int[] availableRows) {
        this.board = board;
        this.availableRows = availableRows;
        splitBoard();
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[] getAvailableRows() {
        return availableRows;
    }

    public void setAvailableRows(int[] availableRows) {
        this.availableRows = availableRows;
    }

    public State makeMove(int col, int turn) {
        int[][] boardCopy = this.board;
        int[] availableRowsCopy = this.availableRows;

        int row = this.availableRows[col];

        if (row != -1) {
            if (turn == Game.AI) {
                boardCopy[row][col] = Game.AI;
            } else {
                boardCopy[row][col] = Game.PLAYER;
            }
            availableRowsCopy[col] = row - 1;
        }

        State boardChild = new State(boardCopy, availableRowsCopy);
        return boardChild;
    }

    public ArrayList<State> getChildren(int turn) {
        ArrayList children = new ArrayList<State>();

        for (int column = 0; column < board[0].length; column++) {
            children.add(this.makeMove(column, turn));
        }
        return children;
    }

    //TODO
    public int evaluate() {
        return -1;
    }

    private void splitBoard() {
        int[][] splittedBoard = new int[4][4];

        for (int r = 5; r >= 3; r--) {
            for (int c = 3; c <= 6; c++) {
                for (int row = r, splRow = 3; row >= r - 3; row--, splRow--) {
                    for (int col = c - 3, splCol = 0; col <= c; col++, splCol++) {
                        splittedBoard[splRow][splCol] = board[row][col];
                    }

                }
                subarrays.add(splittedBoard);
            }

        }
    }

    public boolean isTerminal() {
        
        //check if game has ended without winner
        int sum_full = 0;
        for (int avRow : this.availableRows) {
            if (avRow == -1) {
                sum_full+=1;
            }
        }
        if (sum_full == 7)
            return true;

        for (int index = 0; index < subarrays.size(); index++) {
            int sum_row = 0;
            int sum_col = 0;
            int sum_diag1 = 0;
            int sum_diag2 = 0;
            
            int[][] sub = (int[][]) subarrays.get(index);
            for (int row = 0; row < sub.length; row++) {
                for (int col = 0; col < sub[row].length; col++) {
                    sum_row+=sub[row][col];
                    sum_col+=sub[col][row];
                    
                    if (row == col) {
                        sum_diag1+=sub[row][col];
                    }
                    if (row == sub.length - 1 - row) {
                        sum_diag2+=sub[row][col];
                    }
                }
            }
            
            
            if (Math.abs(sum_row) == 4 || Math.abs(sum_col) == 4 || Math.abs(sum_diag1) == 4 || Math.abs(sum_diag2) == 4)
                return true;
        }
        return false;
    }
}
