module com.example.integratedweightingmethod {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.ooxml.schemas;

    opens com.example.integratedweightingmethod to javafx.fxml;
    exports com.example.integratedweightingmethod;
}