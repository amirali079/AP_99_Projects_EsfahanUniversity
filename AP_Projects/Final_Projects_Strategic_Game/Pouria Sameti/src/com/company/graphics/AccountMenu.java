/*
 * Created by JFormDesigner on Sat Jul 10 02:03:15 IRDT 2021
 */

package com.company.graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class AccountMenu extends JFrame {
    public AccountMenu()
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

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                StartPage sp = new StartPage() ;
                sp.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void createAccountBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                CreateAccount ca = new CreateAccount() ;
                ca.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void getAccountBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetAccount ga = new GetAccount() ;
                ga.setVisible(true);
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
        getAccountBTN = new JButton();
        backBTN = new JButton();
        createAccountBTN = new JButton();

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

            //---- getAccountBTN ----
            getAccountBTN.setText("Get Account");
            getAccountBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getAccountBTN.setBackground(new Color(51, 0, 51));
            getAccountBTN.setForeground(Color.white);
            getAccountBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getAccountBTN.setIcon(new ImageIcon(getClass().getResource("/icons/user.png")));
            getAccountBTN.addActionListener(e -> getAccountBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setForeground(Color.white);
            backBTN.setBackground(new Color(204, 51, 0));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/left.png")));
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- createAccountBTN ----
            createAccountBTN.setText("Create Account");
            createAccountBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            createAccountBTN.setBackground(new Color(33, 66, 0));
            createAccountBTN.setForeground(Color.white);
            createAccountBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            createAccountBTN.setIcon(new ImageIcon(getClass().getResource("/icons/add-user.png")));
            createAccountBTN.addActionListener(e -> createAccountBTNActionPerformed(e));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addContainerGap(363, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(backBTN, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(createAccountBTN, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(getAccountBTN, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                        .addGap(351, 351, 351))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(getAccountBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(createAccountBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
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
    private JButton getAccountBTN;
    private JButton backBTN;
    private JButton createAccountBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
