//William Davidson
//1242220
//william11231999@gmail.com
//CSC 3280 002
package fscchickfila;

public class MenuItem {
	//Properties
	private String itemName;
	private int itemQuantity;
	
	//Constructors
	public MenuItem() {
	}

	public MenuItem(String itemName, int itemQuantity) {
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}
	
	//Getters and Setters

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	//Methods
	public Double getItemPrice() {
		//Record every menu itam and price
		//Check if the itemName matches any menu item
		switch (this.itemName) {
			case "Chicken_Sandwich":
				return 3.05;
			case "Chicken_Sandwich_Combo":
				return 5.95;
			case "Chicken_Sandwich_Spicy":
				return 3.29;
			case "Chicken_Sandwich_Combo_Spicy":
				return 6.79;
			case "Nuggets_8_Piece":
				return 3.05;
			case "Nuggets_12_Piece":
				return 4.45;
			case "Nuggets_8_Piece_Combo":
				return 5.95;
			case "Nuggets_12_Piece_Combo":
				return 8.59;
			case "Grilled_Chicken_Sandwich":
				return 4.39;
			case "Grilled_Chicken_Sandwich_Combo":
				return 7.19;
			case "Waffle_Fries_Small":
				return 1.55;
			case "Waffle_Fries_Medium":
				return 1.65;
			case "Waffle_Fries_Large":
				return 1.85;
			case "Milkshake_Small":
				return 2.75;
			case "Milkshake_Large":
				return 3.15;
			case "Water_Dasani":
				return 1.59;
			case "Soft_Drink_Small":
				return 1.35;
			case "Soft_Drink_Medium":
				return 1.59;
			case "Soft_Drink_Large":
				return 1.85;
			default:
				return 0.00;
		}
	}
}
