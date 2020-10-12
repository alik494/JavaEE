package utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    /**
     * Postgres user's name
     */
    public static final String USER = "postgres";
    /**
     * MySQl user's password
     */
    public static final String PASSWORD = "49410alik";
    /**
     * Url for accessing the database
     */
    public static final String URL =  "jdbc:postgresql://localhost:5432/postgres";
    /**
     * BasicDataSource instance
     */
    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl(URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
