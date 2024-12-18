package org.openjfx.test9;

import java.io.IOException;

import org.openjfx.test9.services.SeralizationControler;

import javafx.fxml.FXML;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.awt.Desktop;

import java.net.URI;

import java.net.URISyntaxException;

public class SecondaryController {

    @FXML
    private Label OutError;

    @FXML
    private TextArea outDatos;

    @FXML
    private Button primaryButton;

    private SeralizationControler J = new SeralizationControler();

	String home = System.getProperty("user.home");
	
	File carpeta = new File(home + "\\SerialTests\\\\Usuarios");
	
	private String path = home + "\\SerialTests\\Usuarios\\";	
	
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

}
