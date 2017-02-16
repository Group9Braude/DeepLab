package equipment;

public class Regulators {
	private int regNum;
	private String regName, regKind, regMenufacture;
	
	
	
	
	public Regulators(int regNum, String regName, String regKind, String regMenufacture) {
		this.regNum = regNum;
		this.regName = regName;
		this.regKind = regKind;
		this.regMenufacture = regMenufacture;
	}
	public int getRegNum() {
		return regNum;
	}
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegKind() {
		return regKind;
	}
	public void setRegKind(String regKind) {
		this.regKind = regKind;
	}
	public String getRegMenufacture() {
		return regMenufacture;
	}
	public void setRegMenufacture(String regMenufacture) {
		this.regMenufacture = regMenufacture;
	}
}
