import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DBCreateTable {

    public static void createTable() {
        // Use your existing getConnection method
        Connection conn = DBConnection.getConnection();
        
        if (conn != null) {
            // SQL Statement to create a table
            String sql = "CREATE TABLE STUDENTS (" +
                         "ID NUMBER PRIMARY KEY, " +
                         "NAME VARCHAR2(50), " +
                         "EMAIL VARCHAR2(50))";

            try (Statement stmt = conn.createStatement()) {
                // executeUpdate is used for CREATE, INSERT, UPDATE, DELETE
                stmt.executeUpdate(sql);
                System.out.println("Table 'STUDENTS' created successfully!");
                
                // Always close the connection when done
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error creating table: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        createTable();
    }
}