package ui;

import java.util.Scanner;

import model.Board;

public class Main {
	
	private Board board;
	private Scanner sc;
	
	public Main() {
		
		board = new Board();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {

		System.out.println("----------APPLICATION STARTS----------");

		Main main = new Main();

		int option = 0;

		do {

			option = main.mainMenu();
			main.excecuteOption(option);

		} while (option != 0);
	}

	public int mainMenu() {

		int option = 0;

		System.out.println("\n\n--------MAIN MENU--------\n");

		System.out.println(
				"\nSelect an option:\n" + 
						"(1) \n" + 
						"(2) " + 

				"\n(0) to exit");

		option = sc.nextInt();
		sc.nextLine();

		return option;
	}
	
	private void excecuteOption(int option) {

		switch(option) {

		default:
			System.out.println("\n---Invalid Option");
			break;

		case 0:
			System.out.println("\n-----OPERATION ENDED-----\n");
			break;
		}
	}
	
	public void inputData() {
		
		
	}
}