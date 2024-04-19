package org.bitcash.applications.marketplace.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.bitcash.applications.marketplace.backend.Session;

import java.io.IOException;

public class HomeController {

    @FXML
    public void initialize() {

        accountMenu.setText(Session.getCurrentSession().getAccount().getEmail());

    }

    @FXML
    private MenuButton accountMenu;

    @FXML
    private MenuItem accountSettings;

    @FXML
    private MenuItem logOut;

    @FXML
    private Button taskManagement;

    @FXML
    private Button videoPlayer;

    public void logOut(ActionEvent e) throws IOException {
        PageManager.switchScene("loginpage",null);
    }



}
