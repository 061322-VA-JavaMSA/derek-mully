package dtos;

import java.sql.Timestamp;

import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.User;

@SuppressWarnings("unused")
public class reimbursementStatusUpdateDto {
	
	private int id;
	private int resolver_id;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "reimbursementStatusUpdateDto [id=" + id + ", resolver_id=" + resolver_id + ", status=" + status + "]";
	}
	
	
	
	
	
	
	

	
	

	

}