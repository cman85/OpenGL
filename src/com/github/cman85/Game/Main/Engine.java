package com.github.cman85.Game.Main;

import org.lwjgl.Sys;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.IOException;

public class Engine {

   private static String IMAGE_FOLDER_BASE = "res/textures/";
   private static TrueTypeFont font;
	
	private static long lastFrame;
	private static int delta;

   public static void init(){
      Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
      Engine.font = new TrueTypeFont(awtFont, false);
      // load font from a .ttf file
    /*  try {
         InputStream inputStream = ResourceLoader.getResourceAsStream("myfont.ttf");
         Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
         awtFont2 = awtFont2.deriveFont(24f); // set font size
      } catch (Exception e) {
         e.printStackTrace();
      }        */
   }

	public static int getDelta() {
		return delta;
	}
	
	public static void calculateDelta(){
		long time = Sys.getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		Engine.delta = delta;
	}

   public static Texture loadTexture(String name) throws IOException {
      return TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(IMAGE_FOLDER_BASE + name +".png"));
   }

   public static void drawText(int x, int y, String string){
     // SimpleText.drawString(string, x, y);
   }

}
