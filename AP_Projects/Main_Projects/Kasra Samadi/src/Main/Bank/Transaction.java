package Main.Bank;
import java.io.Serializable;

public class Transaction implements Serializable {
    private double TransactionAmount;//مبلغ تراکنش
    private String TransactionTime;//زمان انجام تراکنش
    TypeOfTransaction typeOfTransaction;

    public Transaction(double transactionAmount, String transactionTime, TypeOfTransaction typeOfTransaction) {
        TransactionAmount = transactionAmount;
        TransactionTime = transactionTime;
        this.typeOfTransaction = typeOfTransaction;
    }

    public double getTransactionAmount() {
        return TransactionAmount;
    }

    public String getTransactionTime() {
        return TransactionTime;
    }

    public TypeOfTransaction getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTransactionAmount(double transactionAmount) {
        TransactionAmount = transactionAmount;
    }

    public void setTransactionTime(String transactionTime) {
        TransactionTime = transactionTime;
    }

    public void setTypeOfTransaction(TypeOfTransaction typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    @Override
    public String toString() {
        return String.format("Transaction Amount = %s | TransactionTime = %s | Type Of Transaction = %s", TransactionAmount,TransactionTime,typeOfTransaction);
    }
}

