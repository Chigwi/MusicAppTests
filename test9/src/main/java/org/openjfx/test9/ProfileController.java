package org.openjfx.test9;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfileController implements Initializable{ 
	
	@FXML
    private Label outAvs;

    @FXML
    private Label outDIves;

    @FXML
    private Label outFavs;

    @FXML
    private Label outSaves;

    @FXML
    private Label outUser;

    @FXML
    private Label outWikis;
	
	@FXML
	private ImageView logOut;

	@FXML
	private Button mainScreen;

	@FXML
	private Button settings;

	@FXML
	private VBox sidebar;
	
	@FXML
	private ImageView activateSideBar;

	@FXML
	private ImageView deactivateSideBar;

    @FXML
    private TableColumn<Gens, String> Cav;

    @FXML
    private TableColumn<Gens, String> Cfavs;

    @FXML
    private Label OutError;

    @FXML
    private Button backButton;
    
    @FXML
    private TableView<Gens> genresTable = new TableView <Gens>();
    
    private String home = System.getProperty("user.home");
    
    private final String path = home + "\\GenreDive\\Users\\userData.bin";
    
    private SeralizationControler J = new SeralizationControler();
    
    private ObservableList<Gens> genres = FXCollections.observableArrayList();
    
    private boolean isVisible = false;
   
    
    
    @FXML
    void backToMainScreen(ActionEvent event) throws IOException {
    	App.setRoot("MainScreen");
    }
    
    @FXML
    void goSettings(ActionEvent event) throws IOException {
    	App.setRoot("Settings");
    }

    @FXML
    void logOut(MouseEvent event) {
    	try {
    		HashMap <String,Usuario> userData = J.deserializarUser(path);
    		Usuario last = userData.get("last");
    		last.setLoggedIn(false);
    		J.serializarUser(userData, path);
    		App.setRoot("LogInScreen");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

    }

	@Override
	 public void initialize(URL location, ResourceBundle resources) {
		
		genresTable.setOnMouseClicked(event -> {

            if (event.getClickCount() == 2) { // Check for double-click

                Gens selectedGenre = genresTable.getSelectionModel().getSelectedItem();

                if (selectedGenre != null) {
                	if(!selectedGenre.getFav().equals("")) {
                		showGenreInfo(selectedGenre.getFav());
                	}

                }

            }
            else if(event.getClickCount() == 3){
            	
            	 Gens selectedGenre = genresTable.getSelectionModel().getSelectedItem();

                 if (selectedGenre != null) {
                 	if(!selectedGenre.getAv().equals("")) {
                 		showGenreInfo(selectedGenre.getAv());
                 	}
                 }
                 	
            }

        });
		
		populateTable();
		
		populateImages();
		
		populateGrid();
		
	}
	
	 @FXML
	 private void toggleSidebar(MouseEvent event) {
		 TranslateTransition transition = new TranslateTransition(Duration.millis(300), sidebar);
		 if(isVisible) {
			 transition.setToX(-sidebar.getWidth()); // Slide out
			 this.isVisible = false;
		 }else {
			 transition.setToX(0); // Slide in
			 this.isVisible = true;
		 }
		 transition.play();
	    }
	 	
	 private void showGenreInfo(String genre) {
		 String encodedGenre = URLEncoder.encode(genre,StandardCharsets.UTF_8);
		 String URL = "spotify:search:" + encodedGenre;
		 
		 try {
			 Desktop.getDesktop().browse(new URI(URL));
		 }catch(IOException | URISyntaxException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 private void populateTable() {
		 
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
				else if(i < lisFavs.size() && i > lisAvs.size()) {
					Gens x = new Gens(lisFavs.get(i),"");
					genres.add(x);
				}
				else if(i > lisFavs.size() && i < lisAvs.size()){
					Gens x = new Gens("",lisAvs.get(i));
					genres.add(x);
				}
			}
			
			Cav.setCellValueFactory(new PropertyValueFactory<Gens,String>("Av"));
			Cfavs.setCellValueFactory(new PropertyValueFactory<Gens, String>("Fav"));
			genresTable.setItems(genres);
	 }
	 
	 private void populateImages() {
		 
		 	Image sideBar1 = new Image(getClass().getClassLoader().getResourceAsStream("sidebar-icon-1.png"));
			
		 	Image logOut1 = new Image(getClass().getClassLoader().getResourceAsStream("logOutIcon.png"));
			
		 	activateSideBar.setImage(sideBar1);
			
		 	deactivateSideBar.setImage(sideBar1);
			
		 	logOut.setImage(logOut1);
	 }
	 
	 private void populateGrid() {
		
		HashMap <String,Usuario> userData = J.deserializarUser(path);
 		Usuario last = userData.get("last");
 		int saves = last.getMyfavorites().size() + last.getAvoided().size();
 		
 		outUser.setText(last.getUsername());
 		outDIves.setText("" + last.getDives()[0]);
 		outWikis.setText("" + last.getWikis()[0]);
 		outFavs.setText("" + last.getMyfavorites().size());
 		outAvs.setText("" + last.getAvoided().size());
 		outSaves.setText(""+ saves);
 		
	 }
}

