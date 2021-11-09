package model;

public class Board {

	private Square first;
	private Square last;
	
	private int rows;
	private int cols;
	private int snakes;
	private int ladders;
	
	private String players;
	private String playingNow;
	private int playerPos;
	
	public Board(int rows, int cols, int snakes, int ladders, String players) {
		this.setRows(rows);
		this.setCols(cols);
		createBoard();
		numberSquares(0);
		createSnakesAndLadders(snakes, ladders);
		this.setPlayers(players);
		first.setPlayers(players);
		setPlayingNow(null);
		setPlayerPos(-1);
	}
	
	public Board(int rows, int cols) {
		this.setRows(rows);
		this.setCols(cols);
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
	
	public int getTotalSquares() {
		return rows * cols;
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

	public String getPlayingNow() {
		return playingNow;
	}

	public void setPlayingNow(String playingNow) {
		this.playingNow = playingNow;
	}

	public int getPlayerPos() {
		return playerPos;
	}

	public void setPlayerPos(int playerPos) {
		this.playerPos = playerPos;
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
			
//			msg += current.toString();
			msg += current.toString();
			msg += toStringCol(current.getNext());
//			msg += toStringCol(current.getPrev());
		}
		
		return msg;
	}

	private void numberSquares(int n) {
		
//		first.setId(n);
		
		if(n <= getTotalSquares()) {
			
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
	
	public void createSnakesAndLadders(int s, int l) {
		
		int limit = (getTotalSquares()) - 1;
		
		if(s * 2 + l * 2 < getTotalSquares()) {
			
			createSnakes(s, limit, 'A');
			createLadders(l, limit, 1);
		}
	}

	private void createSnakes(int s, int limit, int connectionId) {
		
		if(s > 0) {
			
			int i = (int) (Math.random() * (limit - 2) + 2);
//			System.out.println("\nRandom i: " + i);
			Square a = findSquare(i);
//			System.out.println("A: " + a);
			
			int j = (int) (Math.random() * (limit - 2) + 2);
//			System.out.println("Random j: " + j);
			Square b = findSquare(j);
//			System.out.println("B: " + b);
			
			if(a.hasConnection() || b.hasConnection()) {
				
				createSnakes(s, limit, connectionId);
				
			} else if(a.getRow() == b.getRow()) {
				
				createSnakes(s, limit, connectionId);
				
			} else {
				
				linkSnakes(a, b, connectionId);
				createSnakes(s - 1, limit, connectionId + 1);
			}
		}
	}
	
	private void linkSnakes(Square a, Square b, int connectionId) {

		boolean aIsBigger = a.getId() > b.getId();
		
		if(aIsBigger) {
			
			a.setJump(b);
			
		} else {
			
			b.setJump(a);
		}
		
		char c = Character.valueOf((char) connectionId);
		String cId = String.valueOf(c);
		
		a.setConnection(true);
		a.setConnectionId(cId);
		b.setConnection(true);
		b.setConnectionId(cId);
		
	}

	
	private void createLadders(int l, int limit, int connectionId) {
		
		if(l > 0) {
			
			int i = (int) (Math.random() * (limit - 2) + 2);
//			System.out.println("\nRandom i: " + i);
			Square a = findSquare(i);
//			System.out.println("A: " + a);
			
			int j = (int) (Math.random() * (limit - 2) + 2);
//			System.out.println("Random j: " + j);
			Square b = findSquare(j);
//			System.out.println("B: " + b);
			
			if(a.hasConnection() || b.hasConnection()) {
				
				createLadders(l, limit, connectionId);
				
			} else if(a.getRow() == b.getRow()) {
				
				createLadders(l, limit, connectionId);
				
			} else {
				
				linkLadders(a, b, connectionId);
				createLadders(l - 1, limit, connectionId + 1);
			}
		}
	}
	
	private void linkLadders(Square a, Square b, int connectionId) {

		boolean aIsBigger = a.getId() > b.getId();
		
		if(aIsBigger) {
			
			b.setJump(a);
			
		} else {
			
			a.setJump(b);
		}
		
		String cId = String.valueOf(connectionId);
		
		a.setConnection(true);
		a.setConnectionId(cId);
		b.setConnection(true);
		b.setConnectionId(cId);
	}
	
	public String printClean() {
		
		String msg = "";
		
		msg = rowClean(last);
		
		return msg;
	}

	private String rowClean(Square firstCurrentRow) {
		
		String msg = "";
		
		if(firstCurrentRow != null) {
			
			msg = colClean(firstCurrentRow) + "\n";
			msg += rowClean(firstCurrentRow.getDown());
		}
		
		return msg;
	}

	private String colClean(Square current) {
		
		String msg = "";
		
		if(current != null) {
			
			msg += current.getSquareConnection() + " ";
			msg += colClean(current.getNext());
		}
		
		return msg;
	}
	
	public Square findSquare(int n) {
		
		Square s = null;
		
		if(first != null) {
			
//			System.out.println("\n" + first);;
			s = findRow(n, first, first);
		}
		
		return s;
	}
	
	private Square findRow(int n, Square firstCurrentRow, Square current) {
		
//		System.out.println("-" + firstCurrentRow);
		
		if(firstCurrentRow != null) {
			
			if(firstCurrentRow.getId() != n) {
				
				current = findCol(n, firstCurrentRow.getNext());
				
//				System.out.println("=" + current + ", " + n);
				
				if(current.getId() != n) {
					
					current = findRow(n, firstCurrentRow.getUp(), firstCurrentRow.getUp());
				}
			}
		}
		
		return current;	
	}

	private Square findCol(int n, Square current) {
		
//		System.out.println("--" + current);
		
		if(current != null) {
			
			if(current.getId() != n) {
				
				if(current.getNext() != null) {
					
					current = findCol(n, current.getNext());
				} 
			}				
		}
		
		return current;
	}
	
	public Square findPlayerSquare(String player) {
		
		Square s = null;
		
		if(first != null) {
			
//			System.out.println("\n" + first);;
			s = findPlayerRow(player, first, first);
		}
		
//		System.out.println("S: " + s);
		
		return s;
	}
	
	private Square findPlayerRow(String player, Square firstCurrentRow, Square current) {
		
//		System.out.println("-" + firstCurrentRow);
		
		if(firstCurrentRow != null) {
			
//			System.out.println("\nRead on Row");
			
//			boolean b = readSquareString(player, firstCurrentRow, 0);
//			System.out.println("=Boolean: " + b + "\n");
			
			if(!readSquareString(player, firstCurrentRow, 0)) {
				
				current = findPlayerCol(player, firstCurrentRow.getNext());
				
				if(!findPlayerColBoolean(player, firstCurrentRow.getNext())) {
					
					current = findPlayerRow(player, firstCurrentRow.getUp(), firstCurrentRow.getUp());
				}
			}
		}
		
		return current;	
	}
	
	private Square findPlayerCol(String player, Square current) {
		
//		System.out.println("--" + current);
		
		if(current != null) {
			
//			System.out.println("Read on Col");
			
//			boolean b = readSquareString(player, current, 0);
//			System.out.println("==Boolean: " + b + "\n");
			
			if(!readSquareString(player, current, 0)) {
				
				current = findPlayerCol(player, current.getNext());
			}
		}
		
		return current;
	}
	
	private boolean findPlayerColBoolean(String player, Square current) {
		
//		System.out.println("--" + current);
		
		boolean isThere = false;
		
		if(current != null) {
			
			if(!readSquareString(player, current, 0)) {
				
				isThere = findPlayerColBoolean(player, current.getNext());
				 
			} else {
				
				isThere = true;
			}
		}
		
		return isThere;
	}
	
	private boolean readSquareString(String player, Square current, int pos) {
		
		boolean isHere = false;
		
//		System.out.println("Current: " + current);
//		System.out.println("Pos: " + pos);
		
		if(current != null) {
			
			if(current.getPlayers() != null) {
				
				if(pos < current.getPlayers().length()) {
					
//					System.out.println("-" + current.getPlayers());
//					System.out.println("--" + current.getPlayers().charAt(pos));
					
					String s = String.valueOf(current.getPlayers().charAt(pos));
					
//					System.out.println("---" + s.equalsIgnoreCase(player));
					
					if(!s.equalsIgnoreCase(player)) {			
						
						isHere = readSquareString(player, current, pos + 1);
//						System.out.println("----" + isHere);
						
					} else {
						
						isHere = true;
//						System.out.println("----" + isHere);
					}
				}
			}
		}
		
		return isHere;
//		return current;
	}
	
	private void nextTurn(int n) {
		
		n = n + 1;
		
		if(n < players.length()) {
			
			String player = String.valueOf(players.charAt(n));
			
			setPlayingNow(player);
			setPlayerPos(n);
			
		} else {
			
			setPlayingNow(String.valueOf(players.charAt(0)));
			setPlayerPos(0);
		}
	}

	public String move() {
		
		String result = "";
		
		nextTurn(playerPos);
		
		int d  = dice();
		
		Square origin = findPlayerSquare(playingNow);
		Square destiny = findSquare(origin.getId() + d);
		Square jump = null;
		
		if(origin.getId() + d <= getTotalSquares()) {
			
				origin.setPlayers(origin.getPlayers().replace(playingNow, ""));
				
				if(destiny.getPlayers() == null) {
					
					destiny.setPlayers(playingNow);
					
					if(destiny.getJump() != null) {
						
						jump = makeJump(playingNow, destiny);
					}
					
				} else {
					
					destiny.setPlayers(destiny.getPlayers().concat(playingNow));
					
					if(destiny.getJump() != null) {
						
						jump = makeJump(playingNow, destiny);
					}
				}
				
				result = "\n--Player " + playingNow + " threw the dice and got " + d;
				result += "\n" + origin + "--> " + destiny;
				
				if(jump != null) {
					
					result += "==> " + jump;
				}
				
				if(destiny.getId() == getTotalSquares()) {
					
					result += "\n\n--Player " + playingNow + " has won!";
				}
			
		} else {
			
			result = "\n--Player " + playingNow + " threw the dice and got " + d;
			result += "\n-Player " + playingNow + " can't move, unless the dice number is equal or less to what is needed to win";
		}
		
//		System.out.println("Origin: " + origin);
//		System.out.println("Destiny: " + destiny);
//		System.out.println("Jump: " + jump);
		
		return result;
		
		
//		destiny.setPlayers(playingNow);
//		origin.setPlayers(getPlayers().replace(playingNow, ""));
//		
//		movePlayer(d, playingNow, origin);
	}
	
	public int dice() {

		int d = (int) (Math.random() * (6 - 1) + 1);
		
//		System.out.println("Dice: " + d);
		
		return d;
	}
	
	private Square makeJump(String player, Square destiny) {
		
		Square jump = null;

		if(destiny != null) {
			
			if(destiny.hasConnection()) {
				
				jump = destiny.getJump();
				
				destiny.setPlayers(destiny.getPlayers().replace(player, ""));
//				
//				System.out.println("==Jump: " + jump);

				if(jump.getPlayers() == null) {
					
					jump.setPlayers(player);
					
				} else {
					
					jump.setPlayers(jump.getPlayers().concat(player));
				}
			}
		}
		
		return jump;
	}
}