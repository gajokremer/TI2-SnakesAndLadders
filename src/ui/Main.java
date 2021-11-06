package ui;

import java.util.Scanner;

import model.Board;
import model.Square;

public class Main {
	
//	private Board board;
	private Menu menu;
//	private Scanner sc;
	
	public Main() {
		
//		board = new Board();
		menu = new Menu();
//		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {

		System.out.println("----------APPLICATION STARTS----------");

		Main main = new Main();
		
//		main.menu();
		main.menu.mainMenu();

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
	
}