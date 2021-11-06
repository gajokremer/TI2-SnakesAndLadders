package model;

public class Board {

	private Square first;
	private Square last;
	private int rows;
	private int cols;
	private int ladders;
	private int snakes;
	private char[] players;
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		createBoard();
	}
	
	private void createBoard() {

		System.out.println("\nMatrix is created");
		first =  new Square(0, 0);
		System.out.println("First square created");
		createRow(0, 0, first);
	}
	
	private void createRow(int r, int c, Square firstCurrentRow) {

		System.out.println("\nCreate row with row: " + r);
		createCol(r, c, firstCurrentRow);
		
		if(r + 1 < rows) {
			
			Square firstDownRow = new Square(r, c);
			firstDownRow.setUp(firstCurrentRow);
			firstCurrentRow.setDown(firstDownRow);
			createRow(r + 1, c, firstDownRow);
		}
	}

	private void createCol(int r, int c, Square prev) {
		
		if(c < cols) {
			
			System.out.println("-Create col with col: " + c);
			Square current = new Square(r, c);
			current.setPrev(prev);
			prev.setNext(current);
			createCol(r, c + 1, current);
		}
	}

	public void add(int n, Square s) {
		
	
	}
	
	public String print() {
		
		String result = "";
	
		return result;
	}
}