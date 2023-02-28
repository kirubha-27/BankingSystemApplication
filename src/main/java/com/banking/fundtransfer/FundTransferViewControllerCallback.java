package com.banking.fundtransfer;

import com.banking.dto.Account;

public interface FundTransferViewControllerCallback {
    public void transferFund(double amountToBeTransfer,Account account,long accountNumber, long phoneNumber);
    public void getTransactionHistory(Account account);
}