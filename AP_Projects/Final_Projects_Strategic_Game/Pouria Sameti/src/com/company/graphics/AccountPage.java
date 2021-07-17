/*
 * Created by JFormDesigner on Sat Jul 10 11:14:50 IRDT 2021
 */

package com.company.graphics;
import com.company.Account;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class AccountPage extends JFrame {
    public AccountPage()
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
        dispose() ;
    }


    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void newGameBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>() {
            @Override
            public Object doInBackground() {
                CreateGame cg = new CreateGame();
                cg.setVisible(true);
                return null;
            }
        }.execute();
    }

    private void deleteBTNActionPerformed(ActionEvent e) {
        File deletedFile = new File(Account.currentAccount.getPath()) ;
        boolean DF = deletedFile.delete() ;
        if (DF)
        {
            String message = "Account was Removed\nGame is Restart when you Click on OK button" ;
            ImageIcon icon = new ImageIcon("src\\icons\\remove-friend.png") ;
            JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.INFORMATION_MESSAGE,icon);
            System.exit(0);
        }

        else
        {
            String message = "Error" ;
            JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel3 = new JPanel();
        newGameBTN = new JButton();
        backBTN = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        winsLBL = new JLabel();
        lossesLBL = new JLabel();
        deleteBTN = new JButton();
        label5 = new JLabel();
        gamesLBL = new JLabel();

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
            label1.setText("Account Menu");
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

            //---- newGameBTN ----
            newGameBTN.setText("New Game");
            newGameBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            newGameBTN.setBackground(new Color(0, 71, 0));
            newGameBTN.setForeground(Color.white);
            newGameBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            newGameBTN.setIcon(new ImageIcon(getClass().getResource("/icons/yellow plus.png")));
            newGameBTN.addActionListener(e -> newGameBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setForeground(Color.white);
            backBTN.setBackground(new Color(204, 51, 0));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/left.png")));
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- label3 ----
            label3.setText("Wins");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);
            label3.setIcon(new ImageIcon(getClass().getResource("/icons/trophy.png")));

            //---- label4 ----
            label4.setText("Losses");
            label4.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label4.setForeground(Color.white);
            label4.setIcon(new ImageIcon(getClass().getResource("/icons/skull.png")));

            //---- winsLBL ----
            winsLBL.setText("Text");
            winsLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            winsLBL.setForeground(Color.white);

            //---- lossesLBL ----
            lossesLBL.setText("Text");
            lossesLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            lossesLBL.setForeground(Color.white);

            //---- deleteBTN ----
            deleteBTN.setText("Delete Account");
            deleteBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            deleteBTN.setForeground(Color.white);
            deleteBTN.setBackground(new Color(102, 0, 0));
            deleteBTN.setIcon(new ImageIcon(getClass().getResource("/icons/delete.png")));
            deleteBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            deleteBTN.addActionListener(e -> deleteBTNActionPerformed(e));

            //---- label5 ----
            label5.setText("Games");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);
            label5.setIcon(new ImageIcon(getClass().getResource("/icons/joystick.png")));

            //---- gamesLBL ----
            gamesLBL.setText("Text");
            gamesLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            gamesLBL.setForeground(Color.white);

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(newGameBTN, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(deleteBTN, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(winsLBL, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(388, Short.MAX_VALUE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gamesLBL, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lossesLBL, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 388, Short.MAX_VALUE))))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(winsLBL))
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(lossesLBL))
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(gamesLBL))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                            .addComponent(newGameBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
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
        setSize(930, 530);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel3;
    private JButton newGameBTN;
    private JButton backBTN;
    private JLabel label3;
    private JLabel label4;
    public JLabel winsLBL;
    public JLabel lossesLBL;
    private JButton deleteBTN;
    private JLabel label5;
    public JLabel gamesLBL;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
