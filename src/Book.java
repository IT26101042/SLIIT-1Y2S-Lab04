// Q01

// a)
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private double price;

    // b) I)
    public Book(String title, String author) {
        this(title, author, "Not assigned", 0.0);
    }

    // b) II)
    public Book(String title, String author, String ISBN) {
        this(title, author, ISBN, 0.0);
    }

    // b) III)
    public Book(String title, String author, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }

    // c) I)
    public String getBookDetails() {
        return "Title: " + title
                + "\nAuthor: " + author
                + "\nISBN: " + ISBN
                + "\nPrice: " + price;
    }

    // c) II)
    public String getBookDetails(String ISBN) {
        if (this.ISBN.equals(ISBN)) {
            return getBookDetails();
        }

        return "Book not found for ISBN: " + ISBN;
    }

    // d)
    public static void main(String[] args) {
        Book book1 = new Book(
                "Java Basics", "John Smith"
        );

        Book book2 = new Book(
                "Object Oriented Programming", "Emily Davis", "ISBN002"
        );

        Book book3 = new Book(
                "Data Structures", "Michael Brown", "ISBN003", 2500.0
        );

        System.out.println("Book 1 ");
        System.out.println(book1.getBookDetails());

        System.out.println("\nBook 2 ");
        System.out.println(book2.getBookDetails());

        System.out.println("\nBook 3 ");
        System.out.println(book3.getBookDetails());

        System.out.println("\nSearch by ISBN ");
        System.out.println(book3.getBookDetails("ISBN003"));

        System.out.println("\nInvalid ISBN ");
        System.out.println(book3.getBookDetails("ISBN999"));
    }
}