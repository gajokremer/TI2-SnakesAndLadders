package model;

public class Square {
	
	private int id;
	private int row;
	private int col;
	
	private Square next;
	private Square prev;
	private Square up;
	private Square down;
	private Square jump;
	
	private boolean connection;
	private String connectionId;
	
	private String players;
	
	public Square(int row, int col) {
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
	
	public Square getJump() {
		return jump;
	}

	public void setJump(Square jump) {
		this.jump = jump;
	}

	public boolean hasConnection() {
		return connection;
	}

	public void setConnection(boolean connection) {
		this.connection = connection;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public String getCoordinates() {
		
		return "[" + row + ", " + col + "] ";
	}
	
	public String getSquareConnection() {
		
		String result = "";
		
		result += "[ ";
		
		if(connectionId != null) {
			
			result = "[";
			result += connectionId;
		} 
		
		if(players != null) {
			
			result += players;
		}
		
		result += "]";
		
		return result;
	}
	
	@Override
	public String toString() {
		
		if(connectionId == null) {
			
			return "[" + id + "] ";
			
		} else {
			
			return "[" + id + "-" + connectionId + "] ";
		}
	}
}