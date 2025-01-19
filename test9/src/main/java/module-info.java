module org.openjfx.test9 {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires org.json;

    opens org.openjfx.test9 to javafx.fxml;
    exports org.openjfx.test9;
}
