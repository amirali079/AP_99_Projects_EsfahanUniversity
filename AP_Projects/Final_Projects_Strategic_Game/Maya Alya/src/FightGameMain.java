import java.awt.*;       // Using AWT's Graphics and Color
import javax.swing.*;    // Using Swing's components and containers
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

import static java.lang.Thread.sleep;

public class FightGameMain extends JFrame {
    public static final int CANVAS_WIDTH = 1000;
    public static final int CANVAS_HEIGHT = 500;
    public static final Color CANVAS_BG_COLOR = new Color(10,80,20);
    public static Hero Jax = new FireHero(60,1,1100,0,0,new Color(0,0,0));
    public static Hero Bob = new FireHero(50,1,1300,0,0,new Color(200,80,10));
    public static Hero Amouranth = new IceHero(38,1,1800,0,0,new Color(100,100,230));
    public static Hero Lina = new IceHero(26,1,2100,0,0,new Color(110,30,130));
    public static Hero Fantom = new WindHero(40,2,900,0,0,new Color(180,120,150));
    public static Hero Blade = new WindHero(42,2,800,0,0,new Color(250,10,10));
    public static Hero Albert = new SandHero(52,1,1000,0,0,new Color(180,150,0));
    public static Hero Morgan = new SandHero(45,2,900,0,0,new Color(20,20,80));
    private DrawCanvas canvas;
    public static Random random = new Random();
    private List<Hero> Heroes = new ArrayList<>();
    private List<Hero> LeftSide = new ArrayList<>();
    private List<Hero> RightSide = new ArrayList<>();
    private Tower LeftTower = new Tower(0,0,50,CANVAS_HEIGHT,new Color(255,255,255));
    private Tower RightTower = new Tower(CANVAS_WIDTH-50,0,50,CANVAS_HEIGHT,new Color(255,255,255));
    public FightGameMain() {

        Heroes.add(Jax);
        Heroes.add(Blade);
        Heroes.add(Bob);
        Heroes.add(Amouranth);
        Heroes.add(Albert);
        Heroes.add(Morgan);
        Heroes.add(Fantom);
        Heroes.add(Lina);
        for (int i = 0; i < 4; i++) {
            LeftSide.add(Heroes.remove(Math.abs(random.nextInt()%Heroes.size())));
        }
        for (int i = 0; i < 4; i++) {
            RightSide.add(Heroes.remove(Math.abs(random.nextInt()%Heroes.size())));
        }

        JPanel btnPanel = new JPanel(new FlowLayout());

        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));


        for (int i = 0; i < LeftSide.size(); i++) {
            LeftSide.get(i).setX(1);
            LeftSide.get(i).setY(i);
            LeftSide.get(i).movingThread.myHero = LeftSide.get(i);
            LeftSide.get(i).movingThread.canvas = canvas;
            LeftSide.get(i).movingThread.side = 1;
            LeftSide.get(i).movingThread.Enemies = RightSide;
            LeftSide.get(i).movingThread.EnemyTower = RightTower;
        }
        for (int i = 0; i < RightSide.size(); i++) {
            RightSide.get(i).setX(16);
            RightSide.get(i).setY(i);
            RightSide.get(i).movingThread.myHero = RightSide.get(i);
            RightSide.get(i).movingThread.canvas = canvas;
            RightSide.get(i).movingThread.side = -1;
            RightSide.get(i).movingThread.Enemies = LeftSide;
            RightSide.get(i).movingThread.EnemyTower = LeftTower;
        }
        // Add both panels to this JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.CENTER);
        cp.add(btnPanel, BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Fighting Game");
        pack();            // pack all the components in the JFrame
        setVisible(true);  // show it
        requestFocus();    // "super" JFrame requests focus to receive KeyEvent
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //canvasThread.run();
                for (Hero hero:LeftSide
                ) {
                    try {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                hero.movingThread.start();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                for (Hero hero:RightSide
                ) {
                    try {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                hero.movingThread.start();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }



    // Define inner class DrawCanvas, which is a JPanel used for custom drawing
    public class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(CANVAS_BG_COLOR);
            LeftTower.shape.paint(g);
            RightTower.shape.paint(g);
            for (Hero hero:LeftSide
                 ) {
                hero.shape.paint(g);
            }
            for (Hero hero:RightSide
            ) {
                hero.shape.paint(g);
            }
            //myHero.shape.paint(g);  // the myHero.shape paints itself
        }
    }

    // The entry main() method
    public static void main(String[] args) {
        // Run GUI construction on the Event-Dispatching Thread for thread safety
        FileWriter FW = null;
        try {
            FW = new FileWriter("save.txt",true);
            FW.append("================================================================"+'\n');
            FW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FightGameMain(); // Let the constructor do the job
            }
        });
    }
}