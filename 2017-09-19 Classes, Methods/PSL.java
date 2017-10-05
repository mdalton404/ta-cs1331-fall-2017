/**
 * Class representation of Pumpkin Spice Latte object
 * @author Isabella Plonk
 * @version 1.0
 */
public class PSL {

    private static int numberSold;
    private String name;
    private String size;
    private boolean hasWhippedCream;

    /**
     * Creates an instance of PSL with default values
     * @name name the PSL lover
     */
    public PSL(String name) {
        this(name, "Tall", true);
        // this.name = name;
        // this.size = "Tall";
        // this.hasWhippedCream = true;
        // ++numberSold;
    }

    /**
     * Creates an instance of PSL with user-defined values
     * @name the PSL lover
     * @param size the size of the PSL
     * @param hasWhippedCream whether or not the PSL has whipped cream
     */
    public PSL(String name, String size, boolean hasWhippedCream) {
        this.name = name;
        this.size = size;
        this.hasWhippedCream = hasWhippedCream;
        ++numberSold;
    }

    /**
     * @return the name of the PSL lover
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name of the PSL lover
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the size of the PSL
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size of the PSL
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return whether or not the PSL has whipped cream
     */
    public boolean getHasWhippedCream() {
        return hasWhippedCream;
    }

    /**
     * @param hasWhippedCream whether or not the PSL has whipped cream
     */
    public void setHasWhippedCream(boolean hasWhippedCream) {
        this.hasWhippedCream = hasWhippedCream;
    }


    /**
     * @return a String representation of the PSL
     */
    public String toString() {
        return size + " Pumpkin Spice Latte for " + name + "!";
    }

    /**
     * @return the number of PSLs sold so far
     */
    public static int getNumberSold() {
        return numberSold;
    }

    /**
     * @param psl the PSL to be compared
     * @return whether or not the two PSLs are equal
     */
    public boolean equals(PSL psl) {
        return this.name.equals(psl.name);
    }

}