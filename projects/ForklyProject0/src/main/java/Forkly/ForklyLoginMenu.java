package Forkly;

import java.util.Scanner;

public class ForklyLoginMenu {
	
    public static void main(String[] args) {
    	int userSelected;
    	do {
    		userSelected = MenuData();
    		switch(userSelected) {
    		case 1:
    			break;
    		case 2:
    			break;
    		case 3:
    			break;
    		case 4:
    			break;
    	}
    	while(userSelected > 4)
    }
    
    public static int MenuData()
    {
    	int selection;
    	Scanner scan = new Scanner (System.in);
    	System.out.println("Welcome! Please select an option.");
    	System.out.println("1 - New Customer");
    	System.out.println("2 - Returning Customer");
    	System.out.println("3 - Employee Login");
    	System.out.println("That is not a valid option. Please typ 1, 2, or 3 and press enter.");
    
    	System.out.println("");
    	}
	}
}
	
	
