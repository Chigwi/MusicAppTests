package org.openjfx.test9;
/**
 * @author Allyson
 * @since 15/12/24
 */



import org.openjfx.test9.model.Usuario;
import org.openjfx.test9.services.SeralizationControler;
import java.io.IOException;
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
	private final String path = home + "\\GenreDive\\Users\\";	
	
	/**
	 * Method in charge of logging the user in
	 * @param event
	 * @throws IOException
	 */
	@FXML
    void switchToSecondary(ActionEvent event) throws IOException {
		//gets the user input for username and password
		String userName = InUser.getText();
		String password = InPassword.getText();
		//checks if its correct
		if(checkPass(userName,password)) {
			//turns newly logged in user into the last logged in user
			Usuario last = J.deserializarUser(path, userName);
			J.serializarUser(last, path, "Last");
			System.out.println("pene "+J.deserializarUser(path, "Last").toString());
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
    	try {//checks if the password given is the same as the one registered for the user
    		if(J.deserializarUser(path, userName).getUsername().equals(userName)
    			&& J.deserializarUser(path, userName).getPassword().equals(Password)) {
    			return true;
    		}
    	}catch(Exception e) {//exception in case the user doesnt exist
    		OutError.setText("User doesn't exist");
    		OutError.setVisible(true);
    	}//in case the username and password are incorrect it returns false
    	return false;
    }
}

