package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;

import java.sql.*;

public class SqlConnector {
    public static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);

    private static final String Url = "jdbc:postgresql://localhost:5432/mortgage_calculator";
    private static final String User = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String Password = ReadConfigFiles.getPropertyValues("DbPassword");

    /**
     * Connect to the postgreSQL database
     *
     * @return a Connection object
     */

    private static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Url, User, Password);
            System.out.println("Connected to the postgreSQL server successful");
        } catch (Exception e) {
            LOGGER.error("SQL Connection Exception: " + e.getMessage());
        }
        return conn;
    }

    /**
     * Reading data from the database
     * @param SQL is the method parameter to accept the SQL query
     * @return a ResultSet object
     * @throws SQLException
     */
    public static ResultSet readData(String SQL) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = connect();
            LOGGER.debug("Connection object value " + conn);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

        } catch (SQLException e) {
            LOGGER.error("SQL ResultSet Exception" + e.getMessage());
        }finally {

            conn.close();
        }
        return rs;
   }

}
