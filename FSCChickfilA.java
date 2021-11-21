//William Davidson
//1242220
//william11231999@gmail.com
//CSC 3280 002
//Program 4: FSC Chick-fil-A
//11/12/2020
//I will practice academic and personal integrity and excellence of character and expect the same from others.
package fscchickfila;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FSCChickfilA {

	public static void main(String[] args) throws Exception {
		//Setup to read and write

		File inputFile = new File("FSCChickfilA.in");//Input File
		if (!inputFile.exists()) {//Check if the file exists
			System.out.println("Input file, " + inputFile + ", does not exist.");
			System.exit(0);
		}
		File outputFile = new File("FSCChickfilA.out");//Output File

		Scanner in = new Scanner(inputFile);//Scan from the input file 
		//	commands and info.
		PrintWriter out = new PrintWriter(outputFile);//Prints the results
		//	of a line (if there is one) into the output file

		//Setup for reading lines
		//Number of days the program will be running
		int days = in.nextInt();
		//Number of the order, carries over days
		int orderNum = 274952;
		//Start of the days
		for (int i = 1; i <= days; i++) {
			//Order number for the receipts
			//Print out day
			out.println("**********");
			out.printf("Day %d:\n", i);
			out.println("**********\n");

			//Setup Queues
			//Queue people initially wait in
			ChickfilAQueue outside = new ChickfilAQueue("outside");
			//Queues in the ChickfilA, ints for num people in the line (numPeople) and a boolean for if the persone in the queue is being served (isServing)
			ChickfilAQueue line1 = new ChickfilAQueue("line1");
			int line1NumPeople = 0;
			boolean isServingLine1 = false;
			ChickfilAQueue line2 = new ChickfilAQueue("line2");
			int line2NumPeople = 0;
			boolean isServingLine2 = false;
			ChickfilAQueue line3 = new ChickfilAQueue("line3");
			int line3NumPeople = 0;
			boolean isServingLine3 = false;
			
			//Setup Stack
			//Stack that holds the receipts for the day
			ReceiptStack receipts = new ReceiptStack();

			//Read in and add all coustomers to the outside queue
			int people = in.nextInt();
			for (int j = 0; j < people; j++) {
				HungryPerson newPerson = new HungryPerson(in.nextInt(), in.next(), in.next(), in.nextInt());
				for (int k = 0; k < newPerson.getOrderTime(); k++) {
					MenuItem newItem = new MenuItem(in.next(), in.nextInt());
					newPerson.addMenuItem(newItem);
				}//End of adding order items
				outside.enqueue(newPerson);
			}//End of reading in people

			//Set up time and start the day
			int time = 0;
			//While it is before 8 PM OR ANY of the inside lines have people in them
			while (time < 481 || !line1.isEmpty() || !line2.isEmpty() || !line3.isEmpty()) {
				//Calculate the current time 
				String realTime = getTime(time);
				//Check the queues in the ChickfilA for people
				if (!line1.isEmpty() || !line2.isEmpty() || !line3.isEmpty()) {//If ANY of the lines have anyone
					//If line 1 has someone
					if (!line1.isEmpty()) {
						if (!isServingLine1) {//If the person in line 1 is not currently having their order filled
							out.printf("%s:  %s %s is at the front of Order Line 1 and is now placing order.\n", realTime, line1.peek().getFirstName(), line1.peek().getLastName());
							isServingLine1 = true;
							line1.peek().decreaseOrderTime();
						}
						else if (isServingLine1 && line1.peek().getOrderTime() != 0) {//If the person in line 1 is being served but the order is not done yet
							line1.peek().decreaseOrderTime();
						}
						else if (line1.peek().getOrderTime() == 0) {//If the order for the person in line 1 is done
							line1.peek().getOrder().setTimeCompleted(time);
							line1.peek().getOrder().setOrderNumber(orderNum);
							orderNum++;
							receipts.push(line1.peek().getOrder());
							out.printf("%s:  %s %s received all items, paid $%.2f, and is exiting Order Line 1 (leaving FSC Chick-fil-A).\n", realTime, line1.peek().getFirstName(), line1.peek().getLastName(), receipts.getTotalPrice());
							line1.dequeue();
							line1NumPeople--;
							isServingLine1 = false;
						}
					}
					//If line 2 has someone
					if (!line2.isEmpty()) {
						if (!isServingLine2) {//If the person in line 2 is not currently having their order filled
							out.printf("%s:  %s %s is at the front of Order Line 2 and is now placing order.\n", realTime, line2.peek().getFirstName(), line2.peek().getLastName());
							isServingLine2 = true;
							line2.peek().decreaseOrderTime();
						}
						else if (isServingLine2 && line2.peek().getOrderTime() != 0) {//If the person in line 2 is being served but the order is not done yet
							line2.peek().decreaseOrderTime();
						}
						else if (line2.peek().getOrderTime() == 0) {//If the order for the person in line 2 is done
							line2.peek().getOrder().setTimeCompleted(time);
							line2.peek().getOrder().setOrderNumber(orderNum);
							orderNum++;
							receipts.push(line2.peek().getOrder());
							out.printf("%s:  %s %s received all items, paid $%.2f, and is exiting Order Line 2 (leaving FSC Chick-fil-A).\n", realTime, line2.peek().getFirstName(), line2.peek().getLastName(), receipts.getTotalPrice());
							line2.dequeue();
							line2NumPeople--;
							isServingLine2 = false;
						}
					}
					//If line 3 has someone
					if (!line3.isEmpty()) {
						if (!isServingLine3) {//If the person in line 3 is not currently having their order filled
							out.printf("%s:  %s %s is at the front of Order Line 3 and is now placing order.\n", realTime, line3.peek().getFirstName(), line3.peek().getLastName());
							isServingLine3 = true;
							line3.peek().decreaseOrderTime();
						}
						else if (isServingLine3 && line3.peek().getOrderTime() != 0) {//If the person in line 3 is being served but the order is not done yet
							line3.peek().decreaseOrderTime();
						}
						else if (line3.peek().getOrderTime() == 0) {//If the order for the person in line 3 is done
							line3.peek().getOrder().setTimeCompleted(time);
							line3.peek().getOrder().setOrderNumber(orderNum);
							orderNum++;
							receipts.push(line3.peek().getOrder());
							out.printf("%s:  %s %s received all items, paid $%.2f, and is exiting Order Line 3 (leaving FSC Chick-fil-A).\n", realTime, line3.peek().getFirstName(), line3.peek().getLastName(), receipts.getTotalPrice());
							line3.dequeue();
							line3NumPeople--;
							isServingLine3 = false;
						}
					}
				}

				//Check if the next person in the outside queue has an enter time that matches the current time
				while (time < 480 && !outside.isEmpty() && outside.peek().getEnterTime() == time) {
					out.printf("%s:  %s %s arrived at FSC Chick-fil-A and entered Order Line ", realTime, outside.peek().getFirstName(), outside.peek().getLastName());
					//Add the person to the correct line
					//If all of the lines are the same
					if (line1NumPeople == line2NumPeople && line1NumPeople == line3NumPeople) {
						HungryPerson enteringPerson = outside.dequeue();
						line1.enqueue(enteringPerson);
						line1NumPeople++;
						out.println("1.");
					} //If line1 has less people than line2 AND line 3
					else if (line1NumPeople <= line2NumPeople && line1NumPeople <= line3NumPeople) {
						HungryPerson enteringPerson = outside.dequeue();
						line1.enqueue(enteringPerson);
						line1NumPeople++;
						out.println("1.");
					} //If line 2 has less people than line1 AND has less or an equal amount of people as Line3 
					else if (line2NumPeople < line1NumPeople && line2NumPeople <= line3NumPeople) {
						HungryPerson enteringPerson = outside.dequeue();
						line2.enqueue(enteringPerson);
						line2NumPeople++;
						out.println("2.");
					} //If line3 has less people than line2 AND line1
					else {
						HungryPerson enteringPerson = outside.dequeue();
						line3.enqueue(enteringPerson);
						line3NumPeople++;
						out.println("3.");
					}
				}
				time++;
			}//End of ONE day
			//Print out receipts from the day
			//Setup
			out.println();
			out.printf("*** Day %d:  FSC Chick-fil-A Order Report ***:\n", i);
			out.println();
			out.println("FSC Chick-fil-A Received the following orders:");
			out.println();
			//USe method in ReceiptStaqck to print receipts
			receipts.printStack(out);
		}//End of ALL days
		
		//Close both the in and out files
		in.close();
		out.close();
	}

	//getTime();
	//Return Type - String (Time)
	//Parameters - int time
	//Description - This method will get the time and transform it into 
	//	hour-based time by finding out what hour and minute the given time means
	//	(Example - 256 min = 256 / 60 = 4 (4 hr) and 256 - 240 = 16 (16 min))
	public static String getTime(int time) {
		String realTime = "";
		switch (time / 60) {
			case 0:
				realTime += 12;
				realTime += ":";
				if (time < 10) {
				realTime += "0" + time;
				}
				else {
					realTime += time;
				}
				break;
			case 1:
				realTime += " 1";
				realTime += ":";
				if (time - 60 < 10) {
				realTime += "0" + (time - 60);
				}
				else {
				realTime += time - 60;
				}
				break;
			case 2:
				realTime += " 2";
				realTime += ":";
				if (time - 120 < 10) {
				realTime += "0" + (time - 120);
				}
				else {
				realTime += time - 120;
				}
				break;
			case 3:
				realTime += " 3";
				realTime += ":";
				if (time - 180 < 10) {
				realTime += "0" + (time - 180);
				}
				else {
				realTime += time - 180;
				}
				break;
			case 4:
				realTime += " 4";
				realTime += ":";
				if (time - 240 < 10) {
				realTime += "0" + (time - 240);
				}
				else {
				realTime += time - 240;
				}
				break;
			case 5:
				realTime += " 5";
				realTime += ":";
				if (time - 300 < 10) {
				realTime += "0" + (time - 300);
				}
				else {
				realTime += time - 300;
				}
				break;
			case 6:
				realTime += " 6";
				realTime += ":";
				if (time - 360 < 10) {
				realTime += "0" + (time - 360);
				}
				else {
				realTime += time - 360;
				}
				break;
			case 7:
				realTime += " 7";
				realTime += ":";
				if (time - 420 < 10) {
				realTime += "0" + (time - 420);
				}
				else {
				realTime += time - 420;
				}
				break;
			case 8:
				realTime += " 8";
				realTime += ":";
				if (time - 480 < 10) {
				realTime += "0" + (time - 480);
				}
				else {
				realTime += time - 480;
				}
				break;
			case 9:
				realTime += " 9";
				realTime += ":";
				if (time - 540 < 10) {
				realTime += "0" + (time - 540);
				}
				else {
				realTime += time - 540;
				}
				break;
			case 10:
				realTime += 10;
				realTime += ":";
				if (time - 600 < 10) {
				realTime += "0" + (time - 600);
				}
				else {
				realTime += time - 600;
				}
				break;
			case 11:
				realTime += 11;
				realTime += ":";
				if (time - 660 < 10) {
				realTime += "0" + (time - 660);
				}
				else {
				realTime += time - 660;
				}
				break;
			default:
				break;
		}
		realTime += " PM";
		return realTime;
	}
}
