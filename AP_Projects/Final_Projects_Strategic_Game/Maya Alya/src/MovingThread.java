import java.util.List;

public class MovingThread extends Thread{
    public Hero myHero;
    public List<Hero> Enemies;
    public int side;
    public FightGameMain.DrawCanvas canvas;
    public Tower EnemyTower;
    public synchronized void run()
    {
        try
        {
            int savedX;
            int savedY;
            MySystem.out.println(myHero.getClass().getName()+"("+getId()+") start moving.");
            while (myHero.health>0)
            {
                savedX = myHero.shape.x;
                myHero.setX(myHero.getX() + side* myHero.speed);
                // Repaint only the affected areas, not the entire JFrame, for efficiency
                canvas.repaint(savedX, myHero.shape.y, myHero.shape.width+2, myHero.shape.height+2); // Clear old area to background
                canvas.repaint(myHero.shape.x, myHero.shape.y, myHero.shape.width, myHero.shape.height);
                if(side == 1 ? myHero.x >= 17 : myHero.x<=1)
                {
                    while (EnemyTower.health>0) {
                        EnemyTower.health -= myHero.power;
                        MySystem.out.println((side == 1 ? "Right":"Left") + " tower atacked by " + myHero.getClass().getName()+"("+getId()+") , health = " + EnemyTower.health);
                        sleep(Math.abs(FightGameMain.random.nextInt())%1000+1);
                    }
                    for (Hero enemy:Enemies
                         ) {
                        enemy.health = 0;
                        enemy.shape.color = FightGameMain.CANVAS_BG_COLOR;
                        canvas.repaint();
                        enemy.movingThread.stop();

                    }
                    MySystem.out.println((side == 1 ? "Left":"Right") + " Wins!");
                    Enemies.get(0).movingThread.Enemies.forEach(en -> en.shape.color = FightGameMain.CANVAS_BG_COLOR);
                    canvas.repaint();
                    System.exit(0);
                    stop();

                    return;

                }
                for (Hero enemy:Enemies
                     ) {
                    if(enemy.y == myHero.y && side*(myHero.x - enemy.x)>=0)
                    {
                        while (enemy.health>0 && myHero.health>0)
                        {
                            enemy.health -= myHero.power;
                            MySystem.out.println(enemy.getClass().getName()+"("+enemy.movingThread.getId() + ") atacked by " + myHero.getClass().getName()+"("+getId()+") , health = " + enemy.health);
                            sleep(Math.abs(FightGameMain.random.nextInt())%1000+1);
                        }
                        if(enemy.health<=0){
                            enemy.power = 0;
                            enemy.shape.color = FightGameMain.CANVAS_BG_COLOR;
                            canvas.repaint();
                            enemy.movingThread.stop();
                        }
                        break;
                    }
                }
                sleep(Math.abs(FightGameMain.random.nextInt())%2000+1);
            }
            myHero.shape.color = FightGameMain.CANVAS_BG_COLOR;
            myHero.health =0;
            myHero.power=0;
            canvas.repaint();
            stop();

        }
        catch (Exception e)
        {
            MySystem.out.println(e.getMessage());
        }
    }
}
