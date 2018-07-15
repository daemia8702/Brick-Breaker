package com.daemia.model;

public class Brick extends GameObjects{
	
	
	private boolean[][] map;
	private int row;
	private int col;
	private int startingX;
	private int startingY;
	
	public Brick (int width, int height, int row, int col) {
		super (width, height);
		this.row = row;
		this.col = col;
		map = new boolean[row][col];
		this.startingX = 80;
		this.startingY = 50;
	}
	
	public void setUpMap() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = true;
			}
		}
	}
	
	public void setMap(boolean value, int row, int col) {
		map[row][col] = value;
	}
	
	public int setXStartingPosition(int j) {
		return j* this.getWidth() + startingX;
	}
	
	public int setYStartingPosition(int i) {
		return i * this.getHeight() + startingY;
	}
	
	public int getStartingX() {
		return startingX;
	}

	public void setStartingX(int startingX) {
		this.startingX = startingX;
	}

	public int getStartingY() {
		return startingY;
	}

	public void setStartingY(int startingY) {
		this.startingY = startingY;
	}

	public boolean[][] getMap() {
		return map;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
}
