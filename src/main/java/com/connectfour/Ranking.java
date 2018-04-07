package com.connectfour;

import com.connectfour.Player;

public class Ranking {
	
	private Player player;
    private int points;
    private int won;
    private double winRatio;
    private int gamesOverall;
    
    public Ranking(){
        this.player = null;
        points = won = gamesOverall = 0;
        winRatio = 0.0;
    }

    public Ranking(Player player){
        this.player = player;
        points = won = gamesOverall = 0;
        winRatio = 0.0;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
            this.points += points;
            if(this.points < 0)
                this.points = 0;
    }
    
    public int getWon() {
        return won;
    }

    public void increseWon() {
        won++;
        setWinRatio();
    }
    
    public double getWinRatio() {
        return winRatio;
    }

    private void setWinRatio() {
    	if(gamesOverall == 0)
    		throw new IllegalArgumentException("Division by 0");
        winRatio = won/(double)gamesOverall;
    }
    
    public int getGamesOverall() {
        return gamesOverall;
    }

    public void setGamesOverall() {
        gamesOverall++;
        setWinRatio();
    }
}
