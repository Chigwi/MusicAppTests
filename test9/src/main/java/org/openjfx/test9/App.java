package org.openjfx.test9;

import java.io.File;
import java.io.IOException;

import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class App extends Application {
	
	private static Scene scene;
	
	private SeralizationControler J = new SeralizationControler();
	
	private static Usuario lastUser;
	
	String home = System.getProperty("user.home");
	
	File carpeta = new File(home + "\\SerialTests\\\\Usuarios");
	
	private String path = home + "\\SerialTests\\Usuarios\\";	
	
	private String name = "Last";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.println(carpeta.mkdirs());
			System.out.println(System.getProperty("user.home"));
			System.out.println(getClass().getName());
			System.out.println(J.deserializarUser(path, name));
			lastUser = J.deserializarUser(path, name);
			lastUser.setLoggedIn(false);
			if(lastUser.isLoggedIn()) {
				AnchorPane root  = (AnchorPane) FXMLLoader.load(getClass().getResource("/org/openjfx/test9/MostrarDatos.fxml"));
				scene = new Scene(root);
				String css = this.getClass().getResource("application.css").toExternalForm();
				scene.getStylesheets().add(css);
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			else {
				AnchorPane root  = (AnchorPane) FXMLLoader.load(getClass().getResource("/org/openjfx/test9/PantallaDeIngreso.fxml"));
				scene = new Scene(root);
				String css = this.getClass().getResource("application.css").toExternalForm();
				scene.getStylesheets().add(css);
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
	
	public static void main(String[] args) {
		launch(args);
	}
}
