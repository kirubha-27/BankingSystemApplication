package com.banking.fundtransfer;

import com.banking.dto.Transaction;

import java.util.List;

public interface FundTransferViewCallback {
    public void getTransactionSuccess(List<Transaction> transactionList);
    public void getTransactionFailure(String errorMessage);

    public void fundTransferFailure(String errorMessage);

    public void fundTransferSuccess(Transaction transaction);
}