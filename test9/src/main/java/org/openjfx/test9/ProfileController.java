package org.openjfx.test9;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;

import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfileController implements Initializable{

    @FXML
    private Label OutError;

    @FXML
    private Button backButton;
    
    @FXML
    private TableView<String> genresTable;
    
    String home = System.getProperty("user.home");
    
    private final String path = home + "\\GenreDive\\Users\\userData.bin";
    
    private SeralizationControler J = new SeralizationControler();
    
    
    private ObservableList<String> favorites = FXCollections.observableArrayList();
    
    private ObservableList<String> avoided = FXCollections.observableArrayList();
    
    
    @FXML
    void backToMainScreen(ActionEvent event) throws IOException {
    	App.setRoot("MainScreen");
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		HashMap <String,Usuario> userData = J.deserializarUser(path);
		Usuario last = userData.get("last");
		HashSet<String> myFavs = last.getMyfavorites();
		HashSet<String> myAv = last.getAvoided();
		for (String string : myFavs) {
			favorites.add(string);
		}
		for (String string : myAv) {
			avoided.add(string);
		}
		System.out.println(favorites.toString());
		System.out.println(avoided.toString());
	}
	
	

}

