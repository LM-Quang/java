package oop;

import models.Customer;

public class OOP {
    public static void main(String[] args) {
        Customer customer = new Customer();
        try {
            customer.setId("08209512347");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}