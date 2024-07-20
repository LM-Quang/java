package validation;

/**
 * NumberValidation class description.
 *
 * @author quangle
 * @version 2024/06/30
 */
public class NumberValidation {
    public static boolean isNumber(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}