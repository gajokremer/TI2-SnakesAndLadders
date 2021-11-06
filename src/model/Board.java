package model;

public class Board {

	private Square first;
	private Square last;
	private int rows;
	private int cols;
	private int ladders;
	private int snakes;
	private String players;
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		createBoard();
		numberSquares(0);
	}
	
	public Square getFirst() {
		return first;
	}

	public void setFirst(Square first) {
		this.first = first;
	}

	public Square getLast() {
		return last;
	}

	public void setLast(Square last) {
		this.last = last;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getLadders() {
		return ladders;
	}

	public void setLadders(int ladders) {
		this.ladders = ladders;
	}

	public int getSnakes() {
		return snakes;
	}

	public void setSnakes(int snakes) {
		this.snakes = snakes;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	private void createBoard() {

//		System.out.println("\nMatrix is created");
		first =  new Square(0, 0);
//		System.out.println("First square created");
		createRow(0, 0, first);
	}
	
	private void createRow(int r, int c, Square firstCurrentRow) {

//		System.out.println("\nCreate row with row: " + r);
//		createCol(r, c + 1, firstCurrentRow, firstCurrentRow.getUp());
		createCol(r, c + 1, firstCurrentRow, firstCurrentRow.getDown());
		
		if(r + 1 < rows) {
			
//			Square firstDownRow = new Square(r + 1, c);
//			firstDownRow.setUp(firstCurrentRow);
//			firstCurrentRow.setDown(firstDownRow);
//			createRow(r + 1, c, firstDownRow);
			
			Square firstUpRow = new Square(r + 1, c);
			firstUpRow.setDown(firstCurrentRow);
			firstCurrentRow.setUp(firstUpRow);
			createRow(r + 1, c, firstUpRow);
		}
	}

	private void createCol(int r, int c, Square prev, Square prevRow) {
		
		if(c < cols) {
			
//			System.out.println("-Create col with col: " + c);
			Square current = new Square(r, c);
			current.setPrev(prev);
			prev.setNext(current);
			
			if(prevRow != null) {
				
				prevRow = prevRow.getNext();
//				current.setUp(prevRow);
//				prevRow.setDown(current);
				current.setDown(prevRow);
				prevRow.setUp(current);
			}
			
			if(c == cols - 1) {
				
				last = current;
			}
			
			createCol(r, c + 1, current, prevRow);
		} 
	}
	
	@Override
	public String toString() {
		
		String msg = "";
		
//		msg = toStringRow(first);
		msg = toStringRow(last);
		
		return msg;
	}

	private String toStringRow(Square firstCurrentRow) {
		
		String msg = "";
		
		if(firstCurrentRow != null) {
			
			msg = toStringCol(firstCurrentRow) + "\n";
			msg += toStringRow(firstCurrentRow.getDown());
//			msg += toStringRow(firstCurrentRow.getUp());
		}
		
		return msg;
	}

	private String toStringCol(Square current) {
		
		String msg = "";
		
		if(current != null) {
			
			msg += current.toString();
//			msg += toStringCol(current.getNext());
			msg += toStringCol(current.getPrev());
		}
		
		return msg;
	}

	private void numberSquares(int n) {
		
//		first.setId(n);
		
		if(n <= rows * cols) {
			
			numberRow(n + 1, first);
		}
	}

	private int numberRow(int n, Square firstCurrentRow) {
		
		System.out.println("\nRow n: " + n); //1

		if(firstCurrentRow != null) {
			
			firstCurrentRow.setId(n);
			n = numberCol(n + 1, firstCurrentRow.getNext());
		}
		
		return n;
	}

	private int numberCol(int n, Square current) {
		
		System.out.println("Col n: " + n);
		
		if(current != null) {
			
			current.setId(n);
			n = numberCol(n + 1, current.getNext());
		}
		
		return n;
	}
}