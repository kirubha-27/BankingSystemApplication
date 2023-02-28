package com.banking.fundtransfer;

import com.banking.dto.Account;
import com.banking.dto.Transaction;
import com.banking.repository.BankRepository;

import java.util.List;

public class FundTransferModel implements FundTransferModelCallback {
    FundTransferModelControllerCallback fundTransferController;

    FundTransferModel(FundTransferModelControllerCallback fundTransferController) {
        this.fundTransferController = fundTransferController;
    }

    public void fundTransfer(double amountToBeTransfer,Account account,long accountNumber, long phoneNumber){
        if(amountToBeTransfer>account.getBankBalance()||amountToBeTransfer<=0){
            fundTransferController.fundTransferFailure("Insufficient funds");
            return;
        }

        Account accountToBeTransfer = BankRepository.getInstance().getAccount(accountNumber,phoneNumber);
        if(accountToBeTransfer!=null){

            Transaction transaction = BankRepository.getInstance().setAccountBalance(amountToBeTransfer,account,accountToBeTransfer,phoneNumber);
            fundTransferController.fundTransferSuccess(transaction);
        }else{
            BankRepository.getInstance().setAccountBalance(amountToBeTransfer,account, null,phoneNumber);
        }
    }

    public void getTransactionHistory(Account account){
        List<Transaction> transactionList = BankRepository.getInstance().getTransactions(account);
        if(transactionList!=null){
            fundTransferController.getTransactionSuccess(transactionList);
        }else{
            fundTransferController.getTransactionFailure("There is no transaction history in this account");
        }
    }
}