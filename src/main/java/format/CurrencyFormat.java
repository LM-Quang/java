package format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * CurrencyFormat class description.
 *
 * @author quangle
 * @version 2024/06/30
 */
public class CurrencyFormat {
    public static String getCurrencyFormat(String language, String country, double balance) {
        Locale vn = new Locale(language, country);
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vn);
        return vndFormat.format(balance);
    }
}