package Ragnargame;

public class Ragnargame {
    
    public static void main(String[] args) throws InterruptedException {
        First f = new First();
        f.setVisible(true);
        Thread.sleep(1000);
        f.setVisible(false);
        Menu m = new Menu();
        m.setVisible(true);
    }
    
}
