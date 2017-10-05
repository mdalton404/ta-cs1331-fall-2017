/**
 * Class representation of a Book
 * @author Matthew Dalton
 * run with java BookTester
 */
public class Book {
    //Declare attributes
    private String title;
    private String author;
    private int numPages;
    private ISBN isbn; //Has-A relationship

    //Constructor
    public Book(String t, String a, int np) {
        title = t;
        author = a;
        numPages = np;
        isbn = new ISBN();
    }

    //Overloaded no-args constructor
    public Book() {
        title = "";
        author = "";
        numPages = 0;
        isbn = new ISBN();
    }

    //Instance Methods
    public void setTitle(String newVal) {
        title = newVal;
    }
    public void setAuthor(String newVal) {
        author = newVal;
    }
    public void setNumPages(int newVal) {
        numPages = newVal;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getNumPages() {
        return numPages;
    }
    public ISBN getISBN() {
        return isbn;
    }
    public void ripOutPage() {
        numPages--;
    }
    public boolean isLong() {
        return (numPages > 500);
    }
    public int getTitleLength() {
        return (title.length());
    }
    public String toString() {
        return String.format("%s : %s was written by %s and is %d pages long.\n", 
                            isbn, title, author, numPages);
    }
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null) { //redundant b/c instanceof checks but important to note
            return false;
        }
        if(!(o instanceof Book)) {
            return false;
        }
        Book b = (Book)o;
        return b.title.equals(title) && b.author.equals(author);
    }
}

class BookTester {
    public static void main(String[] args) {
        //object of the Book class
        Book book0 = new Book("Ulysses", "James Joyce", 732);
        Book book0copy2 = new Book("Ulysses", "James Joyce", 732);
        Book book1 = new Book("Ender's Game", "Orson S. Card", 324);
        Book book3; //just creates unassigned reference
        Book[] lotr = new Book[3];
        lotr[0] = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 432);
        lotr[1] = new Book("The Two Towers", "J.R.R. Tolkien", 322);
        lotr[2] = new Book("The Return of the King", "J.R.R. Tolkien", 490);

        book0.ripOutPage();
        System.out.print(book0); //calls toString() object method

        book1.setAuthor("Orson Scott Card");

        for(Book b : lotr) {
            System.out.print(b);
        }

        if (book0.isLong()) {
            System.out.println(book0.getTitle() + " is a long book.");
        } else {
            System.out.println(book0.getTitle() + " is a short book.");
        }
        
        System.out.printf("The title of %s by %s is %d characters long.%n", 
            book0.getTitle(), book0.getAuthor(), book0.getTitleLength());

        System.out.println(book0.equals(book0copy2));
        System.out.println(book0.equals(book1));
    }  
}