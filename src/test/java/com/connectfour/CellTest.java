package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.connectfour.Cell;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CellTest {
	private Cell cell;
	
	
	@Before
    public void setUp(){
        cell = new Cell();
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void checkSetColorException() {
		
		cell.setColor("black");
	}
	
}

