package org.bitcash.applications.marketplace.gui;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class GraphicalStartPoint extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("MarketPlace");
        primaryStage.getIcons().add(GraphicalUtilities.getIcon());
        primaryStage.centerOnScreen();

        GraphicalUtilities.setPrimaryStage(primaryStage);
        GraphicalUtilities.switchPage(new LoginPage());
    }

    public static void enable() {
        launch();
    }
}