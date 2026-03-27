import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Oracle 11g XE JDBC URL
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";       // your Oracle username
    private static final String PASSWORD = "manager"; // your Oracle password

    public static Connection getConnection() {
        try {
            // Optional: modern JDBC can auto-load driver
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected!");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

      public static void main(String[] args) {
        getConnection();
    }
}