import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Character
{
    boolean piratesTrue_giantsFalse;
    public ImageIcon image;

    public int health;
    public int power;
    public int speed;

    public int xCenterOfCharacter;
    public int yCenterOfCharacter;

    boolean idleMode = true;
    boolean runMode = false;
    boolean attackMode = false;
    boolean deathMode = false;

    int modeRepetitionPeriod;
    String pathForImagesOfWalk;
    String pathForImagesOfIdle;
    String pathForImagesOfRun;
    String pathForImagesOfJump;
    String pathForImagesOfAttack;
    String pathForImagesOfDeath;

    int amountOfIncreaseXInEachStepForWalk;
    int xInitialLocationForWalk;
    int yLocationForWalk;

    int numberOfTimesAhead = 0;
    boolean ahead = true;

    boolean attackOnPatinga;
    boolean attackOnGhatinga;
    boolean attackOnWitinga;

    static boolean start;

    public Character(int health, int power, int speed, String pathForImagesOfWalk, String pathForImagesOfIdle, String pathForImagesOfRun, String pathForImagesOfJump, String pathForImagesOfAttack, String pathForImagesOfDeath, int amountOfIncreaseXInEachStepForWalk, int xInitialLocationForWalk, int yLocationForWalk, boolean piratesTrue_giantsFalse, int modeRepetitionPeriod)
    {
        this.health = health;
        this.power = power;
        this.speed = speed;

        this.pathForImagesOfWalk = pathForImagesOfWalk;
        this.pathForImagesOfIdle = pathForImagesOfIdle;
        this.pathForImagesOfRun = pathForImagesOfRun;
        this.pathForImagesOfJump = pathForImagesOfJump;
        this.pathForImagesOfAttack = pathForImagesOfAttack;
        this.pathForImagesOfDeath = pathForImagesOfDeath;

        this.amountOfIncreaseXInEachStepForWalk = amountOfIncreaseXInEachStepForWalk;
        this.xInitialLocationForWalk = xInitialLocationForWalk;
        this.yLocationForWalk = yLocationForWalk;

        this.piratesTrue_giantsFalse = piratesTrue_giantsFalse;
        this.modeRepetitionPeriod = modeRepetitionPeriod;
    }

    void walk(JLabel labelOfCharacter) throws InterruptedException
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                labelOfCharacter.setVisible(true);

                for (int i = 0 ; i < 5 ; ++i)
                {
                    labelOfCharacter.setLocation(((amountOfIncreaseXInEachStepForWalk * i) + xInitialLocationForWalk), yLocationForWalk);

                    labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfWalk + (i) + ".png"));

                    try
                    {
                        Thread.sleep(400);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

                labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfWalk + (modeRepetitionPeriod-1) + ".png"));

                try
                {
                    idle(labelOfCharacter);
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    void idle(JLabel labelOfCharacter) throws InterruptedException
    {
        int idleModeCounter = 0 ;

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    if (start)
                    {
                        checkThePositionForTheAttack();
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();

        while (idleMode)
        {

            labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfIdle + (idleModeCounter) + ".png"));

            idleModeCounter++;

            if (idleModeCounter == modeRepetitionPeriod)
            {
                idleModeCounter = 0;
            }

            Thread.sleep(300);
        }
    }

    void run(JLabel labelOfCharacter, double xDestination, double yDestination) throws InterruptedException
    {
        start = true;

        int xOfCharacter = labelOfCharacter.getX();
        int yOfCharacter = labelOfCharacter.getY();

        int locationCounter = 0;
        int runModeCounter = 0;

        boolean run = false;
        if (((piratesTrue_giantsFalse) && (xDestination > xOfCharacter)) || ((!piratesTrue_giantsFalse) && (xDestination < xOfCharacter)))
        {
            run = true;
        }

        if (run)
        {
            this.idleMode = false;

            double slopeOfMovingLine = (yOfCharacter - yDestination) / (xOfCharacter - xDestination);

            double widthOfMovementInEachStep = Math.sqrt(((Math.pow(speed, 2))/(Math.pow(slopeOfMovingLine, 2) + 1)));

            if (!piratesTrue_giantsFalse)
            {
                widthOfMovementInEachStep *= -1;
            }

            double heightOfMovementInEachStep = widthOfMovementInEachStep * slopeOfMovingLine;

            double lengthOfLineOfMoving = Math.sqrt(Math.pow((yOfCharacter - yDestination), 2) + Math.pow((xOfCharacter - xDestination), 2));

            int numberOfMoves = (int) (lengthOfLineOfMoving/speed);

            int xErrorValue = 0;
            int yErrorValue = 0;

            if (piratesTrue_giantsFalse)
            {
                if (slopeOfMovingLine > 0)
                {
                    numberOfMoves -= 4;

                    xErrorValue = 40;
                }
                else
                {
                    numberOfMoves -= 3;

                    yErrorValue = -labelOfCharacter.getHeight();

                    for (int i = 0 ; i < modeRepetitionPeriod ; ++i)
                    {
                        labelOfCharacter.setLocation(labelOfCharacter.getX(), labelOfCharacter.getY()-(i*10));

                        labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfJump + (i) + ".png"));

                        try
                        {
                            Thread.sleep(50);
                        }
                        catch (InterruptedException interruptedException)
                        {
                            interruptedException.printStackTrace();
                        }
                    }
                }
            }
            else
            {
                if (slopeOfMovingLine < 0)
                {
                    xErrorValue = -200;
                    yErrorValue = -10;
                }
                else
                {
                    xErrorValue = -70;

                    numberOfMoves += 4;
                }
            }

            while (locationCounter != numberOfMoves)
            {
                int x = (int) ((widthOfMovementInEachStep*locationCounter)+xOfCharacter+xErrorValue);
                int y = (int) ((heightOfMovementInEachStep*locationCounter)+yOfCharacter+yErrorValue);

                double xCharacterImageCenter = x + (labelOfCharacter.getWidth()/2);
                double yCharacterImageCenter = y + (labelOfCharacter.getHeight()/2);

                boolean stop = checkTheRangeOfMoving(labelOfCharacter, xCharacterImageCenter, yCharacterImageCenter);

                if (piratesTrue_giantsFalse)
                {
                    if(slopeOfMovingLine > 0)
                    {
                        if ((y < 850-labelOfCharacter.getHeight()) && (x < 1800-labelOfCharacter.getWidth()) && (stop))
                        {
                            labelOfCharacter.setLocation(x, y);
                            locationCounter++;
                        }
                        else
                        {
                            locationCounter = numberOfMoves;
                            runModeCounter = modeRepetitionPeriod - 1;
                        }
                    }
                    else
                    {
                        if ((y > 0) && (x < 1800-labelOfCharacter.getWidth()) && (stop))
                        {
                            labelOfCharacter.setLocation(x, y);
                            locationCounter++;
                        }
                        else
                        {
                            locationCounter = numberOfMoves;
                            runModeCounter = modeRepetitionPeriod - 1;
                        }
                    }
                }
                else
                {
                    if(slopeOfMovingLine > 0)
                    {
                        if ((y > 0) && (x > 0))
                        {
                            labelOfCharacter.setLocation(x, y);
                            locationCounter++;
                        }
                        else
                        {
                            locationCounter = numberOfMoves;
                            runModeCounter = modeRepetitionPeriod - 1;
                        }
                    }
                    else
                    {
                        if ((y < 850-labelOfCharacter.getHeight()) && (x > 0))
                        {
                            labelOfCharacter.setLocation(x, y);
                            locationCounter++;
                        }
                        else
                        {
                            locationCounter = numberOfMoves;
                            runModeCounter = modeRepetitionPeriod - 1;
                        }
                    }
                }


                //JLabel label = new JLabel("o");
                //Main.newPageOfPlay.backgroundPanel.add(label);
                //label.setBounds(new Rectangle(new Point(x, y ),label.getPreferredSize()));


                labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfRun + (runModeCounter) + ".png"));
                runModeCounter++;
                if (runModeCounter == modeRepetitionPeriod)
                {
                    runModeCounter = 0;
                }

                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException interruptedException)
                {
                    interruptedException.printStackTrace();
                }

                int xCharacterImageCenterForGrad = labelOfCharacter.getX() + (labelOfCharacter.getWidth()/2);
                if (xOfCharacter != labelOfCharacter.getX())
                {
                    if((xCharacterImageCenterForGrad > 650) && (xCharacterImageCenterForGrad < 900) && (piratesTrue_giantsFalse) && (numberOfTimesAhead == 0))
                    {
                        health -= (health/16);

                        numberOfTimesAhead++;
                    }
                    else if ((xCharacterImageCenterForGrad > 900) && (xCharacterImageCenterForGrad < 1150) && (piratesTrue_giantsFalse) && (numberOfTimesAhead == 1))
                    {
                        health -= (health/8);

                        numberOfTimesAhead++;
                    }
                    else if ((xCharacterImageCenterForGrad > 1150) && (piratesTrue_giantsFalse) && (numberOfTimesAhead == 2))
                    {
                        health -= (health/4);

                        numberOfTimesAhead++;
                    }
                    else if ((labelOfCharacter.getX() > 900) && (xCharacterImageCenterForGrad < 1150) && (!piratesTrue_giantsFalse) && (numberOfTimesAhead == 0))
                    {
                        health -= (health/16);

                        numberOfTimesAhead++;
                    }
                    else if ((xCharacterImageCenterForGrad > 650) && (xCharacterImageCenterForGrad < 900) && (!piratesTrue_giantsFalse) && (numberOfTimesAhead == 1))
                    {
                        health -= (health/8);

                        numberOfTimesAhead++;
                    }
                    else if ((xCharacterImageCenterForGrad < 650) && (!piratesTrue_giantsFalse) && (numberOfTimesAhead == 2))
                    {
                        health -= (health/4);

                        numberOfTimesAhead++;
                    }
                }

                if (health <= 0)
                {
                    health = 0;

                    death(labelOfCharacter);
                }
            }

            Main.newPageOfPlay.setValueOfLabels();

            this.runMode = false;

            labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfWalk + (modeRepetitionPeriod-1) + ".png"));

            this.idleMode = true;

            this.idle(labelOfCharacter);
        }
    }

    boolean checkTheRangeOfMoving(JLabel labelOfCharacter, double xCharacterImageCenter, double yCharacterImageCenter) throws InterruptedException
    {
        ArrayList<JLabel> characters = new ArrayList<>(Arrays.asList(Main.newPageOfPlay.pitt, Main.newPageOfPlay.george, Main.newPageOfPlay.william, Main.newPageOfPlay.patinga, Main.newPageOfPlay.ghatinga, Main.newPageOfPlay.witinga));

        characters.remove(labelOfCharacter);

        boolean stop = true;

        for (int k = 0 ; k < characters.size() ; ++k)
        {
            double xOtherCharacterImageCenter = characters.get(k).getX() + (characters.get(k).getWidth()/2);
            double yOtherCharacterImageCenter = characters.get(k).getY() + (characters.get(k).getHeight()/2);

            if (Math.sqrt(Math.pow((xOtherCharacterImageCenter - xCharacterImageCenter), 2) + Math.pow((yOtherCharacterImageCenter - yCharacterImageCenter), 2)) < 210)
            {
                if ((((piratesTrue_giantsFalse) && (xOtherCharacterImageCenter > xCharacterImageCenter)) || ((!piratesTrue_giantsFalse) && (xOtherCharacterImageCenter < xCharacterImageCenter))) && (!attackMode))
                {
                    stop = false;
                }

                if (characters.equals(Main.newPageOfPlay.patinga))
                {
                    attackOnPatinga = true;
                }

                if (characters.equals(Main.newPageOfPlay.ghatinga))
                {
                    attackOnGhatinga = true;
                }

                if (characters.equals(Main.newPageOfPlay.witinga))
                {
                    attackOnWitinga = true;
                }
            }
        }

        return stop;
    }

    void checkThePositionForTheAttack() throws InterruptedException
    {
        if ((Main.newPageOfPlay.pitt.getX() < 650)  && (Main.newPageOfPlay.george.getX() < 650) && (Main.newPageOfPlay.william.getX() < 650) && (!Main.patinga.deathMode) && (!Main.ghatinga.deathMode))
        {
            Main.patinga.run(Main.newPageOfPlay.patinga, (1479), (Main.newPageOfPlay.patinga.getY()));
            Main.ghatinga.run(Main.newPageOfPlay.ghatinga, (1479), (Main.newPageOfPlay.ghatinga.getY()));
        }

        if ((Main.newPageOfPlay.pitt.getX() > 650) && (Main.patinga.ahead) && (!Main.patinga.deathMode))
        {
            Main.patinga.run(Main.newPageOfPlay.patinga, (Main.newPageOfPlay.pitt.getX() + Main.newPageOfPlay.pitt.getWidth()), (Main.newPageOfPlay.pitt.getY() + (Main.newPageOfPlay.pitt.getHeight()/3)));

            Main.patinga.jump(Main.newPageOfPlay.patinga);

            Main.patinga.attack(Main.newPageOfPlay.patinga);


            Main.pitt.health -= Main.patinga.power;
            if (Main.pitt.health <= 0)
            {
                Main.pitt.health = 0;

                Main.pitt.death(Main.newPageOfPlay.pitt);
            }


            Main.patinga.ahead = false;

            Main.patinga.run(Main.newPageOfPlay.patinga, (Main.newPageOfPlay.patinga.getX() - 100), (Main.newPageOfPlay.patinga.getY() + 100));
        }

        if ((Main.newPageOfPlay.george.getX() > 650)  && (Main.ghatinga.ahead) && (!Main.ghatinga.deathMode))
        {
            Main.ghatinga.run(Main.newPageOfPlay.ghatinga, (Main.newPageOfPlay.george.getX() + Main.newPageOfPlay.george.getWidth()), (Main.newPageOfPlay.george.getY() + (Main.newPageOfPlay.george.getHeight()/3)));

            Main.ghatinga.jump(Main.newPageOfPlay.ghatinga);

            Main.ghatinga.attack(Main.newPageOfPlay.ghatinga);


            Main.george.health -= Main.ghatinga.power;
            if (Main.george.health <= 0)
            {
                Main.george.health = 0;

                Main.george.death(Main.newPageOfPlay.george);
            }


            Main.ghatinga.ahead = false;

            Main.ghatinga.run(Main.newPageOfPlay.ghatinga, (Main.newPageOfPlay.ghatinga.getX() - 100), (Main.newPageOfPlay.ghatinga.getY() + 100));
        }

        if ((Main.newPageOfPlay.william.getX() > 650)  && (Main.witinga.ahead) && (!Main.witinga.deathMode))
        {
            Main.witinga.run(Main.newPageOfPlay.witinga, (Main.newPageOfPlay.william.getX() + Main.newPageOfPlay.william.getWidth()), (Main.newPageOfPlay.william.getY() + (Main.newPageOfPlay.william.getHeight()/3)));

            Main.witinga.jump(Main.newPageOfPlay.witinga);

            Main.witinga.attack(Main.newPageOfPlay.witinga);


            Main.william.health -= Main.witinga.power;
            if (Main.william.health <= 0)
            {
                Main.william.health = 0;

                Main.william.death(Main.newPageOfPlay.william);
            }


            Main.witinga.ahead = false;

            Main.witinga.run(Main.newPageOfPlay.witinga, (Main.newPageOfPlay.witinga.getX() - 100), (Main.newPageOfPlay.witinga.getY() + 100));
        }

    }

    void jump(JLabel labelOfCharacter) throws InterruptedException
    {
        for (int i = 0 ; i < modeRepetitionPeriod ; ++i)
        {
            labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfJump + (i) + ".png"));

            if (piratesTrue_giantsFalse)
            {
                labelOfCharacter.setLocation(((2 * i) + labelOfCharacter.getX()), ((-3 * i) + labelOfCharacter.getY()));
            }
            else
            {
                labelOfCharacter.setLocation(((-2 * i) + labelOfCharacter.getX()), ((-3 * i) + labelOfCharacter.getY()));
            }

            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException interruptedException)
            {
                interruptedException.printStackTrace();
            }
        }
    }

    void attack(JLabel labelOfCharacter) throws InterruptedException
    {
        for (int i = 0 ; i < modeRepetitionPeriod ; ++i)
        {
            labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfAttack + (i) + ".png"));

            if (piratesTrue_giantsFalse)
            {
                labelOfCharacter.setLocation(((1 * 1) + labelOfCharacter.getX()), ((1 * i) + labelOfCharacter.getY() + 1));
            }
            else
            {
                labelOfCharacter.setLocation(((-1 * i) + labelOfCharacter.getX()), ((-1 * i) + labelOfCharacter.getY() + 1));
            }

            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException interruptedException)
            {
                interruptedException.printStackTrace();
            }
        }

        attackMode = false;
    }

    void death(JLabel labelOfCharacter) throws InterruptedException
    {
        idleMode = false;
        runMode = false;
        deathMode = true;

        for (int i = 0 ; i < modeRepetitionPeriod ; ++i)
        {
            labelOfCharacter.setIcon(new ImageIcon(pathForImagesOfDeath + (i) + ".png"));

            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException interruptedException)
            {
                interruptedException.printStackTrace();
            }
        }
    }

}

