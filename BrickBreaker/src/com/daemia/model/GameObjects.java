package com.daemia.model;

public abstract class GameObjects {
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	public GameObjects(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public GameObjects(int width, int height, int posX, int posY) {
		this (width, height);
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
