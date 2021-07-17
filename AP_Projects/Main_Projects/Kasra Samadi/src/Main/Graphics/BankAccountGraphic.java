/*
 * Created by JFormDesigner on Fri Jul 02 05:25:09 IRDT 2021
 */

package Main.Graphics;

import java.awt.event.*;
import Main.Bank.Bank;
import Main.Bank.BankAccount;
import Main.Bank.Transaction;
import Main.Bank.TypeOfTransaction;
import Main.ConsoleColors;
import Main.Country;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author äÊíÇÈ
 */
public class BankAccountGraphic extends JFrame {
    BankAccount bankAccount;
    Bank bank;
    public BankAccountGraphic(BankAccount bankAccount, Bank bank) {

        initComponents();
        this.bankAccount=bankAccount;
        this.bank=bank;
        this.label8.setText(bank.getBankName());;
        label6.setText(bankAccount.getTheAccountHolder().getName()+" "+bankAccount.getTheAccountHolder().getFamily());
        label10.setText(String.valueOf(bank.calculateNumber_of_active_bank_accounts()));

    }
    public void updateMoneyAndTime(){
        while (this.isShowing()){
            label4.setText(String.valueOf(bankAccount.getAccountBalance()));
            label5.setText(String.valueOf(bankAccount.getTime_Left_until_the_next_profitability_of_the_account()+" s"));
            if (bankAccount.getTransactions().size()!=0){
                for (int i=bankAccount.getTransactions().size()-1;i>0;i--){
                    if (bankAccount.getTransactions().get(i).getTypeOfTransaction()==TypeOfTransaction.BankInterest)
                    label7.setText("+"+bankAccount.getTransactions().get(i).getTransactionAmount()+"$   "+bankAccount.getTransactions().get(i).getTransactionTime());
                    break;

                }
            }
            label9.setText(String.valueOf(Country.Total_money_of_all_accounts)+"$");
            label10.setText(String.valueOf(bank.calculateNumber_of_active_bank_accounts()));

        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        String ans=JOptionPane.showInputDialog(this,"Please Enter The Amount Of Deposit:","DEPOSIT TO ACCOUNT",JOptionPane.QUESTION_MESSAGE);
        if (ans!=null&&!ans.isEmpty()){
            double money=Double.parseDouble(ans);
            bankAccount.setAccountBalance(bankAccount.getAccountBalance()+money);
            Country.Total_money_of_all_accounts+=money;
            label13.setText(String.format("+%f$",money));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Transaction transaction=new Transaction(money,dtf.format(now),TypeOfTransaction.Deposit);
            bankAccount.getTransactions().add(transaction);
            if (bankAccount.isThreadAlive()==false){
                bankAccount.setThreadAlive(true);
                bankAccount.profitCalculate();
            }
            JOptionPane.showMessageDialog(this,"Deposit To Account Was Successful","SUCCESSFUL DEPOSIT",JOptionPane.INFORMATION_MESSAGE);
        }else if(ans!=null){
            if(ans.isEmpty()){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this,"Text Field Shouldn't Be Null!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        String ans= JOptionPane.showInputDialog(this,"Please Enter The Amount Of Withdrawal : (If You Want To Withdrawal All Of Your bank Account Balance Enter Number '0')","WITHDRAWAL",JOptionPane.QUESTION_MESSAGE);
        if (ans!=null&&!ans.isEmpty()){
            if (!ans.equals("0")){
                double money=Double.parseDouble(ans);
                if (money<=bankAccount.getAccountBalance()){
                    bankAccount.setAccountBalance(bankAccount.getAccountBalance()-money);
                    Country.Total_money_of_all_accounts-=money;
                    label13.setText(String.format("-%f$",money));
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    Transaction transaction=new Transaction(money,dtf.format(now),TypeOfTransaction.Withdraw);
                    bankAccount.getTransactions().add(transaction);
                    JOptionPane.showMessageDialog(this,"Withdrawal Was Successful","SUCCESSFUL WITHDRAWAL",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(this,"Your Account Balance Is Less Than The Money To Withdrawal ");
                }
            }else {
                double money=bankAccount.getAccountBalance();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                Transaction transaction=new Transaction(money,dtf.format(now),TypeOfTransaction.Withdraw);
                bankAccount.getTransactions().add(transaction);
                Country.Total_money_of_all_accounts-=money;
                label13.setText(String.format("-%f$",money));
                bankAccount.setAccountBalance(0);
                bankAccount.setThreadAlive(false);
                JOptionPane.showMessageDialog(this,"Withdrawal Was Successful","SUCCESSFUL WITHDRAWAL",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(ans!=null){
            if(ans.isEmpty()){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this,"Text Field Shouldn't Be Null!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                SeeAllAccountTransactions seeAllAccountTransactions=new SeeAllAccountTransactions(bankAccount);
                seeAllAccountTransactions.setVisible(true);
                seeAllAccountTransactions.update();
            }
        });thread.start();

    }

    private void button4ActionPerformed(ActionEvent e) {
        GhangeAccountInformation ghangeAccountInformation=new GhangeAccountInformation(bankAccount);
        ghangeAccountInformation.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel3 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        panel4 = new JPanel();
        label8 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label9 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label10 = new JLabel();

        //======== this ========
        setAlwaysOnTop(true);
        setTitle("Account Management");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel3 ========
        {

            //---- label1 ----
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setIcon(new ImageIcon(getClass().getResource("/pictures/2.png")));

            //---- label2 ----
            label2.setText("Account Balance :");
            label2.setForeground(Color.black);
            label2.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));

            //---- label3 ----
            label3.setText("Next Profit At :");
            label3.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label3.setForeground(Color.black);

            //---- label4 ----
            label4.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label4.setForeground(Color.black);

            //---- label5 ----
            label5.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label5.setForeground(Color.black);

            //---- label6 ----
            label6.setText("text");
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 20));
            label6.setForeground(Color.black);

            //---- label7 ----
            label7.setForeground(Color.black);
            label7.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label7.setHorizontalAlignment(SwingConstants.LEFT);

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(panel3Layout.createParallelGroup()
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label1)))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
            );
        }

