package DAO;

import Model.Offer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface FOfferDAO {
	List<Offer> retrieveOffers() throws SQLException, IOException;

	boolean updateOffer(Offer o) throws SQLException, IOException;

	boolean rejectPendingOffer(int itemId) throws IOException;

	Offer retrieveOffersById(int offerId) throws SQLException, IOException;
}