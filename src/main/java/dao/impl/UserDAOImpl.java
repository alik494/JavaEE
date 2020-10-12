package dao.impl;

import db.entity.User;
import org.apache.log4j.Logger;
import utils.ConnectionPool;
import utils.queries.UserQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl {
    private static final Logger log = Logger.getLogger(UserDAOImpl.class);
    public User findByNameAndPass(String name, String password) {
        User user = null;
        try(Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UserQueries.FIND_BY_NAME_AND_PASS);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException throwables) {
            log.error("Error",throwables);
        }
        return user;

    }

    public void insert(User user) {

    }
}
