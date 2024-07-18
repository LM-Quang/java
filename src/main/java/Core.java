import utils.*;

import java.util.Map;
import java.util.Scanner;

public class Core {
    private static final Scanner SCAN = new Scanner(System.in);

    //     Key: PROVINCE_CODE,  Value: PROVINCE
    private static final Map<String, String> PROVINCE_CODE_LIST = ProvinceCodeList.provinceCodeListInitialize();

    //     Key: GENDER_CODE,  Value: First 2 numbers of the CENTURY
    private static final Map<String, String> GENDER_CODE_LIST = GenderCodeList.genderCodeListInitialize();

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

    private static void showMenu() {
        String title = "CHECK IDENTIFICATION NUMBER";
        String item1 = " 1. Check Your ID Number Information";
        String item2 = " 0. Exit";

        MenuTemplate.showMenu(title, item1, item2);
        System.out.print("Your choice: ");
    }

    private static String createVerificationCode() {
        String title = "CREATE VERIFICATION CODE";
        String item1 = " 1. Simple Verification Code";
        String item2 = " 2. Complex Verification Code";

        String chose;
        do {
            MenuTemplate.showMenu(title, item1, item2);
            System.out.print("Your choice: ");

            chose = SCAN.nextLine();
            switch (chose) {
                case "1":
                    return VerificationCode.createSimpleVerificationCode();
                case "2":
                    return VerificationCode.createComplexVerificationCode();
                default:
                    System.out.println("Invalid. Please choose again!");
            }
        } while (true);
    }

    private static boolean isVerificationCodeValid(String verificationCode) {
        System.out.println("Verification Code: " + verificationCode);
        String inputCode;
        do {
            System.out.print("Your code: ");
            inputCode = SCAN.nextLine();
            
            if (inputCode.equalsIgnoreCase("q")) {
                return false;
            }
            
            if (inputCode.equals(verificationCode)) {
                return true;
            }

            System.out.println("Invalid. Please try again or Type in Q to Quit");
        } while (true);
    }

    private static void checkCitizenIdentificationInformation() {
        String idNumber;
        do {
            System.out.print("Input your ID Number: ");
            idNumber = SCAN.nextLine();
            
            if (idNumber.equalsIgnoreCase("q")) {
                return;
            }

            if (IdValidation.isIdValid(idNumber)) {
                showInformation(idNumber);
                return;
            }
            
            System.out.println("Invalid ID Number.");
            System.out.println("Please try again or Type in 'Q' to Quit");
        } while (true);
    }

    private static void showInformation(String idNumber) {
        String provinceCode = idNumber.substring(0, 3);
        String genderCode = idNumber.substring(3, 4);
        String yearOfBirthCode = idNumber.substring(4, 6);
        String randomCode = idNumber.substring(6);
        String gender = Integer.parseInt(genderCode) % 2 == 0 ? "Male" : "Female";

        String title = "YOUR CITIZENSHIP INFORMATION";
        String item1 = " Place of Birth: " + PROVINCE_CODE_LIST.get(provinceCode);
        String item2 = " Year of Birth: " + GENDER_CODE_LIST.get(genderCode) + yearOfBirthCode;
        String item3 = " Gender: " + gender;
        String item4 = " Random Number: " + randomCode;

        MenuTemplate.showMenu(title, item1, item2, item3, item4);
    }
}