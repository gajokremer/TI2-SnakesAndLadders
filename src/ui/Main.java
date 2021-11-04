package ui;

import java.util.Scanner;

import model.Board;
import model.Square;

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
		
		main.menu();

//		int option = 0;
//
//		do {
//
//			option = main.mainMenu();
//			main.excecuteOption(option);
//
//		} while (option != 0);
	}

//	public int mainMenu() {
//
//		int option = 0;
//
//		System.out.println("\n\n--------MAIN MENU--------\n");
//
//		System.out.println(
//				"\nSelect an option:\n" + 
//						"(1) to Play\n" + 
//						"(2) to print Board" +
//
//				"\n(0) to exit");
//
//		option = sc.nextInt();
//		sc.nextLine();
//
//		return option;
//	}
//
//	public void excecuteOption(int option) {
//
//		switch(option) {
//
//		default:
//			System.out.println("\n---Invalid Option");
//			break;
//
//		case 0:
//			System.out.println("\n-----OPERATION ENDED-----\n");
//			break;
//
//		case 1:
//			play();
//			break;
//
//		case 2:
//			break;
//		}
//	}
	
	public void menu() {

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
				menu();
				break;

			case 1:
				menu();
				break;

			case 2:
				menu();
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
		
		System.out.println();
		
		board.setRows(rows);
		board.setCols(cols);
		board.setPlayers(p);
		
		for(int i = 0; i < p.length; i++) {
			
			System.out.print(board.getPlayers()[i] + " ");
		}
		
		Square s = new Square(1, null, null);
		
		board.add(1, s);
		
		System.out.println(board.print());
		
	}
}