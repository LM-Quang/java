package utils;

/**
 * StringFormat class description.
 *
 * @author quangle
 * @version 2024/06/30
 */
public class StringFormat {
    public static String centerText(String text) {
        int padding = (Constant.STRING_TOTAL_LENGTH - text.length()) / 2;
        text = (text.length() % 2 == 0) ? text + " " : text;
        return String.format("|%" + padding + "s%s%" + padding + "s|", "", text, "");
    }
}