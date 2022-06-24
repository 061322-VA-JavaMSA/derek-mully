package ForklyDirectory;

import java.util.Scanner;

public class ForklyCustomerDirectory {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		CustomerDirectory();
		
	}
	
	public static void CustomerDirectory() {
		
		System.out.println("Welcome, valued customer of Forkly!");
		String choice = "";
		
		do {			
			System.out.println("1: Check out our forks");
			System.out.println("2: View purchased forks");
			System.out.println("3: Leave");
			
			choice = scan.nextLine();
			switch(choice) {
			
			case "1":
				System.out.println("All Available Forks");
				System.out.println();
				break;
				
			case "2":
				System.out.println("Purchased Forks");
				System.out.println();
				break;
				
			case "3":
				System.out.println("Thank you for shopping with Forkly!");
				System.out.println();
				break;
				
			default:
				System.out.println("Invalid selection, please select a listed option");
				System.out.println();
				break;
				
			}
		} while(!choice.equals("4"));
		
		scan.close();
	}

}