package Main.Graphics;

import City.City;
import Country.Country;
import Exceptions.Incorrect_entry_exception;
import Main.Buildings.Bank;
import Main.Main;
import Main.person;

import javax.swing.*;
import java.io.*;

public class main_page extends JFrame{
    private JPanel main_jpl;
    private JLabel header;
    private JTabbedPane build_city;
    private JLabel city_name_lbl;
    private JTextField city_name_text;
    private JButton confirm_btn;
    private JButton clear_btn;
    private JPanel build_city_jpl;
    private JPanel enter_city_jpl;
    private JTextField enter_city_text;
    private JButton entering_city_btn;
    private JButton show_city_btn;
    private JLabel text_field_header_lbl;
    private JScrollPane city_list;
    private JPanel fn_jpl;
    private JScrollPane fn_list;
    public DefaultListModel<String> listModel_fn = new DefaultListModel<>();
    public Enter_city enterCity;
    //main variables__________
    static Country iran;
    static City esf;
    Main alaki = new Main();
    FileReader cities_info;
    FileInputStream cities_obj;
    FileInputStream country_obj;
    ObjectInputStream cio;
    ObjectInputStream cuo;
    //_________________________
    public main_page() throws IOException, ClassNotFoundException, InterruptedException {
        setSize(400,400);
        add(main_jpl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //______________________________

        Bank.t_main = alaki;
        try {
            JOptionPane.showMessageDialog(null,"Try reading last saved file!");
            cities_obj=new FileInputStream("D:\\project faze3\\cities obj.txt");
            country_obj=new FileInputStream("D:\\project faze3\\country obj.txt");
            cio=new ObjectInputStream(cities_obj);
            cuo=new ObjectInputStream(country_obj);
            iran=(Country) cuo.readObject();
            Thread.sleep(2000);
            for (City c: iran.cities)
                for (Bank b:c.banks)
                    b.start();
            JOptionPane.showMessageDialog(null,"Last file loaded successfully!");
            cio.close();
            cuo.close();
            country_obj.close();
            cities_obj.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error while reading file!\nThis is the first time you are using this program or you might not have been saved your last changes to this program!");
            iran=new Country("IRAN");

        }
        //______________________________
        clear_btn.addActionListener(e -> city_name_text.setText(""));

        confirm_btn.addActionListener(e -> {
            try
            {
                String name = city_name_text.getText();
                iran.add_city(name);
                esf = iran.search_city(name);
                person p = new person("mohammad", "mahdavi", "1381/1/15", name, 30, "male", "pilot");
                esf.citizen.add(p);
                p = new person("reza", "mahdavi", "1382/4/15", name, 25, "male", "driver");
                esf.citizen.add(p);
                p = new person("ahmad", "mahdavi", "1380/3/15", name, 15, "male", "staff");
                esf.citizen.add(p);
                p = new person("mohammad", "ahmadi", "1371/2/15", name, 20, "male", "sailor");
                esf.citizen.add(p);
                p = new person("sara", "ahmadi", "1371/2/15", name, 20, "female", "lukomotoran");
                esf.citizen.add(p);
                JOptionPane.showMessageDialog(null,city_name_text.getText()+" City built");
            }
            catch (Incorrect_entry_exception ex)
            {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }

        });

        show_city_btn.addActionListener(e -> {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (City c: iran.cities)
                listModel.addElement(c.get_name());
            JList<String>lst = new JList<>(listModel);
            city_list.setViewportView(lst);
        });

        entering_city_btn.addActionListener(e -> {
            esf = iran.search_city(enter_city_text.getText());
            if (esf == null)
                JOptionPane.showMessageDialog(null,"City not found!");
            else {
                new Thread(() -> {
                    enterCity = new Enter_city();
                    enterCity.setVisible(true);
                }).start();
            }
        });
        new Thread(() -> {
            JList<String>lst = new JList<>(listModel_fn);
            fn_list.setViewportView(lst);
            Main.fn_end = false;
            alaki.fn();
        }).start();
    }
}
