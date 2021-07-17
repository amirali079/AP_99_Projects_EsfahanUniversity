package Main.Bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    double amount ;
    String time ;
    TransactionType type ;

    public Transaction(double amount , TransactionType type ){
        this.amount =  amount;
        this.type = type;
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.time = dtf.format(now);
    }


    public String showInfo(){
        String str =  " | Type : "+this.type.toString() + " | amount : " + this.amount + " | time : " + this.time ;
        return str ;
    }
}


