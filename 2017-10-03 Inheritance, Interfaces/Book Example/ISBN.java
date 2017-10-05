/**
 * Class representation of an ISBN #
 * @author Matthew Dalton
 * an isbn number is a unique identifier for a book
 * composed of four three-digit parts separated by "-"
 * A Book Has-A ISBN
 */
public class ISBN {
    private int part1;
    private int part2;
    private int part3;
    private int part4;
    public ISBN() {
        //random from 111 to 999
        part1 = (int)(Math.random() * 889) + 111; 
        part2 = (int)(Math.random() * 889) + 111;
        part3 = (int)(Math.random() * 889) + 111;
        part4 = (int)(Math.random() * 889) + 111;
    }
    public String toString() {
        return String.format("%d-%d-%d-%d", part1, part2, part3, part4);
    }
}