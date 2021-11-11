package ui;


public class Main {
	
	private Menu menu;
	
	public Main() {
		
		menu = new Menu();
	}

	public static void main(String[] args) {

		System.out.println("----------APPLICATION STARTS----------");

		Main main = new Main();
		
		main.menu.mainMenu();
	}
}