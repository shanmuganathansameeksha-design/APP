CREATE DATABASE collegedb;

USE collegedb;

CREATE TABLE CourseRegistration (
    StudentID INT,
    StudentName VARCHAR(100),
    CourseCode VARCHAR(20),
    CourseName VARCHAR(100),
    Semester INT
);
import java.sql.*;
import java.util.*;

public class CourseRegistration {

    static final String URL =
        "jdbc:mysql://localhost:3306/collegedb";

    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Establish connection
            Connection con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            System.out.println("Database Connected!");

            System.out.print("Enter Course Code: ");
            String code = sc.nextLine();

            String query =
                "SELECT * FROM CourseRegistration " +
                "WHERE CourseCode=?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                    "Student ID: " +
                    rs.getInt("StudentID"));

                System.out.println(
                    "Student Name: " +
                    rs.getString("StudentName"));

                System.out.println(
                    "Course Code: " +
                    rs.getString("CourseCode"));

                System.out.println(
                    "Course Name: " +
                    rs.getString("CourseName"));

                System.out.println(
                    "Semester: " +
                    rs.getInt("Semester"));

                System.out.println("--------------------");
            }

            if (!found) {
                System.out.println(
                    "No students registered for this course.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}