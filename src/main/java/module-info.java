module com.scrypt.scrypt_implementation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires scrypt;

    opens com.scrypt.scryptimplementation to javafx.fxml;
    exports com.scrypt.scryptimplementation;
    exports com.scrypt.scryptimplementation.controller;
    opens com.scrypt.scryptimplementation.controller to javafx.fxml;
}