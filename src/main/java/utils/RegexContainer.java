package utils;

public interface RegexContainer {
    /**
     * Regular expression for name
     */
    String REGEX_NAME_ENG="^[A-Z][a-z]{3,29}$";

    /**
     * Regular expression for password
     */
    String REGEX_PASSWORD = "^[A-Za-z0-9_-]{3,30}$";
}
