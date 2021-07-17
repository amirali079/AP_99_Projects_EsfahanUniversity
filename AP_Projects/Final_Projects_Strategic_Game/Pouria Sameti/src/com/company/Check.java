package com.company;
import com.company.graphics.StartPage;
import java.io.* ;

public class Check {

    public static void main(String [] args)
    {
        readFile();
        StartPage sp = new StartPage() ;
        sp.setVisible(true);
    }


    static void readFile()
    {
        File fileAccounts = new File("src\\Accounts") ;
        File[] allAccount = fileAccounts.listFiles() ;
        for (File account : allAccount)
        {
            try {
                FileInputStream fis = new FileInputStream(account) ;
                ObjectInputStream ois = new ObjectInputStream(fis) ;
                Account a = (Account) ois.readObject() ;
                Account.getAllAccounts().add(a) ;
                ois.close();
                fis.close();
            }
            catch (Exception ie){
                ie.printStackTrace();
            }
        }
    }
}
