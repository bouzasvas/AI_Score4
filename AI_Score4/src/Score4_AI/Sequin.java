/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Score4_AI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Vassilis
 */
public class Sequin {
    private int row, column;
    private JLabel sequin;
    
    public Sequin(int row, int column, ImageIcon sequinIcon) {
        this.row = row;
        this.column = column;
        this.sequin = new JLabel(sequinIcon);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public JLabel getSequin() {
        return sequin;
    }

    public void setSequin(JLabel sequin) {
        this.sequin = sequin;
    }
    
   
}
