package com.banking.userlogin;

import com.banking.dto.Account;
import com.banking.dto.Transaction;
import com.banking.repository.BankRepository;

public class UserLoginModel implements UserLoginModelCallback {
    UserLoginModelControllerCallback userLoginController;

    UserLoginModel(UserLoginModelControllerCallback userLoginController) {
        this.userLoginController = userLoginController;
    }
    public Account currentAccount(int cifNumber){
        return BankRepository.getInstance().getAccount(cifNumber);
    }
    public void checkCredentials(int cif_number, String accountPassword){
        Account account = BankRepository.getInstance().getAccount(cif_number,accountPassword);
        if(account!=null) {
            userLoginController.loginSuccess(account);
        }else{
            userLoginController.loginFailure("Invalid user credentials!!!");
        }
    }
}