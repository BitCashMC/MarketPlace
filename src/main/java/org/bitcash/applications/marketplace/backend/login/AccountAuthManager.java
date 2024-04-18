package org.bitcash.applications.marketplace.backend.login;

import org.bitcash.applications.marketplace.backend.Account;
import org.bitcash.applications.marketplace.backend.Session;

import java.io.*;

import static java.util.Arrays.stream;
import static org.bitcash.applications.marketplace.backend.Account.STORED_ACCOUNTS;

public class AccountAuthManager {

    //Method to execute a login attempt
    public static boolean attemptLogin(String email, String password) {
        FileInputStream fileIn;

        try {
            fileIn = new FileInputStream((STORED_ACCOUNTS + email.toLowerCase()+".ser").trim());
        } catch (FileNotFoundException e) {
            System.err.println("Attempt by " + email + " to log in failed. No records found of an account under the provided address.");
            return false;
        }

        ObjectInputStream in;
        Account account;
        try {
            in = new ObjectInputStream(fileIn);
            account = (Account)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (!password.equalsIgnoreCase(account.getPassword())) return false;

        Session.setCurrentSession(new Session(account));

        return true;
        }


    //Method to create a new session and corresponding account
    public static boolean attemptRegister(String email, String password) {

        if (email.isBlank() || password.isBlank()) return false;
        if (new File(STORED_ACCOUNTS + email + ".ser").isFile()) return false;

        Session.setCurrentSession(new Session(new Account(email,password)));
        return true;
    }
}


