/*
 * Created by JFormDesigner on Sat Jul 10 02:15:03 IRDT 2021
 */

package com.company.graphics;
import com.company.Account;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class CreateAccount extends JFrame {
    public CreateAccount() {
        initComponents();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(getRootPane()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void cancelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void createAccountBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>() {
            @Override
            public Object doInBackground() {

                if (usernameTXT.getText().isEmpty())
                {
                    String message = "Username is Empty" ;
                    JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
                }

                else if (passwordTXT.getText().isEmpty())
                {
                    String message = "Password is Empty" ;
                    JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                    new Account(usernameTXT.getText(),passwordTXT.getText()) ;
                    String message = "Account is Created" ;
                    String title = "Create Account" ;
                    ImageIcon icon = new ImageIcon("src\\icons\\user.png") ;
                    JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE, icon);
                    dispose();
                }
                return null;
            }
        }.execute();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel3 = new JPanel();
        createAccountBTN = new JButton();
        cancelBTN = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        usernameTXT = new JTextField();
        passwordTXT = new JTextField();

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
            label1.setText("Create Account Menu");
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

            //---- createAccountBTN ----
            createAccountBTN.setText("Craete Account");
            createAccountBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            createAccountBTN.setBackground(new Color(0, 61, 0));
            createAccountBTN.setForeground(Color.white);
            createAccountBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            createAccountBTN.setIcon(new ImageIcon(getClass().getResource("/icons/yellow plus.png")));
            createAccountBTN.addActionListener(e -> createAccountBTNActionPerformed(e));

            //---- cancelBTN ----
            cancelBTN.setText("Cancel");
            cancelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            cancelBTN.setBackground(new Color(51, 0, 51));
            cancelBTN.setForeground(Color.white);
            cancelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cancelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            cancelBTN.addActionListener(e -> cancelBTNActionPerformed(e));

            //---- label3 ----
            label3.setText("Username");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- label4 ----
            label4.setText("Password");
            label4.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label4.setForeground(Color.white);

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(createAccountBTN, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                                .addComponent(cancelBTN, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addComponent(usernameTXT, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordTXT, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(330, Short.MAX_VALUE))))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(usernameTXT, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(passwordTXT, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(createAccountBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
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
    private JButton createAccountBTN;
    private JButton cancelBTN;
    private JLabel label3;
    private JLabel label4;
    private JTextField usernameTXT;
    private JTextField passwordTXT;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
