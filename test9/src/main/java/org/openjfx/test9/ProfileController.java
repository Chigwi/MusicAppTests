package org.openjfx.test9;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import org.openjfx.test9.model.Gens;
import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfileController implements Initializable{
	
    @FXML
    private TableColumn<Gens, String> Cav;

    @FXML
    private TableColumn<Gens, String> Cfavs;

    @FXML
    private Label OutError;

    @FXML
    private Button backButton;
    
    @FXML
    private TableView<Gens> genresTable;
    
    private String home = System.getProperty("user.home");
    
    private final String path = home + "\\GenreDive\\Users\\userData.bin";
    
    private SeralizationControler J = new SeralizationControler();
    
    private ObservableList<Gens> genres = FXCollections.observableArrayList();
   
    
    
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
		List <String> lisFavs = new ArrayList<String>(myFavs);
		List <String> lisAvs = new ArrayList<String>(myAv);
		int max = Math.max(lisFavs.size(), lisAvs.size());
		for (int i = 0; i < max; i++) {
			if(i<lisFavs.size() && i<lisAvs.size()) {
				Gens x = new Gens (lisFavs.get(i),lisAvs.get(i));
				genres.add(x);
			}
			else if(i<lisFavs.size() && i> lisAvs.size()) {
				Gens x = new Gens(lisFavs.get(i),"");
				genres.add(x);
			}
			else if(i > lisFavs.size() && i > lisAvs.size()){
				Gens x = new Gens("",lisAvs.get(i));
				genres.add(x);
			}
		}
		Cav.setCellValueFactory(new PropertyValueFactory<Gens,String>("Av"));
		Cfavs.setCellValueFactory(new PropertyValueFactory<Gens, String>("Fav"));
		genresTable.setItems(genres);
		System.out.println(genres.toString());
		
		
	}
	
	
	

}

