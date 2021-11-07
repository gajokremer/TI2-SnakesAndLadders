package model;

public class Board {

	private Square first;
	private Square last;
	private int rows;
	private int cols;
	private int snakes;
	private int ladders;
	private String players;
	
	public Board(int rows, int cols, int snakes, int ladders) {
		this.rows = rows;
		this.cols = cols;
		createBoard();
		numberSquares(0);
		createSnakesAndLadders(snakes, ladders);
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

	public int getSnakes() {
		return snakes;
	}
	
	public void setSnakes(int snakes) {
		this.snakes = snakes;
	}
	
	public int getLadders() {
		return ladders;
	}

	public void setLadders(int ladders) {
		this.ladders = ladders;
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
				
				last = getLastOfRow(current);
			}
			
			createCol(r, c + 1, current, prevRow);
		} 
	}
	
	@Override
	public String toString() {
		
		String msg = "";
		
//		msg = toStringRow(first);
//		Square firstOfRow = getLastOfRow(last);
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
			msg += toStringCol(current.getNext());
//			msg += toStringCol(current.getPrev());
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
		
//		System.out.println("\nRow n: " + n); //1
		
		if(firstCurrentRow != null) {
			
			firstCurrentRow.setId(n);
			
			boolean b = firstCurrentRow.getNext() == null;
			
			if(b) {
				
				n = numberCol(n + 1, firstCurrentRow.getPrev(), b);
				
			} else {
				
				n = numberCol(n + 1, firstCurrentRow.getNext(), b);
			}
			
			firstCurrentRow = getLastOfRow(firstCurrentRow);
//			System.out.println("Last of row: " + firstCurrentRow.toString());
			n = numberRow(n, firstCurrentRow.getUp());
		}
		
		return n;
	}

	private int numberCol(int n, Square current, boolean b) {
		
//		System.out.println("Col n: " + n);
		
		if(current != null) {
			
			current.setId(n);
			
			if(b) {
				
				n = numberCol(n + 1, current.getPrev(), b);
				
			} else {
				
				n = numberCol(n + 1, current.getNext(), b);
			}
		}
		
		return n;
	}
	
	private Square getLastOfRow(Square current) {
		
		if(current.getNext() == null) {
			
			current = findLastLeft(current);
			
		} else if(current.getPrev() == null) {
			
			current = findLastRight(current);
		}
		
		return current;
	}
	
	private Square findLastLeft(Square current) {
		
		if(current.getPrev() != null) {
			
//			current = current.getNext();
			current = findLastLeft(current.getPrev());
//			System.out.println("Last of row: " + current.toString());
		}
		
		return current;
	}
	
	private Square findLastRight(Square current) {
		
		if(current.getNext() != null) {
			
//			current = current.getNext();
			current = findLastRight(current.getNext());
//			System.out.println("Last of row: " + current.toString());
		}
		
		return current;
	}
	
	private void createSnakesAndLadders(int s, int l) {
		
		int limit = (rows * cols) - 1;
		
		createSnakes(s, limit);
		createLadders(l, limit);
	}

	private void createSnakes(int s, int limit) {
		
		int i = (int) (Math.random() * (limit - 2) + 2);
		
		createSnakes(s - 1, limit);
		
//		System.out.println("Random i: " + i);
//		System.out.println("Random i: " + j);
		
		
	}
	
	private void createLadders(int l, int limit) {
		
	}
}