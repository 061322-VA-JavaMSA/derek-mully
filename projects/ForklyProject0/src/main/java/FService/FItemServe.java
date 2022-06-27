package FService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.FItemDAO;
import DAO.FItemPostgres;
import Model.Item;

public class FItemServe {
	private FItemDAO id = new FItemPostgres();
	//all accessing items table and offers table from database
	public List<Item> getItems() throws SQLException, IOException {
		return id.retrieveItems();
	}
	
	public Item createItem(Item i) throws IOException {
		return id.createItem(i);
		
	}
	public boolean deleteItem(int i) throws IOException {
		return id.deleteItemByid(i);
	}
	
	public Item makeOffer(Item i) throws IOException {
		return id.makeAnOffer(i);
	}
}