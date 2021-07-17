/*
 * Created by JFormDesigner on Fri Jul 02 01:04:53 IRDT 2021
 */

package Main.Graphics;

import Main.Bank.Bank;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author äÊíÇÈ
 */
public class LoginPage extends JFrame {
    public String username;
    public String password;
    Bank selectedBank;
    public LoginPage(Bank bank) {
        initComponents();
        selectedBank=bank;
        label7.setText("Welcome To "+bank.getBankName());
        label7.setFont(new Font("French Script MT", Font.BOLD | Font.ITALIC, 40));
        label7.setForeground(Color.white);
        label7.setHorizontalAlignment(SwingConstants.CENTER);

    }

    private void textField1FocusGained(FocusEvent e) {
        textField1.setText("");
    }

    private void passwordField1FocusGained(FocusEvent e) {
        passwordField1.setText("");
    }

    private void button1ActionPerformed(ActionEvent e) {
        if (!textField1.getText().isEmpty()&&passwordField1.getPassword().length!=0){

             username=textField1.getText();
             password=String.valueOf(passwordField1.getPassword());
             this.dispose();
        }else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this,"These Text Fields Shouldn't Be Empty","ERROR",JOptionPane.ERROR_MESSAGE);
        }
            }

            private void button2ActionPerformed(ActionEvent e) {
                        String username1=JOptionPane.showInputDialog(this,"Please Enter Your Username","WHAT'S YOUR USERNAME?",JOptionPane.QUESTION_MESSAGE);
                        boolean usernameFound=false;
                        for (int i=0;i<selectedBank.getBankAccounts().size();i++){
                            if (selectedBank.getBankAccounts().get(i).getUsername().equals(username1)){
                                selectedBank.getBankAccounts().get(i).sendGmail();
                                textField1.setText(username1);
                                JOptionPane.showMessageDialog(this,"Your Account Password Was Sent To "+selectedBank.getBankAccounts().get(i).getGmail()+" Please Check Your Gmail And Enter Your Password Here","Recovery Password",JOptionPane.INFORMATION_MESSAGE);
                                usernameFound=true;
                            }
                        }
                        if (!usernameFound) {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(this, "This Username Was Not Found!", "ERROR", JOptionPane.ERROR_MESSAGE);

                        }
            }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        label7 = new JLabel();

        //======== this ========
        setBackground(new Color(51, 51, 51));
        setTitle("Login Page");
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 102));

            //---- label1 ----
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setIcon(new ImageIcon(getClass().getResource("/pictures/1.png")));
            label1.setForeground(new Color(102, 102, 102));

            //======== panel2 ========
            {
                panel2.setBackground(new Color(153, 153, 153));
                panel2.setForeground(new Color(51, 51, 51));

                //---- label2 ----
                label2.setText("Login");
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setFont(new Font("French Script MT", Font.BOLD | Font.ITALIC, 40));
                label2.setBackground(Color.black);
                label2.setForeground(Color.black);

                //---- label3 ----
                label3.setText("Username");
                label3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
                label3.setForeground(Color.black);

                //---- label4 ----
                label4.setText("Password");
                label4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
                label4.setForeground(Color.black);

                //---- textField1 ----
                textField1.setText("Enter Username");
                textField1.setForeground(Color.white);
                textField1.setBackground(new Color(102, 102, 102));
                textField1.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
                textField1.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField1FocusGained(e);
                    }
                });

                //---- passwordField1 ----
                passwordField1.setText("00000000000");
                passwordField1.setBackground(new Color(102, 102, 102));
                passwordField1.setForeground(Color.white);
                passwordField1.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
                passwordField1.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        passwordField1FocusGained(e);
                    }
                });

                //---- button1 ----
                button1.setText("Login");
                button1.setBackground(new Color(102, 102, 102));
                button1.setForeground(Color.white);
                button1.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
                button1.addActionListener(e -> button1ActionPerformed(e));

                //---- button2 ----
                button2.setText("Forgot Password?");
                button2.setBackground(new Color(102, 102, 102));
                button2.setForeground(Color.white);
                button2.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
                button2.addActionListener(e -> button2ActionPerformed(e));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(textField1, GroupLayout.Alignment.TRAILING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(174, Short.MAX_VALUE))
                                        .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 174, Short.MAX_VALUE))))))
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 96, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button2)
                            .addGap(184, 184, 184))
                );
            }

            //---- label7 ----
            label7.setFont(new Font("French Script MT", Font.BOLD | Font.ITALIC, 40));
            label7.setForeground(Color.white);
            label7.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
