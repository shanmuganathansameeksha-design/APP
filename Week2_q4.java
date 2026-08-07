class Student
{
    String name;
    int rollNo;

    Student(String n, int r)
    {
        name = n;
        rollNo = r;
    }

    void display()
    {
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
    }
}

public class StudentDemo
{
    public static void main(String args[])
    {
        Student s = new Student("Rahul",101);

        s.display();
    }
}