class Pitt extends Character
{
    public Pitt()
    {
        super(50, 10, 50,
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_WALK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_IDLE_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_RUN_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_JUMP_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_ATTACK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_DIE_00",
                71, -284, 0, true, 7);
    }


    public void walk() throws InterruptedException
    {
        super.walk(Main.newPageOfPlay.pitt);
    }

    public void idle() throws InterruptedException
    {
        super.idle(Main.newPageOfPlay.pitt);
    }

    void run() throws InterruptedException
    {
        super.run(Main.newPageOfPlay.pitt, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
    }

}

class George extends Character
{
    public George()
    {
        super(40, 20, 40,
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\PNG\\3_3-PIRATE_WALK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\PNG\\3_3-PIRATE_IDLE_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\PNG\\3_3-PIRATE_RUN_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\PNG\\3_3-PIRATE_JUMP_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\PNG\\3_3-PIRATE_ATTACK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\PNG\\3_3-PIRATE_DIE_00",
                66, -264, 240, true, 7);
    }


    public void walk() throws InterruptedException
    {
        super.walk(Main.newPageOfPlay.george);
    }

    public void idle() throws InterruptedException
    {
        super.idle(Main.newPageOfPlay.george);
    }

    public void run() throws InterruptedException
    {
        super.run(Main.newPageOfPlay.george, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
    }
}

class William extends Character
{
    public William()
    {
        super(30, 30, 30,
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\PNG\\1_entity_000_WALK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\PNG\\1_entity_000_IDLE_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\PNG\\1_entity_000_RUN_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\PNG\\1_entity_000_JUMP_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\PNG\\1_entity_000_ATTACK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\PNG\\1_entity_000_DIE_00",
                77, -310, 490, true, 7);
    }


