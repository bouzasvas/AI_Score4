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
    
    private String welcomeMsg, playerTurnMsg, cpuTurnMsg;
    private int gameTime = 0;
    private Random randomTurn = new Random();
    private int turn; //1 is player, 0 is cpu
    private JLabel timeLabel;
    
    //AI Variables
    private int[][] board;
    
    public Game() {
        this.turn = randomTurn.nextInt(2);
        this.board = new int[6][7];
        for (int[] row : this.board) {
            Arrays.fill(row, -1);
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
        if (whosTurn == 0) {
            playerInfoLabel.setText(getCpuTurnMsg());
            AI_minimax.max(board);
//            Random r = new Random();
//            drawSequinInBoard(r.nextInt(6), r.nextInt(7), this.thisGame.getCpuPlayer(), null);
        } else {
            playerInfoLabel.setText(getPlayerTurnMsg());
        }
    }
    
    public int whosTurn() {
        if (turn == 0) {
            turn = 1;
            return 0;
        }
        else {
            turn = 0;
            return 1;
        }
    }
    
    public int getTurn() {
        return turn;
    }
    
    //public Sequin putSequinInPos(int columnInBoard, ImageIcon sequinIcon) {
    public int putSequinInPos(int columnInBoard) {
        for (int row = this.board.length-1; row >= 0; row--) {
            if (this.board[row][columnInBoard] == -1) {
                this.board[row][columnInBoard] = 1;
                return row;
            }
        }
        return -1;
    }
    
    public int getBoardCell (int row, int column) {
        return this.board[row][column];
    }
    
    public int[][] getBoard () {
        return this.board;
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
