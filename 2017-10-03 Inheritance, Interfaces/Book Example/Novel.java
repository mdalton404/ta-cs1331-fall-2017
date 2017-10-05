/**
 * Class representation of a Novel
 * @author Matthew Dalton
 * a Novel is-a Book
 * run with java NovelTester
 */
public class Novel extends Book {
    private String genre; //has genre and all of the book attributes

    public Novel(String t, String a, int np, String g) {
        super(t,a,np); //call to super must be first statement 
        genre = g;
    }
    //default Constructor
    public Novel() {
        super();
        genre = "";
    }

    public void setGenre(String newVal) {
        genre = newVal;
    }
    public String getGenre() {
        return genre;
    }
    @Override
    public String toString() {
        return String.format("%sAlso it is a novel of the %s genre.\n", 
                             super.toString(), getGenre());
    }
    @Override
    public boolean isLong() {
        return super.isLong() || (genre.equals("Horror")); //Horror books always seem long to me
    }
}

class NovelTester {
    public static void main(String[] args) {
        Novel test0 = new Novel("Emma", "Jane Austen", 221, "Romance");

        System.out.print("toString for Novel:\n" + test0 + "\n");
        Book test1 = new Book("Tale of Two Cities", "Charles Dickens", 355);
        System.out.print("toString for Book:\n" + test1);
    }
}