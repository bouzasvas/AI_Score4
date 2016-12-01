/*
        Μέλη Ομάδας
    Λόκκας Ιωάννης ΑΜ: 3120095
    Μπούζας Βασίλειος ΑΜ: 3120124
    Τασσιάς Παναγιώτης ΑΜ: 3120181
*/

// An about window that displays info about the Developers and the Game

package Score4_GUI;

public class about extends javax.swing.JDialog {

    
    public about(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutLabel = new javax.swing.JLabel();
        auebLogo = new javax.swing.JLabel();
        aboutText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Us");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(450, 200));

        aboutLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        aboutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aboutLabel.setText("About Us");
        aboutLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        auebLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/aueb_logo.jpeg"))); // NOI18N

        aboutText.setEditable(false);
        aboutText.setBackground(new java.awt.Color(204, 204, 204));
        aboutText.setColumns(20);
        aboutText.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        aboutText.setRows(5);
        aboutText.setText("This application is based on the famous game Score4 (or Connect4).\n\nIt was developed for the purpose of Artificial Intelligence (AI) course of\nAthens University of Economics and Business (AUEB).\n\nThe Developers (by alphabetical order):\n-Bouzas Vasileios\n-Lokkas Ioannis\n-Tassias Panagiotis");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(auebLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aboutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aboutText, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(aboutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(auebLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutText, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutLabel;
    private javax.swing.JTextArea aboutText;
    private javax.swing.JLabel auebLogo;
    // End of variables declaration//GEN-END:variables
}
