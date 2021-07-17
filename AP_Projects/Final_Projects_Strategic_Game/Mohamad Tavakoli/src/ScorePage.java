import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Mon Jul 12 00:42:33 IRDT 2021
 */


/**
 * @author mmd
 */
public class ScorePage extends JFrame {
    public ScorePage() {
        initComponents();
    }

    public JLabel getT1LBL() {
        return t1LBL;
    }

    public JLabel getT2LBL() {
        return t2LBL;
    }

    public JLabel getF1s() {
        return f1s;
    }

    public JLabel getW1s() {
        return w1s;
    }

    public JLabel getI1s() {
        return i1s;
    }

    public JLabel getE1s() {
        return e1s;
    }

    public JLabel getF2s() {
        return f2s;
    }

    public JLabel getW2s() {
        return w2s;
    }

    public JLabel getI2s() {
        return i2s;
    }

    public JLabel getE2s() {
        return e2s;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        t1LBL = new JLabel();
        t2LBL = new JLabel();
        f1 = new JLabel(new ImageIcon("Fire.jpg"));
        w1 = new JLabel(new ImageIcon("Wind.jpg"));
        i1 = new JLabel(new ImageIcon("Ice.jpg"));
        e1 = new JLabel(new ImageIcon("Earth.jpg"));
        f1s = new JLabel();
        w1s = new JLabel();
        i1s = new JLabel();
        e1s = new JLabel();
        f2 = new JLabel(new ImageIcon("Fire.jpg"));
        w2 = new JLabel(new ImageIcon("Wind.jpg"));
        i2 = new JLabel(new ImageIcon("Ice.jpg"));
        e2 = new JLabel(new ImageIcon("Earth.jpg"));
        f2s = new JLabel();
        w2s = new JLabel();
        i2s = new JLabel();
        e2s = new JLabel();


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        var ContentPane = getContentPane();

        //---- t1LBL ----
        t1LBL.setText("Team 1 : 0");

        //---- t2LBL ----
        t2LBL.setText("Team 2 : 0");

        //---- f1s ----
        f1s.setText("SCORE : 0");

        //---- w1s ----
        w1s.setText("SCORE : 0");

        //---- i1s ----
        i1s.setText("SCORE : 0");

        //---- e1s ----
        e1s.setText("SCORE : 0");

        //---- f2s ----
        f2s.setText("SCORE : 0");

        //---- w2s ----
        w2s.setText("SCORE : 0");

        //---- i2s ----
        i2s.setText("SCORE : 0");

        //---- e2s ----
        e2s.setText("SCORE : 0");

        GroupLayout ContentPaneLayout = new GroupLayout(ContentPane);
        ContentPane.setLayout(ContentPaneLayout);
        ContentPaneLayout.setHorizontalGroup(
                ContentPaneLayout.createParallelGroup()
                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ContentPaneLayout.createParallelGroup()
                                        .addComponent(t1LBL)
                                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                                .addComponent(f1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(f1s))
                                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                                .addComponent(w1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(w1s))
                                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                                .addComponent(i1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(i1s))
                                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                                .addComponent(e1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(e1s)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(ContentPaneLayout.createParallelGroup()
                                        .addComponent(t2LBL)
                                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                                .addComponent(w2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(w2s))
                                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                                .addComponent(i2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(i2s))
                                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                                .addComponent(e2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(e2s))
                                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                                .addComponent(f2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(f2s)))
                                .addGap(64, 64, 64))
        );
        ContentPaneLayout.setVerticalGroup(
                ContentPaneLayout.createParallelGroup()
                        .addGroup(ContentPaneLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(t1LBL)
                                        .addComponent(t2LBL))
                                .addGap(18, 18, 18)
                                .addGroup(ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(f1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(f1s)
                                        .addComponent(f2s)
                                        .addComponent(f2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(w1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(w1s)
                                        .addComponent(w2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(w2s))
                                .addGap(18, 18, 18)
                                .addGroup(ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(i1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(i1s)
                                        .addComponent(i2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(i2s))
                                .addGap(18, 18, 18)
                                .addGroup(ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(e1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(e1s)
                                        .addComponent(e2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(e2s))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel t1LBL;
    private JLabel t2LBL;
    private JLabel f1;
    private JLabel w1;
    private JLabel i1;
    private JLabel e1;
    private JLabel f1s;
    private JLabel w1s;
    private JLabel i1s;
    private JLabel e1s;
    private JLabel f2;
    private JLabel w2;
    private JLabel i2;
    private JLabel e2;
    private JLabel f2s;
    private JLabel w2s;
    private JLabel i2s;
    private JLabel e2s;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
