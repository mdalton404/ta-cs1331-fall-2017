/**
 * Checked Exception that is thrown when a requested food is not available
 * @author mdalton31
 * @version 1
 */
public class FoodNotFoundException extends Exception {
    /**
     * Constructor
     * @param msg exception message
     */
    public FoodNotFoundException(String msg) {
        super(msg);
    }
}