package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class GameStatusTest {

    private String gWord;
	private Board board;
	private GameStatus status;
	private Player player;
	private Player playerTwo;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"blue"}, {"black"}, {"asdasdasd"}, {"12e813h00220@@#$)&)&!$"}, {"qwdqwd               qwd   fqfe"}
        });
    }

    public GameStatusTest(String word){
        gWord = word;
    }
	
	@Before
    public void setUp(){
        board = new Board();
        status = new GameStatus();
        player = new Player("Nick");
        playerTwo = new Player("Mark");
	}

    @After
    public void tearDown() {
        board = null;
        status = null;
        player = null;
        playerTwo = null;
    }
	
    @Test
    public void checkPrintBoard() {
    	
    	String[][] expected = new String[7][6];
        	
        for(int i = 0; i < 5; i++) {
        	expected[5][i] = "r";
        	board.fillCell("red", 5);
        }
        	
        assertThat(expected, equalTo(status.printBoard(board)));
   }

   @Test
    public void checkWinner(){

       assertThat(status.winner("red"), equalToIgnoringCase("red wins!"));
   }

    @Test
    public void checkChangePlayer(){

	    player.setColor("red");
	    String expected = "red color placed in column 3";

        assertThat(status.changePlayer(player, 3), equalToIgnoringCase(expected));
    }

    @Test
    public void checkMessage(){

	    String message = null;

	    try {
            player.setColor("black");
        }catch (Exception e){
            message = status.message(e.getMessage());
        }

        assertThat(message, containsString("Wrong color"));
	}

	@Test
    public void checkSetColors(){
        ByteArrayInputStream input = new ByteArrayInputStream("red".getBytes());
        System.setIn(input);

        status.setColors(player, playerTwo);
        System.setIn(System.in);

        assertThat("green", equalToIgnoringCase(playerTwo.getColor()));
    }

    @Test
    public void checkSetColorsGreen(){
        ByteArrayInputStream input = new ByteArrayInputStream("green".getBytes());
        System.setIn(input);

        status.setColors(player, playerTwo);
        System.setIn(System.in);

        assertThat("red", equalToIgnoringCase(playerTwo.getColor()));
    }



    @Test(expected = IllegalArgumentException.class)
    public void checkSetColorsException(){
        ByteArrayInputStream input = new ByteArrayInputStream(gWord.getBytes());
        System.setIn(input);

        status.setColors(player, playerTwo);
        System.setIn(System.in);

        assertThat("green", equalToIgnoringCase(playerTwo.getColor()));
    }
}

