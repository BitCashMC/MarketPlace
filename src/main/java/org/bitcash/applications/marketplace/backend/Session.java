package org.bitcash.applications.marketplace.backend;

import java.util.List;

public class Session {

    /*
    Eventually we make a session framework that is purely static and connects everything together.
     */

    //Global constant for all components of the application to access the current session.
    //This session is initialized during
    private static Session current_session;

    public static Session getCurrentSession() {
        return current_session;
    }

    public static void setCurrentSession(Session s) {
        current_session = s;
    }
    private Account account;

    public Session(Account account){
        this.account = account;
        this.account.setSession(this);
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account a) {
        this.account = a;
    }


}
