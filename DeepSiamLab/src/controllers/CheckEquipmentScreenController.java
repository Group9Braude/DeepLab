package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.Main;
import ocsf.client.AbstractClient;
public class CheckEquipmentScreenController extends AbstractClient
{
	@FXML
	public CheckBox oilBox,cleanBox;
	public TextField hoursTextField;
	public TabPane allTab;
	public Tab compTab,regTab,tankTab,BCDTab,CCRTab;
	public Text hoursText;
	public CheckEquipmentScreenController() {
		super(Main.host, Main.port);
		try {
			this.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onContinue()
	{
		cleanBox.setTextFill(Color.BLACK);
		oilBox.setTextFill(Color.BLACK);
		hoursText.setFill(Color.BLACK);
		boolean allRight = true;
		float hours;
		Tab curTab = allTab.getSelectionModel().getSelectedItem();
		if(curTab.equals(compTab))
		{
			if(!cleanBox.isSelected())
			{
				cleanBox.setTextFill(Color.RED);
				allRight = false;
			}

			if(!oilBox.isSelected())
			{
				oilBox.setTextFill(Color.RED);
				allRight = false;
			}
			if(!hoursTextField.getText().equals(""))
			{
				try{
					Float converter = new Float(0);
					hours = converter.parseFloat(hoursTextField.getText());
				}catch(NumberFormatException e)
				{
					hoursText.setFill(Color.RED);
					allRight = false;
				}
			}
			else
			{
				hoursText.setFill(Color.RED);
				allRight = false;
			}
			if(allRight)
				System.out.println("Well done!");
			else System.out.println("You suck!");
		}

	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		// TODO Auto-generated method stub

	}

}
