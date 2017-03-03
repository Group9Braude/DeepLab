package Main;

import java.io.IOException;
import Entities.*;
import ocsf.client.AbstractClient;

public class Client extends AbstractClient {

	public Client() {
		super(Main.host, Main.port);
		try {
			this.openConnection();
		} catch (IOException e) {
			System.out.println("caught");
			e.printStackTrace();
		}
	}
	
	

	@Override
	protected void handleMessageFromServer(Object msg) {
		System.out.println("handleMessageFromServer");
		switch(((GeneralMessage)msg).actionNow){
		case "Incorrect":
			Worker.setCurrentWorker(new Worker());break;
		case "Correct":
			Worker.setCurrentWorker((Worker)msg);break;
		
		}
	}

}
