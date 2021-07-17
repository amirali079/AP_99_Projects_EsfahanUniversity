package Main.Buildings;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Exceptions.Incorrect_entry_exception;
import Exceptions.Non_profit_account_exception;
import Main.Main;
import Main.person;
import org.jetbrains.annotations.NotNull;

public class Bank implements Serializable {
    public static final Object so = new Object();
    public static boolean end = false;
    public static Main t_main ;
    static class bank_account implements Serializable,Comparable<bank_account> {
        String username;
        String password;
        double balance;
        double steady_balance;
        ArrayList<transaction> transactions = new ArrayList<>();
        person owner;
        LocalDateTime ldt;
        long last_profit_time;
        private bank_account(String username, String password, double balance, person owner) throws Incorrect_entry_exception {
            if (owner == null)
                throw new Incorrect_entry_exception("Person not found!\n_____________________________");
            this.username = username;
            this.password = password;
            this.balance = balance;
            steady_balance = balance;
            this.owner = owner;
            this.ldt = LocalDateTime.now();
            this.last_profit_time = System.currentTimeMillis();
            //transactions = (ArrayList<transaction>) Collections.synchronizedList(transactions);
        }
        double cal_profit()
        {
            double temp = steady_balance*3/20;
            balance+=temp;
            steady_balance = balance;
            last_profit_time = System.currentTimeMillis();
            synchronized (Bank.so)
            {
                transaction t = new transaction(temp,"profit",owner);
                transactions.add(t);
                Main.transactions.add(t);
                Main.n_transaction = true;
                t_main.no();

            }
            return temp;
        }

        @Override
        public int compareTo(@NotNull Bank.bank_account o) {
            if (this.last_profit_time>o.last_profit_time)
                return 1;
            else if (this.last_profit_time == o.last_profit_time)
                return 0;
            return -1;
        }
    }
    //__________________
    public String name;
    double total_money;
    ArrayList<bank_account> accounts = new ArrayList<>();
    ArrayList<ArrayList<bank_account>> updated_accounts = new ArrayList<>();
    bank_account processing_account;
    bank_account last_used_account;
    String city_name;
    public Bank(String name,String city_name) {
        this.name = name;
        this.city_name = city_name;
    }
    //THREAD______________________________
    public Thread money_maker = new Thread(() -> {
        do {
            for (bank_account ba : accounts) {
                processing_account = ba;
                try {
                    Thread.sleep(30000 - (System.currentTimeMillis() - ba.last_profit_time));
                    if (ba.steady_balance != 0 & accounts.contains(ba)) {
                        total_money += ba.cal_profit();
                    }
                    ba.last_profit_time = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException ex) {
                    if (ex.getMessage().equals("timeout value is negative")) {
                        total_money += ba.cal_profit();
                        ba.last_profit_time = System.currentTimeMillis();
                    } else
                        ex.printStackTrace();
                }
            }
            for (ArrayList<bank_account> temp:updated_accounts)
                accounts.add(accounts.indexOf(temp.get(1)), temp.get(0));
            updated_accounts.clear();
        } while (!accounts.isEmpty()&!end);
    });
    //FUNCTIONS________________________________
    public void deposit(double amount)
    {
        last_used_account.balance+=amount;
        last_used_account.transactions.add(new transaction(amount,"deposit", last_used_account.owner));
        System.out.println(amount+"$ added to your account!");
    }

    public void with_drawl(String user,String pass,double amount) throws Incorrect_entry_exception, Non_profit_account_exception
    {
        if (last_used_account.username.equals(user) & last_used_account.password.equals(pass)) {
            if (last_used_account.balance < amount)
                throw new Incorrect_entry_exception("Not enough balance for your request!\nRemaining balance : "+last_used_account.balance+"\n_____________________________");
            if (amount == last_used_account.balance) {
                last_used_account.balance -= amount;
                last_used_account.steady_balance -= amount;
                throw new Non_profit_account_exception("You have used all of your balance and This account can not profit you any more!");
            }
            last_used_account.balance -= amount;
            last_used_account.steady_balance -= amount;
            last_used_account.transactions.add(new transaction(amount, "with_drawl", last_used_account.owner));
            System.out.println("Transaction done!\n_____________________________");
        }
        else
            throw new Incorrect_entry_exception("Wrong username or password!");
    }

