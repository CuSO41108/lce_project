package com.lce.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydatabase?useSSL=false&serverTimezone=UTC");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydatabase?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("123456");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver"); // 指定驱动类
        config.setMaximumPoolSize(10);

        dataSource = new HikariDataSource(config);

    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
