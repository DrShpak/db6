package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnection implements ConnectionBuilder {

    private final Properties properties;
    private final String PATH_TO_CONFIG = "src/main/resources/config.properties";
    private final String DB_NAME = "cookbook";

    public PostgresConnection() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(PATH_TO_CONFIG));
            Class.forName(properties.getProperty("driver"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
//        Connection con;

        return DriverManager.getConnection(
            properties.getProperty("host"),
            properties.getProperty("login"),
            properties.getProperty("password"));
    }
}
