package ui;

import java.util.Scanner;

import model.Board;
import model.Square;

public class Menu {
	
	private Board board;
	private Scanner sc;
	
	public Menu() {
		
//		board = new Board();
		sc = new Scanner(System.in);
	}
	
	public void mainMenu() {

		int option = 0;

		System.out.println("\n\n--------MAIN MENU--------\n");

		System.out.println(
				"\nSelect an option:\n" + 
						"(1) to Play\n" + 
						"(2) to print Board" +

				"\n(0) to exit");

		option = sc.nextInt();
		sc.nextLine();

		if(option != 0) {

			switch(option) {

			default:
				System.out.println("\n---Invalid Option");
				mainMenu();;
				break;

			case 1:
				play();
				mainMenu();
				break;

			case 2:
				mainMenu();
				break;
			} 

		} else if(option == 0) {

			System.out.println("\n-----OPERATION ENDED-----\n");
		}
	}
	
	public void play() {
		
		System.out.print("\nInput: ");
		String input = sc.nextLine();
		
		String[] a = input.split(" ");
		
		for(int i = 0; i < a.length; i++) {
			
			System.out.println(a[i]);
		}
		
		int rows = Integer.parseInt(a[0]);
		int cols = Integer.parseInt(a[1]);
				
		char[] p = a[4].toCharArray();
		
		board = new Board(rows, cols);
		
		System.out.println(board);
	}
}
