package org.bitcash.applications.marketplace.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.bitcash.applications.marketplace.backend.login.AccountAuthManager;

import java.io.IOException;

public class LoginPage extends Page {

    public LoginPage() {
        super("loginpage.css","loginpage.fxml");
    }
    @FXML
    private AnchorPane background;

    @FXML
    private SplitPane central_tile;

    @FXML
    private TextField email_input;

    @FXML
    private PasswordField password_input;

    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private Label loginStatus;

    @FXML
    public void initialize() {
        this.login.setDefaultButton(true);
        SplitPane.Divider divider = central_tile.getDividers().get(0);
        divider.positionProperty().addListener((observable, oldvalue, newvalue) -> divider.setPosition(0.5));


    }

    public void login(ActionEvent e) throws IOException {

        Font font = Font.font(Font.getDefault().getName(),FontWeight.BOLD,Font.getDefault().getSize());
        loginStatus.setFont(font);

        if (AccountAuthManager.attemptLogin(
                        getEmailInput().getText(),
                        getPasswordInput().getText())) {

            loginStatus.setTextFill(Color.LIMEGREEN);
            loginStatus.setText("Logged in successfully!");
            GraphicalUtilities.switchPage(new HomePage());
        } else {

            loginStatus.setTextFill(Color.DARKRED);
            loginStatus.setText("Invalid credentials provided.");

        }


        loginStatus.setVisible(true);

    }

    public void register(ActionEvent e) {

        Font font = Font.font(Font.getDefault().getName(),FontWeight.BOLD,Font.getDefault().getSize());
        loginStatus.setFont(font);

        String email,password;
        email = getEmailInput().getText();
        password = getPasswordInput().getText();

        if (AccountAuthManager.attemptRegister(email,password)) {
            loginStatus.setTextFill(Color.LIMEGREEN);
            loginStatus.setText("Registered successfully, please sign in.");
        } else {
            loginStatus.setTextFill(Color.DARKRED);
            loginStatus.setText("Registration failed.");
        }

        loginStatus.setVisible(true);

    }

    public TextField getEmailInput() {
        return this.email_input;
    }

    public PasswordField getPasswordInput() {
        return this.password_input;
    }

}