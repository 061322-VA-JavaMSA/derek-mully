package Model;

public class Item {
	int itemId;
	String itemName;
	int price;
	int offer;
	int userId;
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
		return "item [id=" + itemId + ", itemname=" + itemName + ", price=" + price + "]";
	}

	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
	
	public void setUserId (int userId) {
		this.userId = userId;
	}
	
	public int getUserId () {
		return userId;
	}
}