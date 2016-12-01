/*
        Μέλη Ομάδας
    Λόκκας Ιωάννης ΑΜ: 3120095
    Μπούζας Βασίλειος ΑΜ: 3120124
    Τασσιάς Παναγιώτης ΑΜ: 3120181
*/

package Score4_AI;

import java.util.ArrayList;

public class AI_minimax {

    public static int maxDepth = 4;

    public static State bestState = new State();

    public static State max(State state, int depth) {
        if (state.isTerminal() || depth == maxDepth) {
            state.evaluate();
            
            return state;
        }

        //get the State children
        ArrayList<State> children = state.getChildren(Game.AI);

        State maxState = new State(state);
        maxState.setValue(Integer.MIN_VALUE);

        //iterate on children ArrayList
        for (State child : children) {
            
            // Check if a child at depth 0 is Terminal State
            if (depth == 0) {
                if (child.isTerminal()) {
                    return child;
                }
            }
            
            State intermediateState = min(child, depth + 1);

            if (intermediateState.getValue() > maxState.getValue()) {
                maxState = new State(child);
                maxState.setMove(child.getMove());
                maxState.setValue(intermediateState.getValue());
            }
        }

        return maxState;
    }

    public static State min(State state, int depth) {
        if (state.isTerminal() || depth == maxDepth) {
            state.evaluate();
            return state;
        }

        //get the State children
        ArrayList<State> children = state.getChildren(Game.PLAYER);

        State minState = new State(state);
        minState.setValue(Integer.MAX_VALUE);

        //iterate on children ArrayList
        for (State child : children) {
            State intermediateState = max(child, depth + 1);

            if (intermediateState.getValue() < minState.getValue()) {
                minState = new State(child);
                minState.setMove(child.getMove());
                minState.setValue(intermediateState.getValue());                
            }
        }

        return minState;
    }
    
    
    //MinMax algorithm with tree pruning

    public static int alphabeta(State state, int depth, int alpha, int beta, int player) {
        if (state.isTerminal() || depth == 0) {
            state.evaluate();
            return state.getValue();
        }
        if (player == Game.AI) {
            ArrayList<State> children = state.getChildren(Game.AI);
            int v = Integer.MIN_VALUE;
            for (State child : children) {
                v = Math.max(v, alphabeta(child, depth - 1, alpha, beta, Game.PLAYER));
                alpha = Math.max(alpha, v);
                if (beta <= alpha) {
                    
                    bestState = new State(child);
                    bestState.setMove(child.getMove());
                    break;
                }
            }
            bestState.setValue(v);
            return bestState.getValue();
        } 
        else {
            ArrayList<State> children = state.getChildren(Game.AI);
            int v = Integer.MAX_VALUE;
            for (State child : children) {
                v = Math.min(v, alphabeta(child, depth - 1, alpha, beta, Game.AI));
                beta = Math.min(beta, v);
                if (beta <= alpha) {
                    bestState = new State(child);
                    bestState.setMove(child.getMove());
                    break;
                }
            }
            bestState.setValue(v);   
            return bestState.getValue();
        }
    }
    
    
    public static State minimaxWithPruning(State current){
        alphabeta(current, 8, Integer.MIN_VALUE, Integer.MAX_VALUE, Game.AI);
        return bestState;
    }
}
