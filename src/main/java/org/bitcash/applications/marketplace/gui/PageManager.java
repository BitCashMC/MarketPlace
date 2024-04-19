package org.bitcash.applications.marketplace.gui;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class PageManager {

    private static Image icon = new Image(PageManager.class.getResource("mp-icon.png").toExternalForm());
    private static Stage primaryStage = null;

    public static Image getIcon() {
        return icon;
    }

    protected static void setPrimaryStage(Stage s) {
        primaryStage = s;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static Rectangle2D getScreenDimensions() {
        return Screen.getPrimary().getVisualBounds();
    }

    public static void switchScene(String fileName, Runnable config) throws IOException {
        Parent root = FXMLLoader.load(PageManager.class.getResource(fileName + ".fxml"));

        Stage stage = getPrimaryStage();

        Scene scene = new Scene(root);

        scene.getStylesheets().add(PageManager.class.getResource(fileName + ".css").toExternalForm());

        stage.setScene(scene);

        stage.setResizable(false);
        stage.centerOnScreen();

        if (config != null) config.run();
        stage.show();
    }
}
