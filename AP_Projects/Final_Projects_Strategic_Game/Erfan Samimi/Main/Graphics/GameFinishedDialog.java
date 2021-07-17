package Main.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author erfan
 */
public class GameFinishedDialog extends javax.swing.JDialog {

    /**
     * Creates new form GameFinishedDialog
     */
    public GameFinishedDialog(  String msg) {

        super(new JFrame(), true);
        initComponents();
        msgLabel.setText(msg);
        setVisible(true);

    }



    private void initComponents() {

        msgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );

        pack();
    }



    // Variables declaration - do not modify
    private javax.swing.JLabel msgLabel;
    // End of variables declaration
}
