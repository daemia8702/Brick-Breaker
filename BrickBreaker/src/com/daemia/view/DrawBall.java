package com.daemia.view;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawBall {
	
	public void drawBall(Graphics2D g, int x, int y, int width, int height) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}
}
