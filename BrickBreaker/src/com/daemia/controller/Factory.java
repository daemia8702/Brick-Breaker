package com.daemia.controller;

import com.daemia.model.Ball;
import com.daemia.model.Brick;
import com.daemia.model.GameObjects;
import com.daemia.model.Player;

public class Factory {
	
	private final int ballWidth = 20;
	private final int ballHeight = 20;
	private final int ballXPos = 120;
	private final int ballYPos = 350;
	private final int ballXDir = -2;
	private final int ballYDir = -1;
	
	private final int playerXPos = 310;
	private final int playerWidth = 100;
	private final int playerHeight = 8;
	private final int playerXDir = 20;

	private final int col = 7;
	private final int row = 3;
	
	private final int brickWidth = 75;
	private final int brickHeight = 50;
	
	public GameObjects createGameObjects(Objects objects) {
		switch (objects) {
		case BALL:
			return new Ball(ballWidth, ballHeight, ballXPos, ballYPos, ballXDir, ballYDir);
		case PLAYER:
			return new Player(playerWidth, playerHeight, playerXPos, playerXDir);
		case BRICKS:
			return new Brick(brickWidth, brickHeight, row, col);
		default:
			return null;
		}
	}
}
