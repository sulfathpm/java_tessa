import java.sql.*;
import java.util.Scanner;

public class p29 {
    private static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String USER = "system";
    private static String PASSWORD = "manager";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement()
        ) {

            // CREATE TABLE
            try {
                String createTable = "CREATE TABLE book (" +
                        "bookid NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                        "title VARCHAR2(30), " +
                        "author VARCHAR2(30), " +
                        "price NUMBER)";
                stmt.executeUpdate(createTable);
                System.out.println("Table created");
            } catch (SQLException e) {
                if (e.getErrorCode() == 955) {
                    System.out.println("Table already exists");
                }
            }

            // MENU LOOP (INSIDE TRY ✅)
            while (true) {
                System.out.println("\n......menu......");
                System.out.println("1.insert");
                System.out.println("2.display");
                System.out.println("3.display by title");
                System.out.println("4.display by author");
                System.out.println("5.update price");
                System.out.println("6.delete");
                System.out.println("0.exit");

                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    case 1:
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        System.out.print("Enter Price: ");
                        int price = sc.nextInt();

                        PreparedStatement ps1 = conn.prepareStatement(
                                "INSERT INTO book(title, author, price) VALUES (?, ?, ?)");
                        ps1.setString(1, title);
                        ps1.setString(2, author);
                        ps1.setInt(3, price);

                        int insertRow = ps1.executeUpdate();
                        System.out.println(insertRow + " row(s) inserted");
                        break;

                    case 2:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM book");
                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("bookid") + " | " +
                                    rs.getString("title") + " | " +
                                    rs.getString("author") + " | " +
                                    rs.getInt("price"));
                        }
                        break;

                    case 3:
                        System.out.print("Enter Title: ");
                        String t1 = sc.nextLine();

                        PreparedStatement ps2 = conn.prepareStatement(
                                "SELECT * FROM book WHERE title=?");
                        ps2.setString(1, t1);

                        ResultSet rs2 = ps2.executeQuery();
                        while (rs2.next()) {
                            System.out.println(
                                    rs2.getInt("bookid") + " | " +
                                    rs2.getString("title") + " | " +
                                    rs2.getString("author") + " | " +
                                    rs2.getInt("price"));
                        }
                        break;

                    case 4:
                        System.out.print("Enter Author: ");
                        String t2 = sc.nextLine();

                        PreparedStatement ps3 = conn.prepareStatement(
                                "SELECT * FROM book WHERE author=?");
                        ps3.setString(1, t2);

                        ResultSet rs3 = ps3.executeQuery();
                        while (rs3.next()) {
                            System.out.println(
                                    rs3.getInt("bookid") + " | " +
                                    rs3.getString("title") + " | " +
                                    rs3.getString("author") + " | " +
                                    rs3.getInt("price"));
                        }
                        break;

                    case 5:
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();

                        System.out.print("Enter New Price: ");
                        int newPrice = sc.nextInt();

                        PreparedStatement ps4 = conn.prepareStatement(
                                "UPDATE book SET price=? WHERE bookid=?");
                        ps4.setInt(1, newPrice);
                        ps4.setInt(2, id);

                        int upd = ps4.executeUpdate();
                        System.out.println(upd > 0 ? "Updated!" : "Not found");
                        break;

                    case 6:
                        System.out.print("Enter Book ID: ");
                        int del = sc.nextInt();

                        PreparedStatement ps5 = conn.prepareStatement(
                                "DELETE FROM book WHERE bookid=?");
                        ps5.setInt(1, del);

                        int d = ps5.executeUpdate();
                        System.out.println(d > 0 ? "Deleted!" : "Not found");
                        break;

                    case 0:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}