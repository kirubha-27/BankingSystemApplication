package com.banking.userlogin;

import com.banking.dto.Account;

public class UserLoginController implements UserLoginViewControllerCallback, UserLoginModelControllerCallback {
    private UserLoginViewCallback userLoginView;
    private UserLoginModelCallback userLoginModel;

    UserLoginController(UserLoginViewCallback userLoginView) {
        this.userLoginView = userLoginView;
        userLoginModel = new UserLoginModel(this);
    }

    public void checkCredentials(int cif_number, String accountPassword){
        userLoginModel.checkCredentials(cif_number,accountPassword);
    }

    public Account currentAccount(int cifNumber){
        return userLoginModel.currentAccount(cifNumber);
    }
    public void loginSuccess(Account account){
        userLoginView.loginSuccess(account);
    }
    public void loginFailure(String errorMessage){
        userLoginView.loginFailure(errorMessage);
    }
}