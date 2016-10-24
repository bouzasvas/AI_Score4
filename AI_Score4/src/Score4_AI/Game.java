/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
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
    private int turn;
    private JLabel timeLabel;
    
    public Game() {
        turn = randomTurn.nextInt(1);
    }
    
    public Game(Player player, Player cpu) {
        this.player = player;
        this.cpu = cpu;
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
    
    public int getTurn() {
        return turn;
    }
    
    public void setJLabel(JLabel label) {
        this.timeLabel = label;
    }
}
