package model;

public class Board {

	private Square first;
	private Square last;
	private int rows;
	private int cols;
	private int ladders;
	private int snakes;
	private char[] players;
	
//	public Board(int rows, int cols, char[] players) {
//		super();
//		this.setRows(rows);
//		this.setCols(cols);
//		this.setPlayers(players);
//	}
	
	public Board() {
		
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

	public char[] getPlayers() {
		return players;
	}

	public void setPlayers(char[] players) {
		this.players = players;
	}
	
	public void add(int n, Square s) {
		
		if(first == null) {
			
			first = s;
			
		} else {
			
			add(n, s.getNext());
		}
	}
	
	public String print() {
		
		String result = "";
		Square temp = null;
		
		do {
			
			result += temp.getId();
			temp = temp.getNext();
			
		} while(temp.getNext() != null);
		
		return result;
	}
}