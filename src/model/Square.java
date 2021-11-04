package model;

public class Square {
	
	private int id;
	public char player;
	private Square next;
	private Square prev;
	
	public Square(int id, Square next, Square prev) {
		super();
		this.id = id;
		this.next = next;
		this.prev = prev;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public char getPlayer() {
		return player;
	}
	
	public void setPlayer(char player) {
		this.player = player;
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
}