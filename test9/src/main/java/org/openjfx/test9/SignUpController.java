/**
 * @author Allyson
 * @since 15/12/24
 */
package org.openjfx.test9;

import java.net.URL;
import java.util.ResourceBundle;

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
    
    private final String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
    
    

    @FXML
    void SignIn(ActionEvent event) throws Exception{
    	
    	System.out.println(validPassword(inPassword.getText()));
    }
    private boolean validPassword(String password) {
    	if(inPassword.getText().equals(inConfirm.getText())) {
    		if(password.matches(regex)) {
    			return true;
    		}
    		else {
    			outError.setVisible(true);
    			outError.setText("Password doesn´t match requirements" + "\n" + "Make sure password has:" + "\n"
    		+ "1. at least 1 capital leter" + "\n" + "2. at least 8 total characters" + "\n" + "3. at least 1 number");
    		}
    		
    	}
    	else {
    		outError.setVisible(true);
    		outError.setText("Please make sure passwords match");
    	}
    	return false;
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		outError.setVisible(true);
		outError.setText("Password requirements" + "\n" + "Make sure password has:" + "\n"
    		+ "1. at least 1 capital leter" + "\n" + "2. at least 8 total characters" + "\n" + "3. at least 1 number");
		
	}

}
