package com.github.cman85.Game.Main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class Main{

	private static Main main;

	private int width;
	private int height;
	private static boolean running;

	//private Thread thread;
	private Screen3D screen;

	private Main(){

		try{
			createWindow();

			Game.load();

			start();
		}catch(LWJGLException e){
			e.printStackTrace();
			System.exit(1);
		}


	}

	public void start(){
		setRunning(true);
		Engine.init();
		run();
	}

	public void stop(){
		setRunning(false);
	}

	private void createWindow() throws LWJGLException{
		evaluateScreenSize();
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.setFullscreen(true);
		Display.setVSyncEnabled(true);
		Display.create();
	}

	private void evaluateScreenSize(){
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		width = size.width;
		height = size.height;
		width -= width / 12;
		height -= width / 12;
	}

	public static void cleanUp(){
		Display.destroy();
	}

	public void run(){
		screen = new Screen3D();
		screen.initOGL();
		screen.updateAndRender();
	}

	public static void main(String[] args){
		Main.setMain(new Main());
	}

	public static Main getMain(){
		return main;
	}

	public static void setMain(Main main){
		Main.main = main;
	}

	public static boolean isRunning(){
		return running;
	}

	public static void setRunning(boolean running){
		Main.running = running;
	}

}
