/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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

    
    private String welcomeMsg, playerTurnMsg, cpuTurnMsg;
    private int gameTime = 0;
    private Random randomTurn = new Random();
    private int turn;
    private JLabel timeLabel;
    
    //AI Variables
    private State initState;
    
    public Game() {
        this.turn = randomTurn.nextInt(2);
        this.initState = new State(new int[6][7]);
        for (int[] row : this.initState.getBoard()) {
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
    }

    public void startTimer() {
        Timer timer = null;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameTime++;
                timeLabel.setText(String.valueOf(gameTime)+" sec");
            }
        });
        timer.start();
    }
    
    public void nextMove(JLabel playerInfoLabel) {
        int whosTurn = whosTurn();
        if (whosTurn == Game.AI) {
            playerInfoLabel.setText(getCpuTurnMsg());
            AI_minimax.max(initState, player.getDifficultyDepth());
//            Random r = new Random();
//            drawSequinInBoard(r.nextInt(6), r.nextInt(7), this.thisGame.getCpuPlayer(), null);
        } else {
            playerInfoLabel.setText(getPlayerTurnMsg());
        }
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
        for (int row = this.initState.getBoard().length-1; row >= 0; row--) {
            if (this.initState.getBoard()[row][columnInBoard] == Game.EMPTY) {
                this.initState.getBoard()[row][columnInBoard] = Game.PLAYER;
                return row;
            }
        }
        return -1;
    }
    
    public void setJLabel(JLabel label) {
        this.timeLabel = label;
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
