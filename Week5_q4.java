import java.util.Scanner;

abstract class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    double calculateFinalPrice() {
        return price - calculateDiscount();
    }

    void display() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
        System.out.println("Discount: ₹" + calculateDiscount());
        System.out.println("Final Price: ₹" + calculateFinalPrice());
        System.out.println("----------------------");
    }
}

class Electronics extends Product {

    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return price * 0.10;
    }
}

class Clothing extends Product {

    Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return price * 0.20;
    }
}

class Books extends Product {

    Books(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return price * 0.15;
    }
}

public class ProductDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");

        System.out.print("Enter category: ");
        int choice = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product product;

        switch (choice) {
            case 1:
                product = new Electronics(id, name, price);
                break;

            case 2:
                product = new Clothing(id, name, price);
                break;

            case 3:
                product = new Books(id, name, price);
                break;

            default:
                System.out.println("Invalid category.");
                sc.close();
                return;
        }

        product.display();

        sc.close();
    }
}