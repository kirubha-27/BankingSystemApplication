package com.banking.createaccount;

import com.banking.dto.Account;

public class CreateAccountController implements CreateAccountViewControllerCallback, CreateAccountModelControllerCallback {
    private CreateAccountViewCallback createAccountView;
    private CreateAccountModelCallback createAccountModel;

    CreateAccountController(CreateAccountViewCallback createAccountView) {
        this.createAccountView = createAccountView;
        createAccountModel = new CreateAccountModel(this);
    }
    public void createNewAccount(String accountHolderName,long phoneNumber,String emailId,String branchAddress,String address,String password){
        createAccountModel.createNewAccount(accountHolderName,phoneNumber,emailId,branchAddress,address,password);
    }

    public void accountFailure(String errorMessage){
        createAccountView.accountFailure(errorMessage);
    }

    public void accountSuccess(Account account){
        createAccountView.accountSuccess(account);
    }
}