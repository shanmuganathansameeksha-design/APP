package student;

public class Student {
    String studentId;
    String name;
    String department;

    public Student(String studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}
package course;

public class Course {
    String courseId;
    String courseName;
    int credits;

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void display() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
    }
}
import student.Student;
import course.Course;

public class Main {
    public static void main(String[] args) {

        Student s = new Student("S101", "Rahul", "CSE");

        Course c = new Course("C101", "Java Programming", 4);

        System.out.println("STUDENT DETAILS");
        s.display();

        System.out.println("\nCOURSE DETAILS");
        c.display();
    }
}