import java.sql.*;

public class pg29 {
    private static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String USER = "system";
    private static String PASSWORD = "manager";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            stmt = conn.createStatement();

            String createTable = "CREATE TABLE book (" +
                    "bookid NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                    "title VARCHAR2(30), " +
                    "author VARCHAR2(30), " +
                    "price NUMBER)";

            stmt.executeUpdate(createTable);

            System.out.println("Table created successfully");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing: " + e.getMessage());
            }
        }
    }
}




// import java.sql.*;
// public class pg29 {
//         private static String URL="jdbc:oracle:thin:@localhost:1521:XE";        //jdbc:oracle:thin:@<host>:<port>:<SID>
//         private static String USER="system";
//         private static String PASSWORD="manager";
//         public static void main(String[] args) {
//             Connection conn=null;
//             Statement stmt=null;
//             try{
//                 //Class.forName("oracle.jdbc.OracleDriver");
//                 conn=DriverManager.getConnection(URL, USER, PASSWORD);
//                 String createTable="CREATE TABLE book(bookid INT AUTO_INCREMENT ,title VARCHAR(30),author VARCHAR(30), price INT)";
//                 int res=stmt.executeUpdate(createTable);
//                 System.out.println("table created successfully");
//             }catch(SQLException e){
//                 System.out.println("Error creating table:"+e.getMessage());
//                 e.printStackTrace();
//             }
//             finally{
//                 try{
//                     if(stmt!=null) stmt.close();
//                     if(conn!=null) conn.close();
//                 }catch(SQLException e){
//                     System.out.println("Error closing:"+e.getMessage());
//                     e.printStackTrace();
//                 }
//             }
//     }
// }

