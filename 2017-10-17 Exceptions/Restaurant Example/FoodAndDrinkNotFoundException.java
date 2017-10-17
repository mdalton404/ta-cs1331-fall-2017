/**
 * Checked Exception thrown when requested food and drink are not available
 * @author mdalton31
 * @version 1
 */
public class FoodAndDrinkNotFoundException extends Exception {
    /**
     * Constructor
     * @param msg exception message
     */
    public FoodAndDrinkNotFoundException(String msg) {
        super(msg);
    }
}