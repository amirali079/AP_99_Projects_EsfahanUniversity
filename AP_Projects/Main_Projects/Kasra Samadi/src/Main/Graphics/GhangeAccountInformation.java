/*
 * Created by JFormDesigner on Fri Jul 02 21:00:43 IRDT 2021
 */

package Main.Graphics;

import java.awt.event.*;
import Main.Bank.BankAccount;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author äÊíÇÈ
 */
public class GhangeAccountInformation extends JFrame {
    BankAccount bankAccount;
    public GhangeAccountInformation(BankAccount bankAccount) {
        initComponents();
        this.bankAccount=bankAccount;
        textField1.setText(bankAccount.getUsername());
        textField2.setText(bankAccount.getPassword());
        textField3.setText(bankAccount.getGmail());
        label2.setText(bankAccount.getTheAccountHolder().getName()+" "+bankAccount.getTheAccountHolder().getFamily());
    }

    private void button1ActionPerformed(ActionEvent e) {
        if (!textField1.getText().isEmpty()&&!textField2.getText().isEmpty()&&!textField3.getText().isEmpty()){
            bankAccount.setUsername(textField1.getText());
            bankAccount.setPassword(textField2.getText());
            bankAccount.setGmail(textField3.getText());


            JOptionPane.showMessageDialog(this,"Bank Account Information Was Changed!","CONGRATULATIONS",JOptionPane.NO_OPTION);
            this.dispose();
        }else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this,"These Text Fields Shouldn't Be Empty","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        panel4 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        panel5 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setTitle("Ghange Account Information");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel2 ========
        {
            panel2.setBackground(Color.white);

            //======== panel4 ========
            {
                panel4.setBackground(new Color(0, 102, 255));

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

                //---- textField1 ----
                textField1.setForeground(Color.black);
                textField1.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

                //---- textField2 ----
                textField2.setForeground(Color.black);
                textField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

                //---- textField3 ----
                textField3.setForeground(Color.black);
                textField3.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

                //---- button1 ----
                button1.setText("Save Ghanges ");
                button1.setForeground(Color.black);
                button1.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
                button1.addActionListener(e -> button1ActionPerformed(e));

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addContainerGap(81, Short.MAX_VALUE)
                            .addGroup(panel4Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                    .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField2)
                                        .addComponent(textField3)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                                    .addGap(62, 62, 62))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                    .addComponent(button1)
                                    .addGap(144, 144, 144))))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(button1)
                            .addContainerGap(129, Short.MAX_VALUE))
                );
            }

            //======== panel5 ========
            {
                panel5.setBackground(Color.white);

                //---- label1 ----
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setIcon(new ImageIcon(getClass().getResource("/pictures/3.png")));

                //---- label2 ----
                label2.setText("text");
                label2.setForeground(Color.black);
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 24));

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                            .addContainerGap(78, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72))
                        .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(174, Short.MAX_VALUE))
                );
            }

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel2;
    private JPanel panel4;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JPanel panel5;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
