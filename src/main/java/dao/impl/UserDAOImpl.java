package dao.impl;

import db.entity.User;
import org.apache.log4j.Logger;
import utils.connection.ConnectionPool;
import utils.connection.ConnectionUtils;
import utils.connection.PoolConnectionBuilder;
import utils.queries.UserQueries;

import java.sql.*;

public class UserDAOImpl {
    private static final Logger log = Logger.getLogger(UserDAOImpl.class);

    private PoolConnectionBuilder connectionBuilder;


    public Long getNextUserID() {
        Long nextVal = null;
        try (Connection connection =

                     ConnectionPool.getConnection()) {
//                     connectionBuilder.getConnection()) {
//                     ConnectionUtils.getConnection()) {
            //todo impl connection pool
            PreparedStatement statement = connection.prepareStatement(UserQueries.FIND_NEXT_USER_ID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                nextVal = resultSet.getLong("nextval");
            }
        } catch (SQLException throwables) {
            log.error("Error" + throwables, throwables);
        }
        return nextVal;
    }

    public User findByEmail(String email) {
        User user = null;
        try (Connection connection =
                     ConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UserQueries.FIND_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                log.debug("counter at prepared St by email");
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("active")
                );
            }
        } catch (SQLException throwables) {
            log.error("Error", throwables);
        }
        return user;
    }

    public void insert(User user) {
        try (Connection connection =
                     ConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UserQueries.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setBoolean(5, user.isActive());
            statement.execute();
        } catch (SQLException throwables) {
            log.error("Error", throwables);
        }
    }
}
