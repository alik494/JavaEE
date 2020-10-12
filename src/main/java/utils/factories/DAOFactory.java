package utils.factories;

import dao.impl.UserDAOImpl;

public class DAOFactory {
    public UserDAOImpl createUserDao() {
        return new UserDAOImpl();
    }
}
