package com.company;

import java.io.*;
//import java.sql.*;

 class ReadFileLineByLine {
     static String stra;

    public static void main(String[] args) {


        try {
            File file = new File("D:\\Text.txt.txt");

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            SendToTheDatabase dataB = new SendToTheDatabase();

             stra = reader.readLine();

            while (stra != null) {
                int length = stra.length();

                if (length > 5) {
                    dataB.send();
                }
                stra = reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    }








