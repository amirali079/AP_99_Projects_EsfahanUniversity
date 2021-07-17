package Main.Buildings;

import Main.Main;
import Main.person;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class transaction implements Serializable {
    enum Transaction_type implements Serializable {
        //???????????????????????
        deposit, with_drawl, profit
    }

    LocalDateTime ldt;
    double amount;
    Transaction_type type;
    person owner;

    public transaction(double amount, String type, person owner) {
        this.amount = amount;
        this.type = Transaction_type.valueOf(type);
        this.owner = owner;
        ldt = LocalDateTime.now();
    }

    public void show_info() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Type : " + type.name() + " Amount : " + amount + "$" + " Time : " + ldt.format(dtf)+"\nOwner : "+owner.getName()+" "+owner.getFamily());
        Main.mp.listModel_fn.addElement(String.format("%-10s|%-15s|%-50s|%-35s",type.name(),amount, ldt.format(dtf),(owner.getName()+" "+owner.getFamily())));
    }
}
