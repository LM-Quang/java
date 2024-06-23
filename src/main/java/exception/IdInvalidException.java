package exception;

/**
 * IdInvalidException class description.
 *
 * @author quangle
 * @version 2024/06/23
 */
public class IdInvalidException extends RuntimeException{
    public IdInvalidException(String message) {
        super(message);
    }
}