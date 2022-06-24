package Forkly;

public class Item {
	int itemId;
	String itemName;
	int price;
	public static void main(String[] args) {

	}

	public void setId(int id) {
		this.itemId = id;
	}
	
	public int getId() {
		return itemId;
	}

	public void setItemname(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemname() {
		return itemName;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return "Item [itemname=" + itemName + ", price=" + price + "]";
	}
}