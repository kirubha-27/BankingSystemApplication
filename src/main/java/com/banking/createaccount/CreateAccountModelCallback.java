package com.banking.createaccount;

public interface CreateAccountModelCallback {
    public void createNewAccount(String accountHolderName,long phoneNumber,String emailId,String branchAddress,String address,String password);
}