package oop;

import models.Bank;
import utils.Constant;
import utils.StringFormat;

import java.util.Scanner;

public class OOP {
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
        String str1 = StringFormat.centerText("BANKING APPLICATION");
        String str2 = String.format(Constant.STRING_FORMAT, " 1. ADD NEW CUSTOMER");
        String str3 = String.format(Constant.STRING_FORMAT, " 2. ADD NEW ACCOUNT FOR CUSTOMER");
        String str4 = String.format(Constant.STRING_FORMAT, " 3. SHOW CUSTOMER LIST");
        String str5 = String.format(Constant.STRING_FORMAT, " 4. FIND BY CUSTOMER ID");
        String str6 = String.format(Constant.STRING_FORMAT, " 5. FIND BY CUSTOMER NAME");
        String str7 = String.format(Constant.STRING_FORMAT, " 0. EXIT");

        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.println(str1);
        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println("+-------------------+---------------------+-------------------+");
        System.out.print("Your choice: ");
    }
}