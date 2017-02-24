package Entities;

public class Worker {
	private String ID,fName,lName,email;
	private int isManager;//Only one manager exists
	public Worker(){}
	public Worker(String ID,String fName,String lName,String email,int isManager)
	{
		this.ID = ID;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.isManager = isManager;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsManager() {
		return isManager;
	}
	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
}	
