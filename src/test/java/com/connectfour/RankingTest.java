package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RankingTest {
	
	private Player player;
	private Ranking ranking, rankingTwo;
	
	@Before
	public void setUp(){
		player = new Player("Nick");
		ranking = new Ranking(player);
		rankingTwo = new Ranking();
    }

	@After
	public void tearDown() {
		player = null;
		ranking = null;
		rankingTwo = null;
	}

	@Test
	public void checkSetPlayer() {
		rankingTwo.setPlayer(player);
		
		assertThat(ranking.getPlayer(), equalTo(player));
	}
	
	@Test
	public void checkSetPoints() {
		
		ranking.setPoints(30);
		ranking.setPoints(54);
		
		assertThat(ranking.getPoints(), equalTo(84));
	}
	
	@Test
	public void checkSetPointsMinus() {
		
		ranking.setPoints(10);
		ranking.setPoints(-11);
		
		assertThat(ranking.getPoints(), equalTo(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkIncreaseWonException() {
		
		for(int i = 0; i < 10; i++)
			ranking.increseWon();
			
			
		assertThat(ranking.getWon(), equalTo(10));
	}
	
	@Test
	public void checkGamesOverall() {
		
		for(int i = 0; i < 10; i++) {
			ranking.setGamesOverall();
		}
			
		assertThat(ranking.getGamesOverall(), equalTo(10));
	}
	
	@Test
	public void checkIncreaseWon() {
		
		for(int i = 0; i < 10; i++) {
			ranking.setGamesOverall();
			ranking.increseWon();
		}
			
		assertThat(ranking.getWon(), equalTo(10));
	}
	
	@Test
	public void checkSetWinRatio() {
		
		for(int i = 0; i < 10; i++) {
			ranking.setGamesOverall();
		}
		
		ranking.increseWon();
			
		assertThat(ranking.getWinRatio(), equalTo(0.1));
	}
}
