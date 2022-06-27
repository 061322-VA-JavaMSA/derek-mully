package Model;

public class Offer {

	public static void main(String[] args) {
		
	}

	int offerId;
	int userId;
	int itemId;
	int price;
	int status;

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	
	public int getOfferId() {
		return offerId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId(){
		return userId;
	}
	
	public void setItemID(int itemId) {
		this.itemId = itemId;
	}
	public int getItemId() {
		return itemId;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	
	public String toString() {
		return "offer [offerId=" + offerId + ", userId=\" + userIditemId=" + itemId + ", price=" + price + "]";
	}

	public void setStatus(int status) {
		this.status = status;
		// TODO Auto-generated method stub
		
	}

	public int getStatus() {
		// TODO Auto-generated method stub
		return status;
	}
}