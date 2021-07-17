import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class gamePage extends JFrame implements ActionListener, KeyListener {

    private DrawCanvas canvas;
    private JPanel panel, KeyPanel;
    private JButton BTN1, BTN2, BTN3, BTN4, BTN5, BTN6, BTN7, up, down, right, left, score, info;
    private Game game;
    private int x_cursor, y_cursor;
    private final int canvasX = 1200, canvasY = 700;
    public ScorePage scorePage;

    public gamePage() throws IOException {

        game = new Game(this);

        canvas = new DrawCanvas();
        panel = new JPanel(new GridLayout(11, 1));
        KeyPanel = new JPanel(new BorderLayout());

        KeyPanel.setBackground(new Color(245, 195, 194));

        canvas.setPreferredSize(new Dimension(canvasX, canvasY));

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.CENTER);
        cp.add(panel, BorderLayout.EAST);

        BTN1 = new JButton("start");
        BTN2 = new JButton("Save & Exit");
        BTN3 = new JButton(new ImageIcon("Wind.jpg"));
        BTN4 = new JButton(new ImageIcon("Fire.jpg"));
        BTN5 = new JButton(new ImageIcon("Earth.jpg"));
        BTN6 = new JButton(new ImageIcon("Ice.jpg"));
        BTN7 = new JButton(new ImageIcon("Castle.jpg"));
        up = new JButton("Up");
        down = new JButton("Down");
        right = new JButton("Right");
        left = new JButton("Left");
        info = new JButton("Info");
        score = new JButton("Scores");

        addKeyListener(this);

        BTN1.addActionListener(this);
        BTN2.addActionListener(this);
        BTN3.addActionListener(this);
        BTN4.addActionListener(this);
        BTN5.addActionListener(this);
        BTN6.addActionListener(this);
        BTN7.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);
        right.addActionListener(this);
        left.addActionListener(this);
        info.addActionListener(this);
        score.addActionListener(this);

        BTN1.setFocusable(false);
        BTN2.setFocusable(false);
        BTN3.setFocusable(false);
        BTN4.setFocusable(false);
        BTN5.setFocusable(false);
        BTN6.setFocusable(false);
        BTN7.setFocusable(false);
        up.setFocusable(false);
        down.setFocusable(false);
        right.setFocusable(false);
        left.setFocusable(false);
        info.setFocusable(false);
        score.setFocusable(false);

        //BTN1.getModel().

        BTN1.setForeground(new Color(84, 134, 133));
        BTN2.setForeground(new Color(84, 134, 133));
        info.setForeground(new Color(84, 134, 133));
        score.setForeground(new Color(84, 134, 133));
        up.setForeground(new Color(84, 134, 133));
        down.setForeground(new Color(84, 134, 133));
        right.setForeground(new Color(84, 134, 133));
        left.setForeground(new Color(84, 134, 133));

        BTN1.setBackground(new Color(245, 195, 194));
        BTN2.setBackground(new Color(245, 195, 194));
        info.setBackground(new Color(245, 195, 194));
        score.setBackground(new Color(245, 195, 194));
        BTN3.setBackground(Color.WHITE);
        BTN4.setBackground(Color.WHITE);
        BTN5.setBackground(Color.WHITE);
        BTN6.setBackground(Color.WHITE);
        BTN7.setBackground(Color.WHITE);
        up.setBackground(new Color(245, 195, 194));
        down.setBackground(new Color(245, 195, 194));
        right.setBackground(new Color(245, 195, 194));
        left.setBackground(new Color(245, 195, 194));

        KeyPanel.add(up, BorderLayout.NORTH);
        KeyPanel.add(down, BorderLayout.SOUTH);
        KeyPanel.add(right, BorderLayout.EAST);
        KeyPanel.add(left, BorderLayout.WEST);

        panel.add(KeyPanel);
        panel.add(BTN1);
        panel.add(BTN2);
        panel.add(score);
        panel.add(info);
        panel.add(BTN3);
        panel.add(BTN4);
        panel.add(BTN5);
        panel.add(BTN6);
        panel.add(BTN7);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Game");
        setResizable(false);
        pack();
        setVisible(true);
        requestFocus();
    }

    public DrawCanvas getCanvas() {
        return canvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(BTN1) && !Game.status) {
            x_cursor = 5000;
            y_cursor = 5000;
            repaint();
            try {
                game.startGame();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                game.getPlayers().clear();
                game.getPlayers().clear();
                x_cursor = 0;
                y_cursor = 0;
                repaint();
            }
        } else if (e.getSource().equals(BTN2)) {
            try {
                Game.writeFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if (scorePage != null && scorePage.isDisplayable())
                scorePage.dispose();
            dispose();
            System.exit(0);
        } else if (e.getSource().equals(BTN3) && !Game.status) {  //Wind
            try {
                if (x_cursor <= 100)
                    game.addHeroTeam1(new Wind(x_cursor, y_cursor));
                if (x_cursor >= canvasX - 200)
                    game.addHeroTeam2(new Wind(x_cursor, y_cursor));
                repaint();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(BTN4) && !Game.status) {  //Fire
            try {
                if (x_cursor <= 100)
                    game.addHeroTeam1(new Fire(x_cursor, y_cursor));
                if (x_cursor >= canvasX - 200)
                    game.addHeroTeam2(new Fire(x_cursor, y_cursor));
                repaint();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(BTN5) && !Game.status) {  //Earth
            try {
                if (x_cursor <= 100)
                    game.addHeroTeam1(new Earth(x_cursor, y_cursor));
                if (x_cursor >= canvasX - 200)
                    game.addHeroTeam2(new Earth(x_cursor, y_cursor));
                repaint();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(BTN6) && !Game.status) {  //Ice
            try {
                if (x_cursor <= 100)
                    game.addHeroTeam1(new Ice(x_cursor, y_cursor));
                if (x_cursor >= canvasX - 200)
                    game.addHeroTeam2(new Ice(x_cursor, y_cursor));
                repaint();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(BTN7) && !Game.status) {  //Castle
            try {
                if (x_cursor == 0)
                    game.setTeam1Castle(new Castle(0, y_cursor));
                else if (x_cursor == canvasX - 100)
                    game.setTeam2Castle(new Castle(canvasX - 100, y_cursor));
                else throw new RuntimeException("You Cannot Add Castle Here");
                repaint();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(info)) {
            SwingUtilities.invokeLater(() -> new Info().setVisible(true));
        } else if (e.getSource().equals(score)) {
            SwingUtilities.invokeLater(() -> {
                scorePage = new ScorePage();
                scorePage.getT1LBL().setText("Team 1 : " + Game.T1Score);
                scorePage.getF1s().setText("SCORE : " + Game.FireT1);
                scorePage.getE1s().setText("SCORE : " + Game.EarthT1);
                scorePage.getI1s().setText("SCORE : " + Game.IceT1);
                scorePage.getW1s().setText("SCORE : " + Game.WindT1);
                scorePage.getT2LBL().setText("Team 2 : " + Game.T2Score);
                scorePage.getF2s().setText("SCORE : " + Game.FireT2);
                scorePage.getE2s().setText("SCORE : " + Game.EarthT2);
                scorePage.getI2s().setText("SCORE : " + Game.IceT2);
                scorePage.getW2s().setText("SCORE : " + Game.WindT2);
                scorePage.setVisible(true);
            });
        } else if (e.getSource().equals(up) && !Game.status) moveU();
        else if (e.getSource().equals(down) && !Game.status) moveD();
        else if (e.getSource().equals(right) && !Game.status) moveR();
        else if (e.getSource().equals(left) && !Game.status) moveL();
    }

    private void moveR() {
        if (x_cursor + 100 < canvasX) {
            x_cursor += 100;
            repaint();
        }
    }

    private void moveU() {
        if (y_cursor - 100 >= 0) {
            y_cursor -= 100;
            repaint();
        }
    }

    private void moveD() {
        if (y_cursor + 100 < canvasY) {
            y_cursor += 100;
            repaint();
        }
    }

    private void moveL() {
        if (x_cursor - 100 >= 0) {
            x_cursor -= 100;
            repaint();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) moveL();
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) moveR();
        else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) moveU();
        else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) moveD();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    class DrawCanvas extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //setBackground(Color.GREEN);
            g.drawImage(new ImageIcon("game.jpg").getImage(), 0, 0, null);
            g.drawImage(new ImageIcon("pointer.png").getImage(), x_cursor + 25, y_cursor + 25, 50, 50, null);
            for (Hero x : game.getHeroes())
                x.paint(g);
            if (game.getTeam1Castle() != null) game.getTeam1Castle().paint(g);
            if (game.getTeam2Castle() != null) game.getTeam2Castle().paint(g);
        }

    }

}