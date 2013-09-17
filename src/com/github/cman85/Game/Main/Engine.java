package com.github.cman85.Game.Main;

import org.lwjgl.Sys;

public class Engine {
	
	private static long lastFrame;
	private static int delta;

	public static int getDelta() {
		return delta;
	}
	
	public static void calculateDelta(){
		long time = Sys.getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		Engine.delta = delta;
	}

}
