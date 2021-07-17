/*
 * Created by JFormDesigner on Sat Jul 03 20:44:16 IRDT 2021
 */

package Main.Graphics;

import java.awt.event.*;
import Main.Bank.BankAccount;
import Main.Bank.Transaction;
import Main.Country;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author äÊíÇÈ
 */
public class FinancialManagement extends JFrame {
    public static ArrayList<String>holdTransactionInfo =new ArrayList<>();
    public FinancialManagement(String countryName) {
        initComponents();
        label8.setText(countryName);
    }

    public void updateMoney(){
        while (this.isShowing()){
            label5.setText((Country.TotalBudget)+"$");
            label7.setText((Country.Total_money_of_all_accounts)+"$");
            if (holdTransactionInfo.size()>0){
                textArea1.append(holdTransactionInfo.remove(holdTransactionInfo.size()-1));
                textArea1.append("\n");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();
        label5 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setAlwaysOnTop(true);
        setBackground(new Color(102, 102, 102));
        setTitle("Financial Management");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.black);
            panel1.setForeground(Color.black);

            //---- label1 ----
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setIcon(new ImageIcon(getClass().getResource("/pictures/4.png")));

            //---- label4 ----
            label4.setText("Total Budget :");
            label4.setForeground(new Color(220, 157, 7));
            label4.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));

            //---- label6 ----
            label6.setText("Total Money Of All Bank Accounts :");
            label6.setForeground(new Color(220, 157, 7));
            label6.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));

            //---- label5 ----
            label5.setText("text");
            label5.setForeground(new Color(220, 157, 7));
            label5.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));

            //---- label7 ----
            label7.setText("text");
            label7.setForeground(new Color(220, 157, 7));
            label7.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));

            //---- label8 ----
            label8.setText("text");
            label8.setForeground(new Color(220, 157, 7));
            label8.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 20));
            label8.setHorizontalAlignment(SwingConstants.CENTER);

            //======== scrollPane2 ========
            {
                scrollPane2.setBackground(Color.black);
                scrollPane2.setBorder(null);

                //---- textArea1 ----
                textArea1.setForeground(new Color(220, 157, 7));
                textArea1.setBackground(Color.black);
                textArea1.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 16));
                textArea1.setDisabledTextColor(Color.black);
                textArea1.setSelectionColor(Color.black);
                textArea1.setSelectedTextColor(new Color(204, 204, 204));
                textArea1.setBorder(null);
                textArea1.setEditable(false);
                scrollPane2.setViewportView(textArea1);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label8, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane2)))
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label4;
    private JLabel label6;
    private JLabel label5;
    private JLabel label7;
    private JLabel label8;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
