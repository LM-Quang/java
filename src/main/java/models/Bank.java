package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.id = String.valueOf(UUID.randomUUID());
        customers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer newCustomer) {
        customers.add(newCustomer);
        System.out.println("New customer was added");
    }

    public boolean isCustomerExisted(String customerId) {
        for (Customer c: customers) {
            if (c.getId().equals(customerId)) {
                return true;
            }
        }

        return false;
    }

    public void addAccount(String customerId, Account newAccount) {
        Customer customer = getCustomerById(customerId);
        customer.getAccounts().add(newAccount);
    }

    public boolean isAccountExisted(String accountNumber) {
        for (Customer customer: customers) {
            for (Account account: customer.getAccounts()) {
                if (accountNumber.equals(account.getNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Customer getCustomerById(String customerId) {
        for (Customer customer: customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomersByName(String customerName) {
        List<Customer> foundCustomers = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(customerName.toLowerCase())) {
                foundCustomers.add(customer);
            }
        }

        return foundCustomers;
    }
}