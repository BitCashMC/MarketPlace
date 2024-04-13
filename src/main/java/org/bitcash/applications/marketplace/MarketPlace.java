package org.bitcash.applications.marketplace;

import org.bitcash.applications.marketplace.backend.Account;
import org.bitcash.applications.marketplace.backend.Session;
import org.bitcash.applications.marketplace.gui.login.LoginMain;

import static org.bitcash.applications.marketplace.backend.Session.setCurrentSession;

public class MarketPlace {

    public static void main(String[] args) {

        LoginMain.enable();
    }
}
