package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Model.Item;

public interface FItemDAO {
	Item createItem(Item i) throws IOException;
	List<Item> retrieveItems() throws SQLException, IOException;
	//1 for accept offer for item and 0 for reject offer
	boolean deleteItemByid(int id) throws IOException;
	Item makeAnOffer(Item i) throws IOException;
}