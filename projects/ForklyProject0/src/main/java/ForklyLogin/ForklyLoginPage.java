package ForklyLogin;

import java.util.Scanner;

public class ForklyLoginPage extends NewCustomer {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		loginScreen();
		
	}

	public static void loginScreen() {

		String inputUser;
		String inputPass;
		boolean correct = false;

		do {
			System.out.println("Hello! Please login to Forkly.");
			System.out.println();
			System.out.println("Enter your username here: ");
			inputUser = scan.nextLine();
			System.out.println("Enter your password here: ");
			inputPass = scan.nextLine();

				if (inputUser.equals(getUserName()) && inputPass.equals(getPassWord())) {
					correct = true;
				} else {
					System.out.println("That doesn't look right. Please try again.");
					correct = false;
				}
		} while (correct == false);
	}

}