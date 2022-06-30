import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import FException.LoginException;
import FService.FAuthorization;
import FService.FItemServe;
import FService.FOfferServe;
import FService.FPaymentServe;
import FService.FUserServe;
import Model.Item;
import Model.User;
import Model.Offer;
import Model.Payment;

public class ForklyDriver {
	//access all services and scanner through defined variables that reference service classes
	private static Logger log = LogManager.getLogger(ForklyDriver.class);
	static Scanner scan;
	static FAuthorization fa;
	static FUserServe fu;
	static FPaymentServe fp;
	static FItemServe fi;
	static FOfferServe fo;
	static String username = null;
	static String password = null;
	static int user_id;
	
	public static void main(String[] args) throws LoginException, IOException, SQLException {
		fa = new FAuthorization();
		fo = new FOfferServe();
		fp = new FPaymentServe();
		fu = new FUserServe();
		fi = new FItemServe();
		
		scan = new Scanner(System.in);
		
		System.out.println("Press 1 to register a new account. Press 2 to login. Then hit enter.");
		// 1 will register a new account in the database and 2 will access existing accounts
		switch (scan.nextInt()) {
			case 1: System.out.println("Enter your desired username.");
					String uname = scan.next();
					System.out.println("Enter your desired password.");
					String pass = scan.next();
					User userTBC = new User();
					userTBC.setUsername(uname);
					userTBC.setPassword(pass);
					System.out.println(fu.createUser(userTBC));
					username = uname;
					password = pass;
					break;

			case 2: System.out.println("Enter your username:");
					username = scan.next();
					System.out.println("Enter your password:");
					password = scan.next();	
					break;
			//Don't know how to return with switch(scan)
			default: System.out.println("That's not it. Please try again.");
					 System.exit(0);
		}
		//both cases 1 and 2 bring to login page
		loginPage(username, password);
		
		scan.close();
	
	}

	public static void loginPage(String username, String password) throws IOException, SQLException {
		try {
			fa.login(username, password);
			
		} catch (LoginException e) {
			System.out.println("That's not it. Please try again.");
			System.exit(0);
		}
		//if else statement says that if the user logs in and the employee boolean says that it's false,
		//then the the customer menu will be brought up. Meaning if the isEmployee column in the database is null,
		//then the customer menu is brought up. If it equals to 1, then the employee menu is brought up.
		user_id = fa.checkid(username);
		if(fa.checkEmployee(username) == false) {
			menu();
		} else {
			employeeMenu();
		}
	}
	//customer navigation menu
	public static void menu( ) throws SQLException, IOException {
		System.out.println("Welcome to Forkly, valued customer!");
		System.out.println("Press 1 and hit enter to see our items.");
		System.out.println("Press 2 and hit enter to make a purchase.");
		System.out.println("Press 3 and hit enter to make an offer.");
		switch(scan.nextInt()) {
		case 1: 
				listItem();
				menu();
				break;
		case 2:
			//still haven't figured out what to do with payments, so currently it uses the same function as making an offer
		case 3: makeOffer();
		default: 
				menu();
				break;
	}
	}
	//uses the item service to get items and list the values in the console
	public static void listItem() throws SQLException, IOException {
		List<Item> items = fi.getItems();
		for(Item i: items) {
			System.out.println(i);
		}
	}
	//make offer menu option lists items and asks to choose one, then sends offers for approval for employee
	//if in employee menu these offers can be accepted
	public static void makeOffer() throws IOException, SQLException {
		int itemid;
		int price;
		Item i = new Item();
	
		listItem();
		System.out.println("Type the ID of the item you'd like to buy and press enter.");
		itemid = scan.nextInt();
		System.out.println("Enter your offer price and press enter.");
		price = scan.nextInt();
		i.setId(itemid);
		i.setOffer(price);
		i.setUserId(user_id);
		fi.makeOffer(i);
		log.info("Your offer " + price + " has been taken in for user number " + user_id);
		System.out.println("Your offer has been received. Please wait at least 3 business days for a response.");
		
	}
	//employee menu functioning because of isAdmin boolean created in database. 
	public static void employeeMenu() throws  IOException, SQLException {
		
		System.out.println("Hello, employee!");
		System.out.println("Press 1 and hit enter to remove an item.");
		System.out.println("Press 2 and hit enter to add an item.");
		System.out.println("Press 3 and hit enter to review current offers.");
		switch(scan.nextInt()) {
		case 1: 
				deleteItem();
				employeeMenu();
				break;
		case 2: 
				addItem();
				employeeMenu();
				break;
		case 3: checkOffers();
				break;
		default:
				employeeMenu();
				break;
	}
	};

	private static void checkOffers() throws SQLException, IOException {
		int itemId;
		int offerId;
		int status;
		List<Offer> offers = fo.getOffers();
		for(Offer o: offers) {
			System.out.println(o);
		}
		System.out.println("Enter the ID of the offer to make a decision.");
		offerId = scan.nextInt();
		System.out.println("Press 1 and hit enter to accept the offer. Press 0 and hit enter to deny the offer.");
		status = scan.nextInt();
		Offer of = new Offer();
		of.setOfferId(offerId);
		of.setStatus(status);
		fo.ChangeOfferStatus(of);
		
		if(status == 1) {
			itemId = directToPayment(offerId);
			fo.rejectPendingOffers(itemId);
			//need a return for rejectPendingOffers back to employee menu
		}
	}	
	//accesses "itemname" and "price" columns in items table in SQL and adds item to table if inputs are valid
	public static void addItem() throws IOException {
		String itemname;
		int price;
		System.out.println("Enter the name of the item: ");
		itemname = scan.next();
		System.out.println("Enter the price of the item: ");
		price = scan.nextInt();
		Item addItem = new Item();
		addItem.setItemname(itemname);
		addItem.setPrice(price);
		System.out.println(fi.createItem(addItem));
		System.out.println("Congratulations! Item succesfully added to system.");
	}
	//accesses existing items in items table in SQL database and allows access to remove items from store
	public static void deleteItem() {
		try {
			listItem();
			System.out.println("Type the ID of the item you'd like to delete and press enter: ");
			fi.deleteItem(scan.nextInt());
			System.out.println("Congratulatins! Item has succesfully been deleted from the system.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			//need a way to return to the main employee menu from here
		}
	}
	

	//payment still functioning as offer...must figure out
	public static int directToPayment(int offerId) throws SQLException, IOException {
		Offer offer = new Offer();
		offer = fo.retrieveOfferById(offerId);
		Payment pm = new Payment();
		pm.setItemId(offer.getItemId());
		pm.setUserId(offer.getUserId());
		pm.setOffer(offer.getPrice());
		fp.createPayment(pm);
		return pm.getItemId();
	}
	
	
	
}