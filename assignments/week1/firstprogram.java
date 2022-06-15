package RandomNumMenu;

public class RandomNumMenu {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	public static void loginScreen() {
		String username = "admin";
		String password = "pass";
		
		System.out.println("Please enter your username");
		String usernameInput = scan.nextLine();
		System.out.println("Please enter your password");
		String passwordInput = scan.nextLine();
		
		if(username.equals(usernameInput && password.equals(passwordInput))) {
			System.out.println("Welcome!");
	    } else {
			System.out.println("Invalid credentials");
	}
		
	public static void main(String[] args) {
		java.util.Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome, citizen!");
		System.out.println("Today we are going to figure out your three favorite numbers between 1-10");
		System.out.println("Please give me your first number");
		
		int num = scan.nextInt();
		
		System.out.println(number + "is a great number!");
		System.out.println("Give me your next favorite number between 1-10");
		
		int num = scan.nextInt();
		
		System.out.println("Wow!" + number + "is an even better number!");
		System.out.println("What's your third favorite number between 1=10?");
		
		int num = scan.nextInt();
		
		
		
		