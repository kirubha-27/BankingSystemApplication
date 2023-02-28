package com.banking.userlogin;

import com.banking.dto.Account;

public interface UserLoginViewControllerCallback {
    public void checkCredentials(int cif_number, String accountPassword);
    public Account currentAccount(int cifNumber);
}