/**
 * @author Allyson
 * @since 15/12/24
 */
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
	
	private final String home = System.getProperty("user.home");
	
	private final File carpeta = new File(home + "\\GenreDive\\\\Users");
	
	private final String path = home + "\\GenreDive\\Users\\";	
	
	private final String name = "Last";
	

	@Override
	public void start(Stage primaryStage) {
		try {
			carpeta.mkdirs();
			System.out.println(getClass().getName());
			//gets the last user that was logged in
			lastUser = J.deserializarUser(path, name);
			//System.out.println(lastUser.isLoggedIn());
			//lastUser.setLoggedIn(false);
			//checks if said user logged out before closing the app
			if(lastUser!=null && lastUser.isLoggedIn()) {
				//if its logged in lets the user directly into the app functionallity
				AnchorPane root  = (AnchorPane) FXMLLoader.load(getClass().getResource("/org/openjfx/test9/MostrarDatos.fxml"));
				scene = new Scene(root);
				String css = this.getClass().getResource("application.css").toExternalForm();
				scene.getStylesheets().add(css);
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			else {
				//if not takes the user into the log in screen
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
	/**
	 * method in charge of switching screens
	 * @param fxml
	 * @throws IOException
	 */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    /**
     * loads the fxml file for the screen selected
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
	
	public static void main(String[] args) {
		launch(args);
	}
}
