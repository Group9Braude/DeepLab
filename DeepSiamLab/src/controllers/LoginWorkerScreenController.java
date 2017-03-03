package controllers;

import ocsf.client.AbstractClient;

import java.io.IOException;

import main.Main;

public class LoginWorkerScreenController extends AbstractClient{

	public LoginWorkerScreenController() {
		super(Main.host, Main.port);
		try {
			this.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onCheckEquipment()
	{
		try {
			Main.showMenu("CheckEquipmentScreen");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onIssueOrder(){
		try {Main.showMenu("OpenCardScreen");} catch (IOException e) {e.printStackTrace();}
	}
	
	@Override
	protected void handleMessageFromServer(Object msg) {
		
	}

}
