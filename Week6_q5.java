package student;

public class Student
{
    public int id;
    public String name;
    public int age;

    public Student(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void displayStudent()
    {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}
package course;

public class Course
{
    public int courseId;
    public String courseName;
    public int credits;

    public Course(int courseId, String courseName, int credits)
    {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void displayCourse()
    {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
    }
}
import student.Student;
import course.Course;

public class Main
{
    public static void main(String[] args)
    {
        Student s = new Student(101, "Sameeksha", 19);

        Course c = new Course(501, "Java Programming", 4);

        System.out.println("Student Details");
        s.displayStudent();

        System.out.println();

        System.out.println("Course Details");
        c.displayCourse();
    }
}