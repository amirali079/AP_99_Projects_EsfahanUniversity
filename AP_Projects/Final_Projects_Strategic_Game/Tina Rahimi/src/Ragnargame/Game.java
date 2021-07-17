package Ragnargame;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author KPS
 */
public class Game extends javax.swing.JFrame {

    Container pane;
    Castle castle1;
    Castle castle2;
    ArrayList<Hero> heroes = new ArrayList<>();

    public Game() {
        initComponents();
        this.setSize(1210, 710);
        this.setResizable(false);
        this.pane = this.getContentPane();
        initGame();
    }

    Game(Castle castle1, Castle castle2, ArrayList<Hero> heroes) {
        initComponents();
        this.setSize(1210, 710);
        this.setResizable(false);
        this.castle1 = castle1;
        this.castle2 = castle2;
        this.heroes.addAll(heroes);
        //System.out.println(this.heroes.size());
        /*
        System.out.println(this.heroes.get(0).Health);
        System.out.println(this.heroes.get(1).Health);
        System.out.println(this.heroes.get(2).Health);
        */
        this.pane = this.getContentPane();
        HistoryGame();
    }
    public void HistoryGame(){
        
        castle1.setImg(new ImageIcon("src/Ragnargame2/CastleRed.png"));
        
        castle2.setImg(new ImageIcon("src/Ragnargame2/Castleblue2.png"));
        JPanel panel = new JPanel() {
            
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.gray);

                castle1.paint(g);
                castle2.paint(g);
                this.add(jLabel1);
                this.add(jLabel3);
                this.add(jLabel4);
                this.add(jLabel5);
                this.add(jLabel6);
                this.add(jLabel8);
                this.add(jLabel9);
                this.add(jLabel10);
                jLabel10.setLocation(460, 270);
                jLabel3.setText(Name.Team1);
                jLabel4.setText(Name.Team2);
                jLabel5.setText(String.valueOf(castle1.Health));
                jLabel6.setText(String.valueOf(castle2.Health));
                jLabel1.setLocation(1050, 0);
                jLabel3.setLocation(310, 10);
                jLabel4.setLocation(660, 10);
                jLabel5.setLocation(420, 13);
                jLabel6.setLocation(770, 13);
                jLabel8.setLocation(280, 0);
                jLabel9.setLocation(0 , 0);
                for (Hero hero : heroes) {
                    hero.paint(g);
                }
            }
        };
        jLabel1.setLocation(0, 1089);
        panel.setBackground(Color.GRAY);
        
        panel.setPreferredSize(new Dimension(pane.getWidth(), pane.getHeight()));
//        pane.add(panel);

        this.setContentPane(panel);

        startGame();
    }

    public ArrayList<Hero> getHeroes(String team) {
        ArrayList<Hero> heroList = new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.getTeam().equals(team)) {
                heroList.add(hero);
            }
        }
        return heroList;
    }

    private void initGame() {
        for(int i=0; i<Number.Fire; i++){
            heroes.add(new Fire(Name.Team1, Arange.Fire1_1.get(i).getX(), Arange.Fire1_1.get(i).getY()));
            heroes.add(new Fire(Name.Team2, Arange.Fire2_2.get(i).getX(), Arange.Fire2_2.get(i).getY()));
        }
        
        for(int i=0; i<Number.Ice; i++){
            heroes.add(new Ice(Name.Team1, Arange.Ice1_1.get(i).getX(), Arange.Ice1_1.get(i).getY()));
            heroes.add(new Ice(Name.Team2, Arange.Ice2_2.get(i).getX(), Arange.Ice2_2.get(i).getY()));
        }
        
        for(int i=0; i<Number.Soil; i++){
            heroes.add(new Soil(Name.Team1, Arange.Soil1_1.get(i).getX(), Arange.Soil1_1.get(i).getY()));
            heroes.add(new Soil(Name.Team2, Arange.Soil2_2.get(i).getX(), Arange.Soil2_2.get(i).getY()));
        }
        
        for(int i=0; i<Number.Wind; i++){
            heroes.add(new Wind(Name.Team1, Arange.Wind1_1.get(i).getX(), Arange.Wind1_1.get(i).getY()));
            heroes.add(new Wind(Name.Team2, Arange.Wind2_2.get(i).getX(), Arange.Wind2_2.get(i).getY()));
        }

        castle1 = new Castle(Arange.Castel1_X, Arange.Castel1_Y);
        castle1.setImg(new ImageIcon("src/Ragnargame2/CastleRed.png"));
        castle2 = new Castle(Arange.Castel2_X, Arange.Castel2_Y);
        castle2.setImg(new ImageIcon("src/Ragnargame2/Castleblue2.png"));

        JPanel panel = new JPanel() {
            
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.gray);

                castle1.paint(g);
                castle2.paint(g);
                this.add(jLabel1);
                this.add(jLabel3);
                this.add(jLabel4);
                this.add(jLabel5);
                this.add(jLabel6);
                this.add(jLabel8);
                this.add(jLabel9);
                this.add(jLabel10);
                jLabel10.setLocation(460, 270);
                jLabel3.setText(Name.Team1);
                jLabel4.setText(Name.Team2);
                jLabel5.setText(String.valueOf(castle1.Health));
                jLabel6.setText(String.valueOf(castle2.Health));
                jLabel1.setLocation(1050, 0);
                jLabel3.setLocation(310, 10);
                jLabel4.setLocation(660, 10);
                jLabel5.setLocation(420, 13);
                jLabel6.setLocation(800, 13);
                jLabel8.setLocation(280, 0);
                jLabel9.setLocation(0 , 0);
                
                for (Hero hero : heroes) {
                    hero.paint(g);
                }
                
                
            }
        };
        jLabel1.setLocation(0, 1089);
        panel.setBackground(Color.GRAY);
        
        panel.setPreferredSize(new Dimension(pane.getWidth(), pane.getHeight()));
