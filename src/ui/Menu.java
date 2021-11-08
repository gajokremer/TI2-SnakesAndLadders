package ui;

import java.util.Scanner;

import model.Board;

public class Menu {
	
	private Board board;
	private Scanner sc;
	
	public static final String ANSI_RED = "\u001B[31m";
	
	public Menu() {
		
//		board = new Board();
		sc = new Scanner(System.in);
	}
	
	public void mainMenu() {

		int option = 0;

		System.out.println("\n\n--------MAIN MENU--------\n");

		System.out.println(
				"\nSelect an option:\n" + 
						"(1) to Play" + 
//						"(2) to print Board" +

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
				System.out.println(board);
				System.out.println("First: " + board.getFirst() + ", " + board.getFirst().getCoordinates());
				System.out.println("Last: " + board.getLast() + ", " + board.getLast().getCoordinates());
				mainMenu();
				break;
				
			case 3:
				test();
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
		
//		for(int i = 0; i < a.length; i++) {
//			
//			System.out.println(a[i]);
//		}
		
		int rows = Integer.parseInt(a[0]);
		int cols = Integer.parseInt(a[1]);
		int snakes = Integer.parseInt(a[2]);
		int ladders = Integer.parseInt(a[3]);
		String players = a[4];
		
		board = new Board(rows, cols, snakes, ladders, players);
		
		System.out.println("\n" + board);
		sc.nextLine(); //Enter before starting
		
		gameMenu();
	}
	
	public void test() {
		
		board = new Board(8, 8, 5, 4, "@#$%");
		
		System.out.println("\n" + board);
		gameMenu();
		
//		System.out.println("\n" + board);
//		System.out.println("\n" + board.printClean());
//		
//		System.out.println("First: " + board.getFirst() + ", " + board.getFirst().getCoordinates());
//		System.out.println("Last: " + board.getLast() + ", " + board.getLast().getCoordinates());
	}
	
	public void gameMenu() {
		
		String option = "";

		System.out.println("\n\n--------GAME MENU--------\n");

//		System.out.println(
//				"\nSelect an option:\n" + 
//						"(1) to Play" + 
//						"(2) to print Board" +
//
//				"\n(0) to exit");

		System.out.println(board.printClean());
		
		option = sc.nextLine();
		option.toLowerCase();
		
		if(option != null) {

			switch(option) {

			default:
				System.out.println("\n---Invalid Option");
				gameMenu();;
				break;
				
			case "menu":
				break;
				
			case "num":
				System.out.println("\n" + board);
				gameMenu();
				break;
				
			case "":
				
				String result = (board.move());
				System.out.println(result);;
//				System.out.println("Player: " + board.getPlayingNow() + ", " + board.getPlayerPos());
				
				if(result.contains("won")) {
					
					System.out.println("\n" + board.printClean());;
					mainMenu();
					
				} else {
					
					gameMenu();
				}
				
				break;
			} 
		}
	}
}
