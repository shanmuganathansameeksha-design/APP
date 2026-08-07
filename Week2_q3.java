class Book
{
    String title;
    String author;
    double price;

    Book(String t, String a, double p)
    {
        title = t;
        author = a;
        price = p;
    }

    void display()
    {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }
}

public class BookDemo
{
    public static void main(String args[])
    {
        Book b = new Book("Java Programming", "James", 550);

        b.display();
    }
}