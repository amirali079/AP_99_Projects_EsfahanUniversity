package Main.Graphics;

import Exceptions.Incorrect_entry_exception;
import Exceptions.Non_profit_account_exception;
import Main.Buildings.Bank;
import Main.Buildings.airport;
import Main.person;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enter_city extends JFrame {
    private JPanel main_jpl;
    private JLabel header;
    private JTabbedPane main_tabbedPane;
    private JPanel case1;
    private JTabbedPane menu_jpl;
    private JPanel train_station_jpl;
    private JPanel bus_station_jpl;
    private JPanel airport_jpl;
    private JPanel harbour_jpl;
    private JTextField name_text;
    private JTextField address_text;
    private JButton confirm_btn;
    private JTextField area_text;
    private JTextField runway_text;
    private JCheckBox internationalCheckBox;
    private JPanel bank_jpl;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JPanel bank_case1_jpl;
    private JPanel bank_case2_jpl;
    private JPanel bank_case2_1_jpl;
    private JPanel bank_case2_2_jpl;
    private JButton bank_c1_crt_btn;
    private JButton bank_c1_destroy_btn;
    private JTextField bank_c1_text;
    private JButton bank_c2_1_crt_btn;
    private JButton bank_c2_1_del_btn;
    private JButton bank_c2_1_show_btn;
    private JScrollPane bank_c2_1_list;
    private JTextField bank_c2_1_pass_text;
    private JTextField bank_c2_1_user_text;
    private JTextField bank_c2_1_owner_text;
    private JTextField bank_c2_1_amount_text;
    private JTextField bank_c2_name_text;
    private JButton bank_c2_enter_btn;
    private JTextField bank_c2_2_user_text;
    private JTextField bank_c2_2_pass_text;
    private JButton bank_c2_2_enter_btn;
    private JTabbedPane tabbedPane3;
    private JTextField bank_c2_2_1_amount_text;
    private JButton bank_c2_2_1_dep_btn;
    private JButton bank_c2_2_1_wd_btn;
    private JLabel bank_c2_2_1_capital_lbl;
    private JButton bank_c2_2_2_show_btn;
    public JLabel bank_c2_2_2_info_text;
    private JTabbedPane tabbedPane4;
    private JTabbedPane tabbedPane5;
    private JTextField c2_1_1_id_text;
    private JTextField c2_1_1_pro_text;
    private JTextField c2_1_1_staff_text;
    private JTextField c2_1_1_company_text;
    private JTextField c2_1_1_class_text;
    private JButton c2_1_1_add_btn;
    private JTextField c2_1_name_text;
    private JButton c2_1_enter_btn;
    private JScrollPane c2_1_2_list;
    private JTextField c2_1_2_name_text;
    private JButton c2_1_2_hire_btn;
    private JButton c2_1_2_show_btn;

    //________________________
    boolean airport_type;
    Bank current_bank;
    airport current_airport;
    //________________________
    public Enter_city() throws HeadlessException {
        setSize(800,800);
        add(main_jpl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //_________________________
        header.setText("Welcome to "+main_page.esf.get_name());
        bank_c2_2_1_capital_lbl.setText("Remaining capital : "+main_page.esf.capital);
        confirm_btn.addActionListener(e -> {

            airport a = new airport(main_page.esf.get_name(), name_text.getText(), address_text.getText(), Double.parseDouble(area_text.getText()), Integer.parseInt(runway_text.getText()), airport_type);
            main_page.esf.airports.add(a);
            main_page.esf.capital -= a.get_price();
            JOptionPane.showMessageDialog(null,"Airport built!");
            airport_type = false;
        });


        internationalCheckBox.addActionListener(e -> {
            airport_type = true;
        });
        bank_c1_crt_btn.addActionListener(e -> {
            try {
                main_page.esf.create_bank(bank_c1_text.getText());
                JOptionPane.showMessageDialog(null,"Bank "+bank_c1_text.getText()+" has been built!");
            } catch (Incorrect_entry_exception incorrect_entry_exception) {
                JOptionPane.showMessageDialog(null,incorrect_entry_exception.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        bank_c1_destroy_btn.addActionListener(e -> {
            try {
                main_page.esf.destroy_bank(bank_c1_text.getText());
                JOptionPane.showMessageDialog(null,"Bank "+bank_c1_text.getText()+" has been destroyed!");
            } catch (Incorrect_entry_exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        bank_c2_1_show_btn.addActionListener(e -> {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (person p:main_page.esf.citizen)
                listModel.addElement(p.getName()+" "+p.getFamily());
            JList<String>lst = new JList<>(listModel);
            bank_c2_1_list.setViewportView(lst);
        });
        bank_c2_1_crt_btn.addActionListener(e -> {
            try {
                current_bank.create_account(bank_c2_1_user_text.getText(),bank_c2_1_pass_text.getText(),main_page.esf.search_person(bank_c2_1_owner_text.getText(),main_page.esf.citizen),Double.parseDouble(bank_c2_1_amount_text.getText()));
                main_page.esf.capital -= Double.parseDouble(bank_c2_1_amount_text.getText());
                JOptionPane.showMessageDialog(null,"Account created!");
            } catch (Incorrect_entry_exception | InterruptedException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        bank_c2_enter_btn.addActionListener(e -> {
            try {
                current_bank = main_page.esf.search_bank(bank_c2_name_text.getText());
                JOptionPane.showMessageDialog(null,"Entering bank "+bank_c2_name_text.getText());
            } catch (Incorrect_entry_exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        bank_c2_1_del_btn.addActionListener(e -> {
            try {
                current_bank.delete_account(bank_c2_1_user_text.getText(),bank_c2_1_pass_text.getText());
                JOptionPane.showMessageDialog(null,"Account deleted!!");
            } catch (Incorrect_entry_exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        bank_c2_2_enter_btn.addActionListener(e -> {
            try {
                current_bank.search_account(bank_c2_2_user_text.getText(),bank_c2_2_pass_text.getText());
                JOptionPane.showMessageDialog(null,"Entering account!");
                bank_c2_2_1_capital_lbl.setText("Remaining capital : "+main_page.esf.capital);
            } catch (Incorrect_entry_exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        bank_c2_2_1_dep_btn.addActionListener(e -> {
            if (Double.parseDouble(bank_c2_2_1_amount_text.getText())>main_page.esf.capital)
                JOptionPane.showMessageDialog(null,"Not enough capital!","Error",JOptionPane.ERROR_MESSAGE);
            else {
                current_bank.deposit(Double.parseDouble(bank_c2_2_1_amount_text.getText()));
                main_page.esf.capital -= Double.parseDouble(bank_c2_2_1_amount_text.getText());
                JOptionPane.showMessageDialog(null,"Action done!");
            }
        });
        bank_c2_2_1_wd_btn.addActionListener(e -> {
            try {
                current_bank.with_drawl(bank_c2_2_user_text.getText(),bank_c2_2_pass_text.getText(),Double.parseDouble(bank_c2_2_1_amount_text.getText()));
                main_page.esf.capital += Double.parseDouble(bank_c2_2_1_amount_text.getText());
                JOptionPane.showMessageDialog(null,"Action done!");
            } catch (Incorrect_entry_exception | Non_profit_account_exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage()+"\nmake sure you didn't clear text boxes","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        bank_c2_2_2_show_btn.addActionListener(e -> {
            current_bank.show_account_info();
        });

        c2_1_1_add_btn.addActionListener(e -> {
            if (current_airport == null)
                JOptionPane.showMessageDialog(null,"Airport not found!","Error",JOptionPane.ERROR_MESSAGE);
            else {
                main_page.esf.capital -= current_airport.add_airliner(c2_1_1_id_text.getText(),c2_1_1_company_text.getText(),c2_1_1_pro_text.getText(),Integer.parseInt(c2_1_1_staff_text.getText()),c2_1_1_class_text.getText());
                JOptionPane.showMessageDialog(null,"Action done the remaining capital is : "+main_page.esf.capital);
            }
        });

        c2_1_enter_btn.addActionListener(e -> {
            current_airport = main_page.esf.search_vehicle(c2_1_name_text.getText(),main_page.esf.airports);
            if (current_airport == null)
                JOptionPane.showMessageDialog(null,"Airport not found!","Error",JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"Entering airport!");
        });

        c2_1_2_show_btn.addActionListener(e -> {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (person p:main_page.esf.citizen)
                if (!p.working_status)
                    listModel.addElement(p.getName()+" "+p.getFamily()+"Job : "+p.getCareer()+" salary : "+p.getSalary());
            JList<String>lst = new JList<>(listModel);
            c2_1_2_list.setViewportView(lst);
        });

        c2_1_2_hire_btn.addActionListener(e -> {
            person p = main_page.esf.search_person(c2_1_2_name_text.getText(),main_page.esf.citizen);
            if (p == null)
                JOptionPane.showMessageDialog(null,"Person not found!","Error",JOptionPane.ERROR_MESSAGE);
            else if (!(p.getCareer().equals("pilot")|p.getCareer().equals("staff")))
                JOptionPane.showMessageDialog(null,"Person is not a pilot or staff!","Error",JOptionPane.ERROR_MESSAGE);
            else if (current_airport == null)
                JOptionPane.showMessageDialog(null,"Airport not found!","Error",JOptionPane.ERROR_MESSAGE);
            else {
                main_page.esf.hiring(c2_1_2_name_text.getText(),current_airport);
                JOptionPane.showMessageDialog(null,"Action done!");
            }
        });
    }
}
