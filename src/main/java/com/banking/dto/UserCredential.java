package com.banking.dto;

public class UserCredential extends Account {
    private String password;


    public UserCredential(long accountNumber, int cif_number, String ifscCode, long phoneNumber, String accountHolderName, String branchAddress, String address, String emailId, double bankBalance, String password) {
        super(accountNumber, cif_number, ifscCode, phoneNumber, accountHolderName, branchAddress, address, emailId, bankBalance);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
