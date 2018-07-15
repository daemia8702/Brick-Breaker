package com.daemia.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.daemia.model.Ball;
import com.daemia.model.Brick;
import com.daemia.model.Player;
import com.daemia.view.DrawBall;
import com.daemia.view.DrawBricks;
import com.daemia.view.DrawPlayer;
import com.daemia.view.Window;

public class Game extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;

	private Timer timer;
	private final int delay = 8;
	
	private int numOfBricks = 21;
	private Factory factory;
	private Player player;
	private Ball ball;
	private Brick brick;
	private DrawBall drawingBall;
	private DrawBricks drawingBricks;
	private DrawPlayer drawingPlayer;
	
	private boolean running = false;
	
	public Game() {
		factory = new Factory();
		drawingBall = new DrawBall();
		drawingBricks = new DrawBricks();
		drawingPlayer = new DrawPlayer();
		player = (Player) factory.createGameObjects(Objects.PLAYER);
		ball = (Ball) factory.createGameObjects(Objects.BALL);
		brick = (Brick) factory.createGameObjects(Objects.BRICKS);
		brick.setUpMap();
		setFocusable(true);
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		// Background
		g.setColor(Color.black);
		g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
		
		
		drawingPlayer.drawPlayer((Graphics2D) g, player.getWidth(), player.getHeight(), player.getPosX(), player.getPosY());
		
		drawingBall.drawBall((Graphics2D) g, ball.getPosX(), ball.getPosY(), ball.getWidth(), ball.getHeight());

		drawingBricks.drawBricks((Graphics2D) g, brick.getMap(), brick.getRow(), brick.getCol(), brick.getStartingX(), 
				brick.getStartingY(), brick.getWidth(), brick.getHeight());
		
		
		drawPlayerScore((Graphics2D) g);
		
		if (loose()) {
			running = false;
			loosingMessage((Graphics2D) g);
		}
		
		if (win()) {
			running = false;
			winningMessage((Graphics2D) g);
		}
		
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (running) {
			ball.move(Window.WIDTH);
			checkBrickIntersection();
			if (checkPlayerIntersection()) {
				ball.changeYDirection(ball.getyDir());
				player.setScore(-2);
			}
			repaint();	
		}
		
	}
	
	
	private boolean checkPlayerIntersection() {
		return new Rectangle(ball.getPosX(), ball.getPosY(), ball.getWidth(), ball.getHeight()).intersects(
					new Rectangle(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight()));
	}
	
	private void checkBrickIntersection() {
		boolean myMap[][] = brick.getMap();
		
		for (int i = 0; i < brick.getRow(); i++) {
			for (int j = 0; j < brick.getCol(); j++) {
				
				if (myMap[i][j] == true) {
					Rectangle ballRect = new Rectangle(ball.getPosX(), ball.getPosY(), ball.getWidth(), ball.getHeight());
					Rectangle brickRect = new Rectangle(brick.setXStartingPosition(j), brick.setYStartingPosition(i), 
							brick.getWidth(), brick.getHeight());
				
					if (ballRect.intersects(brickRect)) {
						brick.setMap(false, i, j);
						player.setScore(5);
						numOfBricks--;
						ball.changeYDirection(ball.getyDir());
					}
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		
		if (code == KeyEvent.VK_SPACE)
			running = true;
		
		if (code == KeyEvent.VK_LEFT) {
			running = true;
			player.moveLeft();
			player.setBounds(Window.WIDTH);
		}
		
		if (code == KeyEvent.VK_RIGHT) {
			running = true;
			player.moveRight();
			player.setBounds(Window.WIDTH);
		}
		
	}
	
	private void drawPlayerScore(Graphics2D g) {
		g.setFont(new Font("serif", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Player score: " + Integer.toString(player.getScore()), 520, 30);
	}

	private boolean loose() {
		return ball.getPosY()+ball.getHeight() > Window.HEIGHT; 
	}
	
	private boolean win() {
		return numOfBricks == 0;
	}
	
	private void loosingMessage(Graphics2D g) {
		g.setColor(Color.red);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("GAME OVER! YOUR FINAL SCORE IS: " + Integer.toString(player.getScore()), 100, Window.HEIGHT/2);
	}
	
	private void winningMessage(Graphics2D g) {
		g.setColor(Color.red);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("CONGRATULATIONS! YOUR FINAL SCORE IS: " + Integer.toString(player.getScore()), 95, Window.HEIGHT/2);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}
