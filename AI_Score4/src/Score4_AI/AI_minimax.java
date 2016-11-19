/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import java.util.ArrayList;
/**
 *
 * @author Vassilis
 */
public class AI_minimax {
    
    //only for testing
    //return new int[] {2, 3};
    
    public static int maxDepth = 4;
    
    public static State max(State state, int depth) {
        if (state.isTerminal() || depth == maxDepth) {
            //state.setValue(state.evaluate());
            return state;
        }
        
        //get the State children
        ArrayList<State> children = state.getChildren(Game.AI);
        
        State maxState = new State(state.getBoard(), state.getAvailableRows(), null);
        maxState.setValue(Integer.MIN_VALUE);
        
        //iterate on children ArrayList
        for (State child : children) {
            State intermediateState = min(child, depth+1);
             
            if (intermediateState.getValue() > maxState.getValue()) {
                maxState.setValue(intermediateState.getValue());
                maxState.setMove(intermediateState.getMove());
            }            
        }
        
        return maxState;
    }
        
    public static State min(State state, int depth) {
        if (state.isTerminal() || depth == maxDepth) {
            state.setValue(state.evaluate());
            return state;
        }
        
        //get the State children
        ArrayList<State> children = state.getChildren(Game.PLAYER);
        
        State minState = new State(state.getBoard(), state.getAvailableRows(), null);
        minState.setValue(Integer.MAX_VALUE);
                
        //iterate on children ArrayList
        for (State child : children) {
            State intermediateState = max(child, depth+1);
            
            if (intermediateState.getValue() < minState.getValue()) {
                minState.setValue(intermediateState.getValue());
                minState.setMove(intermediateState.getMove());
            }
        }
        
        return minState;
    }
    
    
    
    
}