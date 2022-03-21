package ro.fasttrackit.curs22.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private TransactionType type;
    private double amount;

    protected Transaction() {
    }

    public Transaction(String description, double amount) {
        this(description, TransactionType.BUY, amount);
    }

    public Transaction(String description, TransactionType type, double amount) {
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}