    public void walk() throws InterruptedException
    {
        super.walk(Main.newPageOfPlay.william);
    }

    public void idle() throws InterruptedException
    {
        super.idle(Main.newPageOfPlay.william);
    }

    public void run() throws InterruptedException
    {
        super.run(Main.newPageOfPlay.william, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
    }
}

class Patinga extends Character
{
    public Patinga()
    {
        super(50, 10, 50,
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\PNG\\Troll_02_1_WALK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\PNG\\Troll_02_1_IDLE_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\PNG\\Troll_02_1_RUN_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\PNG\\Troll_02_1_JUMP_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\PNG\\Troll_02_1_ATTACK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\PNG\\Troll_02_1_DIE_00",
                -80, 1800, 40, false, 10);
    }


    public void walk() throws InterruptedException
    {
        super.walk(Main.newPageOfPlay.patinga);
    }

    public void idle() throws InterruptedException
    {
        super.idle(Main.newPageOfPlay.patinga);
    }

    public void run(double xDestination, double yDestination) throws InterruptedException
    {
        super.run(Main.newPageOfPlay.patinga, xDestination, yDestination);
    }

}

class Ghatinga extends Character
{
    public Ghatinga()
    {
        super(40, 20, 40,
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\PNG\\Troll_01_1_WALK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\PNG\\Troll_01_1_IDLE_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\PNG\\Troll_01_1_RUN_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\PNG\\Troll_01_1_JUMP_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\PNG\\Troll_01_1_ATTACK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\PNG\\Troll_01_1_DIE_00",
                -80, 1800, 290, false, 10);
    }


    public void walk() throws InterruptedException
    {
        super.walk(Main.newPageOfPlay.ghatinga);
    }

    public void idle() throws InterruptedException
    {
        super.idle(Main.newPageOfPlay.ghatinga);
    }
}

class Witinga extends Character
{
    public Witinga()
    {
        super(30, 30, 30,
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\PNG\\Troll_03_1_WALK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\PNG\\Troll_03_1_IDLE_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\PNG\\Troll_03_1_RUN_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\PNG\\Troll_03_1_JUMP_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\PNG\\Troll_03_1_ATTACK_00",
                "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\PNG\\Troll_03_1_DIE_00",
                -80, 1800, 546, false, 10);
    }


    public void walk() throws InterruptedException
    {
        super.walk(Main.newPageOfPlay.witinga);
    }

    public void idle() throws InterruptedException
    {
        super.idle(Main.newPageOfPlay.witinga);
    }
}