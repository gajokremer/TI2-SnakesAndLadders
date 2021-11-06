package model;

public class Square {
	
	private int id;
	private int row;
	private int col;
	
	private Square next;
	private Square prev;
	private Square up;
	private Square down;
	
	public Square(int row, int col) {
//		this.id = id;
		this.row = row;
		this.col = col;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Square getNext() {
		return next;
	}

	public void setNext(Square next) {
		this.next = next;
	}

	public Square getPrev() {
		return prev;
	}

	public void setPrev(Square prev) {
		this.prev = prev;
	}

	public Square getUp() {
		return up;
	}

	public void setUp(Square up) {
		this.up = up;
	}

	public Square getDown() {
		return down;
	}

	public void setDown(Square down) {
		this.down = down;
	}
	
	@Override
	public String toString() {
		
		return "[" + row + ", " + col + "] ";
	}
}