package com.banking.createaccount;

import com.banking.dto.Account;
import com.banking.repository.BankRepository;

public class CreateAccountModel implements CreateAccountModelCallback {
    private static long generateAccountNumber = 6684965786l;
    private static int generateCifNumber = 4563256;

    CreateAccountModelControllerCallback createAccountController;

    CreateAccountModel(CreateAccountModelControllerCallback createAccountController) {
        this.createAccountController = createAccountController;
    }

    public void createNewAccount(String accountHolderName,long phoneNumber,String emailId,String branchAddress,String address,String password){
        String ifscCode = BankRepository.getInstance().getIfsc(branchAddress);
        if(ifscCode==null){
            createAccountController.accountFailure("The branch is not in this location");
        }else {
            Account account = BankRepository.getInstance().setAccount(accountHolderName, ++generateCifNumber, ifscCode, phoneNumber, emailId, branchAddress, address, ++generateAccountNumber, password);
            createAccountController.accountSuccess(account);
        }
    }
}