import utils.*;

public class Core {
    public static void main(String[] args) {
        boolean flag = true;
        do {
            showMenu();
            String chose = Constant.SCAN.nextLine();
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
        String title = StringFormat.centerText("CHECK IDENTIFICATION NUMBER");
        String item1 = String.format(Constant.STRING_FORMAT, " 1. Check Your ID Number Information");
        String item2 = String.format(Constant.STRING_FORMAT, " 0. Exit");

        MenuTemplate.getMenuTemplate(title, item1, item2);
        System.out.print("Your choice: ");
    }

    private static String createVerificationCode() {
        String title = StringFormat.centerText("CREATE VERIFICATION CODE");
        String item1 = String.format(Constant.STRING_FORMAT, " 1. Simple Verification Code");
        String item2 = String.format(Constant.STRING_FORMAT, " 2. Complex Verification Code");

        String chose;
        do {
            MenuTemplate.getMenuTemplate(title, item1, item2);
            System.out.print("Your choice: ");

            chose = Constant.SCAN.nextLine();
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
            inputCode = Constant.SCAN.nextLine();
            
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
            idNumber = Constant.SCAN.nextLine();
            
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

        String title = StringFormat.centerText("YOUR CITIZENSHIP INFORMATION");
        String item1 = String.format(Constant.STRING_FORMAT, " Place of Birth: " + Constant.PROVINCE_CODE_LIST.get(provinceCode));
        String item2 = String.format(Constant.STRING_FORMAT, " Year of Birth: " + Constant.GENDER_CODE_LIST.get(genderCode) + yearOfBirthCode);
        String gender = Integer.parseInt(genderCode) % 2 == 0 ? "Male" : "Female";
        String item3 = String.format(Constant.STRING_FORMAT, " Gender: " + gender);
        String item4 = String.format(Constant.STRING_FORMAT, " Random Number: " + randomCode);

        MenuTemplate.getMenuTemplate(title, item1, item2, item3, item4);
    }
}