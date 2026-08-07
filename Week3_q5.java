class Area {

    void area(int side) {
        System.out.println("Area of Square : " + (side * side));
    }

    void area(int length, int breadth) {
        System.out.println("Area of Rectangle : " + (length * breadth));
    }

    void area(double radius) {
        System.out.println("Area of Circle : " + (3.14 * radius * radius));
    }
}

public class AreaDemo {

    public static void main(String args[]) {

        Area a = new Area();

        a.area(5);
        a.area(6, 4);
        a.area(3.5);
    }
}