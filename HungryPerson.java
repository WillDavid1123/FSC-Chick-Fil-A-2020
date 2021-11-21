//William Davidson
//1242220
//william11231999@gmail.com
//CSC 3280 002
package fscchickfila;

public class HungryPerson {
	//Properties
	private String firstName;
	private String lastName;
	private int enterTime;
	private int orderTime;
	private ChickfilAOrder order;
	private HungryPerson next;
	
	//Constructors
	public HungryPerson() {
	}

	public HungryPerson(int enterTime, String firstName, String lastName, int orderTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.enterTime = enterTime;
		this.orderTime = orderTime;
		this.order = new ChickfilAOrder(orderTime);
		this.next = null;
	}
	
	//Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(int enterTime) {
		this.enterTime = enterTime;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public ChickfilAOrder getOrder() {
		return order;
	}

	public void setOrder(ChickfilAOrder order) {
		this.order = order;
	}
	

	public MenuItem getIndexOrder(int index) {
		return this.order.getIndexItem4order(index);
	}

	public HungryPerson getNext() {
		return next;
	}

	public void setNext(HungryPerson next) {
		this.next = next;
	}
	
	//Methods
	
	//Lower the order time when being served at the front of a queue
	public void decreaseOrderTime() {
		this.orderTime--;
	}
	
	public void addMenuItem(MenuItem item) {
		this.order.addMenuItem(item);
	}

}
