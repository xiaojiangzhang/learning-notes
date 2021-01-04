package com.xiaojiang.java.mysql.dbpool;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataSourceDBCP {
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    /**
     * 加载数据库配置信息
     */
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        DRIVER = properties.getProperty("DRIVER");
        URL = properties.getProperty("URL");
        USER = properties.getProperty("USER");
        PASSWORD = properties.getProperty("PASSWORD");

    }

    public static void main(String[] args) throws Exception {
        testdbcpFactory();

    }

    public static void dbcpTest() throws SQLException {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(DRIVER);
        basicDataSource.setUrl(URL);
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASSWORD);
        Connection connection = basicDataSource.getConnection();
        String sql = "select * from data where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1789);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("time"));
            System.out.println(resultSet.getString("dataContext"));
        }
        preparedStatement.close();



    }
    public static void testdbcpFactory() throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/dbcp.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
//        通过连接池获取连接对象
        Connection connection = dataSource.getConnection();
        String sql = "select * from data where id = ?";
        PreparedStatement preparedStatement =  connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1789);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("time"));
        }
        preparedStatement.close();
    }
}
