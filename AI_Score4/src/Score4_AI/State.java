/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Vassilis
 */
public class State implements Cloneable {

    private int[][] board;
    
    //Father of State
    public State parent = null;
    
    //Check if player or CPU won this game
    private int winner = Game.EMPTY;

    //Min-Max pruning
    private int a, b, value;
    
    //int array for returning the move from MinMax function
    private int[] move = {-1, -1};

    //int array that contains the empty columns
    private int[] availableRows = {5, 5, 5, 5, 5, 5, 5};

    //ArrayList which contains all the subarrays of board
    private List subarrays;

    public State() {
        this.value = Integer.MIN_VALUE;
    }
    
    public State(int[][] board) {
        this.board = board;
        splitBoard();
    }

    public State(int[][] board, int[] availableRows, int[] rowCol) {
        this.board = board;
        this.availableRows = availableRows;
        this.move = rowCol;
        splitBoard();
    }
 
    //copy constructor
    public State(State state) {
        //copy each field
        this.a = state.a;
        this.b = state.b;
        this.value = state.value;
        
        //copy the board
        this.board = new int[6][7];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                this.board[row][col] = state.getBoard()[row][col];
            }
        }
        
        //copy the availableRows
        this.availableRows = new int[7];
        this.availableRows = Arrays.copyOf(state.availableRows, state.availableRows.length);
        
        //call to local splitBoard to fill the local subarrays list
        state.splitBoard();
        this.subarrays = state.subarrays;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
