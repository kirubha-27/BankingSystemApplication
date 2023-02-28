package com.banking.createaccount;

import com.banking.dto.Account;

public interface CreateAccountViewCallback {
    public void accountFailure(String errorMessage);
    public void accountSuccess(Account account);
}