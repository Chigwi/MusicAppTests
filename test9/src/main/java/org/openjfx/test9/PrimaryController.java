package org.openjfx.test9;

import java.io.IOException;

import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;

import javafx.fxml.FXML;



import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label OutError;

    @FXML
    private Button Secondary;
    
    private SeralizationControler J = new SeralizationControler();
	
	private Usuario Ejemplo = new Usuario ("Allie", "23","female");
	
	String home = System.getProperty("user.home");
	
	File carpeta = new File(home + "\\SerialTests\\\\Usuarios");
	
	private String path = home + "\\SerialTests\\Usuarios\\";	
	
	private String name = "Ejemplo";

    @FXML
    void Switch(ActionEvent event) throws IOException {
    	carpeta.mkdirs();
    	J.serializarUser(Ejemplo, path, name);
    	App.setRoot("MostrarDatos");
    }

}

