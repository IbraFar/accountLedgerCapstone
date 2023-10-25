package com.pluralsight;

public class LedgerApp {

    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static final String FILE_NAME = "transactions.csv";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static void main(String[] args) {
        //Manage the stack frames
        while (running) {
            printHomeScreen();


        }
    }

    public static void printHomeScreen(){
        System.out.println("Welcome to TransactionApp");
        System.out.println("Choose an option:");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
    }

    public static void getStringInput(Scanner scanner){

    }

}