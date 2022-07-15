package dao;

import models.ReimbursementStatus;

public interface ReimbursementStatusDAO {
	 ReimbursementStatus getReimbursementStatusById(int id);
	 ReimbursementStatus getByName(String reimb_status);
}