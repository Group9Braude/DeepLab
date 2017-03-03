package entities;


public class Order extends GeneralMessage {

	private int orderNum, handled;//handled -1 - Not handled, 0 - Is being handled, 1-finished an prepared
	private String custID, description, Comments,date;
	public static Order currentOrder;
	
	public Order(int handled, String custID, String description, String comments, String date) {
		super();
		this.handled = handled;
		this.custID = custID;
		this.description = description;
		Comments = comments;
		this.date = date;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getHandled() {
		return handled;
	}
	public void setHandled(int handled) {
		this.handled = handled;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	
	
}
