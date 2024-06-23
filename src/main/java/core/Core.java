package core;

import utils.Utils;

import java.util.Random;
import java.util.Scanner;

public class Core {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Integer VERIFICATION_CODE_LENGTH = 6;

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

    public static void showMenu() {
        String str1 = Utils.centerText("CHECK CITIZENSHIP IDENTIFICATION NUMBER");
        String str2 = String.format(Utils.STRING_FORMAT, " 1. CHECK YOUR CITIZENSHIP IDENTIFICATION NUMBER INFORMATION");
        String str3 = String.format(Utils.STRING_FORMAT, " 0. EXIT");

        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.println(str1);
        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.println(str2);
        System.out.println(str3);
        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.print("Your choice: ");
    }

    public static String createVerificationCode() {
        String str1 = Utils.centerText("CREATE VERIFICATION CODE");
        String str2 = String.format(Utils.STRING_FORMAT, " 1. Simple Verification Code");
        String str3 = String.format(Utils.STRING_FORMAT, " 2. Complex Verification Code");

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

    // Random num from 100 -> 999
    public static String createSimpleVerificationCode() {
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

            if (Utils.isCitizenshipIDValid(idNumber)) {
                showInformation(idNumber);
                return;
            }
            
            System.out.println("Invalid Citizenship ID Number.");
            System.out.print("Please try again or type 'No' to exit: ");
        } while (true);
    }

    public static void showInformation(String idNumber) {
        String provinceCode = idNumber.substring(0, 3);
        String genderCode = idNumber.substring(3, 4);
        String yearOfBirthCode = idNumber.substring(4, 6);
        String randomCode = idNumber.substring(6);

        String str1 = Utils.centerText("YOUR CITIZENSHIP INFORMATION");
        String str2 = String.format(Utils.STRING_FORMAT, " Place of Birth: " + Utils.PROVINCE_CODE_LIST.get(provinceCode));
        String str3 = String.format(Utils.STRING_FORMAT, " Year of Birth: " + Utils.GENDER_CODE_LIST.get(genderCode) + yearOfBirthCode);
        String gender = Integer.parseInt(genderCode) % 2 == 0 ? "Male" : "Female";
        String str4 = String.format(Utils.STRING_FORMAT, " Gender: " + gender);
        String str5 = String.format(Utils.STRING_FORMAT, " Random Number: " + randomCode);

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