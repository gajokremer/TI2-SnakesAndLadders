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
		
		board = new Board(4, 4);
	}
	
	@Test
	public void testAdd() {
		
		setUpScenario1();
		
		assertTrue(board.getLast().getRow() == 3);
		assertTrue(board.getLast().getCol() == 3);
	}
}
