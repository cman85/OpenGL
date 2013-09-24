package com.github.cman85.Game.Main;

import com.github.cman85.Game.entities.player.Player;
import com.github.cman85.Game.world.Block;
import com.github.cman85.Game.world.Chunk;
import com.github.cman85.Game.world.Location;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glLoadIdentity;

public class Screen3D implements Renderable{

	private Player player;

	public Screen3D(){
		player = new Player(Game.getGame().getWorld().getSpawnLocation());
	}

	public void updateAndRender(){

		while(!Display.isCloseRequested() && Main.isRunning()){

			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clears the screen, OGL stores the
			// pixel info in the color buffer
			glLoadIdentity();

			player.getCamera().useView();

			update();
			render();

			glClearColor(0.2f, 0.375f ,0.6f, 1);
			Display.sync(60);
			Display.update();
		}
		Main.cleanUp();

	}

	private void update(){
		Engine.calculateDelta();
		Engine.updateFPS();

		player.handleInput();

	}

	public void render(){
		Game.getGame().getWorld().render();

	}

	public void initOGL(){
		player.getCamera().initProjection();
	}

	/*
	* Model matrix - gives you the shape of the product. Your hallways, etc
	 * Projection matrix - makes things look right. Image you're looking down a
	 * hallway: The doors aren't facing you directly, they're angled. Texture
	 * matrix - Self explanatory, adds the texture to the object.
	 * 
	 * Orthographic - the way objects literally are
	 * Perspective - the way we see them
	 */

}
