package com.connectfour;

import com.connectfour.Board;

import java.util.Scanner;

public class GameStatus {

    public void setColors(Player one, Player two){

        String color = new Scanner(System.in).nextLine().toLowerCase();

        switch (color) {
            case "red":
                one.setColor(color);
                two.setColor("green");
                break;
            case "green":
                one.setColor(color);
                two.setColor("red");
                break;
            default:
                throw new IllegalArgumentException("Dozwolone kolory to 'Red' lub 'Green'");
        }
    }

	public String[][] printBoard(Board board){

        String sign;
        Cell[][] output = board.getBoard();
        String[][] map = new String[output.length][output[0].length];

        for(int i = 0; i < output.length; i++){
            for (int j = output[0].length - 1; j>=0; j--){
                if(output[i][j].getColor() != null)
                    map[i][j] = output[i][j].getColor().substring(0,1).toLowerCase();
                else
                    map[i][j] = null;

            }
        }

        return map;
	}

    public String winner(String color){

        StringBuilder message = new StringBuilder(color);
        message.append(" wins!");

        return message.toString();
    }

    public String changePlayer(Player player, int column){

        StringBuilder message = new StringBuilder(player.getColor());
        message.append(" color placed in column ");
        message.append(String.valueOf(column));

        return message.toString();
    }

    public String message(String message){
        return message;
    }
}
