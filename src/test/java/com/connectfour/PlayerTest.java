package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.connectfour.Player;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
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
}
