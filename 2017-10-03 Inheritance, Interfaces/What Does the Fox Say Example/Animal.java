/**
 * Class representation of an animal
 * @author Isabella Plonk
 * @version 1.0
 */
public class Animal {

    private int numOfLegs;
    private String color;

    /**
     * Creates an animal
     * @param numOfLegs the number of legs the animal has
     * @param color the color of the animal
     */
    public Animal(int numOfLegs, String color) {
        this.numOfLegs = numOfLegs;
        this.color = color;
    }

    /**
     * Makes the animal's noise
     */


    /**
     * @return numOfLegs the number of legs the animal has
     */
    public int getNumOfLegs() {
        return numOfLegs;
    }

    /**
     * @param numOfLegs the number of legs the animal has
     */
    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    /**
     * @return the color of the animal
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color of the animal
     */
    public void setColor(String color) {
        this.color = color;
    }
    
}