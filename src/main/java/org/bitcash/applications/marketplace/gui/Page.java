package org.bitcash.applications.marketplace.gui;

import javafx.fxml.FXML;

import java.net.URL;

public abstract class Page {

    private URL pathToStylesheet;
    private URL pathToFXMLFile;

    public Page(String pathToStylesheet, String pathToFXMLFile) {
        if (pathToStylesheet != null) this.pathToStylesheet = getClass().getResource(pathToStylesheet);
        else this.pathToStylesheet = null;
        this.pathToFXMLFile = getClass().getResource(pathToFXMLFile);
    }

    public URL getPathToStylesheet() {
        return this.pathToStylesheet;
    }

    public URL getPathToFXMLFile() {
        return this.pathToFXMLFile;
    }
}
