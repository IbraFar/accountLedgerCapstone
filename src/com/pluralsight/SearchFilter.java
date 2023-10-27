package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchFilter {


    public static void monthToDate(ArrayList<Transaction> transactions){
        LocalDate current = LocalDate.now();
        for(Transaction transaction: transactions){
            if (transaction.getDate().getYear() == current.getYear() && transaction.getDate().getMonth() == current.getMonth()) {
                System.out.printf("%s| %s| %s| %s| %.2f | %s \n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount(), transaction.getIsDepositOrPayment());
            }
        }
    }
    public static void previousMonth(ArrayList<Transaction> transactions){
        LocalDate current = LocalDate.now();
        LocalDate previousMonth = current.minusMonths(1);
        for(Transaction transaction: transactions){
            if (transaction.getDate().getYear() == previousMonth.getYear() && transaction.getDate().getMonth() == previousMonth.getMonth()) {
                System.out.printf("%s| %s| %s| %s| %.2f | %s \n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount(), transaction.getIsDepositOrPayment());
            }
        }
    }


    public static void yearToDate(ArrayList<Transaction> transactions){
        int year = LocalDate.now().getYear();

        for(Transaction transaction: transactions){
            if (year == transaction.getDate().getYear()) {
                System.out.printf("%s| %s| %s| %s| %.2f | %s \n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount(), transaction.getIsDepositOrPayment());
            }
        }
    }

    public static void previousYear(ArrayList<Transaction> transactions){
        int year = LocalDate.now().getYear();

        for(Transaction transaction: transactions){
            if ((year - 1) == transaction.getDate().getYear()) {
                System.out.printf("%s| %s| %s| %s| %.2f | %s \n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount(), transaction.getIsDepositOrPayment());
            }
        }
    }




    public static void filterTransactionsByVendor(Scanner scanner, ArrayList<Transaction> transactions) {
        String vendor = IO.getStringInput(scanner, "Please enter the vendor you'd like to search for");

        System.out.println("The following are entries filtered by chosen vendor: ");


        for (Transaction transaction : transactions) {

            if (vendor.equalsIgnoreCase(transaction.getVendor())) {
                System.out.printf("%s| %s| %s| %s| %.2f | %s \n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount(), transaction.getIsDepositOrPayment());
            }
        }
    }
}

