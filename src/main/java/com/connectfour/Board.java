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
}
