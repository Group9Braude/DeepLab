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
	
	
	
	public void  onLogin(){
		idTextField.setStyle("-fx-background-color: white;");
		passTextField.setStyle("-fx-background-color: white;");


		if(!(checkText(idTextField.getText()) && checkText(passTextField.getText()))){
			JOptionPane.showMessageDialog(null, "The characters :, \\, ' are not allowed.", "Error",
					JOptionPane.ERROR_MESSAGE);	return;
		}
		if(idTextField.getText().isEmpty())
			idTextField.setStyle("-fx-background-color: red;");
		if(passTextField.getText().isEmpty())
			passTextField.setStyle("-fx-background-color: red;");
		
		Worker worker = new Worker();
		worker.query = "SELECT * FROM orelDeepdivers.Workers WHERE ID = '" + idTextField.getText() + "' AND "
				+ "Password = '" + passTextField.getText() + "';";
		System.out.println("Qeury:" + worker.query);
			Worker.setCurrentWorker(null);
		sendServer(worker, "Login");
		while(Worker.getCurrentWorker()==null){
			Sleep(2);
		}
	}
	
	public boolean checkText(String str){
		if(str.contains("'") || str.contains("\\"))
				return false;
		return true;
		
	}
	
}
