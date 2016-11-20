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

    public static State finalMove = new State();

    public static State max(State state, int depth) {
        if (state.isTerminal() || depth == maxDepth) {
            state.evaluate();
            System.out.println(state.getValue());

//            System.out.println("*************MAX STATE***************");
//            for (int row = 0; row < state.getBoard().length; row++) {
//                for (int col = 0; col < state.getBoard()[0].length; col++) {
//                    System.out.print(state.getBoard()[row][col] + "\t");
//                }
//                System.out.println();
//            }
//            System.out.println("--------------");
            return state;
        }

        //get the State children
        ArrayList<State> children = state.getChildren(Game.AI);

        State maxState = new State(state);
        maxState.setValue(Integer.MIN_VALUE);

        //iterate on children ArrayList
        for (State child : children) {
            State intermediateState = min(child, depth + 1);

            if (intermediateState.getValue() > maxState.getValue()) {
                maxState = new State(child);
                maxState.setMove(child.getMove());
                maxState.setValue(intermediateState.getValue());
            }
        }

//        System.out.println(depth);

//        if (depth == 0) {
//            int minTmp = Integer.MIN_VALUE;
//            for (State child : children) {
//                int childValue = child.getValue();
//                if (Math.max(childValue, minTmp) == childValue) {
//                    minTmp = childValue;
//                    finalMove = new State(child);
//                    finalMove.setMove(child.getMove());
//                }
//            }
//        }

        System.out.println("EVALUATE VALUE "+maxState.getValue());
        return maxState;
    }

    public static State min(State state, int depth) {
        if (state.isTerminal() || depth == maxDepth) {
            state.evaluate();
            System.out.println(state.getValue());
            return state;
        }

//        if (depth == 1) {
//            if (state.getValue() < finalMove.getValue()) {
//                finalMove = state;
//            }
//        }
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

}
