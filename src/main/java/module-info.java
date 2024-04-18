module org.bitcash.applications.marketplace.marketplace {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    exports org.bitcash.applications.marketplace.gui;
    opens org.bitcash.applications.marketplace.gui to javafx.fxml;
}