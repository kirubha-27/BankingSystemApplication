package com.banking;

import com.banking.createaccount.CreateAccountView;
import com.banking.userlogin.UserLoginView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("1.login");
            System.out.println("2.Create New Account");
            System.out.println("3.Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    UserLoginView userLoginView = new UserLoginView();
                    userLoginView.create();
                    break;
                case 2:
                    CreateAccountView createAccountView = new CreateAccountView();
                    createAccountView.create();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }
}