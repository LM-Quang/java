package models;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private String number;
    private double balance;

    public Account() {}

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPremium() {
        return this.balance >= Constant.PREMIUM_POINT;
    }

    public void printAccountInformation() {
        Locale vn = new Locale("vi", "VN");
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vn);

        String str = String.format("%49s", vndFormat.format(this.balance));
        System.out.println(this.number + " |" + str);
    }
}