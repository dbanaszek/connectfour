package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.connectfour.Player;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class PlayerTest {
	
	private Player player;
	
	@Before
	public void setUp(){
		player = new Player("Nick");
    }
	
	@Test
	public void createPlayer() {
		Player playerTwo = new Player();
		
		assertThat(playerTwo.getName(), nullValue());
	}
	
	@Test
	public void checkSetName() {
		player.setName("Frank");
		
		assertThat(player.getName(), is(not("Nick")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkSetColorException() {
		player.setColor("black");
		
		assertFalse(true);
	}
	
	@Test
	public void checkSetColor() {
		player.setColor("red");
		
		assertThat(player.getColor(), is(("red")));
	}
}
