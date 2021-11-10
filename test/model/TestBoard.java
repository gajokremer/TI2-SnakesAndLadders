package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBoard {
	
	private Board board;

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	public void setUpScenario1() {
		
		board = new Board(6, 6, 2, 2, "@#");
	}
	
	public void setUpScenario2() {

		board = new Board(7, 10);
	}
	
	public void setUpScenario3() {
		
		board = new Board(9, 8, 0, 0, "^");
		
		Square s = board.findSquare(board.getTotalSquares() - 1);
		board.getFirst().setPlayers("");
		s.setPlayers("^");
	}
	
	@Test
	public void testAdd() {
		
		setUpScenario2();
		
		assertTrue(board.getLast().getRow() == 6);
		assertTrue(board.getLast().getCol() == 0);
	}
	
	@Test
	public void testPlayers(){
		
		setUpScenario1();
		
		assertTrue(board.getFirst().getPlayers() != null);
		assertEquals(2,board.getFirst().getPlayers().length());
	}
	
	@Test
	public void testDice() {

		setUpScenario1();
		
		int d = board.dice();
		
		assertFalse(d == 0);
	}
	
	@Test
	public void testFindSquare() {

		setUpScenario1();
		
		Square s = board.findSquare(15);
		
		assertTrue(s.getId() == 15);
	}
	
	@Test
	public void testFindPlayerSquare() {

		setUpScenario3();
		
		Square s = board.findPlayerSquare("^");
		
		assertTrue(s.getPlayers().contains("^"));
	}
	
	@Test
	public void testCreateSnakesAndLadders() {
		
		setUpScenario2();
		
		board.createSnakesAndLadders(3, 4);
		
		int limit = board.getRows() * board.getCols();
		
		int r = (int) (Math.random() * (limit - 1) + 1);
		
		Square a = board.findSquare(r);
		Square b = a.getJump();
		
		boolean o = a.hasConnection();
		
		if(o) {
			
			assertTrue(a.getJump() == b);
			
		} else {
			
			assertFalse(a.getJump() != null);
		}
	}
	
	@Test
	public void testWin() {
		 
		setUpScenario3();
		
		assertTrue(board.move(1).contains("won"));
	}
	
	@Test
	public void testNotWin() {
		
		setUpScenario3();
		
		assertTrue(board.move(2).contains("equal"));
	}
	
	@Test
	public void testPrint() {
		
		setUpScenario1();
		
		assertFalse(board.printClean().equals(board.toString()));
	}
	
	@Test
	private void testLastSquare() {

		setUpScenario2();
		
		if(board.getTotalSquares() % 2 == 0) {
			
			assertTrue(board.getLast().getId() == board.getTotalSquares());
			
		} else {
			
			assertFalse(board.getLast().getId() == board.getTotalSquares());
			
			Square lastSquare = board.findSquare(board.getTotalSquares());
			
			assertFalse(board.getLast().getId() == lastSquare.getId());
		}
	}
}
