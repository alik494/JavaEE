package utils.connection;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static final Logger log = Logger.getLogger(ConnectionPool.class);

    public static final String USER = "postgres";

    public static final String PASSWORD = "49410alik";

    public static final String URL =  "jdbc:postgresql://localhost/postgres?useSSL=false&serverTimezone=UTC";

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl(URL);
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
        log.debug(ds);
    }

    /**
     * Method for getting connection
     * @return connection to database
     * @throws SQLException SQLException
     */
    public static Connection getConnection() throws SQLException {
        log.debug(ds);
        return ds.getConnection();
    }


}
