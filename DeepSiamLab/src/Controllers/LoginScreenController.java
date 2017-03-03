package Controllers;

import javax.swing.JOptionPane;

import Entities.*;
import Main.Client;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginScreenController {
	@FXML
	private TextField idTextField, passTextField;

	
	public void sendServer(Object msg, String actionNow){/******************************/
		try {
			((GeneralMessage)msg).actionNow = actionNow;
			Client client = new Client();
			try {
				//client.openConnection();
				client.sendToServer(msg);
			} catch (Exception e) {e.printStackTrace();}
		} catch (Exception e) {	e.printStackTrace();}
	}
	
	public void Sleep(int time){
		try{Thread.sleep(time);}catch(InterruptedException e){e.printStackTrace();}
	}
	
	/**
	 * Confirms that the user does exist in the system.
	 */
	
	public void  onLogin(){
		idTextField.setStyle("-fx-background-color: white;");
		passTextField.setStyle("-fx-background-color: white;");


		if(!(checkText(idTextField.getText()) && checkText(passTextField.getText()))){
			Window.warning("The characters :, \\, ' are not allowed.");	return;
		}
		if(idTextField.getText().isEmpty())
			idTextField.setStyle("-fx-background-color: red;");
		if(passTextField.getText().isEmpty())
			passTextField.setStyle("-fx-background-color: red;");
		
		Worker worker = new Worker();
		worker.query = "SELECT * FROM orelDeepdivers.Workers WHERE ID = '" + idTextField.getText() + "' AND "
				+ "Password = '" + passTextField.getText() + "';";
			Worker.setCurrentWorker(null);
		sendServer(worker, "Login");
		while(Worker.getCurrentWorker()==null){
			Sleep(2);
		}
	}
	/**
	 * This method checks if the string the user inserted is compatible with SQL syntax
	 * @param str The user's string
	 * @return if false, the string in not compatible, else compatible.
	 */
	public boolean checkText(String str){
		if(str.contains("'") || str.contains("\\") || str.contains("/") || str.contains(",") )
				return false;
		return true;
		
	}
	
}
