package models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final List<Account> accounts;
//    private boolean isPremium;
//    private int numOfPremiumAccount;

    public Customer() {
        accounts = new ArrayList<>();
//        isPremium = false;
//        numOfPremiumAccount = 0;
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
        
    }
}