package utils.queries;

import db.entity.User;

public interface UserQueries {

    /**
     * SELECT * FROM app_users WHERE email = ? AND password = ?;
     */
    public static final String FIND_NEXT_USER_ID = "select nextval('hibernate_sequence')";

    /**
     * SELECT * FROM app_users WHERE email = ? AND password = ?;
     */
    public static final String FIND_BY_EMAIL_AND_PASS = "select * from " + User.TABLE_NAME + " where "
            + User.NAME_EMAIL + " = ? and " + User.PASSWORD_COLUMN + " = ?";

    /**
     * SELECT * FROM app_users WHERE email = ?;
     */
    public static final String FIND_BY_EMAIL = "select * from " + User.TABLE_NAME + " where "
            + User.NAME_EMAIL + " = ?";
    /**
     * SELECT * FROM app_users;
     */
    public static final String FIND_ALL = "select * from " + User.TABLE_NAME;
    /**
     * SELECT * FROM app_users WHERE id = ?;
     */
    public static final String FIND_BY_ID = FIND_ALL + " where " + User.ID_COLUMN + " = ?";
    /**
     * INSERT INTO usr(name, password, active) VALUES (?, ?, ?);
     */
    public static final String INSERT_USER = "insert into " + User.TABLE_NAME
            + " (" + User.ID_COLUMN + ", " + User.NAME_EMAIL + ", " + User.NAME_COLUMN + ", " + User.PASSWORD_COLUMN + ", " + User.ACTIVE_COLUMN + ") values (?, ?, ?, ?, ?)";
}
