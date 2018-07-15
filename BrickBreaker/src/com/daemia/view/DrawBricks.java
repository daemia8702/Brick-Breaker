package com.daemia.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class DrawBricks {
	
	public void drawBricks(Graphics2D g, boolean[][] map, int row, int col, int startingX, int startingY, 
			int width, int height) {
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j]) {
					g.setColor(Color.white);
					g.fillRect(width * j + startingX, height * i + startingY, width, height);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(width * j + startingX, height * i + startingY, width, height);
				}
			}
		}
	}
}
