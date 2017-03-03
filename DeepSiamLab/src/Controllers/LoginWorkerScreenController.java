package Controllers;

import ocsf.client.AbstractClient;

import java.io.IOException;

import Main.Main;

public class LoginWorkerScreenController extends AbstractClient{

	public LoginWorkerScreenController() {
		super(Main.host, Main.port);
		try {
			this.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void gotoCheckScreen()
	{
		try {
			Main.showMenu("LoginWorkerScreen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		
	}

}
