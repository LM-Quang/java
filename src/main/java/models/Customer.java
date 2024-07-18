package models;

import utils.CurrencyFormat;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static final String LANGUAGE = "vi";
    private static final String COUNTRY = "VN";

    private String id;
    private String name;
    private final List<Account> accounts;

    public Customer() {
        accounts = new ArrayList<>();
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        accounts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws RuntimeException{
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremium() {
        for (Account account: accounts) {
            if (account.isPremium()) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    public boolean isAccountExisted(Account account) {
        for (Account acc: accounts) {
            if (acc.getNumber().equals(account.getNumber())) {
                return true;
            }
        }
        return false;
    }

    public double getBalance() {
        double balance = 0;
        for (Account account: accounts) {
            balance += account.getBalance();
        }
        return balance;
    }

    public void displayInformation() {
        String id = String.format("%-13s", this.id);
        String name = String.format("| %-16s", this.name);
        String type = String.format(" | %-8s", isPremium() ? "Premium" : "Normal");
        String totalBalance = String.format("|%20s", CurrencyFormat.getCurrencyFormat(LANGUAGE, COUNTRY, getBalance()));
        String str1 = id + name + type + totalBalance;
        System.out.println(str1);

        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            String str2 = String.format("%-6d", i + 1);
            System.out.print(str2);
            account.printAccountInformation();
        }
    }
}