package db.entity;

import java.util.Set;

public class User {
    /**
     * The corresponding name of table in database.
     */
    public static final String TABLE_NAME = "usr";
    /**
     * The corresponding name of id column in table.
     */
    public static final String ID_COLUMN = "id";
    /**
     * The corresponding name of name column in table.
     */
    public static final String NAME_COLUMN = "username";
    /**
     * The corresponding name of password column in table.
     */
    public static final String PASSWORD_COLUMN = "password";

    private Long id;
    private String username;
    private String password;
    private boolean active;
    private Set<Role> roles;



    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, boolean active, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public User(Long id, String username, String password, boolean active, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
