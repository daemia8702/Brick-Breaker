package com.daemia.model;


public class Player extends GameObjects {
	
	private int score;
	private int xDir;
	public final static int playerYPosition = 550;
	
	public Player (int width, int height, int posX, int xDir) {
		super(width, height, posX, playerYPosition);
		this.score = 0;
		this.xDir = xDir;
	}
	
	public void setBounds(int screenWidth) {
		int playerX = this.getPosX();
		int playerWidth = this.getWidth();
		if ((playerX + playerWidth) >= screenWidth) {
			this.setPosX(screenWidth-playerWidth);
		}
		
		if (playerX < 0) {
			this.setPosX(0);
		}
	}
	
	public void moveLeft() {
		int playerX = this.getPosX();
		playerX -= xDir;
		this.setPosX(playerX);
	}
	
	public void moveRight() {
		int playerX = this.getPosX();
		playerX += xDir;
		this.setPosX(playerX);
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score += score;
	}

	public int getxDir() {
		return xDir;
	}

	public void setxDir(int xDir) {
		this.xDir = xDir;
	}
	
}
