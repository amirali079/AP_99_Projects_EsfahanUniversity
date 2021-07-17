import javax.swing.*;

public class Soil extends Hero implements Runnable {
    public boolean exit = false;
    Thread t;

    public Soil(int x, int y, boolean a, Icon i, int v) {
        super(50, 2, 5, x, y, a, i, v);
        exit = false;
    }

    public void run2() {
        exit = false;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (!exit) {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (team == 1) {
                mainFrame.move1(this, mainFrame.c1.getX(), mainFrame.c1.getY());
                this.jb.setBounds(this.getX(), this.getY(), this.jb.getPreferredSize().width, this.jb.getPreferredSize().height);
                try {
                    mainFrame.checkWar2(this);
                    game.sb.jb.setValue(0);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (mainFrame.checkSyahchale(this)) {
                    this.jb.setVisible(false);
                    JOptionPane.showMessageDialog(mainFrame.c1.jb, "soil1 was removed from the game", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                    this.stop();
                }
                try {
                    mainFrame.checkCastle1(mainFrame.hs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (team == 2) {
                mainFrame.move2(this, mainFrame.c2.getX(), mainFrame.c2.getY());
                this.jb.setBounds(this.getX(), this.getY(), this.jb.getPreferredSize().width, this.jb.getPreferredSize().height);
                try {
                    mainFrame.checkWar1(this);
                    game.sb.jb.setValue(0);
                    Thread.sleep(1990);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (mainFrame.checkSyahchale(this)) {
                    this.jb.setVisible(false);
                    JOptionPane.showMessageDialog(mainFrame.c1.jb, "soil2 was removed from the game", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                    this.stop();
                }
                try {
                    mainFrame.checkCastle2(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stop() {
        exit = true;
    }

}
