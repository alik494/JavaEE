package utils.queries;

import db.entity.User;

public interface UserQueries {
    /**
     * SELECT * FROM app_users WHERE email = ? AND password = ?;
     */
    public static final String FIND_BY_NAME_AND_PASS = "select * from " + User.TABLE_NAME + " where "
            + User.NAME_COLUMN + " = ? and " + User.PASSWORD_COLUMN + " = ?";
    /**
     * SELECT * FROM app_users;
     */
    public static final String FIND_ALL = "select * from " + User.TABLE_NAME;
    /**
     * SELECT * FROM app_users WHERE id = ?;
     */
    public static final String FIND_BY_ID = FIND_ALL + " where " + User.ID_COLUMN + " = ?";
}
