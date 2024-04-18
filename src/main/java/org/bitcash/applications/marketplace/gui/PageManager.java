package org.bitcash.applications.marketplace.gui;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class PageManager {
    public static Rectangle2D getScreenDimensions() {
        return Screen.getPrimary().getVisualBounds();
    }
    public static void switchScene(String fileName, Runnable stageConfig) throws IOException {
        Parent root = FXMLLoader.load(PageManager.class.getResource(fileName));

        Stage stage = LoginMain.getPrimaryStage();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stageConfig.run();
        stage.show();
    }

    public static void switchScene(String fileName) throws IOException {
        Parent root = FXMLLoader.load(PageManager.class.getResource(fileName + ".fxml"));

        Stage stage = LoginMain.getPrimaryStage();

        Scene scene = new Scene(root);

        scene.getStylesheets().add(PageManager.class.getResource(fileName + ".css").toExternalForm());

        stage.setScene(scene);

        stage.show();
    }
}
