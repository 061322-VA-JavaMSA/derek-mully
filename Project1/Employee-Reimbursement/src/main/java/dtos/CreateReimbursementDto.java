package dtos;



public class CreateReimbursementDto {

	
	private int id;
	private int amount;
	private int author_id;
	private int resolver_id;
	private int reimbursement_status_id;
	private int reimbursement_type_id;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public int getReimbursement_status_id() {
		return reimbursement_status_id;
	}
	public void setReimbursement_status_id(int reimbursement_status_id) {
		this.reimbursement_status_id = reimbursement_status_id;
	}
	public int getReimbursement_type_id() {
		return reimbursement_type_id;
	}
	public void setReimbursement_type_id(int reimbursement_type_id) {
		this.reimbursement_type_id = reimbursement_type_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CreateReimbursementDto [id=" + id + ", amount=" + amount + ", author_id=" + author_id + ", resolver_id="
				+ resolver_id + ", reimbursement_status_id=" + reimbursement_status_id + ", reimbursement_type_id="
				+ reimbursement_type_id + ", description=" + description + "]";
	} 
	
	
	
	
	
	
	
	
	
}