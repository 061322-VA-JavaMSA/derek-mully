package Model;

public class Offer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	int offerId;
	int itemId;
	int userId;
	int price;
	int status;

	public void setOfferId(int offerId) {
		// TODO Auto-generated method stub
		this.offerId = offerId;
	}
	
	public int getOfferId() {
		return offerId;
	}


	public void setItemID(int itemId) {
		// TODO Auto-generated method stub
		this.itemId = itemId;
	}
	public int getItemId() {
		return itemId;
	}


	public void setUserId(int userId) {
		// TODO Auto-generated method stub
		this.userId = userId;
	}
	public int getUserId(){
		return userId;
	}


	public void setPrice(int price) {
		// TODO Auto-generated method stub
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return "offer [offerId=" + offerId + ",itemId=" + itemId + ", userId=" + userId + ", price=" + price + "]";
	}

	public void setStatus(int status2) {
		// TODO Auto-generated method stub
		
	}
}