package ui;

import java.util.Scanner;

import model.Board;

public class Menu {
	
	private Board board;
	private Scanner sc;
	
	public static final String ANSI_RED = "\u001B[31m";
	
	public Menu() {
		
		sc = new Scanner(System.in);
	}
	
	public void mainMenu() {

		int option = 0;

		System.out.println("\n\n--------MAIN MENU--------\n");

		System.out.println(
				"\nSelect an option:\n" + 
						"(1) to Play" + 

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

//			case 2:
//				test();
//				mainMenu();
//				break;
			} 

		} else if(option == 0) {

			System.out.println("\n-----OPERATION ENDED-----\n");
		}
	}
	
	private void play() {
		
		System.out.print("\nInput: ");
		String input = sc.nextLine();
		
		String[] a = input.split(" ");
		
		int rows = Integer.parseInt(a[0]);
		int cols = Integer.parseInt(a[1]);
		int snakes = Integer.parseInt(a[2]);
		int ladders = Integer.parseInt(a[3]);
		String players = a[4];
		
		board = new Board(rows, cols, snakes, ladders, players);
		
		System.out.println("\n--Board has been created");
		System.out.println("\n" + board);
		sc.nextLine(); //Enter before starting
		
		gameMenu();
	}
	
//	private void test() {
//		
//		board = new Board(10, 10, 7, 5, "@#$%");
//		
//		System.out.println("\n" + board);
//		gameMenu();
//	}
	
	private void gameMenu() {
		
		String option = "";

		System.out.println("\n\n\n----------GAME BOARD----------\n");

		System.out.print(board.printClean());
		
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
				System.out.println("First: " + board.getFirst() + ", " + board.getFirst().getCoordinates());
				System.out.println("Last: " + board.getLast() + ", " + board.getLast().getCoordinates());
				gameMenu();
				break;
				
			case "":
				
				String result = (board.move());
				System.out.println(result);;
//				System.out.println("Player: " + board.getPlayingNow() + ", " + board.getPlayerPos());
				
				if(result.contains("won")) {
					
					System.out.println("\n" + board.printClean());;
					System.out.println("\n----------/GAME ENDED/----------\n");
					System.out.println("\n\n");;
					
				} else {
					
					gameMenu();
				}
				
				break;
			} 
		}
	}
}
