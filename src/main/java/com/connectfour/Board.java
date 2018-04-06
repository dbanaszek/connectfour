package com.connectfour;

/**
 * Hello world!
 *
 */
public class Board
{
    private Cell[][] board;
    private boolean[] isFull;
    private int iterator, placedCells;
    private String[] colors;

    public Board() {

        board = new Cell[7][6];
        isFull = new boolean[7];
        iterator = 0;
        placedCells = 0;
        
        for(int i = 0; i <7; i++) {
        	for(int j = 0; j <6; j++) {
        		board[i][j] = new Cell();
        	}
        }
    }

    public Board(int columns, int rows) {
        board = new Cell[columns][rows];
        isFull = new boolean[columns];
        iterator = 0;
        placedCells = 0;
        
        for(int i = 0; i < columns; i++) {
        	for(int j = 0; j < rows; j++) {
        		board[i][j] = new Cell();
        	}
        }
    }
    
    public Cell[][] getBoard() {
        return board;
    }

    public int fillCell(String color, int column) {

        if(isFull[column]) {
            throw new IllegalArgumentException("Column is full");
        }
        
        for(iterator = 0; iterator < board[column].length; iterator++) {
        	if(board[column][iterator].getColor() == null) {
        		board[column][iterator].setColor(color);
                placedCells++;
                break;
        	}
        }
        
        if (iterator >= board[column].length)
            isFull[column] = true;

        return iterator;
    }
    
    private int[] counter(int[] count, int column, int row){

    	try{
    		
	        switch(board[column][row].getColor()) {
	
	            case "green": count[0]++;
	                count[1] = 0;
	                break;
	
	            case "red":   count[1]++;
	                count[0] = 0;
	                break;
	
	            default: 	  count[0] = 0;
	                count[1] = 0;
	
	        }
    	}catch(Exception e) {
    	}

        return count;
    }
    
    public String checkRow(int row) {
		
		int[] counter = {0, 0};
		for(int i = 0; i < board.length; i++) {

            counter = counter(counter, i, row);
            
            if(counter[0] >= 4)
    			return "green";
    			
    		if(counter[1] >= 4)
    			return "red";
		}

		if(counter[0] >= 4)
			return "green";
			
		if(counter[1] >= 4)
			return "red";
		
		return "none";
	}
}
