import java.util.Scanner;

public class FirstProgram {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
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
		System.out.println("Today we are going to figure out your three favorite numbers between 1-10");
		System.out.println("Please give me your first number");
		
		int num = scan.nextInt();
		
		System.out.println(num + "is a great number!");
		System.out.println("Give me your next favorite number between 1-10");
		
		int num2 = scan.nextInt();
		
		System.out.println("Wow!" + num2 + "is an even better number!");
		System.out.println("What's your third favorite number between 1=10?");
		
		int num3 = scan.nextInt();
	}	
		
		
		
		
}