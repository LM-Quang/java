package utils;

import java.util.Scanner;

/**
 * GetUsernamePassword class description.
 *
 * @author quangle
 * @version 2024/07/16
 */
public class GetUsernamePassword {
    public static String[] getUsernamePassword(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        return new String[] {username, password};
    }
}