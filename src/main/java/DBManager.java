import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class DBManager {
    public static final String CONNECTION_URL = connect("connection.url");

    private static String connect(String s) {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("application.properties"))) {
            props.load(in);
        } catch (IOException ex) {
            Logger.getGlobal().severe(ex.getMessage());
        }
        return props.getProperty(s);
    }
}
