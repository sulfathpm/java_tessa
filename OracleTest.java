import java.sql.*;

public class OracleTest {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "manager"
            );

            System.out.println("Connected to Oracle!");

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}