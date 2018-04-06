package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.connectfour.Board;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Unit test for simple Board.
 */
public class BoardTest
{
    private Board board;
    private Board larger;

    @Before
    public void setUp(){
        board = new Board();
        larger = new Board(12, 9);
    }
    
    @Test
    public void checkFillColumnLarger() {
    	
    	for(int i = 0; i < 3; i++) {
    		larger.fillCell("green", 10);
    		larger.fillCell("red", 10);
    	}
    	Cell[][] map = larger.getBoard();
    	
    	assertEquals(map[10][5].getColor(), "red");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkFillColumnExceptionLarger(){

        for(int i = 0; i < 13; i++ ){
        	larger.fillCell("green", 11);
        }
        assertEquals(true, true);
    }
    
    @Test
    public void checkFillColumn() {
    	
    	board.fillCell("green", 1);
    	board.fillCell("red", 1);
    	Cell[][] map = board.getBoard();
    	
    	assertEquals(map[1][1].getColor(), "red");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFillColumnException(){

        for(int i = 0; i < 9; i++ ){
            board.fillCell("green", 2);
        }
        assertEquals(true, true);
    }
    
    
    
    
}
