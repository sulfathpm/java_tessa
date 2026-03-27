import java.sql.*;
import java.util.Scanner;

public class pgm29 {
    private static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String USER = "system";
    private static String PASSWORD = "manager";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try( Connection conn =DriverManager.getConnection(URL, USER, PASSWORD);
              Statement  stmt = conn.createStatement();
) {

            String createTable = "CREATE TABLE book (" +
                    "bookid NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                    "title VARCHAR2(30), " +
                    "author VARCHAR2(30), " +
                    "price NUMBER)";

            stmt.executeUpdate(createTable);

            System.out.println("Table created successfully");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
        while(true){
            System.out.println("......menu......\n1.insert\n2.display\n3.display based on title\n4.display based on author\n5.update price\n6.delete\nEnter a choice :");
            int ch=sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Price: ");
                    int price = sc.nextInt();
                    String insertSQL = "INSERT INTO book(title, author, price) VALUES (?, ?, ?)";
                    int insertRow=stmt.executeUpdate(insertSQL);
                    System.out.println(insertRow+" row(s) inserted");
                    break;
                case 2:
                    ResultSet dis=stmt.executeQuery("SELECT * FROM book");
                    while (dis.next()) {
                        System.out.println(
                            dis.getInt("bookid")+" | "+
                            dis.getString("author")+" | "+
                            dis.getString("title")+" | "+
                            dis.getInt("price"));
                    }
                    break;
                case 3:
                    System.out.print("Enter Title: ");
                    String t1 = sc.nextLine();
                    String selectQuery="SELECT * FROM book where title=?";
                    PreparedStatement ps=conn.prepareStatement(selectQuery);
                    ps.setArray(1, t1);
                    ResultSet dis1=ps.executeQuery();
                    while(dis1.next()){
                       System.out.println(
                            dis1.getInt("bookid")+" | "+
                            dis1.getString("author")+" | "+
                            dis1.getString("title")+" | "+
                            dis1.getInt("price"));
                    }
                    break; 
                case 4:
                    System.out.print("Enter Author: ");
                    String t2 = sc.nextLine();
                    String selectQuery="SELECT * FROM book where author=?";
                    PreparedStatement ps=conn.prepareStatement(selectQuery);
                    ps.setArray(1, t2);
                    ResultSet dis2=ps.executeQuery();
                    while(dis2.next()){
                       System.out.println(
                            dis2.getInt("bookid")+" | "+
                            dis2.getString("author")+" | "+
                            dis2.getString("title")+" | "+
                            dis2.getInt("price"));
                    }
                    break; 
                case 5:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    int newPrice = sc.nextInt();
                    PreparedStatement ps=conn.prepareStatement("UPDATE book SET price=? WHERE bookid=?");
                    ps.setInt(1, newPrice );
                    ps.setInt(2,id );
                    int upd = ps4.executeUpdate();
                    System.out.println(upd > 0 ? "Updated!" : "Not found");
                    break;
                case 6:
                    System.out.print("Enter Book ID: ");
                    int del = sc.nextInt();
                    PreparedStatement ps5 = conn.prepareStatement("DELETE FROM book WHERE bookid=?");
                    ps5.setInt(1, del);
                    int d = ps5.executeUpdate();
                    System.out.println(d > 0 ? "Deleted!" : "Not found");
                    break;
                case 0:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}