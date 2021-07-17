/*
 * Created by JFormDesigner on Wed Jun 30 22:55:23 IRDT 2021
 */

package Main.Graphics;

import Main.Bank.Bank;
import Main.Bank.BankAccount;
import Main.City;
import Main.Person;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author äÊíÇÈ
 */
public class SignUpPage extends JFrame {
    Person person;
    Bank bank;
    String cityName;
    private String username;
    private String password;
    private String gmail;
    private double Initial_deposit_amount;
    private boolean flag=false;


    public SignUpPage(Person person, Bank bank,String cityName) {
        initComponents();
        this.person=person;
        this.bank=bank;
        this.cityName=cityName;
        label7.setText("Hi Dear "+person.getName()+"Welcome To "+bank.getBankName());
        label7.setFont(new Font("French Script MT", Font.BOLD | Font.ITALIC, 40));
        label7.setForeground(Color.white);
        label7.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGmail() {
        return gmail;
    }

    public double getInitial_deposit_amount() {
        return Initial_deposit_amount;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setInitial_deposit_amount(double initial_deposit_amount) {
        Initial_deposit_amount = initial_deposit_amount;
    }

    private void textField1FocusGained(FocusEvent e) {
        textField1.setText("");
    }

    private void passwordField1FocusGained(FocusEvent e) {
        passwordField1.setText("");    }

        private void textField3FocusGained(FocusEvent e) {
            textField3.setText("");
        }

        private void textField2FocusGained(FocusEvent e) {
            textField2.setText("");
        }

        private void button1ActionPerformed(ActionEvent e) {
            if (!textField1.getText().isEmpty()&&!textField2.getText().isEmpty()&&!textField3.getText().isEmpty()&&passwordField1.getPassword().length!=0){
                 setUsername(textField1.getText());
                 setPassword(String.valueOf(passwordField1.getPassword()));
                 setGmail(textField3.getText());
                 setInitial_deposit_amount(Double.parseDouble(textField2.getText()));
                BankAccount bankAccount=new BankAccount(getInitial_deposit_amount(),person,getUsername(),getPassword(),getGmail(),cityName,bank);
                bankAccount.profitCalculate();

                JOptionPane.showMessageDialog(this,"Bank Account Was Created!","CONGRATULATIONS",JOptionPane.NO_OPTION);
                this.dispose();
            }else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this,"These Text Fields Shouldn't Be Empty","ERROR",JOptionPane.ERROR_MESSAGE);
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
        label5 = new JLabel();
        label6 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        label7 = new JLabel();

        //======== this ========
        setBackground(new Color(51, 51, 51));
        setTitle("Signup Page");
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
                label2.setText("Signup");
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setFont(new Font("French Script MT", Font.BOLD | Font.ITALIC, 40));
                label2.setBackground(new Color(51, 51, 51));
                label2.setForeground(Color.black);

                //---- label3 ----
                label3.setText("Username");
                label3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
                label3.setForeground(Color.black);

                //---- label4 ----
                label4.setText("Password");
                label4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
                label4.setForeground(Color.black);

                //---- label5 ----
                label5.setText("Gmail");
                label5.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
                label5.setForeground(Color.black);

                //---- label6 ----
                label6.setText("Initial Deposit Amount");
                label6.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
                label6.setForeground(Color.black);

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

                //---- textField2 ----
                textField2.setText(" Enter Initial Deposit Amount");
                textField2.setBackground(new Color(102, 102, 102));
                textField2.setForeground(Color.white);
                textField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
                textField2.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField2FocusGained(e);
                    }
                });

                //---- textField3 ----
                textField3.setText("Enter Gmail Address");
                textField3.setBackground(new Color(102, 102, 102));
                textField3.setForeground(Color.white);
                textField3.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
                textField3.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField3FocusGained(e);
                    }
                });

                //---- button1 ----
                button1.setText("Signup");
                button1.setBackground(new Color(102, 102, 102));
                button1.setForeground(Color.white);
                button1.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
                button1.addActionListener(e -> button1ActionPerformed(e));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(textField3)
                                        .addComponent(textField2, GroupLayout.Alignment.TRAILING)
                                        .addComponent(textField1, GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 174, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap(174, Short.MAX_VALUE))
                                        .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)))))
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addGap(137, 137, 137))
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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)
                            .addComponent(button1)
                            .addGap(63, 63, 63))
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
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
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
    private JLabel label5;
    private JLabel label6;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
