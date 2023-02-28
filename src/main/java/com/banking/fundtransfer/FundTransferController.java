package com.banking.fundtransfer;

import com.banking.dto.Account;
import com.banking.dto.Transaction;

import java.util.List;

public class FundTransferController implements FundTransferViewControllerCallback, FundTransferModelControllerCallback {
    private FundTransferViewCallback fundTransferView;
    private FundTransferModelCallback fundTransferModel;

    FundTransferController(FundTransferViewCallback fundTransferView) {
        this.fundTransferView = fundTransferView;
        fundTransferModel = new FundTransferModel(this);
    }
    public void transferFund(double amountToBeTransfer,Account account,long accountNumber, long phoneNumber){
        fundTransferModel.fundTransfer(amountToBeTransfer,account,accountNumber,phoneNumber);
    }
    public void fundTransferSuccess(Transaction transaction){
        fundTransferView.fundTransferSuccess(transaction);
    }
    public void getTransactionHistory(Account account){
        fundTransferModel.getTransactionHistory(account);
    }

    public void getTransactionSuccess(List<Transaction> transactionList){
        fundTransferView.getTransactionSuccess(transactionList);
    }

    public void getTransactionFailure(String errorMessage){
        fundTransferView.getTransactionFailure(errorMessage);
    }

    public void fundTransferFailure(String errorMessage){
        fundTransferView.fundTransferFailure(errorMessage);
    }

}