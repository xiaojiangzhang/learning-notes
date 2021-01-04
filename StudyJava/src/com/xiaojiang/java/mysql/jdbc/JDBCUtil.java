package com.xiaojiang.java.mysql.jdbc;

import java.sql.*;

public class JDBCUtil {
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from data where id = 1789";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String line = resultSet.getString("time");
            System.out.println(line);
        }

        resultSet.close();
        statement.close();

    }
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://47.101.184.222:3306/SampleJavaCode?characterEncoding=UTF-8";
        String username = "root";
        String password = "xiaojiangzhang";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;

    }
}
