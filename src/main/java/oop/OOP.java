package oop;

import models.Account;
import models.Bank;
import models.Customer;
import utils.Utils;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class OOP {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Bank BANK = new Bank();
    private static final Integer ACCOUNT_NUMBER_LENGTH = 6;
    private static final Integer ACCOUNT_FLOOR_LIMIT_BALANCE = 50000;
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
                    addCustomer();
                    break;
                case "2":
                    addAccount();
                    break;
                case "3":
                    displayCustomerList();
                    break;
                case "4":
                    findCustomerByID();
                    break;
                case "5":
                    findCustomerByName();
                    break;
                default:
                    System.out.println("Invalid. Please choose again!");
            }
        } while (flag);
    }
    
    public static void showMenu() {
        String str1 = Utils.centerText("BANKING APPLICATION");
        String str2 = String.format(Utils.STRING_FORMAT, " 1. ADD NEW CUSTOMER");
        String str3 = String.format(Utils.STRING_FORMAT, " 2. ADD NEW ACCOUNT FOR CUSTOMER");
        String str4 = String.format(Utils.STRING_FORMAT, " 3. SHOW CUSTOMER LIST");
        String str5 = String.format(Utils.STRING_FORMAT, " 4. FIND BY CUSTOMER ID");
        String str6 = String.format(Utils.STRING_FORMAT, " 5. FIND BY CUSTOMER NAME");
        String str7 = String.format(Utils.STRING_FORMAT, " 0. EXIT");

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

    public static void addCustomer() {
        System.out.print("INPUT CUSTOMER NAME: ");
        String customerName = SCAN.nextLine();

        String customerId;
        do {
            System.out.print("INPUT CUSTOMER ID: ");
            customerId = SCAN.nextLine();

            if (customerId.equals("No")) {
                return;
            }

            if (Utils.isIdValid(customerId) && !BANK.isCustomerExisted(customerId)) {
                break;
            }

            System.out.println("Invalid ID. Please try again or type 'No' to exit");
        } while (true);

        Customer customer = new Customer(customerId, customerName);
        BANK.addCustomer(customer);
    }

    public static void addAccount() {
        String customerId;
        do {
            System.out.print("INPUT CUSTOMER ID: ");
            customerId = SCAN.nextLine();

            if (customerId.equals("No")){
                return;
            }

            if (Utils.isIdValid(customerId) && BANK.isCustomerExisted(customerId)){
                break;
            }

            System.out.println("Invalid ID. Please try again or type 'No' to exit");
        } while (true);

        Account account = new Account();
        String number = inputNumber();
        double balance = inputBalance();
        account.setNumber(number);
        account.setBalance(balance);

        BANK.addAccount(customerId, account);
    }

    public static String inputNumber() {
        String number;
        do {
            System.out.print("Input a 6-digit number: ");
            number = SCAN.nextLine();

            if (Utils.isNumber(number) && number.length() == ACCOUNT_NUMBER_LENGTH && !BANK.isAccountExisted(number)) {
                break;
            }

            System.out.println("Invalid Account number. Please try again!");
        } while (true);
        return number;
    }

    public static double inputBalance() {
        double balance;
        do {
            System.out.print("Input Balance: ");
            balance = SCAN.nextDouble();
            SCAN.nextLine();

            if (balance >= ACCOUNT_FLOOR_LIMIT_BALANCE) {
                break;
            }

            System.out.print("Balance must be at least "
                            + getCurrencyFormat(ACCOUNT_FLOOR_LIMIT_BALANCE)
                            + ". Please try again!");
        } while (true);
        return balance;
    }

    public static void displayCustomerList() {
        for (Customer customer : BANK.getCustomers()) {
            customer.displayInformation();
            System.out.println();
        }
    }

    public static void findCustomerByID() {
        System.out.print("Input Customer ID to find: ");
        String customerId = SCAN.nextLine();

        if (!BANK.isCustomerExisted(customerId)) {
            System.out.println("Customer ID doesn't exist");
            return;
        }

        Customer foundCustomer = BANK.getCustomerById(customerId);
        foundCustomer.displayInformation();
    }

    public static void findCustomerByName() {
        System.out.print("Input Customer's Name to find: ");
        String name = SCAN.nextLine();

        List<Customer> foundCustomers = BANK.getCustomersByName(name);

        if (foundCustomers.isEmpty()) {
            System.out.println("Customer: " + name + " doesn't exist");
            return;
        }

        for (Customer customer : foundCustomers) {
            customer.displayInformation();
        }
    }

    public static String getCurrencyFormat(int balance) {
        Locale vn = new Locale("vi", "VN");
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vn);

        return vndFormat.format(balance);
    }
}