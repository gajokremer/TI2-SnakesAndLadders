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
		
		board = new Board();
	}
	
	@Test
	public void testAdd() {
		
		setUpScenario1();
		
		Square s = new Square(1, null, null);
		
		board.add(1, s);
		
		assertTrue(board.getFirst() != null);
	}
}
