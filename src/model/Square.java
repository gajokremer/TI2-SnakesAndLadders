package model;

public class Square {
	
	private int id;
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