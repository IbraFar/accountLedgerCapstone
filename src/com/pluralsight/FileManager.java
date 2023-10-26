package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Array;
import java.util.ArrayList;

public class FileManager {
    private ArrayList<Transaction> transactionArrayList= new ArrayList<>();
    String customFileName = "SAMPLE_FILE_NAME";
    BufferedReader bufferedReader = new BufferedReader(new FileReader(customFileName));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(customFileName));

}
