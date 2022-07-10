package Models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="p1_reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reimb_id")
	int reimbId;
	@Column(name = "reimb_amount", nullable = false)
	double reimbAmount;
	@Column(name = "reimb_type_id", nullable = false)
	int reimbTypeId;
	@Column(name = "reimb_description")
	String reimbDescription;
	@Column(name = "reimb_submitted")
    LocalDateTime reimbSubmitted;
	@Column(name = "reimb_resolved")
    LocalDateTime reimbResolved;
	@Column(name = "reimb_author")
    int reimbAuthor;
	@Column(name = "reimb_resolver")
    int reimbResolver;
	@Column(name = "reimb_status_id")
    int reimbStatusId;
	
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public LocalDateTime getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(LocalDateTime reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public LocalDateTime getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(LocalDateTime reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
    
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbTypeId=" + reimbTypeId
				+ ", reimbDescription=" + reimbDescription + ", reimbSubmitted=" + reimbSubmitted + ", reimbResolved="
				+ reimbResolved + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatusId=" + reimbStatusId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(reimbAmount, reimbAuthor, reimbDescription, reimbId, reimbResolved, reimbResolver,
				reimbStatusId, reimbSubmitted, reimbTypeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(reimbAmount) == Double.doubleToLongBits(other.reimbAmount)
				&& reimbAuthor == other.reimbAuthor && Objects.equals(reimbDescription, other.reimbDescription)
				&& reimbId == other.reimbId && Objects.equals(reimbResolved, other.reimbResolved)
				&& reimbResolver == other.reimbResolver && reimbStatusId == other.reimbStatusId
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted) && reimbTypeId == other.reimbTypeId;
	}
	
	
	
}