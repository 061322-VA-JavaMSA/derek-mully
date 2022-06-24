package FService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.FOfferDAO;
import DAO.FOfferPostgres;
import Model.Offer;

public class FOfferServe {
	private FOfferDAO od = new FOfferPostgres();
	public List<Offer> getOffers() throws SQLException, IOException {
		return od.retrieveOffers();
	}
	
	public boolean ChangeOfferStatus(Offer o) throws SQLException, IOException {
		return od.updateOffer(o);
		
	}
}