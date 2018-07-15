package com.daemia.view;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawPlayer {
	
	public void drawPlayer(Graphics2D g, int width, int height, int x, int y) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}
