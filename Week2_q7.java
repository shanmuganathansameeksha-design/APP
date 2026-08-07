class Employee
{
    int id;
    String name;
    double salary;

    Employee(int i,String n,double s)
    {
        id = i;
        name = n;
        salary = s;
    }

    void display()
    {
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Salary : " + salary);
    }
}

public class EmployeeDetails
{
    public static void main(String args[])
    {
        Employee e1 = new Employee(101,"Rahul",45000);
        Employee e2 = new Employee(102,"Priya",50000);

        e1.display();
        e2.display();
    }
}