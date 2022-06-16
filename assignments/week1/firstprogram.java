import java.util.Scanner;

public class FirstProgram {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); {
		
		String username = "admin";
		String password = "pass";
		
		System.out.println("Please enter your username");
		String usernameInput = scan.nextLine();
		System.out.println("Please enter your password");
		String passwordInput = scan.nextLine();
		
		if(username.equals(usernameInput) && password.equals(passwordInput)) {
			System.out.println("Welcome!");
	    } else {
			System.out.println("Invalid credentials"); }
		
		System.out.println("Welcome, citizen!");
		System.out.println("Today we are going to figure out your three favorite numbers");
		System.out.println("Please give me your first number");
		
		int num1 = scan.nextInt();
		
		System.out.println(num1 + "is a great number!");
		System.out.println("Give me your next favorite number");
		
		int num2 = scan.nextInt();
		
		System.out.println("Wow!" + num2 + "is an even better number!");
		System.out.println("What's your third favorite number?");
		
		int num3 = scan.nextInt();
	
		System.out.println("So" + num1 + num2 + num3 + "are your three favorite numbers? Type y for yes or n for no");
		System.out.println("y/n");
		
		scan.nextLine();
		scan.nextLine();
    	
	    String input;
	    boolean yn = true;	    
	    while (yn) {
	    	input = scan.nextLine().trim().toLowerCase(); 
	    		 
	    	if (input.equals("y")) {
	            yn = true; 
	            break; }
	    	if (input.equals("n")) {
	    	    yn = false;
	    	    continue; }
	    	
	    scan.close();
	    
	    System.out.println("Backwards, your three favorite numbers read" + num3 + num2 + num1);
	    System.out.println("Congratulations! You have passed the test. You have now been logged out.");
	    

	    	
	    		
	    	}
	    }
    }
}	