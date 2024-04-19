package org.bitcash.applications.marketplace.gui;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class GraphicsMain extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        PageManager.setPrimaryStage(primaryStage);
        PageManager.switchScene("loginpage",() -> {
            primaryStage.setTitle("MarketPlace");
            primaryStage.getIcons().add(PageManager.getIcon());
        });
    }

    public static void enable() {
        launch();
    }
}