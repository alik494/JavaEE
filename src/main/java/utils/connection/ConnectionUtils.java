package utils.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final Logger log = Logger.getLogger(ConnectionPool.class);

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection =
                    DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/postgres",
                            "postgres",
                            "49410alik");
        } catch (SQLException throwables) {
            log.error(throwables);
        }

        return connection;

    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
