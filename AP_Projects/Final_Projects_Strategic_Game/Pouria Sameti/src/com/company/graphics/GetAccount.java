/*
 * Created by JFormDesigner on Sat Jul 10 02:31:53 IRDT 2021
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
public class GetAccount extends JFrame {
    public GetAccount()
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


    private void getAccountBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
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
                    Account account = Account.getAccount(usernameTXT.getText(), passwordTXT.getText());
                    if (account == null)
                    {
                        String message = "There is NO Account with this Information" ;
                        JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
                    }

                    else
                    {
                        Account.currentAccount = account ;
                        new SwingWorker<>(){
                            @Override
                            public Object doInBackground() {
                                Account.currentAccount.createAccountPanel();
                                Account.currentAccount.updateAccountPanel();
                                dispose();
                                return null ;
                            }
                        }.execute();
                    }
                }
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
            label1.setText("Get Account Menu");
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
            getAccountBTN.setText("Ok");
            getAccountBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getAccountBTN.setBackground(new Color(51, 0, 51));
            getAccountBTN.setForeground(Color.white);
            getAccountBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getAccountBTN.setIcon(new ImageIcon(getClass().getResource("/icons/check 2.png")));
            getAccountBTN.addActionListener(e -> getAccountBTNActionPerformed(e));

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
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addComponent(usernameTXT, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordTXT, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(354, 354, 354)
                                .addComponent(getAccountBTN, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(330, Short.MAX_VALUE))
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addComponent(getAccountBTN, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
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
    private JLabel label3;
    private JLabel label4;
    private JTextField usernameTXT;
    private JTextField passwordTXT;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
