/*
        Μέλη Ομάδας
    Λόκκας Ιωάννης ΑΜ: 3120095
    Μπούζας Βασίλειος ΑΜ: 3120124
    Τασσιάς Παναγιώτης ΑΜ: 3120181
*/

/*
    This class is responsible for making all the moves.
    
    Updates the REAL BOARD and uses the MinMax algorithm returned moves to the Score4_GUI which
    is responsible for drawing the moves on the board.

    Also decides which player plays each turn using the WhosTurn() function and calculates the game time.
*/

package Score4_AI;

import Score4_GUI.MainGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Game {

    //Each game consists of 2 player - Human & CPU
    private Player player, cpu;

    /* Values on the real board based on which player (CPU, Human) played
    
        On BOARD:
           Human cells has value -1
           CPU cells has value 1
           Empty cells has value 0
    */
    public static final int EMPTY = 0;
    public static final int AI = 1;
    public static final int PLAYER = -1;

    //Timer variable that calculates the Game Time
    Timer timer = null;

    //Fields for displaying info - like who's turn and the Game Time - in the Score4_Game window
    private ImageIcon face = null;
    private String welcomeMsg, playerTurnMsg, cpuTurnMsg, msg;
    private int gameTime = 0;
    
    //Fields for choosing which player has to play next
    private Random randomTurn = new Random();
    private int turn;

    //GUI Terminal Check - for displaying suitable dialog window when game ends
    public boolean terminalGUI = false;

    //Swing Components from the parent in order to update them in the parent window - Score4_Game
    private JFrame parentWindow;
    private JLabel timeLabel;
    private JLabel playerInfoLabel;

    /* This variable keeps always the current state of the game
        
        Every action of the game like nextMove, minMax algorithm etc  is based on this field
        
        Every user action or returned result from the MinMax algorithm changes this State
    */    
    private State currentState;

    // A new Game object starts the Game and decides randomly who is going to play at the first move
    // Also fills the real game Board with zeros (empty tiles)
    public Game() {
        this.turn = randomTurn.nextInt(2) == 0 ? Game.AI : Game.PLAYER;
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

    // Starts the Timer and sets the static maxDepth field in the AI_minimax class based on user
    // difficulty selection
    public void startGame() {
        startTimer();
        AI_minimax.maxDepth = player.getDifficultyDepth();
    }

    //Starts and updates (each 1sec) the timer in the Score4_Game Window
    public void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameTime++;
                timeLabel.setText(String.valueOf(gameTime) + " sec");
            }
        });
        timer.start();
    }

    
    /* The nextMove() is the basic function that determines the game flow
        
        Determines who's turn and based on this returns the appropriate array
        
        If it's CPU's turn then the function returns an int array that contains
        the move that CPU made based on the result of MinMax algorithm.
    
        If it's Human turn function returns null so we can manage it later.
    
        This function returns to makeTheMoveOnBoard() function in Score4_Game class
        and the final move is drawn on the board using function drawSequinOnBoard of the Score4_Game class
    */
    public int[] nextMove() {
        int[] nextMoveArray = null;

        //Check if we are at terminal state so do not repeat the process
        if (!terminalGUI) {
            int whosTurn = whosTurn();
            if (whosTurn == Game.AI) {
                playerInfoLabel.setText(getCpuTurnMsg());

                //call the max function for the selected difficulty level and return
                //the valid move to Score4_Game.java class for making the move
                currentState = AI_minimax.max(currentState, 0);
                
                //MinMax algorithm with tree pruning
                //Uncomment the following line to run it
                
                //currentState = AI_minimax.minimaxWithPruning(currentState);
                
                //Max function returns the State but we want only the new move that
                //was made so we call currentState.getMove() to take it
                nextMoveArray = currentState.getMove();
            } else {
                //Actually when Human plays do nothing and return null
                playerInfoLabel.setText(getPlayerTurnMsg());
                nextMoveArray = null;
            }
        // if we are at terminal state show the appropriate dialog on screen
        // asking user whether he wants to repeat the Game
        } else {
            String dialogMessage = "Do you want to play again?\nYour time was: " + this.gameTime+" sec";
            Object[] options = {"Yeah, let\'s go!", "No, thanks!"};
            int returnedCode = JOptionPane.showOptionDialog(this.parentWindow, dialogMessage, msg,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, this.face, options, options[0]);

            if (returnedCode == 0) {
                new MainGUI().setVisible(true);
                parentWindow.dispose();
            } else {
                System.exit(3);
            }
        }
        return nextMoveArray;
    }

    // Function that returns who's turn and changes the turn variable for next move
    public int whosTurn() {
        if (turn == Game.PLAYER) {
            turn = Game.AI;
            return Game.PLAYER;
        } else {
            turn = Game.PLAYER;
            return Game.AI;
        }
    }

    public int getTurn() {
        return turn;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    /* Function that is used only for the USER MOVES
        
        It checks the row that the sequin can placed for the given column based on which Column button
        in the Score4_Game user clicked.
    
        Makes the move on the REAL Board and returns the row that move was made in order to draw it
        on the board using drawSequinOnBoard function.
    */
    public int putSequinInPos(int columnInBoard) {
        for (int row = this.currentState.getBoard().length - 1; row >= 0; row--) {
            int[][] newMove = this.currentState.getBoard();
            if (newMove[row][columnInBoard] == Game.EMPTY) {
                newMove[row][columnInBoard] = Game.PLAYER;
                currentState.setBoard(newMove);
                currentState.getAvailableRows()[columnInBoard] = currentState.getAvailableRows()[columnInBoard] - 1;
                currentState.setValue(0);
                return row;
            }
        }
        return -1;
    }

    // Check if currentState is terminal state in order to stop the repeated process
    // Also updates with messsages the player info labels in Score4_Game window
    public void ifTerminalExit(State currentState) {

        if (currentState.isTerminal()) {

            if (currentState.getWinner() == Game.PLAYER) {
                this.msg = player.getPname() + ", you won this game!";
                this.face = new ImageIcon(getClass().getResource("/Assets/happy_face.png"));
                this.playerInfoLabel.setText("YOU WON!!! :)");
            } else if (currentState.getWinner() == Game.AI) {
                this.msg = player.getPname() + ", you lost this game!";
                this.face = new ImageIcon(getClass().getResource("/Assets/sad_face.png"));
                this.playerInfoLabel.setText("YOU LOST :(");
            }
            else {
                this.msg = "Game is draw!";
                this.face = new ImageIcon(getClass().getResource("/Assets/face.png"));
                this.playerInfoLabel.setText("TIE GAME!");
            }

            //STOP the Timer
            timer.stop();
            
            this.terminalGUI = true;
        }
    }

    //Setters & Getters
    
    public void setJLabel(JLabel label) {
        this.timeLabel = label;
    }

    public void setParentWindow(JFrame parent) {
        this.parentWindow = parent;
    }

    public void setPlayerInfoLabel(JLabel label) {
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
