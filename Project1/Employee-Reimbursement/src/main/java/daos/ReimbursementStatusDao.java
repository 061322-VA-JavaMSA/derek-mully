package daos;

import models.ReimbursementStatus;

public interface ReimbursementStatusDao {

	 ReimbursementStatus getReimbursementStatusById(int id);
	 ReimbursementStatus getReimbursementByStatus(String reimbursement_status);
}