package org.bitcash.applications.marketplace.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bitcash.applications.marketplace.gui.login.LoginController;

import java.io.IOException;

public interface SceneManager {

    public static void switchScene(String fileName, ActionEvent event, SceneManager config) throws IOException {
        Parent root = FXMLLoader.load(LoginController.class.getResource(fileName));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        config.runConfiguration(event);

        stage.show();
    }

    void runConfiguration(ActionEvent e);

}
