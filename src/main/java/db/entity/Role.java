package db.entity;


public enum Role {
    USER,ADMIN;


    public String getAuthority() {
        return name();
    }
}
