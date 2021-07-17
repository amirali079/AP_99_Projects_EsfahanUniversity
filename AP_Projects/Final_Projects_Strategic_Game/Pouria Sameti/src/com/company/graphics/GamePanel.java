/*
 * Created by JFormDesigner on Wed Jul 07 00:55:44 IRDT 2021
 */

package com.company.graphics;
import com.company.Account;
import com.company.Check;
import com.company.castle.EnemyCastle;
import com.company.castle.GamerCastle;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class GamePanel extends JFrame {
    public GamePanel()
    {
        initComponents();
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                setLocation(0,0);
                gamePanel.setLayout(null);
                GamerCastle.currentGamerCastle.createCastleLabel(gamePanel);
                EnemyCastle.currentEnemyCastle.createCastleLabel(gamePanel);
                GamerCastle.currentGamerCastle.addHeroTOPanel(gamePanel);
                EnemyCastle.currentEnemyCastle.addHeroTOPanel(gamePanel);
                return null ;
            }
        }.execute();

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if (info.getName().equals("Nimbus"))
            {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(getRootPane()));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void playBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        GamerCastle.currentGamerCastle.start();
        EnemyCastle.currentEnemyCastle.start();
        playBTN.setEnabled(false);
        continueBTN.setEnabled(true);
    }

    private void continueBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        GamerCastle.currentGamerCastle.setContinue(true);
        EnemyCastle.currentEnemyCastle.setContinue(true);
    }

    private void exitBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                try {
                    Account.currentAccount.updateAccountPanel();
                    GamerCastle.currentGamerCastle.join();
                    EnemyCastle.currentEnemyCastle.join();
                }
                catch (Exception E){
                    E.printStackTrace();
                }
                return null ;
            }
        }.execute();
    }

    private void pauseBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        GamerCastle.currentGamerCastle.setContinue(false);
        EnemyCastle.currentEnemyCastle.setContinue(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        gamePanel = new JPanel();
        panel3 = new JPanel();
        playBTN = new JButton();
        continueBTN = new JButton();
        exitBTN = new JButton();
        label3 = new JLabel();
        label5 = new JLabel();
        showWinner = new JLabel();
        pauseBTN = new JButton();
        GamerPB = new JProgressBar();
        EnemyPB = new JProgressBar();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/icons/swords.png")).getImage());
        setTitle("Mini Battle");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(51, 0, 51));
        var contentPane = getContentPane();

        //======== panel2 ========
        {
            panel2.setBackground(new Color(0, 0, 51));

            //---- label1 ----
            label1.setText("Game Panel");
            label1.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label1.setForeground(Color.white);

            //---- label2 ----
            label2.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label2MouseClicked(e);
                }
            });

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 957, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
        }

        //======== gamePanel ========
        {
            gamePanel.setBackground(new Color(0, 0, 102));
            gamePanel.setLayout(new FlowLayout());
        }

        //======== panel3 ========
        {
            panel3.setBackground(new Color(51, 0, 0));

            //---- playBTN ----
            playBTN.setText("Play");
            playBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            playBTN.setBackground(new Color(0, 0, 51));
            playBTN.setForeground(Color.white);
            playBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            playBTN.setIcon(new ImageIcon(getClass().getResource("/icons/play-button.png")));
            playBTN.addActionListener(e -> playBTNActionPerformed(e));

            //---- continueBTN ----
            continueBTN.setText("Continue");
            continueBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            continueBTN.setBackground(new Color(25, 0, 25));
            continueBTN.setForeground(Color.white);
            continueBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            continueBTN.setIcon(new ImageIcon(getClass().getResource("/icons/arrows.png")));
            continueBTN.setEnabled(false);
            continueBTN.addActionListener(e -> continueBTNActionPerformed(e));

            //---- exitBTN ----
            exitBTN.setText("Exit");
            exitBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            exitBTN.setBackground(new Color(81, 0, 0));
            exitBTN.setForeground(Color.white);
            exitBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            exitBTN.setIcon(new ImageIcon(getClass().getResource("/icons/stand-by.png")));
            exitBTN.addActionListener(e -> exitBTNActionPerformed(e));

            //---- label3 ----
            label3.setText("Gamer Status");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);
            label3.setIcon(new ImageIcon(getClass().getResource("/icons/smile.png")));

            //---- label5 ----
            label5.setText("Enemy Status");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);
            label5.setIcon(new ImageIcon(getClass().getResource("/icons/enemy.png")));

            //---- showWinner ----
            showWinner.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            showWinner.setForeground(Color.white);

            //---- pauseBTN ----
            pauseBTN.setText("Pause");
            pauseBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            pauseBTN.setBackground(new Color(0, 56, 0));
            pauseBTN.setForeground(Color.white);
            pauseBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pauseBTN.setIcon(new ImageIcon(getClass().getResource("/icons/pause.png")));
            pauseBTN.addActionListener(e -> pauseBTNActionPerformed(e));

            //---- GamerPB ----
            GamerPB.setBackground(new Color(0, 51, 0));
            GamerPB.setStringPainted(true);
            GamerPB.setForeground(Color.black);
            GamerPB.setValue(100);
            GamerPB.setOpaque(true);

            //---- EnemyPB ----
            EnemyPB.setBackground(new Color(0, 20, 10));
            EnemyPB.setStringPainted(true);
            EnemyPB.setForeground(Color.black);
            EnemyPB.setValue(100);
            EnemyPB.setOpaque(true);

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(continueBTN, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                        .addComponent(playBTN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(exitBTN, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pauseBTN, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(showWinner, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(GamerPB, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(EnemyPB, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(33, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(playBTN, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(continueBTN, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pauseBTN, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(exitBTN, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GamerPB, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(label5)
                        .addGap(3, 3, 3)
                        .addComponent(EnemyPB, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showWinner, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(gamePanel, GroupLayout.PREFERRED_SIZE, 924, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(gamePanel, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
        setSize(1265, 735);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    public static JPanel gamePanel;
    private JPanel panel3;
    private JButton playBTN;
    private JButton continueBTN;
    private JButton exitBTN;
    private JLabel label3;
    private JLabel label5;
    public static JLabel showWinner;
    private JButton pauseBTN;
    public static JProgressBar GamerPB;
    public static JProgressBar EnemyPB;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
