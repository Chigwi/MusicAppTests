package org.openjfx.test9;
/**
 * @author Allyson
 * @since 15/12/24
 */



import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;
import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXML;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {
	//fxml attributes
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
    //object in charge of serialization
    private SeralizationControler J = new SeralizationControler();
	
	//users home directory
	private final String home = System.getProperty("user.home");
	//path towards the users binary files
	private final String path = home + "\\GenreDive\\Users\\userData.bin";
	
	private final File folder = new File(home + "\\GenreDive\\\\Users");
	
	/**
	 * Method in charge of logging the user in
	 * @param event
	 * @throws IOException
	 */
	@FXML
    void switchToSecondary(ActionEvent event) throws IOException {
		HashMap <String,Usuario> userData = J.deserializarUser(path);
		System.out.println(userData.get("last"));
		//gets the user input for username and password
		String userName = InUser.getText();
		String password = InPassword.getText();
		//checks if its correct
		if(checkPass(userName,password)) {
			//turns newly logged in user into the last logged in user
			Usuario last = userData.get(userName);
			userData.replace("last", last);
			System.out.println("pene "+userData.get("last"));
			//checks if user wants to be kept logged in
			if(isLoggedIn.isSelected()) {
				//if the user wants to be kept logged in it switches the logged in valule to true
				last.setLoggedIn(true);
				userData.replace("Last", last);
				J.serializarUser(userData, path);
				System.out.println(last);
				App.setRoot("MainScreen");
				System.out.println(J.deserializarUser(path));
			}
			else {
				//if not switches it to false
				last.setLoggedIn(false);
				userData.replace("Last", last);
				J.serializarUser(userData, path);
				App.setRoot("MainScreen");
			}
			
		}
		else {
			//lets the user know that the password is incorrect
			OutError.setVisible(true);
		}
    }
    //closes the app
	/**
	 * closes the app
	 * @param event
	 */
    @FXML
    void Exit(ActionEvent event) {
    	System.exit(0);
    }
    //takes the user to the screen to create a new user
    /**
     * switches screen to sign in
     * @param event
     * @throws Exception
     */
    @FXML
    void switchToPrimary(ActionEvent event) throws Exception{
    	App.setRoot("SignUpScreen");
    }
    //checks if the password is correct for the user name given 
    /**
     * method in charge of checking if the password is correct
     * @param userName
     * @param Password
     * @return
     */
    private boolean checkPass (String userName, String Password) {
    	HashMap <String,Usuario> userData = J.deserializarUser(path);
    	try {
    		if(userData.get(userName)!=null) {
    			if(userData.get(userName).getPassword().equals(Password)) {
    				return true;
    			}else {
    				return false;
    			}
    		}else {
    			OutError.setText("User doesn't exist");
        		OutError.setVisible(true);
    		}
    	}catch(Exception e) {
    		
    	}
    	return false;
    }
}

