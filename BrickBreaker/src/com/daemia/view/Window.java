package com.daemia.view;

import java.awt.Dimension;
import javax.swing.JFrame;


import com.daemia.controller.Game;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 600;
	
	public Window() {
		super("Brick Breaker");
	}
	
	public void setUpWindow(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		add(game);
	}
}
