package utils;

/**
 * StringFormat class description.
 *
 * @author quangle
 * @version 2024/06/30
 */
public class StringFormat {
    private static final int STRING_TOTAL_LENGTH = 61;
    private static final String STRING_FORMAT = "|%-" + STRING_TOTAL_LENGTH + "s|";

    public static String centerText(String text) {
        int padding = (STRING_TOTAL_LENGTH - text.length()) / 2;
        text = (text.length() % 2 == 0) ? text + " " : text;
        return String.format("|%" + padding + "s%s%" + padding + "s|", "", text, "");
    }

    public static String alignLeftText(String text) {
        return String.format(STRING_FORMAT, text);
    }
}