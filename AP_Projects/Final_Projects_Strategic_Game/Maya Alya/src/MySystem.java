import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;

public class MySystem {
    public static class out
    {
        public static void println(String txt)
        {
            try {
                FileWriter FW = new FileWriter("save.txt",true);
                FW.append(txt+'\n');
                FW.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            System.out.println(txt);
        }
    }
}
