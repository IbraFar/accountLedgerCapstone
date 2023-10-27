package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerApp {
    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        //Manage the stack frames

        FileManager fileManager = new FileManager();
        fileManager.loadTransactions();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            homeScreen(scanner);


        }
        scanner.close();
        running = false;
    }



    public static void homeScreen(Scanner scanner){
        System.out.println("""
               
               ==================================
                      Home Screen Menu
               ==================================
               Choose an option:
               
               (D) Make Deposit
               (P) Make Payment (Debit)
               (L) Ledger
               (X) Exit
               
               """);

        Character input = IO.getCharInput(scanner, "Please enter the initial of your choice: \n");

        switch (Character.toUpperCase(input)) {
            case 'D':
                addDeposit(scanner);
                break;
            case 'P':
                addPayment(scanner);
                break;
            case 'L':
                ledgerMenu(scanner);
                break;
            case 'X':
                System.out.println("Have a great day!");
                return;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void addDeposit(Scanner scanner){
        System.out.println("""
               
               ==================================
                       Making a Deposit....
               ==================================
               """);

        LocalDate date = IO.getDateInput(scanner, "Please enter the date of the deposit(YYYY-MM-DD): ");
        LocalTime time = IO.getTimeInput(scanner, "Please enter the time of the deposit(HH:mm:ss): ");
        String description = IO.getStringInput(scanner, "Please enter the description: ");
        String vendor = IO.getStringInput(scanner, "Please enter the vendor: ");
        double amount = IO.getDoubleInput(scanner, "Please enter the amount: ");

        Transaction newTransaction = new Transaction(date, time, description, vendor, amount, true);

        transactions.add(newTransaction);

        FileManager.postSingleTransaction(newTransaction);

    }

    public static void addPayment(Scanner scanner){
        System.out.println("""
               
               ==================================
                       Making a Payment....
               ==================================
               """);

        LocalDate date = IO.getDateInput(scanner, "Please enter the date of the deposit(YYYY-MM-DD): ");
        LocalTime time = IO.getTimeInput(scanner, "Please enter the time of the deposit(HH:mm:ss): ");
        String description = IO.getStringInput(scanner, "Please enter the description: ");
        String vendor = IO.getStringInput(scanner, "Please enter the vendor: ");
        double amount = IO.getDoubleInput(scanner, "Please enter the amount: ");

        Transaction newTransaction = new Transaction(date, time, description, vendor, amount, false);

        transactions.add(newTransaction);

        FileManager.postSingleTransaction(newTransaction);

    }


    public static void ledgerMenu(Scanner scanner){
        System.out.println("""
               
               ==================================
                          Ledger Menu
               ==================================
               Choose an option:
               
               (A) All
               (D) Deposits
               (P) Payments
               (R) Reports
               (H) Home
               """);

        Character input = IO.getCharInput(scanner, "Please enter the initial of your choice: \n");

        switch (Character.toUpperCase(input)) {
            case 'A':
                allTransactions();
                break;
            case 'D':
                allDeposits();
                break;
            case 'P':
                allPayments();
                break;
            case 'R':
                reportMenu(scanner);
            default:
                return;
        }
    }

    public static void allTransactions(){
        System.out.println("""
               
               ==================================
                    Loading All Transactions
               ==================================
               """);
        for(Transaction transaction: transactions){
            System.out.println(transaction.toString());
        };
        System.out.println("\nSending you back to the main menu....");
    }

    public static void allDeposits(){
        System.out.println("""
               
               ==================================
                    Loading All Deposits
               ==================================
               """);
        for(Transaction transaction: transactions){
            if(transaction.getDeposit()) {
                System.out.println(transaction.toString());
            }
        };
        System.out.println("\nSending you back to the main menu....");
    }

    public static void allPayments(){
        System.out.println("""
               
               ==================================
                    Loading All Deposits
               ==================================
               """);
        for(Transaction transaction: transactions){
            if(!transaction.getDeposit()) {
                System.out.println(transaction.toString());
            }
        };
        System.out.println("\nSending you back to the main menu....");
    }

    public static void reportMenu(Scanner scanner){
        System.out.println("""
               
               ==================================
                          Report Menu
               ==================================
               Choose an option:
               
               (1) Month To Date
               (2) Previous Month
               (3) Year To Date
               (4) Previous Year
               (5) Search By Vendor
               (0) Back
               """);

        Character input = IO.getCharInput(scanner, "Please enter the number of your choice: \n");

        switch (Character.toUpperCase(input)) {
            case '1':
                SearchFilter.monthToDate(transactions);
                break;
            case '2':
                SearchFilter.previousMonth(transactions);
                break;
            case '3':
                SearchFilter.yearToDate(transactions);
                break;
            case '4':
                //
                break;
            case '5':
                SearchFilter.filterTransactionsByVendor(scanner, transactions);
                break;
            default:
                System.out.println("Not an option! Sending you back...");
                return;
        }
    }

}

