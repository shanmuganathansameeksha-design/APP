CREATE DATABASE librarydb;

USE librarydb;

CREATE TABLE Book (
    BookID INT PRIMARY KEY,
    Title VARCHAR(100),
    Author VARCHAR(100),
    Price DOUBLE,
    Availability VARCHAR(20)
);
import java.sql.*;
import java.util.*;

public class Library {

    static final String URL =
        "jdbc:mysql://localhost:3306/librarydb";

    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            System.out.println("Database Connected!");

            // 1. Insert Book
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            String insert =
                "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
                con.prepareStatement(insert);

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setString(5, "Available");

            ps.executeUpdate();

            System.out.println("Book inserted!");

            // 2. Search Book
            System.out.print("Enter Book ID to search: ");
            int searchID = sc.nextInt();

            String search =
                "SELECT * FROM Book WHERE BookID=?";

            ps = con.prepareStatement(search);
            ps.setInt(1, searchID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Book ID: " +
                        rs.getInt("BookID"));
                System.out.println("Title: " +
                        rs.getString("Title"));
                System.out.println("Author: " +
                        rs.getString("Author"));
                System.out.println("Price: " +
                        rs.getDouble("Price"));
                System.out.println("Availability: " +
                        rs.getString("Availability"));
            } else {
                System.out.println("Book not found!");
            }

            // 3. Display available books
            String available =
                "SELECT * FROM Book WHERE Availability='Available'";

            ps = con.prepareStatement(available);
            rs = ps.executeQuery();

            System.out.println("\nAvailable Books:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("BookID") + " " +
                    rs.getString("Title") + " " +
                    rs.getString("Author")
                );
            }

            // 4. Issue Book
            System.out.print("\nEnter Book ID to issue: ");
            int issueID = sc.nextInt();

            String update =
                "UPDATE Book SET Availability='Issued' " +
                "WHERE BookID=?";

            ps = con.prepareStatement(update);
            ps.setInt(1, issueID);

            ps.executeUpdate();

            System.out.println("Book issued successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}