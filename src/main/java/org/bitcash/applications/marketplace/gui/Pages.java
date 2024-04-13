package org.bitcash.applications.marketplace.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bitcash.applications.marketplace.gui.login.LoginController;

import java.io.IOException;

public class Pages {
    /*
    Utility class to manage communication between pages
     */

    public static void switchScene(String fileName, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(LoginController.class.getResource(fileName));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }
}
