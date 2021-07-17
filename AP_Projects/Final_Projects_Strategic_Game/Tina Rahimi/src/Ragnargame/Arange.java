package Ragnargame;

import com.sun.glass.events.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.PopupMenu;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author KPS
 */
public class Arange extends javax.swing.JFrame {
    int f1=0;
    int f2=0;
    int s1=0;
    int s2=0;
    int i1=0;
    int i2=0;
    int w1=0;
    int w2=0;
    public static LinkedList<JLabel> Fire1_1 = new LinkedList<>();
    public static LinkedList<JLabel> Fire2_2 = new LinkedList<>();
    public static LinkedList<JLabel> Wind1_1 = new LinkedList<>();
    public static LinkedList<JLabel> Wind2_2 = new LinkedList<>();
    public static LinkedList<JLabel> Soil1_1 = new LinkedList<>();
    public static LinkedList<JLabel> Soil2_2 = new LinkedList<>();
    public static LinkedList<JLabel> Ice1_1 = new LinkedList<>();
    public static LinkedList<JLabel> Ice2_2 = new LinkedList<>();
    public static int Castel1_X;
    public static int Castel1_Y;
    public static int Castel2_X;
    public static int Castel2_Y;
    
    public Arange() {
        
        initComponents();
        this.setSize(1210 , 710);
        this.setResizable(false);
        this.setBackground(Color.getHSBColor(0, 0, 90));
        for(int i=0; i<Number.Fire; i++){
            Fire1_1.add(new JLabel());
            Fire1_1.get(i).setSize(101 , 101);
            Fire1_1.get(i).setIcon(Fire1.getIcon());
            Fire1_1.get(i).setLocation(0 , 0);
            this.add(Fire1_1.get(i));
        }
        
        for(int i=0; i<Number.Fire; i++){
            Fire2_2.add(new JLabel());
            Fire2_2.get(i).setSize(101 , 101);
            Fire2_2.get(i).setIcon(Fire2.getIcon());
            Fire2_2.get(i).setLocation(1089 , 0);
            this.add(Fire2_2.get(i));
        }
        
        for(int i=0; i<Number.Wind; i++){
            Wind1_1.add(new JLabel());
            Wind1_1.get(i).setSize(101 , 101);
            Wind1_1.get(i).setIcon(Wind1.getIcon());
            Wind1_1.get(i).setLocation(101 , 0);
            this.add(Wind1_1.get(i));
        }
        
        for(int i=0; i<Number.Wind; i++){
            Wind2_2.add(new JLabel());
            Wind2_2.get(i).setSize(101 , 101);
            Wind2_2.get(i).setIcon(Wind2.getIcon());
            Wind2_2.get(i).setLocation(988 , 0);
            this.add(Wind2_2.get(i));
        }
        
        for(int i=0; i<Number.Ice; i++){
            Ice1_1.add(new JLabel());
            Ice1_1.get(i).setSize(101 , 101);
            Ice1_1.get(i).setIcon(Ice1.getIcon());
            Ice1_1.get(i).setLocation(202 , 0);
            this.add(Ice1_1.get(i));
        }
        
        for(int i=0; i<Number.Ice; i++){
            Ice2_2.add(new JLabel());
            Ice2_2.get(i).setSize(101 , 101);
            Ice2_2.get(i).setIcon(Ice2.getIcon());
            Ice2_2.get(i).setLocation(786 , 0);
            this.add(Ice2_2.get(i));
        }
        
        for(int i=0; i<Number.Soil; i++){
            Soil1_1.add(new JLabel());
            Soil1_1.get(i).setSize(101 , 101);
            Soil1_1.get(i).setIcon(Soil1.getIcon());
            Soil1_1.get(i).setLocation(303 , 0);
            this.add(Soil1_1.get(i));
        }
        
        for(int i=0; i<Number.Soil; i++){
            Soil2_2.add(new JLabel());
            Soil2_2.get(i).setSize(101 , 101);
            Soil2_2.get(i).setIcon(Soil2.getIcon());
            Soil2_2.get(i).setLocation(887 , 0);
            this.add(Soil2_2.get(i));
        }
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        Soil1 = new javax.swing.JLabel();
        Castle2 = new javax.swing.JLabel();
        Ice1 = new javax.swing.JLabel();
        Fire1 = new javax.swing.JLabel();
        Fire2 = new javax.swing.JLabel();
        Wind1 = new javax.swing.JLabel();
        Wind2 = new javax.swing.JLabel();
        Soil2 = new javax.swing.JLabel();
        Ice2 = new javax.swing.JLabel();
        Castle1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(231, 231, 231));
        setFocusCycleRoot(false);
        setSize(new java.awt.Dimension(1300, 700));
        getContentPane().setLayout(null);

