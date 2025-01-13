package org.openjfx.test9;

import java.io.IOException;

import org.openjfx.test9.services.SeralizationControler;

import javafx.fxml.FXML;
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

import java.awt.Desktop;

import java.net.URI;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SecondaryController implements Initializable{

    @FXML
    private Label OutError;

    @FXML
    private TextArea outDatos;

    @FXML
    private Button primaryButton;

    @FXML
    private ImageView display;
    
    private SeralizationControler J = new SeralizationControler();

	String home = System.getProperty("user.home");
	
	File carpeta = new File(home + "\\SerialTests\\\\Usuarios");
	
	//path towards the users binary files
	 private final String path = home + "\\GenreDive\\GenreList\\MusicGenresList";
		
	 private final File folder = new File(home + "\\GenreDive\\\\GenreList");
	
	private String name = "Ejemplo";
	
	
	
    @FXML
    void switchToSecondary(ActionEvent event) {
    	/*
    	 * para que el JAR funcione hay que utiliar el default local openjfx simple maven plug in versison 21 de javafx
    	 * utilizar un anchor pane en la pantalla a mostrar
    	 * y serializar por fuera del archivo JAR
    	 */
    	//outDatos.setText(J.deserializarUser(path, name).toString());
    	 String genre = "dariacore"; // Replace with the selected genre

    	    String url = "https://open.spotify.com/search/" + genre;

    	    try {

    	        Desktop.getDesktop().browse(new URI(url));

    	    } catch (IOException | URISyntaxException e) {

    	        e.printStackTrace();

    	    }
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Image image = new Image(getClass().getClassLoader().getResourceAsStream("Aespa1.jpg"));
			display.setImage(image);
			outDatos.setText(Arrays.toString(J.deserializarListA(path)));
		}catch(Exception e) {
			Alert al = new Alert(AlertType.INFORMATION);
    		al.setTitle("Info");
    		al.setContentText(e.toString());
    		System.out.println(e.toString());
    		al.showAndWait();
		}
		
		
	}

}
