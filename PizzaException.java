/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This is the exception class that I built to be thrown whenever there is a problem with a linked list, stack or
 * Queue. It will extend exception so that it may be used as one.
 */
public class PizzaException extends RuntimeException {
    /**
     * Default constructor that can be used if needed, not very descriptive to any problems so I didnt use it.
     */
    public PizzaException() {
        super();
    }

    /**
     * This constructor will take in a message that can be displayed once the exception is caught.
     *
     * @param message The string telling the user what went wrong and where.
     */
    public PizzaException(String message) {
        super(message);
    }
}
