module org.openjfx.test9 {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;

    opens org.openjfx.test9 to javafx.fxml;
    exports org.openjfx.test9;
}
