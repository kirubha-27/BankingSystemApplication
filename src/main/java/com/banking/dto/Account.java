package com.banking.dto;

import java.util.List;

public class Account {
    private long accountNumber;
    private int cif_number;
    private String ifscCode;

    private long phoneNumber;

    private String accountHolderName;
    private String branchAddress;
    private String address;
    private String emailId;
    private double bankBalance;



    public Account(long accountNumber, int cif_number, String ifscCode, long phoneNumber, String accountHolderName, String branchAddress, String address, String emailId, double bankBalance) {
        this.accountNumber = accountNumber;
        this.cif_number = cif_number;
        this.ifscCode = ifscCode;
        this.phoneNumber = phoneNumber;
        this.accountHolderName = accountHolderName;
        this.branchAddress = branchAddress;
        this.address = address;
        this.emailId = emailId;
        this.bankBalance = bankBalance;

    }



    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCif_number() {
        return cif_number;
    }

    public void setCif_number(int cif_number) {
        this.cif_number = cif_number;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", cif_number=" + cif_number +
                ", ifscCode='" + ifscCode + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                ", address='" + address + '\'' +
                ", emailId='" + emailId + '\'' +
                ", bankBalance=" + bankBalance +
                '}';
    }
}
