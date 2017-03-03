package controllers;


import entities.Windows;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OrderController {

	@FXML
	private CheckBox regulatorCheckBox, bcdCheckBox, ccrCheckBox, tankCheckBox, deepCheckBox, privateCheckBox;
	@FXML
	private TextArea commentsTextArea;
	@FXML
	private TextField regManuTextField, regDeepNumTextField, bcdModelTextField,bcdDeepNumTextField, tankDeepNumTextField, tankManuTextField,
	ccrOwnerTextField, ccrDeepNumTextField;
	
	public OrderController(){
		
	}
	
	/**
	 * This method removes/changes/adds fields to the order window, depending on wether it's private equipment or deep's
	 */
	public void onDeepSelection(){
		privateCheckBox.setSelected(false);
		regDeepNumTextField.setPromptText("Deep Number");
		tankDeepNumTextField.setPromptText("Deep Number");
		ccrDeepNumTextField.setPromptText("Deep Number");
		bcdDeepNumTextField.setVisible(true);
		
	}
	/**
	 * This method removes/changes/adds fields to the order window, depending on wether it's private equipment or deep's
	 */
	public void onPrivateSelection(){
		deepCheckBox.setSelected(false);
		regDeepNumTextField.setPromptText("Serial Number");
		tankDeepNumTextField.setPromptText("Serial Number");
		ccrDeepNumTextField.setPromptText("Serial Number");
		bcdDeepNumTextField.setVisible(false);
	}
	/**
	 * This method checks the order fields and issues an order by writing the information into the description String
	 * which will later be shown to the tech
	 */
	public void onIssueOrder(){
		String description="";//This String will be shown to the tech when he opens the ticket.
		if(privateCheckBox.isSelected()){//Private Equipment
			


			
		if(regulatorCheckBox.isSelected())
			description+="Regulator:\n -Serial Num: " + regDeepNumTextField.getText() + "\n -Manufacturer: " + regManuTextField.getText() + "\n";
		if(bcdCheckBox.isSelected())
			description+="BCD:\n -Model: " + bcdModelTextField.getText() + "\n";
		if(tankCheckBox.isSelected())
			description+="Tank:\n -Serial Num: " + tankDeepNumTextField.getText() + "\n -Manufacturer: " + tankManuTextField.getText() + "\n";
		if(ccrCheckBox.isSelected())
			description+="CCR:\n -Owner: "+ ccrOwnerTextField.getText() + "\n -Serial Number: " + ccrDeepNumTextField.getText() + "\n";
		
		
		
		
		}else if(deepCheckBox.isSelected()){//Deep Equipment

			if(regulatorCheckBox.isSelected())
				description+="Regulator:\n -Deep Number: " + regDeepNumTextField.getText() + "\n -Manufacturer: " + regManuTextField.getText() + "\n";
			if(bcdCheckBox.isSelected())
				description+="BCD:\n -Model: " + bcdModelTextField.getText() + "\n";
			if(tankCheckBox.isSelected())
				description+="Tank:\n -Deep Number: " + tankDeepNumTextField.getText() + "\n -Manufacturer: " + tankManuTextField.getText() + "\n";
			if(ccrCheckBox.isSelected())
				description+="CCR:\n -Owner: "+ ccrOwnerTextField.getText() + "\n -Serial Number: " + ccrDeepNumTextField.getText() + "\n";
			
		}else{//Nothing is ticked
			
		}
		
		System.out.println("Description : \n" + description);
		if(Windows.yesNo("Are you sure that you've TICKED everything needed?", "Be completely sure!")==0)
			;//Continue
		
	}
	
}
