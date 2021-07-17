/*
 * Created by JFormDesigner on Fri Jul 02 16:43:34 IRDT 2021
 */

package Main.Graphics;

import Main.Bank.BankAccount;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author äÊíÇÈ
 */
public class SeeAllAccountTransactions extends JFrame {
    BankAccount bankAccount;
    public SeeAllAccountTransactions(BankAccount bankAccount) {
        initComponents();
        this.bankAccount=bankAccount;

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setAlwaysOnTop(true);
        setTitle("See All Account Transactions");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setBackground(new Color(102, 102, 102));
            textArea1.setForeground(Color.white);
            textArea1.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
            textArea1.setRows(3);
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public void update(){
        while (this.isShowing()){
            StringBuilder stringBuilder=new StringBuilder();

                for (int i=0;i<bankAccount.getTransactions().size();i++){
                    stringBuilder.append(String.format("\n(%d) %s\n", i + 1, bankAccount.getTransactions().get(i).toString()));
                }
                textArea1.setText(stringBuilder.toString());
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
