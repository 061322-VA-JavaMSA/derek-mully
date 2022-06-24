package ForklyCustomers;

import java.sql.Connection;
import java.util.Objects;
import java.util.Scanner;

public class NewCustomer{
	
	public static String firstName = null;
	public static String lastName = null;
	public static String userName = null;
	public static String passWord = null;
	public static NewCustomer nc = new NewCustomer();
	public static Connection getHardcodedConnection;
	
	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)){
			
			System.out.println("Enter your first name: ");
			String firstName = scan.nextLine();
			nc.setFirstName(firstName);
			
			System.out.println("Enter your last name: ");
			String lastName = scan.nextLine();
			nc.setLastName(lastName);
			
			System.out.println("Pick your username: ");
			String userName = scan.nextLine();
			nc.setUserName(userName);
			
			System.out.println("Create a password: ");
			String passWord = scan.nextLine();
			nc.setPassWord(passWord);
			
			scan.close();
			
			System.out.println(nc.toString());
		}
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		NewCustomer.firstName = firstName;
	}
	public String getLastName() {
		return lastName ;
	}
	public void setLastName(String lastName) {
		NewCustomer.lastName = lastName;
	}
	public static String getUserName() {
		return userName ;
	}
	public void setUserName(String userName) {
		NewCustomer.userName = userName;
	}
	public static String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		NewCustomer.passWord = passWord;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, userName, passWord);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return Objects.equals(firstName, NewCustomer.firstName)
				&& Objects.equals(lastName, NewCustomer.lastName) && Objects.equals(userName, NewCustomer.userName)
				&& Objects.equals(passWord, NewCustomer.passWord);
	}

	@Override
	public String toString() {
		return "New Customer: [First Name = " + firstName + ", Last Name = " + lastName
				+ ", Username = " + userName + ", Password = " + passWord + "]";
	}
}