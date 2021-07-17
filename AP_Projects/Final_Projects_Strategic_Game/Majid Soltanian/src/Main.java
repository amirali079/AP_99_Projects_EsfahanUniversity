import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;

public class Main
{
    public static Pitt pitt = new Pitt();
    public static George george = new George();
    public static William william = new William();

    public static Patinga patinga = new Patinga();
    public static Ghatinga ghatinga = new Ghatinga();
    public static Witinga witinga = new Witinga();

    public static PageOfPlay newPageOfPlay = new PageOfPlay();
    public static PageOfEntering newPageOfEntering = new PageOfEntering();

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                newPageOfEntering.setVisible(true);
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        for (int i = 0 ; i < 5 ; ++i)
                        {
                            newPageOfEntering.setSize(250*i, 182*i);

                            try
                            {
                                Thread.sleep(50);
                            }
                            catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

                try
                {
                    newPageOfEntering.showTitle();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

    }
}
