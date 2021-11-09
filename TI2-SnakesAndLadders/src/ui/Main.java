package ui;


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
		
		main.menu.mainMenu();
	}
}