        Soil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Soil1.png"))); // NOI18N
        Soil1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Soil1MouseDragged(evt);
            }
        });
        Soil1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Soil1MouseClicked(evt);
            }
        });
        getContentPane().add(Soil1);
        Soil1.setBounds(202, 0, 101, 101);

        Castle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Castleblue2.png"))); // NOI18N
        Castle2.setToolTipText("");
        Castle2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Castle2MouseDragged(evt);
            }
        });
        Castle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Castle2MouseClicked(evt);
            }
        });
        getContentPane().add(Castle2);
        Castle2.setBounds(910, 460, 281, 202);

        Ice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Ice1.png"))); // NOI18N
        Ice1.setText("jLabel1");
        Ice1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Ice1MouseDragged(evt);
            }
        });
        Ice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ice1MouseClicked(evt);
            }
        });
        getContentPane().add(Ice1);
        Ice1.setBounds(303, 0, 101, 101);

        Fire1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Fire1.png"))); // NOI18N
        Fire1.setName("Fire1"); // NOI18N
        Fire1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Fire1MouseDragged(evt);
            }
        });
        Fire1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fire1MouseClicked(evt);
            }
        });
        getContentPane().add(Fire1);
        Fire1.setBounds(0, 0, 101, 101);

        Fire2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Fire2.png"))); // NOI18N
        Fire2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Fire2MouseDragged(evt);
            }
        });
        Fire2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fire2MouseClicked(evt);
            }
        });
        getContentPane().add(Fire2);
        Fire2.setBounds(1089, 0, 101, 101);

        Wind1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Wind1.png"))); // NOI18N
        Wind1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Wind1MouseDragged(evt);
            }
        });
        Wind1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Wind1MouseClicked(evt);
            }
        });
        getContentPane().add(Wind1);
        Wind1.setBounds(101, 0, 101, 101);

        Wind2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/wind2.png"))); // NOI18N
        Wind2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Wind2MouseDragged(evt);
            }
        });
        Wind2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Wind2MouseClicked(evt);
            }
        });
        getContentPane().add(Wind2);
        Wind2.setBounds(988, 0, 101, 101);

        Soil2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Soil2.png"))); // NOI18N
        Soil2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Soil2MouseDragged(evt);
            }
        });
        Soil2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Soil2MouseClicked(evt);
            }
        });
        getContentPane().add(Soil2);
        Soil2.setBounds(887, 0, 101, 101);

        Ice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Ice2.png"))); // NOI18N
        Ice2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Ice2MouseDragged(evt);
            }
        });
        Ice2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ice2MouseClicked(evt);
            }
        });
        getContentPane().add(Ice2);
        Ice2.setBounds(786, 0, 101, 101);

        Castle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/CastleRed.png"))); // NOI18N
        Castle1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Castle1MouseDragged(evt);
            }
        });
        Castle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Castle1MouseClicked(evt);
            }
        });
        getContentPane().add(Castle1);
        Castle1.setBounds(0, 458, 281, 202);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Start.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 10, 240, 110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Fire1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fire1MouseClicked
        f1++;
        if(f1==Number.Fire)
            Fire1.setVisible(false);
    }//GEN-LAST:event_Fire1MouseClicked

    private void Wind1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Wind1MouseClicked
        w1++;
        if(w1==Number.Wind)
            Wind1.setVisible(false);
    }//GEN-LAST:event_Wind1MouseClicked

    private void Soil1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Soil1MouseClicked
        s1++;
        if(s1==Number.Soil)
            Soil1.setVisible(false);
    }//GEN-LAST:event_Soil1MouseClicked

    private void Ice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ice1MouseClicked
        i1++;
        if(i1==Number.Ice)
            Ice1.setVisible(false);
    }//GEN-LAST:event_Ice1MouseClicked

    private void Ice2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ice2MouseClicked
        i2++;
        if(i2==Number.Ice)
            Ice2.setVisible(false);
    }//GEN-LAST:event_Ice2MouseClicked

    private void Soil2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Soil2MouseClicked
        s2++;
        if(s2==Number.Soil)
            Soil2.setVisible(false);
    }//GEN-LAST:event_Soil2MouseClicked

    private void Wind2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Wind2MouseClicked
        w2++;
        if(w2==Number.Wind)
            Wind2.setVisible(false);
    }//GEN-LAST:event_Wind2MouseClicked

    private void Fire2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fire2MouseClicked
        f2++;
        if(f2==Number.Wind)
            Fire2.setVisible(false);
    }//GEN-LAST:event_Fire2MouseClicked

    private void Castle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Castle1MouseClicked
        Castel1_X = Castle1.getX();
        Castel1_Y = Castle1.getY();
    }//GEN-LAST:event_Castle1MouseClicked

    private void Castle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Castle2MouseClicked
        Castel2_X = Castle2.getX();
        Castel2_Y = Castle2.getY();
    }//GEN-LAST:event_Castle2MouseClicked

    private void Fire1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fire1MouseDragged
        Fire1_1.get(f1).setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Fire1MouseDragged

    private void Castle1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Castle1MouseDragged
        Castle1.setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Castle1MouseDragged

    private void Castle2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Castle2MouseDragged
        Castle2.setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Castle2MouseDragged

    private void Wind1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Wind1MouseDragged
        Wind1_1.get(w1).setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Wind1MouseDragged

    private void Soil1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Soil1MouseDragged
        Soil1_1.get(s1).setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Soil1MouseDragged

    private void Ice1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ice1MouseDragged
        Ice1_1.get(i1).setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Ice1MouseDragged

    private void Ice2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ice2MouseDragged
        Ice2_2.get(i2).setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Ice2MouseDragged

    private void Soil2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Soil2MouseDragged
        Soil2_2.get(s2).setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Soil2MouseDragged

    private void Wind2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Wind2MouseDragged
        Wind2_2.get(w2).setLocation(evt.getLocationOnScreen());
    }//GEN-LAST:event_Wind2MouseDragged

    private void Fire2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fire2MouseDragged
        
        Fire2_2.get(f2).setLocation(evt.getLocationOnScreen());
        
    }//GEN-LAST:event_Fire2MouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Game g = new Game();
        g.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Arange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arange().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Castle1;
    private javax.swing.JLabel Castle2;
    private javax.swing.JLabel Fire1;
    private javax.swing.JLabel Fire2;
    private javax.swing.JLabel Ice1;
    private javax.swing.JLabel Ice2;
    private javax.swing.JLabel Soil1;
    private javax.swing.JLabel Soil2;
    private javax.swing.JLabel Wind1;
    private javax.swing.JLabel Wind2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
