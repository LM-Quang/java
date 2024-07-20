import models.Bank;
import format.MenuFormat;

import java.util.Scanner;

public class BasicOOP {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Bank BANK = new Bank();

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
                    BANK.addCustomer(SCAN);
                    break;
                case "2":
                    BANK.addAccount(SCAN);
                    break;
                case "3":
                    BANK.displayCustomerList();
                    break;
                case "4":
                    BANK.findCustomerByID(SCAN);
                    break;
                case "5":
                    BANK.findCustomerByName(SCAN);
                    break;
                default:
                    System.out.println("Invalid. Please choose again!");
            }
        } while (flag);
    }
    static void showMenu() {
        String str1 = "BANKING APPLICATION";
        String str2 = " 1. ADD NEW CUSTOMER";
        String str3 = " 2. ADD NEW ACCOUNT FOR CUSTOMER";
        String str4 = " 3. SHOW CUSTOMER LIST";
        String str5 = " 4. FIND BY CUSTOMER ID";
        String str6 = " 5. FIND BY CUSTOMER NAME";
        String str7 = " 0. EXIT";

        MenuFormat.showMenu(str1, str2, str3, str4, str5, str6, str7);
        System.out.print("Your choice: ");
    }
}