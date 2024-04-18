package org.bitcash.applications.marketplace.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import org.bitcash.applications.marketplace.gui.LoginController;

import java.io.IOException;

public class LoginMain extends Application {

    private static Stage stage;

    public static Stage getPrimaryStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        stage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginpage.fxml"));
        Parent root = loader.load();
        LoginController controller = loader.getController();
        controller.setLoginAsDefaultButton(true);
        Scene scene = new Scene(root);
        String css = getClass().getResource("loginpage.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.setTitle("MarketPlace");

        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();

        SplitPane.Divider divider = controller.getCentralTile().getDividers().get(0);
        divider.positionProperty().addListener((observable, oldvalue, newvalue) -> divider.setPosition(0.5));
    }

    public static void enable() {
        launch();
    }
}