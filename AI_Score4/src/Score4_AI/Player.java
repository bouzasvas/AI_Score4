/*
        Μέλη Ομάδας
    Λόκκας Ιωάννης ΑΜ: 3120095
    Μπούζας Βασίλειος ΑΜ: 3120124
    Τασσιάς Παναγιώτης ΑΜ: 3120181
*/

/* The game consists of 2 Player Objects.

    Each player has it's own members that are used during the whole Game like:
        1. Player Name
        2. Player sequin image icon
        3. Player difficulty
       etc.
*/

package Score4_AI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Player {
    //Used to show dialogs to the Parent Window
   private JPanel parentWindow;
   
   //Default Values used for AI
   private boolean ai = true;
   private String pname = "CPU";
   
   //The Sequin ImageIcon that is placed on the board
   private ImageIcon pIcon = null;
   
   //The difficulty level that user chose corresponds to the MinMax depth
   public static int difficultyDepth;

   
   public Player() {
       super();
   }
   
   public Player(JPanel parent, boolean ai, String pname, String pdifficulty, String filePath) {
       this.ai = ai;
       this.pname = pname;
       this.parentWindow = parent;
       try {
           this.pIcon = new ImageIcon(getClass().getResource(filePath));
       }
       catch (Exception fileEx) {
           // Exception thrown when Image File is missing
           JOptionPane.showMessageDialog(parentWindow, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
       }
       
       // Set the MinMax depth between 4 and 6 based on user difficulty selection
       // Higher difficult levels corresponds to deeper MinMax depth
       switch (pdifficulty) {
           case "Easy":
               this.difficultyDepth = 4;
               break;
           case "Medium":
               this.difficultyDepth = 5;
               break;
           case "Hard":
               this.difficultyDepth = 6;
               break;
           default:
               this.difficultyDepth = -1;
               break;
       }
   }
   
   public Player(JPanel parent, String filePath) {
       this.parentWindow = parent;
       try {
           this.pIcon = new ImageIcon(getClass().getResource(filePath));
       }
       catch (Exception fileEx) {
           JOptionPane.showMessageDialog(parentWindow, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
       }
   }

   //Setters and Getters
   
    public boolean isAi() {
        return ai;
    }

    public void setAi(boolean ai) {
        this.ai = ai;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public ImageIcon getpIcon() {
        return pIcon;
    }

    public void setpIcon(ImageIcon pIcon) {
        this.pIcon = pIcon;
    }
   
    public int getDifficultyDepth() {
         return difficultyDepth;
     }
}
