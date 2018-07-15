package com.daemia.model;

public class Ball extends GameObjects {
	
	private int xDir;
	private int yDir;

	public Ball(int width, int height, int posX, int posY, int xDir, int yDir) {
		super (width, height, posX, posY);
		this.xDir = xDir;
		this.yDir = yDir;
	}
	
	public void move(int screenWidth) {
		int ballPosY = this.getPosY();
		int ballPosX = this.getPosX();
		int ballWidth = this.getWidth();
		
		ballPosX += xDir;
		ballPosY += yDir;
		
		this.setPosX(ballPosX);
		this.setPosY(ballPosY);
		
		if (ballPosX < 0 || (ballPosX + ballWidth) >= screenWidth) {
			xDir = -xDir;
		}
		
		if (ballPosY < 0) {
			yDir = -yDir;
		}
	}
	
	public void changeYDirection(int yDir) {
		this.setyDir(-yDir);
	}
	
	public void changeXDirection(int xDir) {
		this.setxDir(-xDir);
	}
	
	public int getxDir() {
		return xDir;
	}

	public void setxDir(int xDir) {
		this.xDir = xDir;
	}

	public int getyDir() {
		return yDir;
	}

	public void setyDir(int yDir) {
		this.yDir = yDir;
	}

}
