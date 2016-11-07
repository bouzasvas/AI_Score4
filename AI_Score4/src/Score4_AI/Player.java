/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vassilis
 */
public class Player {
    //For Message Dialog
   private JPanel parentWindow;
   
   //Class Fields
   private boolean ai = true;
   private String pname = "CPU";
   private ImageIcon pIcon = null;
   
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
           JOptionPane.showMessageDialog(parentWindow, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
       }
       
       switch (pdifficulty) {
           case "Easy":
               this.difficultyDepth = 3;
               break;
           case "Medium":
               this.difficultyDepth = 4;
               break;
           case "Hard":
               this.difficultyDepth = 5;
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
