package com.daemia.controller;

import com.daemia.view.Window;

public class Main {
	
	public static void main(String[] args) {
		Window window = new Window();
		window.setUpWindow(new Game());
	}

}
