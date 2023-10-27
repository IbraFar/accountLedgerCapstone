package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    private boolean isDeposit;


    private String isDepositOrPayment;


    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount, boolean isDeposit) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.isDeposit = isDeposit;
        this.isDepositOrPayment = (isDeposit)? "DEPOSIT" : "PAYMENT";
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }


    public String getVendor() {
        return vendor;
    }

    public boolean getDeposit() {
        return isDeposit;
    }
    public String getIsDepositOrPayment() {
        return isDepositOrPayment;
    }


    public double getAmount() {
        return amount;
    }



    @Override
    public String toString() {
        return
        String.format("\n%s|%s|%s|%s|%.2f|%s",
                getDate(),
                getTime(),
                getDescription(),
                getVendor(),
                getAmount(),
                getIsDepositOrPayment());
    }
}
