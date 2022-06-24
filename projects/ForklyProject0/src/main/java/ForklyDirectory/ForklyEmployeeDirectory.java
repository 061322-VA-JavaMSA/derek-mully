package ForklyDirectory;

import java.util.Scanner;

public class ForklyEmployeeDirectory {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		EmployeeDirectory();
		
	}
	
	public static void EmployeeDirectory() {
		
		System.out.println("Welcome to the Main Menu!");
		String choice = "";
		
		do {			
			System.out.println("1: Add items to the item menu");
			System.out.println("2: Remove items from the item menu");
			System.out.println("3: View item offers");
			System.out.println("4: View all payments");
			System.out.println("5: Exit");
			
			choice = scan.nextLine();
			switch(choice) {
			
			case "1":
				System.out.println("Add an item");
				System.out.println();
				break;
				
			case "2":
				System.out.println("Remove an item");
				System.out.println();
				break;
				
			case "3":
				System.out.println("Current offers");
				System.out.println();
				break;
				
			case "4":
				System.out.println("All payments");
				System.out.println();
				break;
				
			case "5":
				System.out.println("Goodbye!");
				System.out.println();
				break;
				
			default:
				System.out.println("Invalid selection, please select a listed option");
				System.out.println();
				break;
				
			}
		} while(!choice.equals("5"));
		
		scan.close();
	}

}