package oop;

import models.Account;
import models.Bank;
import models.Customer;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
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
                        addCustomer();
                        break;
                    case "2":
                        addAccount();
                        break;
                    case "3":
                        displayCustomerList();
                        break;
                    case "4":
                        findCustomerByCustomerID();
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
        Customer customer = new Customer();

        System.out.print("Nhap ten khach hang: ");
        String customerName = SCAN.nextLine();
        customer.setName(customerName);

        System.out.print("Nhap so CCCD: ");
        String soCCCD;
        boolean flag = true;
        do {
            try {
                soCCCD = SCAN.nextLine();
                if (soCCCD.equals("No")) {
                    break;
                }
                customer.setCustomerId(soCCCD);
                BANK.addCustomer(customer);
                flag = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Vui long nhap lai hoac 'No' de thoat: ");
            }
        } while (flag);
    }

    public static void addAccount() {
        boolean kiemTraCCCD = true;
        System.out.print("Nhap CCCD khach hang: ");
        String soCCCD;
        do {
            soCCCD = SCAN.nextLine();
            if(soCCCD.equals("No")){
                return;
            }
            if(!BANK.isCustomerExisted(soCCCD)){
                System.out.println("So CCCD khong ton tai trong he thong.");
                System.out.print("Vui long nhap lai hoac 'No' de thoat: ");
            } else {
                kiemTraCCCD = false;
            }
        } while (kiemTraCCCD);

        Account account = new Account();
        String stk = nhapSTK();
        double soDu = nhapSoDu();
        account.setAccountNumber(stk);
        account.setBalance(soDu);

        BANK.addAccount(account);
//        BANK.addAccount(soCCCD, account);
    }

    public static void displayCustomerList() {
        for (Customer customer : BANK.getCustomers()) {
            customer.displayInformation();
            System.out.println();
        }
    }

    public static void findCustomerByCustomerID() {
        System.out.print("Nhap so CCCD can tim: ");
        String soCCCD = SCAN.nextLine();

        if (BANK.isCustomerExisted(soCCCD)) {
            Customer foundCustomer = new Customer();

            for (Customer customer : BANK.getCustomers()) {
                if (customer.getCustomerId().equals(soCCCD)) {
                    foundCustomer = customer;
                }
            }
            foundCustomer.displayInformation();
        } else {
            System.out.println("So CCCD khong ton tai");
        }
    }

    public static void findCustomerByName() {
        System.out.print("Nhap ten Khach hang can tim: ");
        String name = SCAN.nextLine();

        List<Customer> foundCustomers = new ArrayList<>();

        for (Customer customer : BANK.getCustomers()) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                foundCustomers.add(customer);
            }
        }
        if (foundCustomers.isEmpty()) {
            System.out.println("Khong co khach hang ten: " + name);
        } else {
            for (Customer customer : foundCustomers) {
                customer.displayInformation();
            }
        }
    }

    private static boolean isStringNumber(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean kiemTraTonTaiSTK(String stk){
        for(Customer customer: BANK.getCustomers()){
            for(Account account: customer.getAccounts()){
                if(account.getAccountNumber().equals(stk)){
                    return true;
                }
            }
        }
        return false;
    }

    public static String nhapSTK() {
        boolean flag = true;
        System.out.print("Nhap ma STK gom 6 chu so: ");
        String stk;
        do {
            stk = SCAN.nextLine();
            if(!isStringNumber(stk)||stk.length()!=6){
                System.out.println("So tai khoan khong hop le.");
                System.out.print("Vui long nhap lai: ");
            } else if(kiemTraTonTaiSTK(stk)){
                System.out.println("So tai khoan da ton tai.");
                System.out.print("Vui long nhap lai: ");
            } else {
                flag = false;
            }
        } while (flag);
        return stk;
    }

    public static double nhapSoDu() {
        System.out.print("Nhap so du: ");
        double soDu;
        boolean flag = true;
        do {
            soDu = SCAN.nextDouble();
            SCAN.nextLine();
            if (soDu >= 50000) {
                flag = false;
            } else {
                System.out.println("So du khong duoc nho hon 50.000vnd");
                System.out.print("Vui long nhap lai: ");
            }
        } while (flag);
        return soDu;
    }
}