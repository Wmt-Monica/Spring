package com.dreamplume.po;

/**
 * @Classname Transfer
 * @Description TODO
 * @Date 2021/3/17 9:03
 * @Created by 翊
 */
public class Transfer {
    private String userName;

    private int balance;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
