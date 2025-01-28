package org.openjfx.test9;

import java.io.IOException;

import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;
import org.openjfx.test9.services.WikipediaFetcher;

import javafx.fxml.Initializable;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;

import java.awt.Desktop;

import java.net.URI;
import java.util.Random;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SecondaryController implements Initializable{
	
	@FXML
    private Button favs;
	
	@FXML
	private Button wiki;
	
    @FXML
    private Button userProfile;
    
    @FXML
    private Button Settings;
	
    @FXML
    private ImageView logOut;
	
	@FXML
    private ImageView deactivateSideBar;
	
    @FXML
    private ImageView activateSideBar;
    
    @FXML
    private VBox sidebar;

    @FXML
    private Label OutError;

    @FXML
    private TextArea outDatos;

    @FXML
    private Button primaryButton;
    
    private SeralizationControler J = new SeralizationControler();

	String home = System.getProperty("user.home");
	
	File carpeta = new File(home + "\\SerialTests\\\\Usuarios");
	
	String currentG = "";
	
	//path towards the users binary files
	 private final String path = home + "\\GenreDive\\GenreList\\MusicGenresList";
	 
	 private final String path1 = home + "\\GenreDive\\Users\\userData.bin";
		
	 private final File folder = new File(home + "\\GenreDive\\\\GenreList");
	
	private String name = "Ejemplo";
	
	private boolean isVisible = false;
	
	
	/*
	 * para que el JAR funcione hay que utiliar el default local openjfx simple maven plug in versison 21 de javafx
	 * utilizar un anchor pane en la pantalla a mostrar
	 * y serializar por fuera del archivo JAR
	 */
	//outDatos.setText(J.deserializarUser(path, name).toString());
    @FXML
    void switchToSecondary(ActionEvent event) {
    	
    	
    	 String [] genreList = J.deserializarListA(path);
    	 
         Random rand = new Random();
         int upperbound = genreList.length;
         int random = rand.nextInt(upperbound);

    	 // Encode the genre for the URL
         	String genre = genreList[random].trim();
         	 String encodedGenre = URLEncoder.encode(genre, StandardCharsets.UTF_8);
    	    System.out.println(encodedGenre);
    	    this.currentG = encodedGenre;
    	    String url = "spotify:search:" + encodedGenre;

    	    try {
    	        Desktop.getDesktop().browse(new URI(url));
    	        wiki.setDisable(false);

    	    } catch (IOException | URISyntaxException e) {
    	        e.printStackTrace();

    	    }
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Image sideBar1 = new Image(getClass().getClassLoader().getResourceAsStream("sidebar-icon-1.png"));
			Image logOut1 = new Image(getClass().getClassLoader().getResourceAsStream("logOutIcon.png"));
			activateSideBar.setImage(sideBar1);
			deactivateSideBar.setImage(sideBar1);
			logOut.setImage(logOut1);
			wiki.setDisable(true);
		}catch(Exception e) {
			Alert al = new Alert(AlertType.INFORMATION);
    		al.setTitle("Info");
    		al.setContentText(e.toString());
    		System.out.println(e.toString());
    		al.showAndWait();
		}
		
		
	}
	
	 @FXML
	    void toggleSidebar(MouseEvent event) {
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
	 
	 	
	    @FXML
	    void logOut(MouseEvent event) {
	    	try {
	    		HashMap <String,Usuario> userData = J.deserializarUser(path1);
	    		Usuario last = userData.get("last");
	    		last.setLoggedIn(false);
	    		J.serializarUser(userData, path1);
	    		App.setRoot("LogInScreen");
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}

	    }
	    
	    @FXML
	    void accessProfile(ActionEvent event) throws IOException {
	    	App.setRoot("UserProfile");
	    }

	    @FXML
	    void goSettings(ActionEvent event) throws IOException {
	    	App.setRoot("Settings");
	    }
	    
	    @FXML
	    void showInfo(ActionEvent event) {
	    	String definition = WikipediaFetcher.fetchGenreDefinition(currentG);
	    	outDatos.setText(definition);
	    }
	    
	    @FXML
	    void addToFavorites(ActionEvent event) {
	    	HashMap <String,Usuario> userData = J.deserializarUser(path1);
    		Usuario last = userData.get("last");
    		last.getMyfavorites().add(currentG);
    		J.serializarUser(userData, path1);
    		System.out.println(last.getMyfavorites());

	    }
	    
}
