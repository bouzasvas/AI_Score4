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
    private State 

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

    public boolean makeMove() {
        for (int column = 0; column < board[0].length; column++) {
            int row = this.availableRows[column];
            
            if (row != 0) {    
                this.board[row][column] = 0;
                return true;
            }
        }
        return false;
    }
    
    //public List getChildren() {
    public State getChild() {
        //List children = new ArrayList<State>();
        //State child = new State(this.board, this.availableRows);
        
//        if (child.makeMove()) {
//            children.add(child);
//            return child.getChildren();
//        } 
        State child = this.getChild();
        if (child.getChild() == null){
            if(child.getValue)
            return child;
        }
            
        
        
        return null;
    }
}
