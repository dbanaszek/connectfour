package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class CellTest {
	private Cell cell;
	
	
	@Before
    public void setUp(){
        cell = new Cell();
    }

	@After
	public void tearDown() {
		cell = null;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkSetColorException() {
		
		cell.setColor("black");
	}
	
}

