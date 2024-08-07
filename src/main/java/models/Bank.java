package models;

import format.CurrencyFormat;
import validation.IdValidation;
import validation.NumberValidation;

import java.util.*;

public class Bank {
    private final List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Scanner scanner) {
        System.out.print("INPUT CUSTOMER NAME: ");
        String customerName = scanner.nextLine();

        String customerId = inputCustomerId(scanner, false, "Customer ID already existed");
        if (customerId == null) return;

        Customer customer = new Customer(customerId, customerName);
        customers.add(customer);

        System.out.println("Added customer - " + customer.getName());
    }

    public void addAccount(Scanner scanner) {
        String customerId = inputCustomerId(scanner, true, "Customer ID doesn't exist");
        if (customerId == null) return;

        Account account = createAccount(scanner);

        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            customer.addAccount(account);
        }
    }

    public void displayCustomerList() {
        for (Customer customer : customers) {
            customer.displayInformation();
            System.out.println();
        }
    }

    public void findCustomerByID(Scanner scanner) {
        System.out.print("Input Customer ID to find: ");
        String customerId = scanner.nextLine();

        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            customer.displayInformation();
        } else {
            System.out.println("Customer ID doesn't exist");
        }
    }

    public void findCustomerByName(Scanner scanner) {
        System.out.print("Input Customer Name to find: ");
        String name = scanner.nextLine();

        List<Customer> foundCustomers = getCustomersByName(name);

        if (foundCustomers.isEmpty()) {
            System.out.println("Customer: " + name + " doesn't exist");
            return;
        }

        foundCustomers.forEach(Customer::displayInformation);
    }

    private Account createAccount(Scanner scanner) {
        Account account = new Account();

        String number = inputNumber(scanner);
        double balance = inputBalance(scanner);
        account.setNumber(number);
        account.setBalance(balance);

        return account;
    }

    private boolean isCustomerExisted(String customerId) {
        Customer customer = getCustomerById(customerId);
        return customer != null;
    }

    private boolean isAccountExisted(String accountNumber) {
        for (Customer customer: customers) {
            for (Account account: customer.getAccounts()) {
                if (accountNumber.equals(account.getNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Customer getCustomerById(String customerId) {
        for (Customer customer: customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    private List<Customer> getCustomersByName(String customerName) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(customerName.toLowerCase())) {
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }

    private String inputCustomerId(Scanner scanner, boolean isCustomerExisted, String errorMessage) {
        String customerId;

        do {
            System.out.print("INPUT CUSTOMER ID: ");
            customerId = scanner.nextLine();

            if (customerId.equalsIgnoreCase("no")) {
                customerId = null;
                break;
            }

            if (!IdValidation.isIdValid(customerId)) {
                System.out.println("Customer ID is invalid");
                System.out.println("Please try again or type 'No' to exit");
                continue;
            }

            if (isCustomerExisted(customerId) != isCustomerExisted) {
                System.out.println(errorMessage);
                System.out.println("Please try again or type 'No' to exit");
//                continue;
            }

//            return customerId;
        } while (true);

        return customerId;
    }

    private String inputNumber(Scanner scanner) {
        String number;
        do {
            System.out.print("Input a 6-digit number: ");
            number = scanner.nextLine();

            if (NumberValidation.isNumber(number) && number.length() == Constant.ACCOUNT_NUMBER_LENGTH && !isAccountExisted(number)) {
                break;
            }

            System.out.println("Invalid Account number. Please try again!");
        } while (true);
        return number;
    }

    private double inputBalance(Scanner scanner) {
        double balance;
        do {
            System.out.print("Input Balance: ");
            balance = scanner.nextDouble();
            scanner.nextLine();

            if (balance >= Constant.ACCOUNT_FLOOR_LIMIT_BALANCE) {
                break;
            }

            System.out.println("Balance must be at least "
                    + CurrencyFormat.getCurrencyFormat(Constant.LANGUAGE, Constant.COUNTRY, Constant.ACCOUNT_FLOOR_LIMIT_BALANCE)
                    + ". Please try again!");
        } while (true);
        return balance;
    }
}