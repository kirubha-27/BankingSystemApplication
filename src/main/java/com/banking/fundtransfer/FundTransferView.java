package com.banking.fundtransfer;

import com.banking.dto.Account;
import com.banking.dto.Transaction;
import com.banking.util.Read;

import java.util.List;
import java.util.Scanner;

public class FundTransferView implements FundTransferViewCallback {
    private FundTransferViewControllerCallback fundTransferController;
    private Scanner scanner = new Scanner(System.in);

    public FundTransferView() {
        fundTransferController = new FundTransferController(this);
    }
    public void create(Account account){
        transferFund(account);
    }
    private void transferFund(Account account){
        long accountNumber = 0;
        try {
            accountNumber = Read.changeToLong(Read.input("Enter Receiver Account Number:"));
        }catch (NumberFormatException e){
            System.out.println("Enter valid fields");
            transferFund(account);
        }
        long phoneNumber=0;
        try {
            phoneNumber = Read.changeToLong(Read.input("Enter The Phone Number:"));
        }catch (NumberFormatException e){
            System.out.println("Enter valid fields");
            transferFund(account);
        }
        double amountToBeTransfer = 0;
        try {
            amountToBeTransfer = Read.changeToDouble(Read.input("Enter Amount:"));
        }catch (NumberFormatException e){
            System.out.println("Enter valid fields");
            transferFund(account);
        }
        fundTransferController.transferFund(amountToBeTransfer,account,accountNumber,phoneNumber);

    }
    private void getTransactionHistory(Account account){
        fundTransferController.getTransactionHistory(account);
    }
    public void showStatement(Account account){
        this.getTransactionHistory(account);
    }
    private void showFunds(Account account){
        System.out.println("------>FUNDS<--------");
        System.out.println("Account Number: "+account.getAccountNumber());
        System.out.println("Account Holder Name: "+account.getAccountHolderName());
        System.out.println("Bank Balance: "+account.getBankBalance());
        System.out.println();
    }
    public void show(Account account){
        showFunds(account);
    }

    public void getTransactionSuccess(List<Transaction> transactionList){
        this.showTransaction(transactionList);
    }
    public void showTransaction(List<Transaction> transactionList){
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|   from acc      to acc        date          status       amount      balance  |");
        System.out.println("---------------------------------------------------------------------------------");
        for(Transaction transaction : transactionList){
            System.out.println("|   "+transaction.getAccountNumber()+"      "+transaction.getReceiverAccountNumber()+"     "+transaction.getDate()+"         "+transaction.getStatus()+"      "+transaction.getTransferAmount()+"      "+transaction.getBalance()+"   |");
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void getTransactionFailure(String errorMessage){
        System.out.println(errorMessage);
    }
    public void fundTransferFailure(String errorMessage){
        System.out.println(errorMessage);
    }
    public void fundTransferSuccess(Transaction transaction){
        System.out.println("-----------Bank Statement------------");
        System.out.println(transaction.getTransferAmount()+" debited from "+transaction.getAccountNumber()+" to "+transaction.getReceiverAccountNumber()+" successfully");
        System.out.println("Date: "+transaction.getDate());
        System.out.println("--------------------------------------");
    }
}    