//        pane.add(panel);

        this.setContentPane(panel);

        startGame();


    }

    private void startGame() {

        for (Hero hero : heroes) {

            new Thread(() -> {

                ArrayList<Hero> enemies;
                Castle targetCastle;

                if (hero.getTeam().equals(Name.Team1)) {
                    targetCastle = castle2;
                    enemies = getHeroes(Name.Team2);
                } else {
                    targetCastle = castle1;
                    enemies = getHeroes(Name.Team1);
                }

                while (!isGameOver()) {

                    if (hero.catches(targetCastle.getX(), targetCastle.getY())) {

                        System.out.println("attack castle");

                        while (!isGameOver()) {
                            hero.attack(targetCastle);
                            //System.out.println(targetCastle.getHealth());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        break;
                    }


                    for (Hero hero2 : enemies) {

                        if (hero.isEnemy(hero2) && hero.catches(hero2.getX(), hero2.getY())) {

                            //System.out.println("attack player");


                            while (hero.getHealth() > 0 && hero2.getHealth() > 0 && !isGameOver()) {

                                hero.attack(hero2);

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (hero.getHealth() <= 0) {
                                heroes.remove(hero);
                                enemies.remove(hero);
                                repaint();
                                break;
                            }

                        }

                        if (isGameOver()) {
                            break;
                        }
                    }

                    if (!isGameOver()) {
                        hero.moveTo(targetCastle.getX(), targetCastle.getY());
                        repaint();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

    }

    private boolean isGameOver() {
        if(castle1.getHealth() <= 0){
            jLabel10.setText(Name.Team2 +" is Win!");
            
        }
        if(castle2.getHealth() <= 0){
            jLabel10.setText(Name.Team1 +" is Win!");
        } 
        return castle1.getHealth() <= 0 || castle2.getHealth() <= 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1300, 700));
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Save2.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1110, 0, 120, 60);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Team1:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(310, 10, 120, 40);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Team2:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(660, 10, 110, 40);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 10, 90, 40);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(770, 10, 90, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/navar3.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 0, 620, 71);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ragnargame2/Newgame.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 120, 60);

        jLabel10.setFont(new java.awt.Font("Adobe Garamond Pro", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(460, 270, 270, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Name n = new Name();
        n.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            saveGame();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked
    private void saveGame() throws IOException {

        FileWriter fw = new FileWriter("lastGame.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        int team1_score = 0;
        for(Hero hero : heroes){
            if(hero.getTeam().equals(Name.Team1))
                team1_score+=hero.getScore();
        }
        bw.write(String.format("T1 %s %d\n", Name.Team1, team1_score));

        int team2_score = 0;
        for(Hero hero : heroes){
            if(hero.getTeam().equals(Name.Team2));
                team2_score+=hero.getScore();
        }
        bw.write(String.format("T2 %s %d\n", Name.Team2, team2_score));

        bw.write(String.format("C1 %d %d %d\n", castle1.getX(), castle1.getY(), castle1.getHealth()));
        bw.write(String.format("C2 %d %d %d\n", castle2.getX(), castle2.getY(), castle2.getHealth()));


        for (Hero hero : heroes) {
            bw.write(String.format("%s %s %d %d %d %d\n", hero.getClass().getSimpleName(), hero.getTeam(), hero.getX(), hero.getY(), hero.getHealth(), hero.getScore()));
        }

        bw.close();
        fw.close();
    }
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
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
