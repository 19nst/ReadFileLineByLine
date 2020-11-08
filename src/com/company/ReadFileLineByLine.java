package com.company;

import java.io.*;
import java.sql.*;


// построчно читаем файл файла и выводим его в таблицу БД
public class ReadFileLineByLine {

    public static void main(String[] args) {
        try {
            File file = new File("D:\\Text.txt.txt");

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String stra = reader.readLine();

            while (stra != null) {

                int length = stra.length();
                if (length > 5) {

                    final String url = "jdbc:mysql://localhost:3306/employees?serverTimezone=UTC";
                    final String user = "root";
                    final String password = "root";

                        try {
                            Connection connection = DriverManager.getConnection(url, user, password);
                            String sql = "INSERT INTO workers (The_Words)  VALUES (?)";
                            PreparedStatement stat = connection.prepareStatement(sql);
                            stat.setString(1, stra);
                            stat.executeUpdate();
                            connection.close();

                         }catch (SQLException e) {
                            e.printStackTrace();
                        }
                }
                stra = reader.readLine();
            }
        }
        //Исключения
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}








