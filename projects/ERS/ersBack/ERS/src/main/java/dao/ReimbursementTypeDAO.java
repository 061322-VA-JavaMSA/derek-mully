package dao;

import java.util.List;

import models.ReimbursementType;

public interface ReimbursementTypeDAO {
	ReimbursementType getReimbursementTypeById(int id);
	ReimbursementType getByName(String reimb_type);
	List<ReimbursementType> getReimbursementType();
}