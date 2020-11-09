package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SendToTheDatabase  extends  ReadFileLineByLine {

    public void send() {
         final String url = "jdbc:mysql://localhost:3306/employees?serverTimezone=UTC";
         final String user = "root";
         final String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO workers (The_Words)  VALUES (?)";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1,this.stra);
            stat.executeUpdate();
            connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}

