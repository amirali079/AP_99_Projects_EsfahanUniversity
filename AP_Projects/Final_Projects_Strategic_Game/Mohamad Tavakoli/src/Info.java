import javax.swing.*;
import javax.swing.GroupLayout;

public class Info extends JFrame {
    public Info() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        firePic = new JLabel(new ImageIcon("Fire.jpg"));
        windPic = new JLabel(new ImageIcon("Wind.jpg"));
        firePower = new JLabel();
        fireSpeed = new JLabel();
        fireHealth = new JLabel();
        windPower = new JLabel();
        windSpeed = new JLabel();
        windHeath = new JLabel();
        icePic = new JLabel(new ImageIcon("Ice.jpg"));
        earthPic = new JLabel(new ImageIcon("Earth.jpg"));
        earthSpeed = new JLabel();
        earthPower = new JLabel();
        iceSpeed = new JLabel();
        earthHeath = new JLabel();
        icePower = new JLabel();
        iceHealth = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        var contentPane = getContentPane();

        //---- firePower ----
        firePower.setText("Power = 5");

        //---- fireSpeed ----
        fireSpeed.setText("Speed = 1");

        //---- fireHealth ----
        fireHealth.setText("Health = 60");

        //---- windPower ----
        windPower.setText("Power = 3");

        //---- windSpeed ----
        windSpeed.setText("Speed = 2");

        //---- windHeath ----
        windHeath.setText("Health = 60");

        //---- icePic ----
        icePic.setText("text");

        //---- earthPic ----
        earthPic.setText("text");

        //---- earthSpeed ----
        earthSpeed.setText("Speed = 1");

        //---- earthPower ----
        earthPower.setText("Power = 3");

        //---- iceSpeed ----
        iceSpeed.setText("Speed = 1");

        //---- earthHeath ----
        earthHeath.setText("Health = 70");

        //---- icePower ----
        icePower.setText("Power = 2");

        //---- iceHealth ----
        iceHealth.setText("Health = 100");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(firePic, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(windPic, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(windPower, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                .addComponent(fireSpeed, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                .addComponent(firePower, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                .addComponent(windSpeed, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                .addComponent(windHeath, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                                        .addComponent(fireHealth))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(earthPic, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(earthSpeed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(earthPower, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                        .addComponent(earthHeath, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(icePic, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(icePower, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                        .addComponent(iceHealth, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                        .addComponent(iceSpeed, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(firePic, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(icePic, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(iceHealth)
                                                                .addComponent(fireHealth))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                .addComponent(firePower)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(fireSpeed))))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(icePower)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(iceSpeed)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(earthPower)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(earthSpeed))
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(windPic, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(windPower)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(windSpeed)))
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(earthPic, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(earthHeath)
                                                        .addComponent(windHeath))))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel firePic;
    private JLabel windPic;
    private JLabel firePower;
    private JLabel fireSpeed;
    private JLabel fireHealth;
    private JLabel windPower;
    private JLabel windSpeed;
    private JLabel windHeath;
    private JLabel icePic;
    private JLabel earthPic;
    private JLabel earthSpeed;
    private JLabel earthPower;
    private JLabel iceSpeed;
    private JLabel earthHeath;
    private JLabel icePower;
    private JLabel iceHealth;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
