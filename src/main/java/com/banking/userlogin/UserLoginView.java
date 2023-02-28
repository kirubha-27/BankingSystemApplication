package com.banking.userlogin;

import com.banking.dto.Account;

import com.banking.fundtransfer.FundTransferView;
import com.banking.util.Read;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserLoginView implements UserLoginViewCallback {
    public int cif_number;
    private UserLoginViewControllerCallback userLoginController;

    private Scanner scanner = new Scanner(System.in);

    public UserLoginView() {
        userLoginController = new UserLoginController(this);
    }

    private void checkForLogin(){
        System.out.print("Enter the CIF code: ");
        cif_number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the password: ");
        String accountPassword = scanner.nextLine();
        userLoginController.checkCredentials(cif_number,accountPassword);
    }
    public void create(){
        checkForLogin();
    }
    public void loginOption(){
        boolean flag = true;
        while(flag){

            System.out.println("1.Fund Transfer");
            System.out.println("2.Funds");
            System.out.println("3.Bank Statement");
            System.out.println("4.Withdraw");
            System.out.println("5.Deposit");
            System.out.println("6.Logout");
            Account account = userLoginController.currentAccount(cif_number);
            FundTransferView fundTransferView = new FundTransferView();
            int choice =0;
            try {
                choice = Read.changeToInt(Read.input("Enter the choice: "));
            }catch (InputMismatchException e){
                e.getMessage();
            }
            switch (choice){
                case 1:
                    fundTransferView.create(account);
                    break;
                case 2:
                    fundTransferView.show(account);
                    break;
                case 3:
                    fundTransferView.showStatement(account);
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
    }
    public void loginSuccess(Account account){
        System.out.println("---------->Welcome to Zsgs Bank<-----------");
//        System.out.println("welcome "+account.getAccountHolderName()+"!!!");
//
        System.out.println();
        System.out.println("YOUR ACCOUNT DETAILS");
        System.out.println("-------------------------------------------------");
        System.out.println("Account Holder Name: "+account.getAccountHolderName());
        System.out.println("Account Number: "+account.getAccountNumber());
        System.out.println("Ifsc code: "+account.getIfscCode());
        System.out.println("CIF NUMBER: "+account.getCif_number());
        System.out.println("Bank Balance: "+account.getBankBalance());
        System.out.println("---------------------------------------------------");
        loginOption();
    }
    public void loginFailure(String errorMessage){
        System.out.println(errorMessage);
    }
}    
    