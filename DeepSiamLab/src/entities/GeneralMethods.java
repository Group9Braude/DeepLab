package entities;

import main.Client;

public class GeneralMethods {
	public void sendServer(Object msg, String actionNow){/******************************/
		try {
			((GeneralMessage)msg).actionNow = actionNow;
			Client client = new Client();
			try {
				client.openConnection();
				client.sendToServer(msg);
			} catch (Exception e) {e.printStackTrace();}
		} catch (Exception e) {	e.printStackTrace();}
	}

	public void Sleep(int time){
		try{Thread.sleep(time);}catch(InterruptedException e){e.printStackTrace();}
	}
	
}
