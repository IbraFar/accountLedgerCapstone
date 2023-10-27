package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileManager {
    private static final String customFileName = "transactions.csv";


    /* Loading transactions from the csv file using bufferedReader.
       Splitting each line into its individual parts into an array
       Using the array to construct Transaction variables which are then added to transactionArrayList
     */
    public void loadTransactions(){

        try {
            File someFile = new File(customFileName);
            if (someFile.createNewFile()) {
                System.out.println("Must create a new file:");
            }
        } catch (IOException e) {
            System.out.println("Wait a minute, hold on. The file can not be created. SORRY!");
        }
        try{

            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));
            String line;
            while((line = reader.readLine()) != null){
                String[] transactionConstructorVariables = line.split("\\|");
                // Create methods that parse each of these into their desired input values i.e. return
                // LocalDate instead of String
                String date = transactionConstructorVariables[0];
                String time = transactionConstructorVariables[1];
                String description = transactionConstructorVariables[2];
                String vendor = transactionConstructorVariables[3];
                double amount  = Double.parseDouble(transactionConstructorVariables[4]);
                boolean isDeposit = transactionConstructorVariables[5].equals("DEPOSIT");


                Transaction transaction = new Transaction(
                        IO.localDateFormatter(date),
                        LocalTime.parse(time),
                        description,vendor,
                        amount, isDeposit);

                LedgerApp.transactions.add(transaction);
            }
            reader.close();
        }catch(IOException e){
            System.err.println("You are hitting this IOException" + customFileName);
        }
    }

    /*public static void postTransactions() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(customFileName, true));

            for (Transaction transaction : LedgerApp.transactions) {
                postSingleTransaction(transaction);

                bufferedWriter.write(newlyWrittenTransactions);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
     */

    public static void postSingleTransaction(Transaction transaction) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(customFileName, true));
                String transactionType = transaction.getDeposit()? "DEPOSIT": "PAYMENT";

                String newlyWrittenTransactions = String.format("\n%s|%s|%s|%s|%.2f|%s",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount(),
                        transactionType);


                bufferedWriter.write(newlyWrittenTransactions);

            bufferedWriter.close();
            System.out.println("Transaction entered into the Ledger!");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

}
