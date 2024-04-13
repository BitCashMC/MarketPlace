module org.bitcash.applications.marketplace.marketplace {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.bitcash.applications.marketplace.gui.login to javafx.fxml;
    exports org.bitcash.applications.marketplace.gui.login;
}