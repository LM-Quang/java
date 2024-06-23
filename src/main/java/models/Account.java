package models;

import utils.Utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private String accountNumber;
    private double balance;
//    private String customerId;

    public Account() {}

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
//        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }

    public boolean isPremium() {
        return this.balance >= Utils.PREMIUM_POINT;
    }

    public void numberToString() {
        Locale vn = new Locale("vi", "VN");
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vn);

        String str = String.format("%38s", vndFormat.format(this.balance));
        System.out.println(this.accountNumber + " |" + str);
    }


}