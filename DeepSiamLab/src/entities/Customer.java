package entities;

public class Customer extends GeneralMessage{
private String name, lastName, custID, email;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getCustID() {
	return custID;
}

public void setCustID(String custID) {
	this.custID = custID;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

}
