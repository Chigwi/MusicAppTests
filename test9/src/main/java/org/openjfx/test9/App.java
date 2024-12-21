/**
 * @author Allyson
 * @since 15/12/24
 */
package org.openjfx.test9;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openjfx.test9.model.GenreList;
import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;



public class App extends Application {
	
	private static Scene scene;
	
	private SeralizationControler J = new SeralizationControler();
	
	private static Usuario lastUser;
	
	private final String path = "src/main/resources/users/userData.bin";	
	
	private final String name = "last";
	
	private final static HashMap<String,Usuario> UserData = new HashMap<>();
	

	@Override
	public void start(Stage primaryStage) {
		try {
			if(J.deserializarUser(path)==null){
				Usuario user1 = new Usuario ("Allie","Chigwi23");
				
				Usuario user2 = new Usuario ("Salo","Salo123");
				
				Usuario user3 = new Usuario ("Cothu","Chotu");
				
				Usuario last = user1;
				
				UserData.put("Allie", user1);
				
				UserData.put("Salo", user2);
				
				UserData.put("Cothu", user3);
				
				UserData.put("last", last);
				
				System.out.println(UserData.get("last"));
				
				J.serializarUser(UserData,"src/main/resources/users/userData.bin");
			}else {
			GenreList.createList();
			System.out.println(getClass().getName());
			//gets the last user that was logged in
			HashMap <String,Usuario> userData = J.deserializarUser(path); 
			lastUser = userData.get(name);
			System.out.println(lastUser);
			//lastUser.setLoggedIn(false);
			//checks if said user logged out before closing the app
			if(lastUser!=null && lastUser.isLoggedIn()) {
				//if its logged in lets the user directly into the app functionallity
				AnchorPane root  = (AnchorPane) FXMLLoader.load(getClass().getResource("/org/openjfx/test9/MainScreen.fxml"));
				scene = new Scene(root);
				String css = this.getClass().getResource("application.css").toExternalForm();
				scene.getStylesheets().add(css);
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			else {
				//if not takes the user into the log in screen
				AnchorPane root  = (AnchorPane) FXMLLoader.load(getClass().getResource("/org/openjfx/test9/LogInScreen.fxml"));
				scene = new Scene(root);
				String css = this.getClass().getResource("application.css").toExternalForm();
				scene.getStylesheets().add(css);
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			
			}
		} catch(Exception e) {
			Alert al = new Alert(AlertType.INFORMATION);
    		al.setTitle("Info");
    		al.setContentText(e.toString());
    		System.out.println(e.toString());
    		al.showAndWait();
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
