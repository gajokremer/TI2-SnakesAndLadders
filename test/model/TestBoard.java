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

		board = new Board(7, 10, 3, 4, "&#*");
	}
	
	@Test
	public void testAdd() {
		
		setUpScenario1();
		
		assertTrue(board.getLast().getRow() == 5);
		assertTrue(board.getLast().getCol() == 0);
	}
	
	@Test
	public void testCreateSnakes() {
		
		setUpScenario1();
		
		int total = (board.getRows() * board.getCols()) - 1;
		
		System.out.println("\n" + board);
		
		int i = (int) (Math.random() * (total - 2) + 2);
		Square a = board.findSquare(i);
		Square b = a.getJump();
		
		boolean o = a.hasConnection();
		
		if(a.hasConnection()) {
			
			assertTrue(a.getJump() == b);
			
		} else {
			
			System.out.println(o);
			assertFalse(a.getJump() != null);
		}
		
//		int j = (int) (Math.random() * (total - 2) + 2);
//		
//		assertNotEquals(i, 1);
//		assertNotEquals(i, total - 1);
//		assertNotEquals(j, 1);
//		assertNotEquals(j, total - 1);
	}
	
	@Test
	public void testCreateLadders(){
		
		setUpScenario1();
		
		assertTrue(board.getFirst().getPlayers() != null);
		assertEquals(2,board.getFirst().getPlayers().length());
	}
	
	@Test
	public void testDice() {

		setUpScenario2();
		
		int d = (int) (Math.random() * (6 - 1) + 1);
		
		assertFalse(d == 0);
	}
}