//        splitBoard();
    }

    public int[] getAvailableRows() {
        return availableRows;
    }

    public void setAvailableRows(int[] availableRows) {
        this.availableRows = availableRows;
    }
    
    public int get_a() {
        return a;
    }

    public void set_a(int a) {
        this.a = a;
    }

    public int get_b() {
        return b;
    }

    public void set_b(int b) {
        this.b = b;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getMove() {
        return move;
    }

    public void setMove(int[] rowCol) {
        this.move = rowCol;
    }

    public int getWinner() {
        return this.winner;
    }
    
    public State makeMove(int col, int turn) {
        
        //Make copy of the original arrays to create the new State item
//        int[][] boardCopy = new int[6][7];
//        boardCopy = Arrays.copyOf(this.board, this.board.length);
//        
//        int[] availableRowsCopy = new int[7];
//        availableRowsCopy = Arrays.copyOf(this.availableRows, this.availableRows.length);
        
        int[] rowCol = new int[2];

        int row = this.availableRows[col];

        if (row != -1) {
            if (this.board[row][col] == Game.EMPTY) {
                if (turn == Game.AI) {
                    this.board[row][col] = Game.AI;
                } else {
                    this.board[row][col] = Game.PLAYER;
                }
                this.availableRows[col] = row - 1;
            }
            else {
                return null;
            }
        }
        
        //set Row-Col of the last move
        this.move[0] = row;
        this.move[1] = col;
        
        return this;
    }

    public ArrayList<State> getChildren(int turn) {
        ArrayList children = new ArrayList<State>();

        for (int column = 0; column < board[0].length; column++) {
            //copy the current state
            State child = new State(this);
            
            //produce the child and add them in arraylist
            children.add(child.makeMove(column, turn));
            
//            System.out.println("*************CHILD***************");
//            for (int row = 0; row < child.getBoard().length; row++) {
//                for (int col = 0; col < child.getBoard()[0].length; col++) {
//                    System.out.print(child.getBoard()[row][col]+"\t");
//                }
//                System.out.println();
//            }
//            System.out.println("--------------");
            
        }
        return children;
    }

    //TODO
    public void evaluate() {        

        
        splitBoard();
        for (int index = 0; index < subarrays.size(); index++) {
            int[][] subarray = (int[][]) subarrays.get(index);
            this.value += evalMiniArray(subarray);
        }

//        Random r = new Random();
//        this.value =  r.nextInt(100);
    }
    
    private int evalMiniArray(int[][] sub){
        
      
        final int doubles = 10;
        final int triples = 25;
        final int quads = 1000;
        
        int totalMiniValue = 0;
        
        int sum_row = 0;
        int sum_col = 0;
        int sum_diag1 = 0;
        int sum_diag2 = 0;
        for (int row = 0; row < sub.length; row++) {
                for (int col = 0; col < sub[row].length; col++) {
                    sum_row += sub[row][col];
                    sum_col += sub[col][row];

                    if (row == col) {
                        sum_diag1 += sub[row][col];
                    }
                    if (row == sub.length - 1 - row) {
                        sum_diag2 += sub[row][col];
                    }
                }
                
                switch (sum_row) {
                    case(4):
                        totalMiniValue += quads;
                        break;
                    case(-4):
                        totalMiniValue -= quads;
                        break;
                    case(3):
                        totalMiniValue += triples;
                        break;
                    case(-3):
                        totalMiniValue -= triples;
                        break;
                    case(2):
                        totalMiniValue += doubles;
                        break;
                    case(-2):
                        totalMiniValue -= doubles;
                        break;
                    default:
                        totalMiniValue += sum_row;
                        break;
                }
                
                switch (sum_col) {
                    case(4):
                        totalMiniValue += quads;
                        break;
                    case(-4):
                        totalMiniValue -= quads;
                        break;
                    case(3):
                        totalMiniValue += triples;
                        break;
                    case(-3):
                        totalMiniValue -= triples;
                        break;
                    case(2):
                        totalMiniValue += doubles;
                        break;
                    case(-2):
                        totalMiniValue -= doubles;
                        break;
                    default:
                        totalMiniValue += sum_col;
                        break;
                }
               
                sum_row = 0;
                sum_col = 0;
        }
        
        switch (sum_diag1) {
                    case(4):
                        totalMiniValue += quads;
                        break;
                    case(-4):
                        totalMiniValue -= quads;
                        break;
                    case(3):
                        totalMiniValue += triples;
                        break;
                    case(-3):
                        totalMiniValue -= triples;
                        break;
                    case(2):
                        totalMiniValue += doubles;
                        break;
                    case(-2):
                        totalMiniValue -= doubles;
                        break;
                    default:
                        totalMiniValue += sum_col;
                        break;
                }
                
                switch (sum_diag2) {
                    case(4):
                        totalMiniValue += quads;
                        break;
                    case(-4):
                        totalMiniValue -= quads;
                        break;
                    case(3):
                        totalMiniValue += triples;
                        break;
                    case(-3):
                        totalMiniValue -= triples;
                        break;
                    case(2):
                        totalMiniValue += doubles;
                        break;
                    case(-2):
                        totalMiniValue -= doubles;
                        break;
                    default:
                        totalMiniValue += sum_col;
                        break;
                }
        
        
        return totalMiniValue;
    }

    private void splitBoard() {
        subarrays = new ArrayList<int[][]>();
//        if (subarrays.size() == 12) {
//            subarrays = new ArrayList<int[][]>();
//        }
        int[][] splittedBoard;

        for (int r = 5; r >= 3; r--) {
            for (int c = 3; c <= 6; c++) {
                splittedBoard = new int[4][4];
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
                sum_full += 1;
            }
        }
        if (sum_full == 7) {
            return true;
        }

        for (int index = 0; index < subarrays.size(); index++) {
            int sum_row = 0;
            int sum_col = 0;
            int sum_diag1 = 0;
            int sum_diag2 = 0;

            int[][] sub = (int[][]) subarrays.get(index);
            for (int row = 0; row < sub.length; row++) {
                for (int col = 0; col < sub[row].length; col++) {
                    sum_row += sub[row][col];
                    sum_col += sub[col][row];

                    if (row == col) {
                        sum_diag1 += sub[row][col];
                    }
                    if (row == sub.length - 1 - row) {
                        sum_diag2 += sub[row][col];
                    }
                }
//                if (Math.abs(sum_row) == 4 || Math.abs(sum_col) == 4) {
//                    return true;
//                }

                if (sum_row == 4 || sum_col == 4) {
                    this.winner = Game.AI;
                    return true;
                }
                else if (sum_row == -4 || sum_col == -4) {
                    this.winner = Game.PLAYER;
                    return true;
                }
                sum_row = 0;
                sum_col = 0;
            }
            

//            if (Math.abs(sum_diag1) == 4 || Math.abs(sum_diag2) == 4) {
//                return true;
//            }
                if (sum_diag1 == 4 || sum_diag2 == 4) {
                    this.winner = Game.AI;
                    return true;
                }
                else if (sum_diag1 == -4 || sum_diag2 == -4) {
                    this.winner = Game.PLAYER;
                    return true;
                }
        }
        return false;
    }
}
