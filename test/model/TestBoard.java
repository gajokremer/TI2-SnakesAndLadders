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
		
		board = new Board(6, 6, 2, 2);
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
		
		int i = (int) (Math.random() * (total - 2) + 2);
		int j = (int) (Math.random() * (total - 2) + 2);
		
		assertNotEquals(i, 1);
		assertNotEquals(i, total - 1);
		assertNotEquals(j, 1);
		assertNotEquals(j, total - 1);
	}
}
