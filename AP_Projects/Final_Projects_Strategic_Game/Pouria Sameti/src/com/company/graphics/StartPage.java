/*
 * Created by JFormDesigner on Mon Jul 05 18:59:00 IRDT 2021
 */

package com.company.graphics;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class StartPage extends JFrame {
    public StartPage()
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
        System.exit(0);
    }

    private void exitBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void infoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                InfoGame ig = new InfoGame() ;
                ig.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void startBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                AccountMenu am = new AccountMenu() ;
                am.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void resetBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        File f = new File("src\\Accounts");
        File[] allAccounts = f.listFiles();
        for (File account : allAccounts)
            account.delete();
        String message = "Reset Progress is Done\n Restart Program";
        String title = "Reset Alarm";
        ImageIcon icon = new ImageIcon("src\\icons\\reset.png");
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(0);
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
        startBTN = new JButton();
        resetBTN = new JButton();
        infoBTN = new JButton();
        exitBTN = new JButton();

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
            label1.setText("Start Menu");
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

            //---- startBTN ----
            startBTN.setText("Start");
            startBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            startBTN.setBackground(new Color(0, 0, 51));
            startBTN.setForeground(Color.white);
            startBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            startBTN.setIcon(new ImageIcon(getClass().getResource("/icons/play-button.png")));
            startBTN.addActionListener(e -> startBTNActionPerformed(e));

            //---- resetBTN ----
            resetBTN.setText("Reset");
            resetBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            resetBTN.setForeground(Color.white);
            resetBTN.setBackground(new Color(153, 51, 0));
            resetBTN.setIcon(new ImageIcon(getClass().getResource("/icons/reset.png")));
            resetBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            resetBTN.addActionListener(e -> resetBTNActionPerformed(e));

            //---- infoBTN ----
            infoBTN.setText("Info");
            infoBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            infoBTN.setBackground(new Color(0, 61, 0));
            infoBTN.setForeground(Color.white);
            infoBTN.setIcon(new ImageIcon(getClass().getResource("/icons/info.png")));
            infoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            infoBTN.addActionListener(e -> infoBTNActionPerformed(e));

            //---- exitBTN ----
            exitBTN.setText("Exit");
            exitBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            exitBTN.setForeground(Color.white);
            exitBTN.setBackground(new Color(102, 0, 0));
            exitBTN.setIcon(new ImageIcon(getClass().getResource("/icons/power.png")));
            exitBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            exitBTN.addActionListener(e -> exitBTNActionPerformed(e));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(exitBTN, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetBTN, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addComponent(startBTN, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(372, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(startBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exitBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(89, Short.MAX_VALUE))
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
    private JButton startBTN;
    private JButton resetBTN;
    private JButton infoBTN;
    private JButton exitBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
