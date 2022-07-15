package models;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int amount;
	@Column 
	private Timestamp  submitted;
	@Column
 	private Timestamp  resolved;
	@Column
	private String description;
	@ManyToOne
    @JoinColumn(name = "author_id")
	private User author;
	@ManyToOne
    @JoinColumn(name = "resolver_id")
	private User resolver;
	@ManyToOne 
	@JoinColumn(name = "reimbursement_status_id")	
	private ReimbursementStatus  reimbursementStatus;
	@ManyToOne 
	@JoinColumn(name = "reimbursement_type_id")
	private ReimbursementType reimbursementType;
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
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", reimbursementStatus=" + reimbursementStatus + ", reimbursementType=" + reimbursementType + "]";
	}
	
	
	
}