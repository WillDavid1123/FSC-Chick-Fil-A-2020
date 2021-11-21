//William Davidson
//1242220
//william11231999@gmail.com
//CSC 3280 002
package fscchickfila;

public class ChickfilAQueue {

	//Properties
	private HungryPerson front;
	private HungryPerson back;
	private String name;
	private HungryPerson next;

	//Constructors
	public ChickfilAQueue() {
		this.front = null;
		this.back = null;
		this.next = null;
	}

	public ChickfilAQueue(String name) {
		this.front = null;
		this.back = null;
		this.next = null;
		this.name = name;
	}

	//Methods
	public boolean isEmpty() {
		return front == null;
	}

	//Enter a new person into the queue at the back
	public void enqueue(HungryPerson newPerson) {
		if (isEmpty()) {//If the queue is empty
			this.front = this.back = enqueue(front, back, newPerson);
		}
		else {//If the queue has people
			this.back = enqueue(front, back, newPerson);
		}
	}
	
	private HungryPerson enqueue(HungryPerson front, HungryPerson back, HungryPerson newPerson) {
		if (isEmpty()) {//If the queue is empty
			return newPerson;
		}
		else {//If the queue has people
			this.back.setNext(newPerson);
			back = back.getNext();
			return back;
		}
	}
	
	//Remove the person from the front of the queue
	public HungryPerson dequeue() {
		HungryPerson temp = this.front;
		front = dequeue(front);
		if (front == null) {
			this.back = null;
		}
		temp.setNext(null);
		return temp;
	}
	
	private HungryPerson dequeue(HungryPerson front) {
		front = front.getNext();
		return front;
	}
	
	//Look at the person at the front of the queue without removing them
	public HungryPerson peek() {
		return peek(this.front);
	}
	
	private HungryPerson peek(HungryPerson front) {
		return this.front;
	}
	
	//Print the queue for testing
	public void printQueue() {
		printQueue(this.front);
	}
	
	private void printQueue(HungryPerson front) {
		HungryPerson helpPtr = front;
		while(helpPtr != null) {
			System.out.print("[" + helpPtr.getFirstName() + ", " + helpPtr.getEnterTime() + "] \n");
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}
}
