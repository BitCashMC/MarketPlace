package org.bitcash.applications.marketplace.gui;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

public class GraphicalUtilities {

    private static Image icon = new Image(GraphicalUtilities.class.getResource("mp-icon.png").toExternalForm());
    private static Stage primaryStage = null;
    public static Image getIcon() {
        return icon;
    }

    protected static void setPrimaryStage(Stage s) {
        primaryStage = s;
    }
    public static void alterPrimaryStage(Consumer<Stage> op) {
        op.accept(primaryStage);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static Rectangle2D getScreenDimensions() {
        return Screen.getPrimary().getVisualBounds();
    }

    public static void switchPage(Page page) throws IOException {
        Stage stage = getPrimaryStage();

        Parent root = FXMLLoader.load(page.getPathToFXMLFile());
        Scene scene = new Scene(root);

        try {
            scene.getStylesheets().add(page.getPathToStylesheet().toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("WARNING -- Attempted to load CSS stylesheet for " + page + " but was null\n" + e);
        }

        stage.setScene(scene);

        if (!stage.isResizable()) stage.setResizable(true); //to reset the stage resizability property if one of the Pages orders resizability to be turned off

        stage.show();
    }
}
