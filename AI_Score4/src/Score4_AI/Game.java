/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import Score4_GUI.MainGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Vassilis
 */
public class Game {
    private Player player, cpu;
    
    public static final int EMPTY = 0;
    public static final int AI = 1;
    public static final int PLAYER = -1;

    //Timer
    Timer timer = null;
    
    private String welcomeMsg, playerTurnMsg, cpuTurnMsg;
    private int gameTime = 0;
    private Random randomTurn = new Random();
    private int turn;
    
    //Swing Components
    private JFrame parentWindow;
    private JLabel timeLabel;
    private JLabel playerInfoLabel;
    
    //AI Variables
    private State currentState;
    
    public Game() {
        this.turn = randomTurn.nextInt(2)==0 ? Game.AI : Game.PLAYER;
        this.currentState = new State(new int[6][7]);
        for (int[] row : this.currentState.getBoard()) {
            Arrays.fill(row, Game.EMPTY);
        }
    }
    
    public Game(Player player, Player cpu) {
        this();
        this.player = player;
        this.cpu = cpu;
        welcomeMsg = "Welcome back " + player.getPname() + "!";
        playerTurnMsg = welcomeMsg + " It's your turn!";
        cpuTurnMsg = welcomeMsg + " It's computer's turn!";
    }
    
    public void startGame() {
       startTimer();
       AI_minimax.maxDepth = player.getDifficultyDepth();
    }

    public void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameTime++;
                timeLabel.setText(String.valueOf(gameTime)+" sec");
            }
        });
        timer.start();
    }
    
    public int[] nextMove() {
        int[] nextMoveArray = null;
        
        int whosTurn = whosTurn();
        if (whosTurn == Game.AI) {
            playerInfoLabel.setText(getCpuTurnMsg());
            
            //call the max function for the selected difficulty level and return
            //the valid move to Score4Game.java class for making the move
            
            currentState = AI_minimax.max(currentState, 0);
                    
            //currentState = AI_minimax.finalMove;
            nextMoveArray =  currentState.getMove();
            
            //return AI_minimax.max(currentState, 0).getMove();
        } else {
            playerInfoLabel.setText(getPlayerTurnMsg());
        }
        
        System.out.println("*************BOARD***************");
        for (int row = 0; row < currentState.getBoard().length; row++) {
            for (int col = 0; col < currentState.getBoard()[0].length; col++) {
                System.out.print(currentState.getBoard()[row][col]+"\t");
            }
            System.out.println();
        }
        System.out.println("--------------");
        
        ifTerminalExit(currentState);
        return nextMoveArray;
    }
    
    public int whosTurn() {
        if (turn == Game.PLAYER) {
            turn = Game.AI;
            return Game.PLAYER;
        }
        else {
            turn = Game.PLAYER;
            return Game.AI;
        }
    }
    
    public int getTurn() {
        return turn;
    }
    
    public int putSequinInPos(int columnInBoard) {
        for (int row = this.currentState.getBoard().length-1; row >= 0; row--) {
            int[][] newMove = this.currentState.getBoard();
//            if (this.initState.getBoard()[row][columnInBoard] == Game.EMPTY) {
//                this.initState.getBoard()[row][columnInBoard] = Game.PLAYER;
//                return row;
//            }
              if (newMove[row][columnInBoard] == Game.EMPTY) {
                  newMove[row][columnInBoard] = Game.PLAYER;
                  currentState.setBoard(newMove);
                  currentState.getAvailableRows()[columnInBoard] = currentState.getAvailableRows()[columnInBoard] - 1;
                  return row;
              }
        }
        return -1;
    }
    
    private void ifTerminalExit(State currentState) {
        String msg;
        
        if (currentState.isTerminal()) {
            
            if (currentState.getWinner() == Game.PLAYER) {
                msg = player.getPname()+", you won this game :)";
                this.playerInfoLabel.setText("YOU WON!!! :)");
            }
            else { 
                msg = player.getPname() + ", you lost this game :(";
                this.playerInfoLabel.setText("YOU LOST :(");
            }
                
            //STOP the Timer
            timer.stop();
            
            Object[] options = {"Yeah let\'s go!", "No thanks!"};
            int returnedCode = JOptionPane.showOptionDialog(this.parentWindow, "Do you want to play again?", msg,
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            
            if (returnedCode == 0) {
                new MainGUI().setVisible(true);
                parentWindow.dispose();
            }
            else {
                System.exit(3);
            }
        }
    }
    
    public void setJLabel(JLabel label) {
        this.timeLabel = label;
    }
    
    public void setParentWindow (JFrame parent) {
        this.parentWindow = parent;
    }
    
    public void setPlayerInfoLabel (JLabel label) {
        this.playerInfoLabel = label;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Player getCpuPlayer() {
        return this.cpu;
    }
    
    public String getWelcomeMsg() {
        return this.welcomeMsg;
    }
    
    public String getPlayerTurnMsg() {
        return this.playerTurnMsg;
    }
    
    public String getCpuTurnMsg() {
        return this.cpuTurnMsg;
    }
}
