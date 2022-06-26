import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;

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
			default: System.out.println("That's not it. Please try again. Press 0 to exit.");
					 System.exit(0);
		}
		
		loginPage(username, password);
		
		scan.close();
	}
	
	public static void loginPage(String username, String password) throws IOException, SQLException {
		try {
			fa.login(username, password);
			
		} catch (LoginException e) {
			System.out.println("That's not it. Please try again. Press 0 to exit.");
			System.exit(0);
		}
		user_id = fa.checkid(username);
		if(fa.checkAdmin(username) == false) {
			menu();
		} else {
			adminMenu();
		}
	}
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
		case 3: makeOffer();
		default: 
				menu();
				break;
	}
	}
	
	public static void listItem() throws SQLException, IOException {
		List<Item> items = fi.getItems();
		for(Item i: items) {
			System.out.println(i);
		}
	}
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
		System.out.println("Your offer has been received. Please wait at least 3 business days for a response.");
		
	}
	
	public static void adminMenu() throws  IOException, SQLException {
		
		System.out.println("Hello, admin!");
		System.out.println("Press 1 and hit enter to remove an item.");
		System.out.println("Press 2 and hit enter to add an item.");
		System.out.println("Press 3 and hit enter to review current offers.");
		switch(scan.nextInt()) {
		case 1: 
				deleteItem();
				adminMenu();
				break;
		case 2: 
				addItem();
				adminMenu();
				break;
		case 3: checkOffers();
				break;
		default:
				adminMenu();
				break;
	}
	};

	

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
		}
	}
	
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
		}
	}

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