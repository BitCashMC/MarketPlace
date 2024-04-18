package org.bitcash.applications.marketplace.backend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {

    private String email;
    private String password;
    private transient Session session;

    public static final String STORED_ACCOUNTS = "src/main/resources/org/bitcash/applications/marketplace/gui/accounts/";
    private static final long serialVersionUID = ObjectStreamClass.lookup(Account.class).getSerialVersionUID();

    public Account(String email, String password) {
        this.email = email.toLowerCase();
        this.password = password;

        try {
            File file = new File(STORED_ACCOUNTS + email + ".ser");
            file.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
        } catch (IOException f) {
            throw new RuntimeException(f);
        }

    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    protected void setSession(Session s) {
        this.session = s;
    }

    public Session getSession() {
        return this.session;
    }

}
