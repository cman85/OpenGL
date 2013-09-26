package com.github.cman85.Game.Main;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Engine{

	private static String IMAGE_FOLDER_BASE = "res" + File.separator + "textures" + File.separator;

	private static long lastFrame;
	private static int delta;
	private static long lastFPS;
	private static int fps;

	public static void init(){

	}

	public static int getDelta(){
		return delta;
	}

	public static void calculateDelta(){
		long time = getTime();
		int delta = (int)(time - lastFrame);
		lastFrame = time;
		Engine.delta = delta;
	}

	public static void updateFPS() {
		if(lastFPS == 0) lastFPS = getTime();
		if (getTime() - lastFPS > 1000) {
			Display.setTitle(" FPS: " + getFps());
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	public static Texture loadTexture(String name) throws IOException{
		return TextureLoader.getTexture("PNG", getTextureInputStream(name));
		// new FileInputStream(new File(IMAGE_FOLDER_BASE + name + ".png")));
	}

	public static InputStream getTextureInputStream(String name){
		return ResourceLoader.getResourceAsStream(IMAGE_FOLDER_BASE + name + ".png");
	}

	public static void drawText(int x, int y, String string){
		// SimpleText.drawString(string, x, y);
	}
	public static int getFps(){
		return fps;
	}

}
