package com.banking.createaccount;

import com.banking.dto.Account;
import com.banking.util.Read;

import java.util.Scanner;

public class CreateAccountView implements CreateAccountViewCallback {
    private CreateAccountViewControllerCallback createAccountController;
    Scanner scanner = new Scanner(System.in);
    public CreateAccountView() {
        createAccountController = new CreateAccountController(this);
    }

    private void createAccount(){

        String accountHolderName = Read.input("ENTER THE NAME: ");
        long phoneNumber=0;
        try {
            phoneNumber = Read.changeToLong(Read.input("Enter the phone number: "));
        }catch (NumberFormatException e){
            System.out.println("Enter valid fields");
            createAccount();
        }
        String emailId = Read.getEmail("Enter the Email id: ");

        String address = Read.input("Enter the address: ");

        String branchAddress = Read.input("Enter the branch address");

        String password = Read.getPassword("Enter the password: ");
        createAccountController.createNewAccount(accountHolderName,phoneNumber,emailId,branchAddress,address,password);
    }
    public void create(){
        createAccount();
    }
    public void accountFailure(String errorMessage){
        System.out.println(errorMessage);
        System.out.println("Do you want to continue? y/n");
        char a = scanner.next().charAt(0);
        scanner.nextLine();
        if(a=='y'){
            createAccount();
        }else if(a=='n'){
            return;
        }
    }
    public void accountSuccess(Account account){
        System.out.println("-------------------------------------------------");
        System.out.println("Account Holder Name: "+account.getAccountHolderName());
        System.out.println("Account Number: "+account.getAccountNumber());
        System.out.println("Ifsc code: "+account.getIfscCode());
        System.out.println("CIF NUMBER: "+account.getCif_number());
        System.out.println("Bank Balance: "+account.getBankBalance());
        System.out.println("---------------------------------------------------");
        System.out.println("Account Created Successfully");
    }
}    
    