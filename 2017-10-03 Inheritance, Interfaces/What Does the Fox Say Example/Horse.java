/**
 * Class representation of a horse
 * Horse is-an Animal
 * @author Isabella Plonk
 * @version 1.0
 */
public class Horse extends Animal {

    private boolean knowsMorse;

    /**
     * Creates a horse
     * @param color the color of the horse
     * @param knowsMorse whether or not the horse knows morse code
     */
    public Horse(String color, boolean knowsMorse) {
        super(4, color);
        this.knowsMorse = knowsMorse;
    }

    // @Override
    // public void makeNoise() {
    //     System.out.println("Neigh");
    // }

    /**
     * @return whether or not the horse knows morse code
     */
    public boolean getKnowsMorse() {
        return knowsMorse;
    }

    /**
     * @param knowsMorse whether or not the horse knows morse code
     */
    public void setKnowsMorse(boolean knowsMorse) {
        this.knowsMorse = knowsMorse;
    }

}