package Model;

public class Payment {
	int paymentId;
	int userId;
	int itemId;
	int payment;
	int offer;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
	
	public String toString() {
		return "payment [paymentId=" + paymentId + ",userId=" + userId + ", itemId=" + itemId + ", payment=" + payment + ", offer=" + offer + "]";
	}
}