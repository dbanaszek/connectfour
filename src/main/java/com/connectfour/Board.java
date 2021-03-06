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
        		try {
	        		board[column][iterator].setColor(color);
	                placedCells++;
	                break;
        		}catch(Exception e) {
        			throw new IllegalArgumentException(e.getMessage());
        		}
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
		
    	if(row >= board[0].length)
			throw new IndexOutOfBoundsException("Row does not exist");
    	
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
    
    public String checkColumn(int column) {
	
		if(column >= board.length)
			throw new IndexOutOfBoundsException("Column does not exist");
		
		int[] counter = {0, 0};
		for(int i = 0; i < board[column].length; i++) {

            counter = counter(counter, column, i);
		}
		if(counter[0] >= 4)
			return "green";
			
		if(counter[1] >= 4)
			return "red";
		
		return "none";
	}
    
    public String checkRightDiagonal(int column, int row) {
    	
    	if(row >= board[0].length || column >= board.length)
			throw new IndexOutOfBoundsException("Row does not exist");
    	
    	int[] counter = {0, 0};
    	while(column != 0 && row != 0) {
    		column--;
    		row--;
    	}
    	
    	while(column < board.length && row < board[column].length) {
    		counter = counter(counter, column, row);
			column++;
			row++;
    	}
		if(counter[0] >= 4)
			return "green";
		
		if(counter[1] >= 4)
			return "red";
	
		return "none";
	}
    
    public String checkRightDiagonal(int column) {
    	
    	String result = "none";
    	
    	if(column >= board.length)
    		throw new IndexOutOfBoundsException("Row does not exist");
    	
    	for(int i = 0; i< board[column].length; i++) {
    		result = checkRightDiagonal(column, i);
    		if(!result.equalsIgnoreCase("none"))
    			break;
    	}
    	
    	return result;
    }
    
    public String checkLeftDiagonal(int column, int row) {
		
	if(row >= board[0].length || column >= board.length)
		throw new IndexOutOfBoundsException("Row does not exist");
	
		int[] counter = {0, 0};
		
		while(column != 0 && row != board[column].length) {
    		column--;
    		row++;
    	}
		
		while(column < board.length && row >= 0) {
			counter = counter(counter, column, row);
			column++;
			row--;
		}
		
		if(counter[0] >= 4)
			return "green";
		
		if(counter[1] >= 4)
			return "red";
	
		return "none";
	}
    
    public String checkLeftDiagonal(int column) {
    	
    	String result = "none";
    	
    	if(column >= board.length)
    		throw new IndexOutOfBoundsException("Row does not exist");
    	
    	for(int i = 0; i< board[column].length; i++) {
    		result = checkLeftDiagonal(column, i);
    		if(!result.equalsIgnoreCase("none"))
    			break;
    	}
    	
    	return result;
    }

    public boolean CheckDraw(){

	    int boardSize = board.length * board[0].length;
	    if(placedCells >= boardSize)
	        return true;
	
	    return false;
    }
    
    public String checkWinningCondition(String color, int column, int row){

    	if(color.equals("red") || color.equals("green")) {
		    switch (1){
	            case 1:
	                if (color.equals(checkLeftDiagonal(column)))
	                    return color;
	
	            case 2:
	                if (color.equals(checkRightDiagonal(column)))
	                    return color;
	
	            case 3:
	                if (color.equals(checkColumn(column)))
	                    return color;
	
	            case 4:
	                if (color.equals(checkRow(row)))
	                    return color;
	
	            default:
	                return "none";
	        }
    	}
    	else
    		throw new IllegalArgumentException("Unexpected color");
    }
    
}
