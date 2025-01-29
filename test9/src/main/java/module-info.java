module org.openjfx.test9 {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires org.json;

    opens org.openjfx.test9 to javafx.fxml;
    opens org.openjfx.test9.model to javafx.base;
    exports org.openjfx.test9;
}
