/**
 * Class representation of a Textbook
 * @author Matthew Dalton
 * a Textbook is-a Book
 * run with TestTextbook
 */
public class Textbook extends Book {
    private String subject;
    //constructor
    public Textbook(String t, String a, int np, String s) {
        super(t,a,np);
        subject = s;
    }
    public Textbook() {
        super();
        this.subject = "";
    }
    public String getSubject() {
        return this.subject;
    }
    public void setSubject(String newVal) {
        this.subject = newVal;
    } 
    @Override
    public String toString() { //overrides Book toString()
        return String.format("%sAlso it is a %s textbook.\n", super.toString(), subject);
    }
    public void setTitle() { //overloaded such that alters title to have subject
        super.setTitle(super.getTitle() + "(" + this.subject + ")");
    }
}

class TestTextbook {
    public static void main(String[] args) {
        Textbook test0 = new Textbook("Java for Beginners", "Cay Horstmann", 1331, "Computer Science");
        test0.setTitle();
        System.out.println(test0);
    }
}