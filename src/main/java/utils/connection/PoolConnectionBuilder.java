package utils.connection;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder {

    private static final Logger log = Logger.getLogger(PoolConnectionBuilder.class);
    private DataSource dataSource;

    public PoolConnectionBuilder(DataSource dataSource) {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:com/env/jdbc/postgres");
        } catch (NamingException e) {
            log.error("error in PoolConnectionBuilder " + e, e);
        }
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            log.error(throwables);
        }
        return connection;
    }
}
