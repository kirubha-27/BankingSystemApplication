package com.banking.dto;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private  long accountNumber;

    private LocalDate date;
    private String status;
    private long receiverAccountNumber;
    private double transferAmount;
    private double balance;

    public Transaction(long accountNumber, LocalDate date, String status, long receiverAccountNumber, double transferAmount, double balance) {
        this.accountNumber = accountNumber;

        this.date = date;
        this.status = status;
        this.receiverAccountNumber = receiverAccountNumber;
        this.transferAmount = transferAmount;
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(long receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountNumber=" + accountNumber +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", receiverAccountNumber=" + receiverAccountNumber +
                ", transferAmount=" + transferAmount +
                ", balance=" + balance +
                '}';
    }
}
