package org.bitcash.applications.marketplace.gui.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.bitcash.applications.marketplace.gui.SceneManager;
import org.bitcash.applications.marketplace.gui.login.LoginController;
import org.controlsfx.control.action.Action;

public class HomeController implements SceneManager {

    @Override
    public void runConfiguration(ActionEvent e) {

        Stage stage = (Stage)((Node) LoginController.event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
    }

}
