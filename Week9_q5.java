CREATE DATABASE storedb;

USE storedb;

CREATE TABLE Product (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    Price DOUBLE,
    Quantity INT
);
import java.sql.*;
import java.util.*;

public class ProductManagement {

    static final String URL =
        "jdbc:mysql://localhost:3306/storedb";

    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            System.out.println("Connected to database!");

            // 1. Insert Product
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            String insert =
                "INSERT INTO Product VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                con.prepareStatement(insert);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            ps.executeUpdate();

            System.out.println("Product inserted!");

            // 2. Retrieve Product
            System.out.print("Enter Product ID to search: ");
            int searchID = sc.nextInt();

            String select =
                "SELECT * FROM Product WHERE ProductID=?";

            ps = con.prepareStatement(select);
            ps.setInt(1, searchID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                    "Product ID: " +
                    rs.getInt("ProductID"));

                System.out.println(
                    "Product Name: " +
                    rs.getString("ProductName"));

                System.out.println(
                    "Price: " +
                    rs.getDouble("Price"));

                System.out.println(
                    "Quantity: " +
                    rs.getInt("Quantity"));

            } else {
                System.out.println("Product not found!");
            }

            // 3. Update quantity
            System.out.print("Enter Product ID to update: ");
            int updateID = sc.nextInt();

            System.out.print("Enter new quantity: ");
            int newQuantity = sc.nextInt();

            String update =
                "UPDATE Product SET Quantity=? WHERE ProductID=?";

            ps = con.prepareStatement(update);

            ps.setInt(1, newQuantity);
            ps.setInt(2, updateID);

            ps.executeUpdate();

            System.out.println("Quantity updated!");

            // 4. Products below quantity 10
            String lowStock =
                "SELECT * FROM Product WHERE Quantity < 10";

            ps = con.prepareStatement(lowStock);
            rs = ps.executeQuery();

            System.out.println("\nLow Stock Products:");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("ProductID") + " " +
                    rs.getString("ProductName") + " " +
                    rs.getDouble("Price") + " " +
                    rs.getInt("Quantity")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}