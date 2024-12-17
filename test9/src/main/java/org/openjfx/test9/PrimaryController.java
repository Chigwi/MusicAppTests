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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button BttExit;

    @FXML
    private Button BttSignUp;

    @FXML
    private PasswordField InPassword;

    @FXML
    private TextField InUser;

    @FXML
    private Label OutError;

    @FXML
    private Button primaryButton;
    
    @FXML
    private CheckBox isLoggedIn;
    
    private SeralizationControler J = new SeralizationControler();
	
	private final String home = System.getProperty("user.home");
	
	private final File carpeta = new File(home + "\\GenreDive\\\\Users");
	
	private final String path = home + "\\GenreDive\\Users\\";	
	
	private String name = "Ejemplo";

	@FXML
    void switchToSecondary(ActionEvent event) throws IOException {
		//gets the user input for username and password
		String userName = InUser.getText();
		String password = InPassword.getText();
		//checks if its correct
		if(checkPass(userName,password)) {
			//turns newly logged in user into the last logged in user
			Usuario last = J.deserializarUser(path, "Last");
			J.serializarUser(last, path, "Last");
			System.out.println(J.deserializarUser(path, "Last").toString());
			//checks if user wants to be kept logged in
			if(isLoggedIn.isSelected()) {
				//if the user wants to be kept logged in it switches the logged in valule to true
				last.setLoggedIn(true);
				J.serializarUser(last, path, "Last");
				App.setRoot("MostrarDatos");
			}
			else {
				//if not switches it to false
				last.setLoggedIn(false);
				J.serializarUser(last, path, "Last");
				App.setRoot("MostrarDatos");
			}
			
		}
    }
    
    @FXML
    void Exit(ActionEvent event) {

    }

    @FXML
    void switchToPrimary(ActionEvent event) {

    }
    //checks if the password is correct for the user name given 
    private boolean checkPass (String userName, String Password) {
    	try {
    		if(J.deserializarUser(path, userName).getUsername().equals(userName)
    			&& J.deserializarUser(path, userName).getPassword().equals(Password)) {
    			return true;
    		}
    	}catch(Exception e) {
    		OutError.setText("User doesn't exist");
    		OutError.setVisible(true);
    	}
    	return false;
    }
}

