//William Davidson
//1242220
//william11231999@gmail.com
//CSC 3280 002
package fscchickfila;

import java.io.PrintWriter;

public class ReceiptStack {

	//Properties
	private ChickfilAOrder top;

	//Constructors
	public ReceiptStack() {
		top = null;
	}

	//Methods
	public boolean isEmpty() {
		return top == null;
	}

	//Put a new order on top of the stack
	public void push(ChickfilAOrder newOrder) {
		top = push(top, newOrder);
	}

	private ChickfilAOrder push(ChickfilAOrder top, ChickfilAOrder newOrder) {
		newOrder.setNext(top);
		return newOrder;
	}

	//Remove the top order from the stack
	public ChickfilAOrder pop() {
		ChickfilAOrder temp = top;
		top = pop(top);
		return temp;
	}

	private ChickfilAOrder pop(ChickfilAOrder top) {
		top = top.getNext();
		return top;
	}

	public ChickfilAOrder peek() {
		return peek(top);
	}

	private ChickfilAOrder peek(ChickfilAOrder top) {
		return top;
	}

	public void printStack(PrintWriter out) {
		printStack(top, out);
	}

	//Print the stack for the end of the day
	private void printStack(ChickfilAOrder top, PrintWriter out) {
		//Go through eack order in the stack
		ChickfilAOrder helpPtr = top;
		while (helpPtr != null) {
			out.printf("Order Number:  %d\n", helpPtr.getOrderNumber());
			//Calculate time the order was completed by getting the time and 
			//	transforming it into hour-based time by finding out what hour 
			//	and minute the given time means.
			//	(Example - 256 min = 256 / 60 = 4 (4 hr) and 256 - 240 = 16 (16 min))
			int timeHR = 0;
			String timeMin = "";
			switch (helpPtr.getTimeCompleted() / 60) {
				case 0:
					timeHR = 12;
					if (helpPtr.getTimeCompleted() < 10) {
						timeMin += "0" + helpPtr.getTimeCompleted();
					} else {
						timeMin += helpPtr.getTimeCompleted();
					}
					break;
				case 1:
					timeHR = 1;
					if (helpPtr.getTimeCompleted() - 60 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 60);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 60;
					}
					break;
				case 2:
					timeHR = 2;
					if (helpPtr.getTimeCompleted() - 120 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 120);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 120;
					}
					break;
				case 3:
					timeHR = 3;
					if (helpPtr.getTimeCompleted() - 180 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 180);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 180;
					}
					break;
				case 4:
					timeHR = 4;
					if (helpPtr.getTimeCompleted() - 240 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 240);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 240;
					}
					break;
				case 5:
					timeHR = 5;
					if (helpPtr.getTimeCompleted() - 300 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 300);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 300;
					}
					break;
				case 6:
					timeHR = 6;
					if (helpPtr.getTimeCompleted() - 360 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 360);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 360;
					}
					break;
				case 7:
					timeHR = 7;
					if (helpPtr.getTimeCompleted() - 420 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 420);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 420;
					}
					break;
				case 8:
					timeHR = 8;
					if (helpPtr.getTimeCompleted() - 480 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 480);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 480;
					}
					break;
				case 9:
					timeHR = 9;
					if (helpPtr.getTimeCompleted() - 540 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 540);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 540;
					}
					break;
				case 10:
					timeHR = 10;
					if (helpPtr.getTimeCompleted() - 600 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 600);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 600;
					}
					break;
				case 11:
					timeHR = 11;
					if (helpPtr.getTimeCompleted() - 660 < 10) {
						timeMin += "0" + (helpPtr.getTimeCompleted() - 660);
					} else {
						timeMin += helpPtr.getTimeCompleted() - 660;
					}
					break;
				default:
					break;
			}
			out.printf("	Time Completed:%4d:%s PM\n", timeHR, timeMin);
			out.println("	Items:  ");
			out.printf("\t| %-30s | %-10s | %-10s |\n", "NAME", "PRICE", "QUANTITY");
			//Print the ordered items 
			for (int i = 0; i < helpPtr.getItem4order().length; i++) {
				out.printf("\t| %-30s | $%-9s | %-10s |\n", helpPtr.getIndexItem4order(i).getItemName(), helpPtr.getIndexItem4order(i).getItemPrice(), helpPtr.getIndexItem4order(i).getItemQuantity());
			}
			double totalPrice = getTotalPrice(helpPtr);
			out.printf("	Total Price:  $%.2f\n", totalPrice);
			helpPtr = helpPtr.getNext();
		}
		out.println("");
		out.println("");
	}

	//getTotalPrice()
	//Return Type - double (Total Price)
	//Parameters - NA (ChickfilAOrder helpPtr for private)
	//Description - This method gets the total price for an order. It is 
	//	seperate from the printStack method so it can be used in the main 
	//	program.
	public double getTotalPrice() {
		return getTotalPrice(this.top);
	}

	private double getTotalPrice(ChickfilAOrder helpPtr) {
		double totalPrice = 0;
		for (int i = 0; i < helpPtr.getItem4order().length; i++) {
			totalPrice += helpPtr.getIndexItem4order(i).getItemPrice() * helpPtr.getIndexItem4order(i).getItemQuantity();
		}
		return totalPrice;
	}
}
