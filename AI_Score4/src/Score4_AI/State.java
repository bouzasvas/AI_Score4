/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import java.util.ArrayList;
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

    public State(int[][] board) {
        this.board = board;
    }

    public State(int[][] board, int[] availableRows) {
        this.board = board;
        this.availableRows = availableRows;
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

        if (row != 0) {
            if (turn == Game.AI)
                boardCopy[row][col] = Game.AI;
            else
                boardCopy[row][col] = Game.PLAYER;
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
}
