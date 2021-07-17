package Main.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.Main;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author erfan
 */
public class RestoreDialog extends javax.swing.JDialog {

    /**
     * Creates new form restoreDialog
     */
    public RestoreDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setVisible(true);
    }



    private void initComponents() {

        restoreButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        restoreButton.setText("Restore Previous Game");
        restoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    restoreButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        newGameButton.setText("Start New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    newGameButtonActionPerformed(evt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(restoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                        .addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(restoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }




    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {
        // TODO add your handling code here:

        Main.newGame();
        Main.gameFrame.setVisible(true);

        dispose();
    }

    private void restoreButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:

        Main.restoreGame();
        Main.gameFrame.setVisible(true);

        dispose();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton restoreButton;
    // End of variables declaration
}

