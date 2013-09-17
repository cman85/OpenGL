package com.github.cman85.Game.Main;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Game  {

	private int width;
	private int height;
	private static boolean running;

	//private Thread thread;
	private Screen3D screen;

	public Game() {
		try {
			createWindow();
			start();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void start() {
		setRunning(true);
		run();
	}

	public void stop() {
		setRunning(false);
	}

	private void createWindow() throws LWJGLException {
		evaluateScreenSize();
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.create();
	}

	private void evaluateScreenSize() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		width = size.width;
		height = size.height;
		width -= width / 12;
		height -= width / 12;
	}
	
	public static void cleanUp(){
		Display.destroy();
	}

	public void run() {
		screen = new Screen3D();
		screen.initOGL();
		screen.updateAndRender();
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		Game.running = running;
	}
}
