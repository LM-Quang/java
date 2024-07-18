package utils;

import java.util.Random;

/**
 * VerificationCode class description.
 *
 * @author quangle
 * @version 2024/07/17
 */
public class VerificationCode {
    private static final int VERIFICATION_CODE_LENGTH = 6;
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER = "0123456789";

    // Random number from 100 -> 999
    public static String createSimpleVerificationCode() {
        int random = (int) (Math.random() * 900 + 100);

        return String.valueOf(random);
    }

    // Random code with 6-digit code
    public static String createComplexVerificationCode() {
        String combination = UPPER + LOWER + NUMBER;
        char[] password = new char[VERIFICATION_CODE_LENGTH];
        Random r = new Random();

        for (int i = 0; i < VERIFICATION_CODE_LENGTH; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }

        return new String(password);
    }
}