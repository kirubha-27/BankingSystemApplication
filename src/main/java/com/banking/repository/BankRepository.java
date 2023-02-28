package com.banking.repository;

import com.banking.dto.Account;
import com.banking.dto.Transaction;
import com.banking.dto.UserCredential;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {
    public static BankRepository bankRepository;
    Map<String,String> branches = new HashMap<>();
    //private List<Account> accountList = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();
    private List<UserCredential> credentials = new ArrayList<>();
    private BankRepository(){

    }
    public static BankRepository getInstance(){
        if(bankRepository==null){
            bankRepository = new BankRepository();
            bankRepository.initialSetup();

        }
        return bankRepository;
    }

    public void initialSetup(){
        credentials.add(new UserCredential(66L,66,"IDIB0001",66L,"Kirubhakaran","pulivalam","thiruvarur","karankumar.kpk@gmail.com",6000000.00d,"66"));
        credentials.add(new UserCredential(67L,67,"IDID001",67L,"kiru","pulivalam","thiruvarur","k",5000d,"67"));

        branches.put("pulivalam","IDIDB000");
        branches.put("guduvanchery","IDIDB001");
        branches.put("tambaram","IDIDB002");
    }
    public List<Transaction> getTransactions(Account account){
        List<Transaction> transactionList = new ArrayList<>();
        for(Transaction transaction : transactions){
            if(account.getAccountNumber()==transaction.getAccountNumber()){
                transactionList.add(transaction);
            }
        }
        return transactionList;
    }
    public Account getAccount(int cif_number, String password){
        for(UserCredential userCredential : credentials){
            if(userCredential.getCif_number()==cif_number&& userCredential.getPassword().equals(password)){
                return userCredential;
            }
        }
        return null;
    }
    public Account setAccount(String accountHolderName,int cif_number,String ifscCode,long phoneNumber,String emailId,String branchAddress,String address,long accountNumber,String password){
        credentials.add(new UserCredential(accountNumber,cif_number,ifscCode,phoneNumber,accountHolderName,branchAddress,address,emailId,0.0,password));
        return credentials.get(credentials.size()-1);
    }
    public String getIfsc(String branchAddress){
        for(Map.Entry<String,String> entry:branches.entrySet()){
            if(entry.getKey().equals(branchAddress)){
                return (branches.get(entry.getKey()));
            }

        }
        return null;
    }

    public Account getAccount(int cif_number){
        //System.out.println(accountList);
        for(Account account : credentials){
            if(account.getCif_number()==cif_number){
                return account;
            }
        }
        return null;
    }
    //long accountNumber, LocalDate date, String status, long receiverAccountNumber, double transferAmount, double balance
    public Transaction setAccountBalance(double amountToBeTransfer,Account senderAccount, Account receiverAccount,long phoneNumber) {
        transactions.add(new Transaction(senderAccount.getAccountNumber(), LocalDate.now(), "Debited", receiverAccount.getAccountNumber(), amountToBeTransfer, senderAccount.getBankBalance() - amountToBeTransfer));

        senderAccount.setBankBalance(senderAccount.getBankBalance() - amountToBeTransfer);


        if (receiverAccount != null){
            transactions.add(new Transaction(receiverAccount.getAccountNumber(), LocalDate.now(), "Credited", senderAccount.getAccountNumber(), amountToBeTransfer, receiverAccount.getBankBalance() + amountToBeTransfer));
            receiverAccount.setBankBalance(receiverAccount.getBankBalance() + amountToBeTransfer);
        }
        return transactions.get(transactions.size()-1);
    }

    public Account getAccount(long accountNumber, long phoneNumber){
        for(Account account : credentials){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        return null;
    }
}
