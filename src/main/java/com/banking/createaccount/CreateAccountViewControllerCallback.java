package com.banking.createaccount;

public interface CreateAccountViewControllerCallback {
    public void createNewAccount(String accountHolderName,long phoneNumber,String emailId,String branchAddress,String address,String password);
}