package core;

import utils.Utils;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Core {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Integer VERIFICATION_CODE_LENGTH = 6;
    private static final Integer STRING_TOTAL_LENGTH = 61;
    private static final String STRING_FORMAT = "|%-" + STRING_TOTAL_LENGTH + "s|";

    //     Key: PROVINCE_CODE,  Value: PROVINCE
    private static final Map<String, String> PROVINCE_CODE_LIST = Utils.provinceCodeListInitialize();

    //     Key: GENDER_CODE,  Value: First 2 numbers of the CENTURY
    private static final Map<String, String> GENDER_CODE_LIST = Utils.genderCodeListInitialize();

    public static void main(String[] args) {
        boolean flag = true;
        do {
            showMenu();
            String chose = SCAN.nextLine();
            switch (chose) {
                case "0":
                    flag = false;
                    break;
                case "1":
                    String verificationCode = createVerificationCode();
                    if (isVerificationCodeValid(verificationCode)) {
                        checkCitizenIdentificationInformation();
                    }
                    break;
                default:
                    System.out.println("Invalid. Please choose again!");
            }
        } while (flag);
    }
    static String centerText(String text) {
        int padding = (STRING_TOTAL_LENGTH - text.length()) / 2;
        text = (text.length() % 2 == 0) ? text + " " : text;
        return String.format("|%" + padding + "s%s%" + padding + "s|", "", text, "");
    }
    static void showMenu() {
        String str1 = centerText("CHECK CITIZENSHIP IDENTIFICATION NUMBER");
        String str2 = String.format(STRING_FORMAT, " 1. CHECK YOUR CITIZENSHIP IDENTIFICATION NUMBER INFORMATION");
        String str3 = String.format(STRING_FORMAT, " 0. EXIT");

        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.println(str1);
        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.println(str2);
        System.out.println(str3);
        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.print("Your choice: ");
    }

    static String createVerificationCode() {
        String str1 = centerText("CREATE VERIFICATION CODE");
        String str2 = String.format(STRING_FORMAT, " 1. Simple Verification Code");
        String str3 = String.format(STRING_FORMAT, " 2. Complex Verification Code");

        String chose;
        do {
            System.out.println("+-------------------+---------------------+-------------------+");
            System.out.println(str1);
            System.out.println("+-------------------+---------------------+-------------------+");
            System.out.println(str2);
            System.out.println(str3);
            System.out.println("+-------------------+---------------------+-------------------+");
            System.out.print("Your choice: ");

            chose = SCAN.nextLine();
            switch (chose) {
                case "1":
                    return createSimpleVerificationCode();
                case "2":
                    return createComplexVerificationCode();
                default:
                    System.out.println("Invalid. Please choose again!");
            }
        } while (true);
    }

    static String createSimpleVerificationCode() {
        // Random num from 100 -> 999
        int random = (int) (Math.random() * 900 + 100);

        return String.valueOf(random);
    }

    static String createComplexVerificationCode() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String combination = upper + lower + number;
        char[] password = new char[VERIFICATION_CODE_LENGTH];
        Random r = new Random();

        for (int i = 0; i < VERIFICATION_CODE_LENGTH; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }

        return new String(password);
    }

    static boolean isVerificationCodeValid(String verificationCode) {
        System.out.println("Verification Code: " + verificationCode);
        String inputCode;
        do {
            System.out.print("Your code: ");
            inputCode = SCAN.nextLine();
            
            if (inputCode.equals("Q")) {
                return false;
            }
            
            if (inputCode.equals(verificationCode)) {
                return true;
            }
            
            System.out.println("Invalid. Please try again or Type in Q to Quit");
        } while (true);
    }

    static void checkCitizenIdentificationInformation() {
        String idNumber;
        System.out.print("Input your Citizenship ID Number: ");
        do {
            idNumber = SCAN.nextLine();
            
            if (idNumber.equals("No")) {
                return;
            } 
            
            if (checkCitizenIdentificationNumber(idNumber)) {
                showInformation(idNumber);
                return;
            }
            
            System.out.println("Invalid Citizenship ID Number.");
            System.out.print("Please try again or type \'No\' to exit: ");
        } while (true);
    }
    
    public static boolean checkCitizenIdentificationNumber(String idNumber) {
        /*
         * Kiểm tra số CCCD
         * 1. Độ dài đúng bằng 12 kí tự
         * 2. Tất cả các ký tự phải là số từ [0-9]
         * 3. Kiểm tra mã tỉnh: tách 3 kí tự đầu của CCCD sau đó so với mảng mã tĩnh
         * */
        
        /*
        * Check Citizen Identification Number
        * 1. Has to be a 12-character length
        * 2. Each character has to be a number from 0 to 9
        * 3. Check Province Code: Compare the first 3 characters with Province Code
        * */
        if (idNumber.length() != 12) {
            return false;
        }
        
        if (!isNumber(idNumber)) {
            return false;
        }
        
        String provinceCode = idNumber.substring(0, 3);
        return PROVINCE_CODE_LIST.containsKey(provinceCode);
    }
    
    public static boolean isNumber(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void showInformation(String idNumber) {
        String provinceCode = idNumber.substring(0, 3);
        String genderCode = idNumber.substring(3, 4);
        String yearOfBirthCode = idNumber.substring(4, 6);
        String randomCode = idNumber.substring(6);

        String str1 = centerText("YOUR CITIZENSHIP INFORMATION");
        String str2 = String.format(STRING_FORMAT, " Place of Birth: " + PROVINCE_CODE_LIST.get(provinceCode));
        String str3 = String.format(STRING_FORMAT, " Year of Birth: " + GENDER_CODE_LIST.get(genderCode) + yearOfBirthCode);
        String gender = Integer.parseInt(genderCode) % 2 == 0 ? "Male" : "Female";
        String str4 = String.format(STRING_FORMAT, " Gender: " + gender);
        String str5 = String.format(STRING_FORMAT, " Random Number: " + randomCode);

        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.println(str1);
        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println("+-------------------+---------------------+-------------------+");
    }
}