package com.connectfour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RankingTest {

	private int rOne, rTwo, rExpected;
	private Player player;
	private Ranking ranking, rankingTwo;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{30, 53, 83}, {50, 1223, 1273}, {54, 23, 77}, {23, -43, 0}, {2, -5, 0}, {-34, -34, 0}
		});
	}

	public RankingTest(int one, int two, int expected) {
		rOne = one;
		rTwo = two;
		rExpected = expected;
	}
	
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
		
		ranking.setPoints(rOne);
		ranking.setPoints(rTwo);
		
		assertThat(ranking.getPoints(), equalTo(rExpected));
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
