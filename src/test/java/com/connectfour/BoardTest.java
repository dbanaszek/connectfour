package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setUp(){
        board = new Board();
    }

    @Test(expected = IllegalArgumentException.class)
    public void CheckFillColumnException(){

        for(int i = 0; i < 9; i++ ){
            board.fillCell("green", 2);
        }
        assertEquals(true, true);
    }
}
