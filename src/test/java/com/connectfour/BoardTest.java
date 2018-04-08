package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.connectfour.Board;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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

	@After
	public void tearDown() {
		board = null;
		larger = null;
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
    
    @Test(expected = IllegalArgumentException.class)
    public void checkFillColumnWrongColor(){
    	board.fillCell("black", 2);
    	
    	assertEquals(true, true);
    }
    
    @Test
    public void checkRowGreen() {
    	for(int i = 0; i < 4; i++ ){
            board.fillCell("green", i);
        }
    	
    	assertThat(board.checkRow(0), equalTo("green"));
    }
    
    @Test
    public void checkRowFalse() {
    	for(int i = 0; i < 12; i+=2 ){
            larger.fillCell("green", i);
            larger.fillCell("red", i+1);
        }
    	
    	assertThat(board.checkRow(0), equalTo("none"));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkRowOutOfRange() {
    	
    	board.checkRow(52);
    	assertEquals(true, true);
    }
    
    @Test
    public void checkColumnGreen() {
    	
    	for(int i = 0; i < 2; i++ ){
            larger.fillCell("green", 5);
            larger.fillCell("red", 5);
        }
    	
    	for(int i = 0; i < 4; i++ ){
    		larger.fillCell("green", 5);
    	}
    	
    	assertThat(larger.checkColumn(5), equalTo("green"));
    }
    
    @Test
    public void checkColumnFalse() {
    	for(int i = 0; i < 10; i+=2 ){
            larger.fillCell("green", 5);
            larger.fillCell("red", 5);
        }
    	
    	assertThat(board.checkRow(0), equalTo("none"));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkColumnOutOfRange() {
    	
    	board.checkColumn(32);
    	assertEquals(true, true);
    }
    
    @Test
    public void checkRightDiagonalRed() {
    	
    	board.fillCell("red", 2);
    	for(int i = 3; i < 6; i++) {
    		board.fillCell("green", i);
    	}
    	
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 5);
    	
    	assertThat(board.checkRightDiagonal(2, 0), equalTo("red"));
    }
    
    @Test
    public void checkRightDiagonalFalse() {
    	
    	board.fillCell("red", 2);
    	for(int i = 3; i < 6; i++) {
    		board.fillCell("green", i);
    	}
    	
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("green", 5);
    	
    	assertThat(board.checkRightDiagonal(2, 0), equalTo("none"));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkRightDiagonalException() {
    	
    	board.checkRightDiagonal(52, 1204);
    	assertEquals(true, true);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkRightDiagonalExceptionOneArgument() {
    	
    	board.checkRightDiagonal(52);
    	assertEquals(true, true);
    }
    
    @Test
    public void checkRightDiagonalFalseOneArgument() {
    	
    	board.fillCell("red", 2);
    	for(int i = 3; i < 6; i++) {
    		board.fillCell("green", i);
    	}
    	
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("green", 5);
    	
    	assertThat(board.checkRightDiagonal(2), equalTo("none"));
    }
    
    @Test
    public void checkRightDiagonalRedOneArgument() {
    	
    	board.fillCell("red", 2);
    	for(int i = 3; i < 6; i++) {
    		board.fillCell("green", i);
    	}
    	
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 5);
    	
    	assertThat(board.checkRightDiagonal(2), equalTo("red"));
    }
    
    @Test
    public void checkLeftDiagonalGreen() {
    	
    	for(int i = 2; i < 5; i++) {
    		board.fillCell("red", i);
    	}
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 2);
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	
    	board.fillCell("red", 2);
    	board.fillCell("green", 3);
    	
    	board.fillCell("green", 2);
    	
    	
    	assertThat(board.checkLeftDiagonal(5, 0), equalTo("green"));
    	
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkLeftDiagonalException() {
    	
    	board.checkLeftDiagonal(52, 1204);
    	assertEquals(true, true);
    }
    
    @Test
    public void checkLeftDiagonalFalse() {
    	
    	for(int i = 2; i < 5; i++) {
    		board.fillCell("red", i);
    	}
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 2);
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	
    	board.fillCell("red", 2);
    	board.fillCell("red", 3);
    	
    	board.fillCell("green", 2);
    	
    	assertThat(board.checkLeftDiagonal(5, 0), equalTo("none"));
    }
    
    @Test
    public void checkLeftDiagonalGreenOneArgument() {
    	
    	for(int i = 2; i < 5; i++) {
    		board.fillCell("red", i);
    	}
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 2);
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	
    	board.fillCell("red", 2);
    	board.fillCell("green", 3);
    	
    	board.fillCell("green", 2);
    	
    	
    	assertThat(board.checkLeftDiagonal(5), equalTo("green"));
    	
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkLeftDiagonalExceptionOneArgument() {
    	
    	board.checkLeftDiagonal(234);
    	assertEquals(true, true);
    }
    
    @Test
    public void checkDraw() {
    	
    	boolean change = true;
    	
    	for(int j = 0; j <6; j++) {
    		for(int i = 0; i < 7; i++) {
    			if(change){
    				board.fillCell("green", i);
    				change = false;
    			}
    			else {
    				board.fillCell("red", i);
    				change = false;
    			}
    		}
    	}
    	
    	assertThat(board.CheckDraw(), is(true));
    }
    
    @Test
    public void checkDrawFalse() {
    	
    	boolean change = true;
    	
    	for(int j = 0; j <5; j++) {
    		for(int i = 0; i < 7; i++) {
    			if(change) {
    				board.fillCell("green", i);
    				change = false;
    			}
    			else {
    				board.fillCell("red", i);
    				change = false;
    			}
    		}
    	}
    	
    	assertThat(board.CheckDraw(), is(false));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWinningConditionWrongColor() {
    	
    	board.checkWinningCondition("blue", 5, 2);
    	
    	assertEquals(true, true);
    }
    
    @Test
    public void checkWinningConditionRightDiagonal() {
    	board.fillCell("red", 2);
    	for(int i = 3; i < 6; i++) {
    		board.fillCell("green", i);
    	}
    	
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 4);
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 5);
    	
    	assertThat(board.checkWinningCondition("red", 3, 1), equalTo("red"));
    }
    
    @Test
    public void checkWinningConditionLeftDiagonal() {
    	
    	for(int i = 2; i < 5; i++) {
    		board.fillCell("red", i);
    	}
    	board.fillCell("green", 5);
    	
    	board.fillCell("red", 2);
    	board.fillCell("red", 3);
    	board.fillCell("green", 4);
    	
    	board.fillCell("red", 2);
    	board.fillCell("green", 3);
    	
    	board.fillCell("green", 2);
    	
    	
    	assertThat(board.checkWinningCondition("green", 3, 2), equalTo("green"));
    }
    
    @Test
    public void checkWinningConditionRow() {
    	for(int i = 0; i < 4; i++ ){
            board.fillCell("green", i);
        }
    	
    	assertThat(board.checkWinningCondition("green", 4, 0), equalTo("green"));
    }
    
    @Test
    public void checkWinningConditionColumn() {
    	for(int i = 0; i < 2; i++ ){
            larger.fillCell("red", 5);
            larger.fillCell("green", 5);
        }
    	
    	for(int i = 0; i < 4; i++ ){
    		larger.fillCell("red", 5);
    	}
    	
    	assertThat(larger.checkWinningCondition("red", 5, 5), equalTo("red"));
    }
    
    @Test
    public void checkWinningConditionNone() {
    	for(int i = 0; i < 6; i+= 2){
            board.fillCell("green", i);
            board.fillCell("red", i);
        }
    	
    	assertThat(board.checkWinningCondition("green", 4, 0), equalTo("none"));
    }
}


