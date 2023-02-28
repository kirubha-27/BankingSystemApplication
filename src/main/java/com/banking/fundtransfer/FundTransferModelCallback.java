package com.banking.fundtransfer;

import com.banking.dto.Account;

public interface FundTransferModelCallback {
    public void fundTransfer(double amountToBeTransfer, Account account, long accountNumber, long phoneNumber);
    public void getTransactionHistory(Account account);
}