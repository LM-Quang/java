package utils;

/**
 * MenuTemplate class description.
 *
 * @author quangle
 * @version 2024/07/17
 */
public class MenuTemplate {
    private static final String DIVIDER = "+-------------------+---------------------+-------------------+";

    public static void showMenu(String title, String... items) {
        System.out.println(DIVIDER);
        System.out.println(StringFormat.centerText(title));
        System.out.println(DIVIDER);
        for (String item: items) {
            System.out.println(StringFormat.alignLeftText(item));
        }
        System.out.println(DIVIDER);
    }
}