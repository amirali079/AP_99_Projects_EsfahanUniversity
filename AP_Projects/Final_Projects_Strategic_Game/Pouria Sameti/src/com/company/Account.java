package com.company;
import java.io.*;
import java.util.ArrayList;
import com.company.castle.GamerCastle;
import com.company.graphics.AccountPage;

import javax.swing.*;

public class Account implements Serializable
{
    private static ArrayList<Account> allAccounts = new ArrayList<>() ;
    private String username ;
    private String password ;
    private ArrayList<GamerCastle> allGames = new ArrayList<>() ;
    private int score ;
    private int lose ;
    private String path ;
    public static Account currentAccount ;
    private transient AccountPage accountPage ;

    public Account(String username, String password)
    {
        currentAccount = this ;
        this.username = username ;
        this.password = password ;
        allAccounts.add(this) ;
        this.path = "src\\Accounts\\Account " + allAccounts.size() + ".txt" ;
        writeAccount();
    }

    public void addGame()
    {
        currentAccount.allGames.add(GamerCastle.currentGamerCastle) ;
        writeAccount();
    }

    public static Account getAccount(String username, String password)
    {
        Account returnValue = null ;
        for (Account account : allAccounts)
            if (account.getUsername().equals(username) && account.getPassword().equals(password))
                returnValue = account ;
        return returnValue ;
    }

    public void calculateScore()
    {
        int counter = 0 ;
        for (GamerCastle GC : allGames)
            if (GC.isWin())
                ++counter ;
        setScore(counter);
        writeAccount();
    }

    public void calculateLose()
    {
        int counter = 0 ;
        for (GamerCastle GC : allGames)
            if (!GC.isWin())
                ++counter ;
        setLose(counter);
        writeAccount();
    }


    public void writeAccount()
    {
        try {
            FileOutputStream fos = new FileOutputStream(path) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(this);
            oos.flush();
            oos.close();
            fos.close();
        }
        catch (IOException ie){
            ie.printStackTrace();
        }
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setScore(int score) { this.score = score; }
    public int getScore() { return score; }

    public void setLose(int lose) { this.lose = lose; }
    public int getLose() { return lose; }

    public String getPath() { return path; }

    public ArrayList<GamerCastle> getAllGames() { return allGames; }

    public static ArrayList<Account> getAllAccounts(){return allAccounts ;}


    //graphical method
    public void createAccountPanel()
    {
        accountPage = new AccountPage() ;
        accountPage.setVisible(true);
    }

    public void updateAccountPanel()
    {
        calculateScore();
        calculateLose();
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                accountPage.gamesLBL.setText(String.valueOf(getAllGames().size()));
                accountPage.winsLBL.setText(String.valueOf(getScore()));
                accountPage.lossesLBL.setText(String.valueOf(getLose()));
                return null ;
            }
        }.execute();
    }
}
