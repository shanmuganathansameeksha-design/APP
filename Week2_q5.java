class Rectangle
{
    int length;
    int breadth;

    Rectangle(int l, int b)
    {
        length = l;
        breadth = b;
    }

    void area()
    {
        System.out.println("Area = " + (length * breadth));
    }
}

public class RectangleDemo
{
    public static void main(String args[])
    {
        Rectangle r = new Rectangle(10,5);

        r.area();
    }
}