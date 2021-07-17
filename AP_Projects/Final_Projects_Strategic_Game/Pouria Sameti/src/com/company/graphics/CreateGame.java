/*
 * Created by JFormDesigner on Fri Jul 09 11:21:15 IRDT 2021
 */

package com.company.graphics;
import com.company.Account;
import com.company.castle.EnemyCastle;
import com.company.castle.GamerCastle;
import com.company.heroPackage.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class CreateGame extends JFrame {
    public CreateGame()
    {
        initComponents();
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

    private void finishBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        int xCastleGamer = (int)gamerXCastle.getValue() ;
        int yCastleGamer = (int) gamerYCastle.getValue() ;
        int GamerFireNMB = (int)gamerFireNumberSPN.getValue() ;
        int GamerWindNMB = (int) gamerWindNumberSPN.getValue() ;
        int GamerIceNMB = (int) gamerIceNumberSPN.getValue() ;
        int GamerEarthNMB = (int) gamerEarthNumberSPN.getValue() ;
        ArrayList<Hero> gamersHero = new ArrayList<>() ;
        for (int i = 0 ; i < GamerFireNMB ; ++i)
            gamersHero.add(new Fire(false)) ;
        for (int i = 0 ; i < GamerWindNMB ; ++i)
            gamersHero.add(new Wind(false)) ;
        for (int i = 0 ; i < GamerIceNMB ; ++i)
            gamersHero.add(new Ice(false)) ;
        for (int i = 0 ; i < GamerEarthNMB ; ++i)
            gamersHero.add(new Earth(false)) ;
        GamerCastle gc = new GamerCastle(xCastleGamer,yCastleGamer,gamersHero) ;
        Account.currentAccount.addGame();

        int xCastleEnemy = (int) enemyXCastle.getValue() ;
        int yCastleEnemy = (int) enemyYCastle.getValue() ;
        int EnemyFireNMB = (int) EnemyFireNumberSPN.getValue() ;
        int EnemyWindNMB = (int) EnemyWindNumberSPN.getValue() ;
        int EnemyIceNMB = (int) EnemyIceNumberSPN.getValue() ;
        int EnemyEarthNMB = (int) EnemyEarthNumberSPN.getValue() ;
        ArrayList<Hero> EnemyHero = new ArrayList<>() ;
        for (int i = 0 ; i < EnemyFireNMB ; ++i)
            EnemyHero.add(new Fire(true)) ;
        for (int i = 0 ; i < EnemyWindNMB ; ++i)
            EnemyHero.add(new Wind(true)) ;
        for (int i = 0 ; i < EnemyIceNMB ; ++i)
            EnemyHero.add(new Ice(true)) ;
        for (int i = 0 ; i < EnemyEarthNMB ; ++i)
            EnemyHero.add(new Earth(true)) ;
        EnemyCastle ec = new EnemyCastle(xCastleEnemy, yCastleEnemy, EnemyHero) ;


        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GamePanel gp = new GamePanel() ;
                gp.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                AccountPage ap = new AccountPage() ;
                ap.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel3 = new JPanel();
        finishBTN = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        gamerFireNumberSPN = new JSpinner();
        gamerWindNumberSPN = new JSpinner();
        gamerIceNumberSPN = new JSpinner();
        gamerEarthNumberSPN = new JSpinner();
        gamerXCastle = new JSpinner();
        gamerYCastle = new JSpinner();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        enemyXCastle = new JSpinner();
        label19 = new JLabel();
        enemyYCastle = new JSpinner();
        EnemyFireNumberSPN = new JSpinner();
        EnemyWindNumberSPN = new JSpinner();
        EnemyIceNumberSPN = new JSpinner();
        EnemyEarthNumberSPN = new JSpinner();
        backBTN = new JButton();

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
            label1.setText("Craete Game Menu");
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 622, Short.MAX_VALUE)
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

        //======== panel3 ========
        {
            panel3.setBackground(new Color(0, 0, 102));

            //---- finishBTN ----
            finishBTN.setText("Finish");
            finishBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            finishBTN.setBackground(new Color(0, 0, 102));
            finishBTN.setForeground(Color.white);
            finishBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            finishBTN.setIcon(new ImageIcon(getClass().getResource("/icons/check 2.png")));
            finishBTN.addActionListener(e -> finishBTNActionPerformed(e));

            //---- label3 ----
            label3.setBackground(Color.white);
            label3.setOpaque(true);

            //---- label4 ----
            label4.setText("Fire Knight");
            label4.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label4.setForeground(Color.white);
            label4.setIcon(new ImageIcon(getClass().getResource("/icons/mini gamer -fire knight.png")));

            //---- label5 ----
            label5.setText("Wind Knight");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);
            label5.setIcon(new ImageIcon(getClass().getResource("/icons/mini gamer - wind knight.png")));

            //---- label6 ----
            label6.setText("Ice Knight");
            label6.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label6.setForeground(Color.white);
            label6.setIcon(new ImageIcon(getClass().getResource("/icons/mini gamer - ice knight.png")));

            //---- label7 ----
            label7.setText("Earth Knight");
            label7.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label7.setForeground(Color.white);
            label7.setIcon(new ImageIcon(getClass().getResource("/icons/mini gamer - earth knight.png")));

            //---- label8 ----
            label8.setText("Gamer");
            label8.setFont(new Font("Myanmar Text", Font.PLAIN, 25));
            label8.setForeground(Color.white);
            label8.setIcon(new ImageIcon(getClass().getResource("/icons/smile.png")));

            //---- label9 ----
            label9.setText("Enemy");
            label9.setFont(new Font("Myanmar Text", Font.PLAIN, 25));
            label9.setForeground(Color.white);
            label9.setIcon(new ImageIcon(getClass().getResource("/icons/enemy.png")));

            //---- label10 ----
            label10.setText("Fire Knight");
            label10.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label10.setForeground(Color.white);
            label10.setIcon(new ImageIcon(getClass().getResource("/icons/mini enemy - fire knight.png")));

            //---- label11 ----
            label11.setText("Wind Knight");
            label11.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label11.setForeground(Color.white);
            label11.setIcon(new ImageIcon(getClass().getResource("/icons/mini enemy - wind knight.png")));

            //---- label12 ----
            label12.setText("Ice Knight");
            label12.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label12.setForeground(Color.white);
            label12.setIcon(new ImageIcon(getClass().getResource("/icons/mini enemy - ice knight.png")));

            //---- label13 ----
            label13.setText("Earth Knight");
            label13.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label13.setForeground(Color.white);
            label13.setIcon(new ImageIcon(getClass().getResource("/icons/mini enemy - earth knight.png")));

            //---- label14 ----
            label14.setText("Castle Location");
            label14.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label14.setForeground(Color.white);
            label14.setIcon(new ImageIcon(getClass().getResource("/icons/mini castle.png")));

            //---- label15 ----
            label15.setText("Castle Location");
            label15.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label15.setForeground(Color.white);
            label15.setIcon(new ImageIcon(getClass().getResource("/icons/mini castle.png")));

            //---- gamerFireNumberSPN ----
            gamerFireNumberSPN.setModel(new SpinnerNumberModel(0, 0, 10, 1));
            gamerFireNumberSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- gamerWindNumberSPN ----
            gamerWindNumberSPN.setModel(new SpinnerNumberModel(0, 0, 10, 1));
            gamerWindNumberSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- gamerIceNumberSPN ----
            gamerIceNumberSPN.setModel(new SpinnerNumberModel(0, 0, 10, 1));
            gamerIceNumberSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- gamerEarthNumberSPN ----
            gamerEarthNumberSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            gamerEarthNumberSPN.setModel(new SpinnerNumberModel(0, 0, 10, 1));

            //---- gamerXCastle ----
            gamerXCastle.setModel(new SpinnerNumberModel(100, 0, 350, 1));
            gamerXCastle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- gamerYCastle ----
            gamerYCastle.setModel(new SpinnerNumberModel(50, 50, 420, 1));
            gamerYCastle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- label16 ----
            label16.setText("X");
            label16.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label16.setForeground(Color.white);
            label16.setIcon(null);

            //---- label17 ----
            label17.setText("Y");
            label17.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label17.setForeground(Color.white);
            label17.setIcon(null);

            //---- label18 ----
            label18.setText("X");
            label18.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label18.setForeground(Color.white);
            label18.setIcon(null);

            //---- enemyXCastle ----
            enemyXCastle.setModel(new SpinnerNumberModel(351, 351, 700, 1));
            enemyXCastle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- label19 ----
            label19.setText("Y");
            label19.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label19.setForeground(Color.white);
            label19.setIcon(null);

            //---- enemyYCastle ----
            enemyYCastle.setModel(new SpinnerNumberModel(50, 50, 420, 1));
            enemyYCastle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- EnemyFireNumberSPN ----
            EnemyFireNumberSPN.setModel(new SpinnerNumberModel(0, 0, 10, 1));
            EnemyFireNumberSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- EnemyWindNumberSPN ----
            EnemyWindNumberSPN.setModel(new SpinnerNumberModel(0, 0, 10, 1));
            EnemyWindNumberSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- EnemyIceNumberSPN ----
            EnemyIceNumberSPN.setModel(new SpinnerNumberModel(0, 0, 10, 1));
            EnemyIceNumberSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- EnemyEarthNumberSPN ----
            EnemyEarthNumberSPN.setModel(new SpinnerNumberModel(0, 0, 10, 1));
            EnemyEarthNumberSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setBackground(new Color(153, 51, 0));
            backBTN.setForeground(Color.white);
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/left.png")));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(label6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(label14, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addComponent(gamerFireNumberSPN, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gamerWindNumberSPN, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gamerIceNumberSPN, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gamerEarthNumberSPN, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(label16)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gamerXCastle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(label17)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gamerYCastle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EnemyWindNumberSPN, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EnemyIceNumberSPN, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EnemyFireNumberSPN, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, panel3Layout.createSequentialGroup()
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(label15, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                        .addComponent(label13, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(label18)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(enemyXCastle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                            .addGap(43, 43, 43)
                                            .addComponent(label19)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(enemyYCastle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(EnemyEarthNumberSPN, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(finishBTN, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(32, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label8)
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(gamerFireNumberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5)
                                    .addComponent(gamerWindNumberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6)
                                    .addComponent(gamerIceNumberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label7)
                                    .addComponent(gamerEarthNumberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label14)
                                    .addComponent(label16)
                                    .addComponent(gamerXCastle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label17)
                                    .addComponent(gamerYCastle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label9)
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label10)
                                    .addComponent(EnemyFireNumberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label11)
                                    .addComponent(EnemyWindNumberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label12)
                                    .addComponent(EnemyIceNumberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label13)
                                    .addComponent(EnemyEarthNumberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label15)
                                    .addComponent(label18)
                                    .addComponent(enemyXCastle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label19)
                                    .addComponent(enemyYCastle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(finishBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setSize(930, 590);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel3;
    private JButton finishBTN;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JSpinner gamerFireNumberSPN;
    private JSpinner gamerWindNumberSPN;
    private JSpinner gamerIceNumberSPN;
    private JSpinner gamerEarthNumberSPN;
    private JSpinner gamerXCastle;
    private JSpinner gamerYCastle;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JSpinner enemyXCastle;
    private JLabel label19;
    private JSpinner enemyYCastle;
    private JSpinner EnemyFireNumberSPN;
    private JSpinner EnemyWindNumberSPN;
    private JSpinner EnemyIceNumberSPN;
    private JSpinner EnemyEarthNumberSPN;
    private JButton backBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