        //======== panel4 ========
        {
            panel4.setBackground(new Color(0, 102, 255));

            //---- label8 ----
            label8.setText("text");
            label8.setHorizontalAlignment(SwingConstants.CENTER);
            label8.setFont(new Font("French Script MT", Font.BOLD | Font.ITALIC, 40));
            label8.setForeground(Color.white);

            //---- button1 ----
            button1.setText("Withdrawal");
            button1.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            button1.setForeground(Color.black);
            button1.addActionListener(e -> button1ActionPerformed(e));

            //---- button2 ----
            button2.setText("Deposit");
            button2.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            button2.setForeground(Color.black);
            button2.addActionListener(e -> button2ActionPerformed(e));

            //---- button3 ----
            button3.setText("See All Account Transactions");
            button3.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            button3.setForeground(Color.black);
            button3.addActionListener(e -> button3ActionPerformed(e));

            //---- button4 ----
            button4.setText("Ghange Account Information");
            button4.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            button4.setForeground(Color.black);
            button4.addActionListener(e -> button4ActionPerformed(e));

            //---- label9 ----
            label9.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label9.setForeground(Color.white);

            //---- label11 ----
            label11.setText("Total Bank Money :");
            label11.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label11.setForeground(Color.white);

            //---- label12 ----
            label12.setText("Withdrawal And Deposit Ghanges:");
            label12.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label12.setForeground(Color.white);

            //---- label13 ----
            label13.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label13.setForeground(Color.white);
            label13.setText("0");

            //---- label14 ----
            label14.setText("Number Of Active Accounts :");
            label14.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
            label14.setForeground(Color.white);

            //---- label10 ----
            label10.setForeground(Color.white);
            label10.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(GroupLayout.Alignment.LEADING, panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel4Layout.createSequentialGroup()
                                                .addComponent(label14, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(GroupLayout.Alignment.LEADING, panel4Layout.createSequentialGroup()
                                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(6, 6, 6)))))
                        .addGap(11, 11, 11))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(button4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup()
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel4Layout.createParallelGroup()
                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(button1)
                        .addGap(18, 18, 18)
                        .addComponent(button2)
                        .addGap(18, 18, 18)
                        .addComponent(button3)
                        .addGap(18, 18, 18)
                        .addComponent(button4)
                        .addContainerGap(137, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel4, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JPanel panel4;
    private JLabel label8;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label9;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
