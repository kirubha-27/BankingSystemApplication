package com.banking.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Read {
    private static Scanner sc = new Scanner(System.in);

    public static String input(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String val = sc.nextLine();
                if (!val.isBlank())
                    return val;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static long changeToLong(String str) throws NumberFormatException {
        return Long.parseLong(str);
    }
    public static int changeToInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }
    public static double changeToDouble(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static String getEmail(String prompt) {
        while (true) {
            try {
                String res = input(prompt);
                if (Check.isValidEmail(res)) {
                    return res;
                } else {
                    System.out.println("Please Enter a Valid Email.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getPassword(String prompt) {
        while (true) {
            String res = input(prompt);
            if (Check.isStrongPassword(res)) {
                return res;
            } else {
                System.out.println("password is to weak. Password must contain one Special Characters,one Capital " +
                        "letters,and numbers");
            }
        }
    }
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
}
