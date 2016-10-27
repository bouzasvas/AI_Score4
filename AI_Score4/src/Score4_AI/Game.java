/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private int gameTime = 0;
    private Random randomTurn = new Random();
    private int turn; //1 is player, 0 is cpu
    private JLabel timeLabel;
    private Sequin[][] score4Sequin;
    
    public Game() {
        this.turn = randomTurn.nextInt(1);
        this.score4Sequin = new Sequin[6][7];
    }
    
    public Game(Player player, Player cpu) {
        this();
        this.player = player;
        this.cpu = cpu;
    }
    
    public void startGame() {
        startTimer();
        
        //testing ONLY
        for (int i =0; i < this.score4Sequin.length; i++) {
            for (int j = 0; j < this.score4Sequin[i].length; j++) {
                this.score4Sequin[i][j] = (new Sequin(i, j, new ImageIcon(getClass().getResource("/Assets/green_player.png"))));
            }
        }
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
    
    public int whosNext() {
        if (turn == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
    public int getTurn() {
        return turn;
    }
    
    public Sequin putSequinInPos(int columnInBoard, ImageIcon sequinIcon) {
        for (int row = 0; row < this.score4Sequin.length; row++) {
            if (this.score4Sequin[row][columnInBoard] == null) {
                return this.score4Sequin[row][columnInBoard] = new Sequin(row, columnInBoard, player.getpIcon());
            }
        }
        return null;
    }
    
    public Sequin getSequin (int row, int column) {
        return this.score4Sequin[row][column];
    }
    
    public Sequin[][] getSequinArray() {
        return this.score4Sequin;
    }
    
    public void setJLabel(JLabel label) {
        this.timeLabel = label;
    }
    
    public Player getPlayer() {
        return this.player;
    }
}
