package com.banking.userlogin;

import com.banking.dto.Account;

public interface UserLoginModelControllerCallback {
    public void loginSuccess(Account account);
    public void loginFailure(String errorMessage);
}