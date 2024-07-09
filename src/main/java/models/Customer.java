package models;

import utils.Constant;
import utils.CurrencyFormat;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private final List<Account> accounts;
//    private boolean isPremium;
//    private int numOfPremiumAccount;

    public Customer() {
        accounts = new ArrayList<>();
//        isPremium = false;
//        numOfPremiumAccount = 0;
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

//    public boolean isPremium() {
//        return isPremium;
//    }
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
        String totalBalance = String.format("|%20s", CurrencyFormat.getCurrencyFormat(Constant.LANGUAGE, Constant.COUNTRY, getBalance()));
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