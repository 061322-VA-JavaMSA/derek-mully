package dtos;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.User;

@SuppressWarnings("unused")
public class ReimbursementDto {

	private int id;
	private int amount;
	private Timestamp  submitted;
 	private Timestamp  resolved;
	private String description;
	private User author;
	private User resolver;
	private ReimbursementStatus  reimbursementStatus;
	private ReimbursementType reimbursementType;
	
	
	public ReimbursementDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementDto(Reimbursement r) {
		id = r.getId();
		amount = r.getAmount();
		description = r.getDescription();
		author = r.getAuthor();
		resolver = r.getResolver();
		reimbursementStatus = r.getReimbursementStatus();
		reimbursementType = r.getReimbursementType();
	}
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
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public User getResolver() {
		return resolver;
	}
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	public ReimbursementStatus getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(ReimbursementStatus reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	public ReimbursementType getReimbursementType() {
		return reimbursementType;
	}
	public void setReimbursementType(ReimbursementType reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
	@Override
	public String toString() {
		return "ReimbursementDto [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", reimbursementStatus=" + reimbursementStatus + ", reimbursementType=" + reimbursementType + "]";
	}
	
	
	

	
	
}