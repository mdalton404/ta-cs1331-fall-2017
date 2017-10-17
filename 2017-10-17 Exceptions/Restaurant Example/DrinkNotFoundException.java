/**
 * Checked Exception that is thrown when a requested drink is not available
 * @author mdalton31
 * @version 1
 */
public class DrinkNotFoundException extends Exception {
    /**
     * Constructor
     * @param msg exception message
     */
    public DrinkNotFoundException(String msg) {
        super(msg);
    }
}