/**
 * @author Allyson
 * @since 15/12/24
 */
package org.openjfx.test9;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpController implements Initializable {

    @FXML
    private Button SignIn;

    @FXML
    private TextField inConfirm;

    @FXML
    private TextField inPassword;

    @FXML
    private TextField inUsername;

    @FXML
    private Label outError;
    //regular expression in charge of checking passwords
    private final String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
    //object in charge of serialization
    private final SeralizationControler J = new SeralizationControler();
    //users home directory
    private final String home = System.getProperty("user.home");
    //path towards the users binary files	
	private final String path = home + "\\GenreDive\\Users\\";
	//users directory file
	private final File carpeta = new File(home + "\\GenreDive\\\\Users");
    
    
	/**
	 * method in charge of creating a new user
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void SignIn(ActionEvent event) throws Exception{
    	if(validUsername(inUsername.getText())) {
    		if(validPassword(inPassword.getText())) {
    			Usuario newUser = new Usuario (inUsername.getText(),inConfirm.getText());
    			String name = newUser.getUsername();
    			J.serializarUser(newUser, path, name);
    			outError.setText("User created succesfully!");
    			App.setRoot("PantallaDeIngreso");
    		}
    	}
    	else {
    		outError.setText("Username already exist" + "\n" + "Please change your username");
    	}
    	System.out.println("Available password "+ validPassword(inPassword.getText()));
    	System.out.println("Available Username "+ validUsername(inUsername.getText()));
    }
    /**
     * method that checks that the password is valid
     * @param password
     * @return
     */
    private boolean validPassword(String password) {
    	if(inPassword.getText().equals(inConfirm.getText())) {
    		if(password.matches(regex)) {
    			return true;
    		}
    		else {
    			outError.setVisible(true);
    			outError.setText("Password doesn´t match requirements" + "\n" + 
    			"Make sure password has:" + "\n"+ "1. at least 1 capital leter" 
    			+ "\n" + "2. at least 8 total characters" + "\n" + "3. at least 1 number");
    		}
    		
    	}
    	else {
    		outError.setVisible(true);
    		outError.setText("Please make sure passwords match");
    	}
    	return false;
    }
    /**
     * method that checks if the username is available
     * @param userName
     * @return
     */
    private boolean validUsername(String userName) {
    	Usuario user = J.deserializarUser(path, inUsername.getText());
    	if(user==null) {
    		return true;
    	}
    	return false;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		outError.setVisible(true);
		outError.setText("Password requirements" + "\n" + "Make sure password has:" + "\n"
    		+ "1. at least 1 capital leter" + "\n" + "2. at least 8 total characters" + "\n" 
			+ "3. at least 1 number");
		
	}

}
