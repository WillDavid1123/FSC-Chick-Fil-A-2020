//William Davidson
//1242220
//william11231999@gmail.com
//CSC 3280 002
package fscchickfila;

public class ChickfilAOrder {
	//Properties
	private MenuItem[] item4order;
	private int numItems;
	private int totalPrice;
	private int orderNumber;
	private int timeCompleted;
	private ChickfilAOrder next;
	
	//Constructors
	public ChickfilAOrder() {
		this.item4order = new MenuItem[numItems];
		this.numItems = 0;
	}


	public ChickfilAOrder(int numItems) {
		this.numItems = 0;
		this.item4order = new MenuItem[numItems];
		this.orderNumber = 0;
		this.next = null;
	}

	
	public ChickfilAOrder(int numItems, int totalPrice, int orderNumber, int timeCompleted) {
		this.item4order = new MenuItem[numItems];
		this.numItems = 0;
		this.totalPrice = totalPrice;
		this.orderNumber = orderNumber;
		this.timeCompleted = timeCompleted;
		this.next = null;
	}
	
	//Getters and Setters
	public MenuItem getIndexItem4order(int index) {
		return item4order[index];
	}

	public MenuItem[] getItem4order() {
		return item4order;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getTimeCompleted() {
		return timeCompleted;
	}

	public void setTimeCompleted(int timeCompleted) {
		this.timeCompleted = timeCompleted;
	}

	public ChickfilAOrder getNext() {
		return next;
	}

	public void setNext(ChickfilAOrder next) {
		this.next = next;
	}
	
	//Methods
	public void addMenuItem(MenuItem item) {
		this.item4order[numItems] = item;
		this.numItems++;
	}
}
