package com.xiaojiang.java.mysql.dbpool;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPConnections {
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static BasicDataSource basicDataSource;
    
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/dbcp.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        try {
            basicDataSource = BasicDataSourceFactory.createDataSource(properties);
            //设置最大空闲连接
//            basicDataSource.setMaxIdle(5);
            basicDataSource.setMaxTotal(30);
            basicDataSource.setInitialSize(5);
//            basicDataSource.setRemoveAbandonedOnMaintenance(true);
//            basicDataSource.setRemoveAbandonedOnBorrow(true);
//            basicDataSource.setRemoveAbandonedTimeout(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }


}

class TestThread extends Thread {
    DBCPConnections dbcpConnections;

    public TestThread(DBCPConnections dbcpConnections, String name) {
        this.setName(name);
        this.dbcpConnections = dbcpConnections;

    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            try {
                BasicDataSource basicDataSource = dbcpConnections.getBasicDataSource();
                Connection connection = basicDataSource.getConnection();
                String sql = "insert into user (name, password) values(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "username" + i);
                preparedStatement.setString(2, "password" + i);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                System.out.println("当前线程编号：" + Thread.currentThread().getName()
                        + ",当前执行第" + i + "步，"
                        + ",当前活跃连接数量：" + basicDataSource.getNumActive()
                        + "，最大空闲连接数量：" + basicDataSource.getMaxIdle()
                        + "，最少空闲数量数量：" + basicDataSource.getMinIdle()
                        + "，最大连接数量：" + basicDataSource.getMaxTotal()
                );
                sleep(1000);
            } catch (Exception e) {
            }


        }
    }


}

class TestDBCP {
    public static void main(String[] args) {
        DBCPConnections dbcpConnections = new DBCPConnections();
        TestThread testThread1 = new TestThread(dbcpConnections, "thread1");
        TestThread testThread2 = new TestThread(dbcpConnections, "thread2");
        TestThread testThread3 = new TestThread(dbcpConnections, "thread3");
        testThread1.start();
        testThread2.start();
        testThread3.start();

    }
}