    public void create_account(String user,String pass,person owner,double initial_amount) throws Incorrect_entry_exception, InterruptedException {
        if (accounts.size() == 0 & money_maker.isAlive()) {
            System.out.println("Profit calculator needs to be restarted\nPlease wait (it only takes half a minute or less) ...");
            money_maker.join();
        }
        for (bank_account ba:accounts)
            if (ba.username.equals(user) & ba.password.equals(pass))
                throw new Incorrect_entry_exception("This username or password is not available!");
        if (accounts.size()>0) {
            ArrayList<bank_account>temp = new ArrayList<>();
            temp.add(new bank_account(user,pass,initial_amount,owner));
            temp.add(processing_account);
            updated_accounts.add(temp);
            // accounts.add(accounts.indexOf(processing_account),new bank_account(user,pass,initial_amount,owner));
        }
        else {
            accounts.add(new bank_account(user, pass, initial_amount, owner));
            money_maker.start();
        }
        System.out.println("Account created successfully!");
        total_money+=initial_amount;
    }

    public void start()
    {
        end = false;
        System.out.println("Restarting profit calculator!(in bank "+name+" in "+city_name+")");
        money_maker = new Thread(() -> {
            do {
                for (bank_account ba : accounts) {
                    processing_account = ba;
                    try {
                        Thread.sleep(30000 - (System.currentTimeMillis() - ba.last_profit_time));
                        if (ba.steady_balance != 0 & accounts.contains(ba)) {
                            total_money += ba.cal_profit();
                        }
                        ba.last_profit_time = System.currentTimeMillis();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException ex) {
                        if (ex.getMessage().equals("timeout value is negative")) {
                            total_money += ba.cal_profit();
                            ba.last_profit_time = System.currentTimeMillis();
                        } else
                            ex.printStackTrace();
                    }
                }
                for (ArrayList<bank_account> temp:updated_accounts)
                    accounts.add(accounts.indexOf(temp.get(1)), temp.get(0));
                updated_accounts.clear();
            } while (!accounts.isEmpty()&!end);
        });
        for (int i= accounts.size()-1;i>0;i--)
            accounts.get(i).last_profit_time = accounts.get(i).last_profit_time - accounts.get(i-1).last_profit_time;
        accounts.get(0).last_profit_time = System.currentTimeMillis();
        for (int i=1;i<accounts.size();i++)
            accounts.get(i).last_profit_time = accounts.get(i-1).last_profit_time + accounts.get(i).last_profit_time;
        money_maker.start();
    }

    public void delete_account(String user,String pass) throws Incorrect_entry_exception
    {
        bank_account temp = search_account(user,pass);
        accounts.remove(temp);
    }

    public void show_account_info()
    {
        System.out.println("Username : "+last_used_account.username+"\nPassword : "+last_used_account.password+"\nBalance : "+last_used_account.balance+"$"+"\nTransactions :");
        Main.mp.enterCity.bank_c2_2_2_info_text.setText("Username : "+last_used_account.username+"\nPassword : "+last_used_account.password+"\nBalance : "+last_used_account.balance+"$");
        for (transaction t: last_used_account.transactions)
            t.show_info();
        System.out.println("________________________________");
    }
    public void show_info()
    {
        int temp = 0;
        for (bank_account b:accounts)
            temp+=b.transactions.size();
        System.out.println("Name : "+name+"\nAccounts : "+accounts.size()+"\nTotal balance : "+total_money+"\nTransactions(lately) : "+temp+"\n________________________________");
    }
    //SEARCH FUNCTION__________________________
    public bank_account search_account(String user,String pass) throws Incorrect_entry_exception {
        for (bank_account ba:accounts)
            if (ba.username.equals(user) & ba.password.equals(pass)) {
                last_used_account = ba;
                return ba;
            }
        throw new Incorrect_entry_exception("Wrong username or password!");
    }
    //finalize function
    @Override
    protected void finalize() throws Throwable {
        accounts.clear();
        money_maker.join();
        super.finalize();
    }
}

