package entities;

public class BCD extends GeneralMessage {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String deepNum, size, model, manufacturer;

public String getDeepNum() {
	return deepNum;
}

public void setDeepNum(String deepNum) {
	this.deepNum = deepNum;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public String getManufacturer() {
	return manufacturer;
}

public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}

}
