/*
        Μέλη Ομάδας
    Λόκκας Ιωάννης ΑΜ: 3120095
    Μπούζας Βασίλειος ΑΜ: 3120124
    Τασσιάς Παναγιώτης ΑΜ: 3120181
*/

/*
    This class is the main Board Window for our Score4 App
    
    It is responsible for the User Interaction (UI) with the App.
*/

package Score4_GUI;
import Score4_AI.Game;
import Score4_AI.Player;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Score4_Game extends javax.swing.JFrame {

    //The Global Game field that contains the REAL board and the 2 players
    private Game thisGame;
    
    //The Virtual Board that is only what users see on the Screen
    //This JLabel array containts JLabel elements.
    //Each of them is actually an image icon that is drawn on the board
    private JLabel[][] seqPosition;

    public Score4_Game(Game game) {
        initComponents();
        this.thisGame = game;
        this.thisGame.setJLabel(timeLiveLabel);
        this.thisGame.setParentWindow(this);
        this.thisGame.setPlayerInfoLabel(this.playerInfoLabel);
        startGame();
    }

    /* START GAME Actions
        
        1. Start the timer and initialize the real board
        2. Initialize the virtual board on the screen with empty sequins
        3. Find the first move
        4. Draw the move on board
    */    
    
    private void startGame() {
        this.thisGame.startGame();
        createBoard();
        int[] move = this.thisGame.nextMove();
        makeTheMoveOnBoard(move);
    }

    
    //Initialize the board with the empty sequins
    private void createBoard() {
        this.playerInfoLabel.setText("Welcome back " + this.thisGame.getPlayer().getPname() + "!");
        this.seqPosition = new JLabel[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                this.seqPosition[row][col] = new JLabel(new ImageIcon(getClass().getResource("/Assets/empty_seq.png")));
                this.score4JPanel.add(this.seqPosition[row][col]);
            }
        }
        pack();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerInfoPanel = new javax.swing.JPanel();
        playerInfoLabel = new javax.swing.JLabel();
        timePanel = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        columnButtons = new javax.swing.JToolBar();
        col1Button = new javax.swing.JButton();
        colSeperator1 = new javax.swing.JToolBar.Separator();
        col2Button = new javax.swing.JButton();
        colSeperator2 = new javax.swing.JToolBar.Separator();
        col3Button = new javax.swing.JButton();
        colSeperator3 = new javax.swing.JToolBar.Separator();
        col4Button = new javax.swing.JButton();
        colSeperator4 = new javax.swing.JToolBar.Separator();
        col5Button = new javax.swing.JButton();
        colSeperator5 = new javax.swing.JToolBar.Separator();
        col6Button = new javax.swing.JButton();
        colSeperator6 = new javax.swing.JToolBar.Separator();
        col7Button = new javax.swing.JButton();
        buttonsBoardSeperator = new javax.swing.JSeparator();
        infoBoardSeperator = new javax.swing.JSeparator();
        infoTimeSeperator = new javax.swing.JSeparator();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        score4Board = new javax.swing.JLabel();
        score4JPanel = new javax.swing.JPanel();
        timeLiveLabel = new javax.swing.JLabel();
        inGameMenu = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ExitMenuItem = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        howToMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Score4");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon.png")).getImage());
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        playerInfoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout playerInfoPanelLayout = new javax.swing.GroupLayout(playerInfoPanel);
        playerInfoPanel.setLayout(playerInfoPanelLayout);
        playerInfoPanelLayout.setHorizontalGroup(
            playerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerInfoPanelLayout.createSequentialGroup()
                .addComponent(playerInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        playerInfoPanelLayout.setVerticalGroup(
            playerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/clock.png"))); // NOI18N

        javax.swing.GroupLayout timePanelLayout = new javax.swing.GroupLayout(timePanel);
        timePanel.setLayout(timePanelLayout);
        timePanelLayout.setHorizontalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        timePanelLayout.setVerticalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        columnButtons.setBorder(new javax.swing.border.MatteBorder(null));
        columnButtons.setFloatable(false);
        columnButtons.setRollover(true);
        columnButtons.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        col1Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        col1Button.setMnemonic(KeyEvent.VK_1);
        col1Button.setText("Col1");
        col1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        col1Button.setFocusable(false);
        col1Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        col1Button.setMargin(new java.awt.Insets(2, 23, 2, 18));
        col1Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        col1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col1ButtonActionPerformed(evt);
            }
        });
        columnButtons.add(col1Button);
        columnButtons.add(colSeperator1);

        col2Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        col2Button.setMnemonic(KeyEvent.VK_2);
        col2Button.setText("Col2");
        col2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        col2Button.setFocusable(false);
        col2Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        col2Button.setMargin(new java.awt.Insets(2, 23, 2, 14));
        col2Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        col2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col2ButtonActionPerformed(evt);
            }
        });
        columnButtons.add(col2Button);
        columnButtons.add(colSeperator2);

        col3Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        col3Button.setMnemonic(KeyEvent.VK_3);
        col3Button.setText("Col3");
        col3Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        col3Button.setFocusable(false);
        col3Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        col3Button.setMargin(new java.awt.Insets(2, 23, 2, 14));
        col3Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        col3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col3ButtonActionPerformed(evt);
            }
        });
        columnButtons.add(col3Button);
        columnButtons.add(colSeperator3);

        col4Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        col4Button.setMnemonic(KeyEvent.VK_4);
        col4Button.setText("Col4");
        col4Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        col4Button.setFocusable(false);
        col4Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        col4Button.setMargin(new java.awt.Insets(2, 23, 2, 14));
        col4Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        col4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col4ButtonActionPerformed(evt);
            }
        });
        columnButtons.add(col4Button);
        columnButtons.add(colSeperator4);

        col5Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        col5Button.setMnemonic(KeyEvent.VK_5);
        col5Button.setText("Col5");
        col5Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        col5Button.setFocusable(false);
        col5Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        col5Button.setMargin(new java.awt.Insets(2, 23, 2, 14));
        col5Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        col5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col5ButtonActionPerformed(evt);
            }
        });
        columnButtons.add(col5Button);
        columnButtons.add(colSeperator5);

        col6Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        col6Button.setMnemonic(KeyEvent.VK_6);
        col6Button.setText("Col6");
        col6Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        col6Button.setFocusable(false);
        col6Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        col6Button.setMargin(new java.awt.Insets(2, 23, 2, 14));
        col6Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        col6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col6ButtonActionPerformed(evt);
            }
        });
        columnButtons.add(col6Button);
        columnButtons.add(colSeperator6);

        col7Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        col7Button.setMnemonic(KeyEvent.VK_7);
        col7Button.setText("Col7");
        col7Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        col7Button.setFocusable(false);
        col7Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        col7Button.setMargin(new java.awt.Insets(2, 23, 2, 14));
        col7Button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        col7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col7ButtonActionPerformed(evt);
            }
        });
        columnButtons.add(col7Button);

        infoTimeSeperator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        score4Board.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/board.png"))); // NOI18N

        score4JPanel.setOpaque(false);
        score4JPanel.setPreferredSize(new java.awt.Dimension(640, 480));
        score4JPanel.setLayout(new java.awt.GridLayout(6, 7));

        jLayeredPane1.setLayer(score4Board, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(score4JPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(score4JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(score4Board)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(score4JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(score4Board, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        timeLiveLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLiveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        FileMenu.setText("File");

        newGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGameMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/new_game.png"))); // NOI18N
        newGameMenuItem.setText("New Game");
        newGameMenuItem.setToolTipText("Click to start a new game!");
        newGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuItemActionPerformed(evt);
            }
        });
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

        inGameMenu.add(FileMenu);

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

        inGameMenu.add(HelpMenu);

        setJMenuBar(inGameMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoBoardSeperator)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playerInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoTimeSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLiveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(buttonsBoardSeperator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(columnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoTimeSeperator)
                    .addComponent(timeLiveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoBoardSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(columnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(buttonsBoardSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        Action when a column button is clicked
        
        Each time user clicks 1 of the 7 available column buttons these things are happened:
    
        1. putSequinInPos(int col) method checks the row that sequin can be placed,
            updates the real Game Board and returns the row in the variable sequin
    
        2. The returned row with the column of the button are used as arguments for the
            drawSequinInBoard function which draws the sequin on Board
    */
    
    private void col1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col1ButtonActionPerformed
        int sequin = thisGame.putSequinInPos(0);
        drawSequinOnBoard(sequin, 0, this.thisGame.getPlayer(), (JButton) evt.getSource());
    }//GEN-LAST:event_col1ButtonActionPerformed

    private void col2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col2ButtonActionPerformed
        int sequin = thisGame.putSequinInPos(1);
        drawSequinOnBoard(sequin, 1, this.thisGame.getPlayer(), (JButton) evt.getSource());
    }//GEN-LAST:event_col2ButtonActionPerformed

    private void col3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col3ButtonActionPerformed
        int sequin = thisGame.putSequinInPos(2);
        drawSequinOnBoard(sequin, 2, this.thisGame.getPlayer(), (JButton) evt.getSource());
    }//GEN-LAST:event_col3ButtonActionPerformed

    private void col4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col4ButtonActionPerformed
        int sequin = thisGame.putSequinInPos(3);
        drawSequinOnBoard(sequin, 3, this.thisGame.getPlayer(), (JButton) evt.getSource());
    }//GEN-LAST:event_col4ButtonActionPerformed

    private void col5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col5ButtonActionPerformed
        int sequin = thisGame.putSequinInPos(4);
        drawSequinOnBoard(sequin, 4, this.thisGame.getPlayer(), (JButton) evt.getSource());
    }//GEN-LAST:event_col5ButtonActionPerformed

    private void col6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col6ButtonActionPerformed
        int sequin = thisGame.putSequinInPos(5);
        drawSequinOnBoard(sequin, 5, this.thisGame.getPlayer(), (JButton) evt.getSource());
    }//GEN-LAST:event_col6ButtonActionPerformed

    private void col7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col7ButtonActionPerformed
        int sequin = thisGame.putSequinInPos(6);
        drawSequinOnBoard(sequin, 6, this.thisGame.getPlayer(), (JButton) evt.getSource());
    }//GEN-LAST:event_col7ButtonActionPerformed

    //Action when "Exit" Menu Item is clicked
    //Actually exits the app and returns the code 0
    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    //Create a NEW GAME action when the "New Game" Menu Item is clicked
    private void newGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameMenuItemActionPerformed

        //Confirmation dialog in case of missclick
        int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to create a new game?",
                "New Game?", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            //if user confirms his action then close this window and go to MainGUI
            new MainGUI().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_newGameMenuItemActionPerformed
    
    //Action when "About" Menu Item is clicked
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        new about(this, false).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    
    /* Make the move on board according to int[] move array that is returned by the MinMax algorithm
       
       If CPU plays then the move array will contain the move - row, col pair - that it will be drawn on the board
       
       If Human plays the move array will be null and the final position by player will be done by clicking 1 of the 7 column buttons above
    */
    
    private void makeTheMoveOnBoard(int[] move) {
        if (move != null) {
            drawSequinOnBoard(move[0], move[1], this.thisGame.getCpuPlayer(), null);
        }
    }
    
    /* Method that handles all the drawings on board
        
       Takes as arguments the following:
        
         1. Row-Column pair for drawing the sequin on JLabel board
         2. Player object for drawing the right image icon based on which player currently plays (CPU, Human)
         3. JButton component for disabling the button when column is full
    */
    
    private void drawSequinOnBoard(int row, int col, Player p, JButton pressedButton) {
        // check if column is full and show suitable dialog window
        if (row == -1) {
            if (pressedButton !=null) {
                pressedButton.setEnabled(false);
                JOptionPane.showMessageDialog(this, "This column is filled!", "Full column", JOptionPane.INFORMATION_MESSAGE);
            }    
        }
        // make the move on the JLabel Board
        else {
            JLabel thisPos = this.seqPosition[row][col];
            thisPos.setIcon(p.getpIcon());
            pack();
        
            //check if current state is terminal to terminate the game and show the winner
            this.thisGame.ifTerminalExit(this.thisGame.getCurrentState());
            
            /* continue the game and repeat the whole process from the beggining
                
                The repeated steps are:
                    nextMove() -- returns the move from the result of MinMax Algorirtm
                    makeTheMoveOnBoard(int[] move) -- Checks if Human or CPU plays to make the move
                    drawSequinOnBoard -- Draws the sequin on the board in the right position
            */
            int [] move = this.thisGame.nextMove();
            makeTheMoveOnBoard(move);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JSeparator buttonsBoardSeperator;
    private javax.swing.JButton col1Button;
    private javax.swing.JButton col2Button;
    private javax.swing.JButton col3Button;
    private javax.swing.JButton col4Button;
    private javax.swing.JButton col5Button;
    private javax.swing.JButton col6Button;
    private javax.swing.JButton col7Button;
    private javax.swing.JToolBar.Separator colSeperator1;
    private javax.swing.JToolBar.Separator colSeperator2;
    private javax.swing.JToolBar.Separator colSeperator3;
    private javax.swing.JToolBar.Separator colSeperator4;
    private javax.swing.JToolBar.Separator colSeperator5;
    private javax.swing.JToolBar.Separator colSeperator6;
    private javax.swing.JToolBar columnButtons;
    private javax.swing.JMenuItem howToMenuItem;
    private javax.swing.JMenuBar inGameMenu;
    private javax.swing.JSeparator infoBoardSeperator;
    private javax.swing.JSeparator infoTimeSeperator;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JLabel playerInfoLabel;
    private javax.swing.JPanel playerInfoPanel;
    private javax.swing.JLabel score4Board;
    private javax.swing.JPanel score4JPanel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeLiveLabel;
    private javax.swing.JPanel timePanel;
    // End of variables declaration//GEN-END:variables

}
