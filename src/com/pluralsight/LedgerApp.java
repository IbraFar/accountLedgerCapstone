package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerApp {
    private static final ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static final String FILE_NAME = "transactions.csv";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

    public static void main(String[] args) {
        //Manage the stack frames
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            printHomeScreenOptions();


            homeScreenSwitchCase(scanner);



            running = false;
        }
    }


    public static void printHomeScreenOptions(){
        System.out.println("Welcome to TransactionApp");
        System.out.println("Choose an option:");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
    }

    public static String getStringInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public static Character getCharInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextLine().charAt(0);
    }

    public static BigDecimal getBigDecimalInput(Scanner scanner,String prompt){
        System.out.println(prompt);
        return scanner.nextBigDecimal();
    }

    public static void homeScreenSwitchCase(Scanner scanner){

        Character input = getCharInput(scanner, "Please enter the initial of your choice: \n");

        switch (Character.toUpperCase(input)) {
            case 'D':
                addDeposit(scanner);
                break;
            case 'P':
                //addPayment(scanner);
                break;
            case 'L':
                //ledgerMenu(scanner);
                break;
            case 'X':
                //running = false;
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void addDeposit(Scanner scanner){

        getStringInput(scanner, "Sample deposit method code");
    }
}

