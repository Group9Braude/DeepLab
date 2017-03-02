package Main;

import java.io.IOException;
import Entities.*;
import ocsf.client.AbstractClient;

public class Client extends AbstractClient {

	public Client() {
		super(Main.host, Main.port);
		try {this.openConnection();} catch (IOException e) {e.printStackTrace();}
	}
	
	public void sendServer(Object msg, String actionNow){
			try {this.sendToServer(msg);} catch (Exception e) {e.printStackTrace();}
	}
	
	public void onLogin(){
		BCD bcd = new BCD();
		sendServer(bcd, "");
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		
	}

}
