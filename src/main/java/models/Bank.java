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
}