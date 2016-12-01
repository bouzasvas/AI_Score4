/*
        Μέλη Ομάδας
    Λόκκας Ιωάννης ΑΜ: 3120095
    Μπούζας Βασίλειος ΑΜ: 3120124
    Τασσιάς Παναγιώτης ΑΜ: 3120181
*/


/* Creates the main app window which allow users to set their Name,
   their desired difficulty level and their favourite color!

   When "START!" button is clicked Game Starts and the Main Board window is appeared!
*/


package Score4_GUI;

import Score4_AI.Game;
import Score4_AI.Player;
import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;


public class MainGUI extends javax.swing.JFrame {
    
    //Three available options for difficulty level
    private final String[] difficultyLevel = {"Easy", "Medium", "Hard"};
    
    //We use this as PARENT WINDOW for showing dialogs between Frames
    private final javax.swing.JPanel thisWindow = (javax.swing.JPanel) getContentPane();
    
    public MainGUI() {
        
        //Creates all the components that are needed for this window
        initComponents();
    }
    
    
    //This method is responsible for opening the video link
    private static void open(URI uri) {
    if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().browse(uri);
      } catch (IOException e) {
          System.err.println("Could not open the request URL");
      }
    }
  }

    //The default Netbeans Method for CREATING THE WINDOW'S COMPONENTS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorGroupRadio = new javax.swing.ButtonGroup();
        playerOptions = new javax.swing.JPanel();
        NameLabel = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        DifficultyLabel = new javax.swing.JLabel();
        DifficultyList = new javax.swing.JComboBox<>();
        ColorLabel = new javax.swing.JLabel();
        redPlayer = new javax.swing.JRadioButton();
        greenPlayer = new javax.swing.JRadioButton();
        greenPlayer_icon = new javax.swing.JLabel();
        redPlayer_icon = new javax.swing.JLabel();
        START_button = new javax.swing.JButton();
        youtube_URL = new javax.swing.JLabel();
        description1Label = new javax.swing.JLabel();
        Img = new javax.swing.JLabel();
        description2Label = new javax.swing.JLabel();
        pregameMenu = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ExitMenuItem = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        howToMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Score4 Pre-Game");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon.png")).getImage());
        setLocation(new java.awt.Point(450, 200));
        setResizable(false);

        NameLabel.setText("Name");

        DifficultyLabel.setText("Difficulty");

        ColorLabel.setText("Color");

        colorGroupRadio.add(redPlayer);

        colorGroupRadio.add(greenPlayer);

        greenPlayer_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/green_player_main.png"))); // NOI18N
        greenPlayer_icon.setLabelFor(greenPlayer);
        greenPlayer_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                greenPlayer_iconMouseClicked(evt);
            }
        });

        redPlayer_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/red_player_main.png"))); // NOI18N
        redPlayer_icon.setLabelFor(redPlayer);
        redPlayer_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redPlayer_iconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout playerOptionsLayout = new javax.swing.GroupLayout(playerOptions);
        playerOptions.setLayout(playerOptionsLayout);
        playerOptionsLayout.setHorizontalGroup(
            playerOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DifficultyLabel)
                    .addComponent(ColorLabel)
                    .addGroup(playerOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(DifficultyList, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, playerOptionsLayout.createSequentialGroup()
                            .addComponent(greenPlayer)
                            .addGap(18, 18, 18)
                            .addComponent(greenPlayer_icon))
                        .addComponent(NameText, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(playerOptionsLayout.createSequentialGroup()
                        .addComponent(redPlayer)
                        .addGap(18, 18, 18)
                        .addComponent(redPlayer_icon)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        playerOptionsLayout.setVerticalGroup(
            playerOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(DifficultyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DifficultyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ColorLabel)
                .addGroup(playerOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerOptionsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(greenPlayer_icon))
                    .addGroup(playerOptionsLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(greenPlayer)))
                .addGroup(playerOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerOptionsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(redPlayer_icon)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerOptionsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(redPlayer)
                        .addGap(42, 42, 42))))
        );

        DifficultyList.setModel(new javax.swing.DefaultComboBoxModel(difficultyLevel));

        START_button.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        START_button.setForeground(new java.awt.Color(51, 153, 255));
        START_button.setText("START!");
        START_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                START_buttonActionPerformed(evt);
            }
        });

        youtube_URL.setText("to learn how to play Score4!");

        description1Label.setText("Click");

        javax.swing.ImageIcon img = new javax.swing.ImageIcon(getClass().getResource("/Assets/iconBG.png"));
        Img.setIcon(new javax.swing.ImageIcon(img.getImage().getScaledInstance(200, 170, Image.SCALE_DEFAULT)));

        description2Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        description2Label.setForeground(new java.awt.Color(0, 0, 153));
        description2Label.setText("here");
        description2Label.setToolTipText("Link to Youtube Video");
        description2Label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        description2Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                description2LabelMouseClicked(evt);
            }
        });

        FileMenu.setText("File");

        newGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGameMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/new_game.png"))); // NOI18N
        newGameMenuItem.setText("New Game");
        newGameMenuItem.setToolTipText("Click to start a new game!");
        FileMenu.add(newGameMenuItem);
        FileMenu.add(jSeparator1);

        ExitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        ExitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/exit.png"))); // NOI18N
        ExitMenuItem.setText("Exit");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenuItem);

        pregameMenu.add(FileMenu);

        HelpMenu.setText("Help");

        howToMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        howToMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/question.png"))); // NOI18N
        howToMenuItem.setText("How to play");
        HelpMenu.add(howToMenuItem);
        HelpMenu.add(jSeparator2);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/info.png"))); // NOI18N
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        HelpMenu.add(aboutMenuItem);

        pregameMenu.add(HelpMenu);

        setJMenuBar(pregameMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(START_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(description1Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(description2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(youtube_URL))
                    .addComponent(Img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(youtube_URL)
                            .addComponent(description2Label)
                            .addComponent(description1Label))
                        .addGap(30, 30, 30)
                        .addComponent(START_button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(playerOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action when "START!" button is clicked
    
    private void START_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_START_buttonActionPerformed
        boolean inputOk = true;
        String userIconFile = null;
        String cpuIconFile = null;
        
        /* Check that user has fill all the required fields
           In our case we need
            Player Name
            Desired difficulty level
            Favourite Color
        
           If something is missing we inform the user with a dialog window
        */
        
            if (this.NameText.getText().equals("") || (this.NameText.getText() == null)) {
                JOptionPane.showMessageDialog(this, "Please type your name", "Name is required", JOptionPane.INFORMATION_MESSAGE);
                inputOk = false;
            }
            if (this.DifficultyList.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please select a difficulty lever", "Select difficulty level", JOptionPane.INFORMATION_MESSAGE);
                inputOk = false;
            }
            if (!(this.greenPlayer.isSelected() || this.redPlayer.isSelected())) {
                JOptionPane.showMessageDialog(this, "Please select your favourite color", "Select color", JOptionPane.INFORMATION_MESSAGE);
                inputOk = false;
            }
            else {
                //Select the appropriate image icon based on user selection
                userIconFile = greenPlayer.isSelected() ? "/Assets/green_player.png" : "/Assets/red_player.png";
                cpuIconFile = greenPlayer.isSelected() ? "/Assets/red_player.png" : "/Assets/green_player.png";
            }
        
        /* If the user has filled all the required fields 
           
            1. Create the 2 players (CPU, Human)
            2. Initialize Human with the above fields
            3. Start the Game with the 2 players and make the window visible
            4. Close this window (this.dispose())
        */
            
        if (inputOk) {
            Player player = new Player(thisWindow, false, this.NameText.getText(), this.DifficultyList.getSelectedItem().toString(), userIconFile);
            Player cpu = new Player(thisWindow, cpuIconFile);
            Game newGame = new Game(player, cpu);
            new Score4_Game(newGame).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_START_buttonActionPerformed

    
    //Onclick method for action when Red Sequin Icon is Clicked
    private void greenPlayer_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_greenPlayer_iconMouseClicked
        greenPlayer.doClick();
    }//GEN-LAST:event_greenPlayer_iconMouseClicked

    //Onclick method for action when Red Sequin Icon is Clicked
    private void redPlayer_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redPlayer_iconMouseClicked
        redPlayer.doClick();
    }//GEN-LAST:event_redPlayer_iconMouseClicked

    //Onclick method for action when "Exit" Menu Item is Clicked
    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    //Onclick method for action when "About" Menu Item is Clicked
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        new about(this, false).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed
    
    //Onclick method for label that contains the video link    
    private void description2LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_description2LabelMouseClicked
        try {
            open(new URI("https://www.youtube.com/watch?v=mNzksM72o94"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_description2LabelMouseClicked

    
    //The main function that creates the MainGUI window
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ColorLabel;
    private javax.swing.JLabel DifficultyLabel;
    private javax.swing.JComboBox<String> DifficultyList;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JLabel Img;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameText;
    private javax.swing.JButton START_button;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.ButtonGroup colorGroupRadio;
    private javax.swing.JLabel description1Label;
    private javax.swing.JLabel description2Label;
    private javax.swing.JRadioButton greenPlayer;
    private javax.swing.JLabel greenPlayer_icon;
    private javax.swing.JMenuItem howToMenuItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JPanel playerOptions;
    private javax.swing.JMenuBar pregameMenu;
    private javax.swing.JRadioButton redPlayer;
    private javax.swing.JLabel redPlayer_icon;
    private javax.swing.JLabel youtube_URL;
    // End of variables declaration//GEN-END:variables
}
