package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IO {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static LocalDate localDateFormatter(String date){
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDate.parse(date, DATE_FORMATTER);
    }
    public static LocalDate getDateInput(Scanner scanner, String prompt){
        LocalDate dateInput;
        boolean running = true;
        System.out.println(prompt);
        while (running) {
            try {
                String date = scanner.nextLine();
                dateInput = localDateFormatter(date);
                return dateInput;
            }catch(Exception e){
                System.out.println("Please enter the time in the correct format (yyyy-MM-dd):");
            }
            running = false;
        }
        //Placeholder return statement
        return LocalDate.now();
    }

    public static LocalTime getTimeInput(Scanner scanner, String prompt) {
        boolean running = true;
        System.out.println(prompt);
        while (running) {
            try {
                String time = scanner.nextLine();
                return LocalTime.parse(time);
            }catch(Exception e){
                System.out.println("Please enter the time in the correct format (HH:mm:ss):");
            }
            running = false;
        }
        //Placeholder return statement
        return LocalTime.now();
    }

    public static String getStringInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public static Character getCharInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextLine().charAt(0);
    }

    public static double getDoubleInput(Scanner scanner, String prompt){
        boolean running = true;
        System.out.println(prompt);
        while (running) {
            try {
                double doubleInput = scanner.nextDouble();
                scanner.nextLine();

                if(doubleInput >= 0) {
                    return doubleInput;
                }
            } catch (Exception e) {
                System.out.println("Invalid format.");
            }
                running = false;
        }
        return 0;
    }
}
