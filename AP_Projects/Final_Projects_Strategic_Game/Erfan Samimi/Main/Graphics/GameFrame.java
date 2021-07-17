package Main.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.Heroes_Package.Heroes;
import Main.Main;
import Main.Team;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author erfan
 */
public class GameFrame extends javax.swing.JFrame {

    /**
     * Creates new form MyFrame
     */
    public GameFrame() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new GameBoardPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));


        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea1.setBackground(new Color(76, 75, 75));
        jTextArea2.setBackground(new Color(76, 75, 75));

        jTextArea1.setForeground( new Color(58, 233, 76));
        jTextArea2.setForeground( new Color(58, 233, 76) );


        saveButton.setLabel("Save Game");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    saveButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        startButton.setLabel("Start Game");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        exitButton.setLabel("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(163, 163, 163)
                                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );

        pack();
    }// </editor-fold>

//----------------------------------------------------------------------------------------------

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        FileOutputStream fout = new FileOutputStream("/home/erfan/Projects/Java/Files/FinalProject/savedGame.txt");

        ObjectOutputStream objOut = new ObjectOutputStream(fout);

        objOut.writeObject(Main.team1);
        objOut.writeObject(Main.team2);
    }

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        Main.startGame();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Heroes.startMovingTeamObjects(Main.team1);
        Heroes.startMovingTeamObjects(Main.team2);
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }



    public void updateTeamsStatus(Team team1 , Team team2){
        jTextArea1.setText(team1.getTeamStatus());
        jTextArea2.setText(team2.getTeamStatus());
    }

    public void changeColor(int x , int y , Color color , String name){
        jPanel1.changeColor(x , y , color , name);
    }


    // Variables declaration - do not modify
    private javax.swing.JButton exitButton;
    private GameBoardPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton startButton;
    // End of variables declaration
}
