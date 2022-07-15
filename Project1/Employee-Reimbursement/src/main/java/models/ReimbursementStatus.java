package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reimbursement_status")
public class ReimbursementStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="reimbursement_status_id")
	private int id;
	@Column 
	private String reim_status;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReim_status() {
		return reim_status;
	}
	public void setReim_status(String reim_status) {
		this.reim_status = reim_status;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", reim_status=" + reim_status + "]";
	}
 
	

}