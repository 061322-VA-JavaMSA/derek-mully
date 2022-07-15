import daos.ReimbursementStatusDao;
import daos.ReimbursementStatusHibernate;
import models.ReimbursementStatus;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReimbursementStatusDao rd = new ReimbursementStatusHibernate();
		ReimbursementStatus r =  rd.getReimbursementByStatus("pending");
		System.out.println(r);
	}

}