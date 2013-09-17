package com.github.cman85.Game.Main;

import org.lwjgl.opengl.Display;

import com.github.cman85.Game.entities.player.Player;
import com.github.cman85.Game.world.Location;

import static org.lwjgl.opengl.GL11.*;

public class Screen3D {

	private Player player;
	
	public Screen3D() {
		player = new Player(new Location(0,0,0));
	}

	public void updateAndRender() {
		float x = 0;
		while (!Display.isCloseRequested() && Game.isRunning()) {
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clears the screen, OGL stores the
											// pixel info in the color buffer
			glLoadIdentity();

			player.getCamera().useView();

			update();
			render(x);

			x += 3f;
			Display.sync(60);
			Display.update();
		}
		Game.cleanUp();

	}

	private void update() {
		Engine.calculateDelta();
		player.handleInput();

	}

	private void render(float x) {
		glPushMatrix();
		{
			glTranslatef(0, 0, -10);
			glRotatef(x, 1, 1, 0);
			glBegin(GL_QUADS);
			{
				// FrontFace
				glColor3f(1f, 0.0f, 0.0f);
				glVertex3f(-1, -1, 1);
				glVertex3f(-1, 1, 1);
				glVertex3f(1, 1, 1);
				glVertex3f(1, -1, 1);

				// BackFace
				glColor3f(0.0f, 1f, 0.0f);
				glVertex3f(-1, -1, -1);
				glVertex3f(-1, 1, -1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);

				// BottomFace
				glColor3f(0f, 0f, 1f);
				glVertex3f(-1, -1, -1);
				glVertex3f(-1, -1, 1);
				glVertex3f(-1, 1, 1);
				glVertex3f(-1, 1, -1);

				// TopFace
				glColor3f(1f, 1f, 0f);
				glVertex3f(1, -1, -1);
				glVertex3f(1, -1, 1);
				glVertex3f(1, 1, 1);
				glVertex3f(1, 1, -1);

				// LeftFace
				glColor3f(0f, 1f, 1f);
				glVertex3f(-1, -1, -1);
				glVertex3f(1, -1, -1);
				glVertex3f(1, -1, 1);
				glVertex3f(-1, -1, 1);

				// Right Face
				glColor3f(1f, 0f, 1f);
				glVertex3f(-1, 1, -1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, 1, 1);
				glVertex3f(-1, 1, 1);
			}
			glEnd();
		}
		glPopMatrix();
	}

	public void initOGL() {
		player.getCamera().initProjection();
	}

	/*
	 * Model matrix - gives you the shape of the product. Your hallways, etc
	 * Projection matrix - makes things look right. Image you're looking down a
	 * hallway: The doors aren't facing you directly, they're angled. Texture
	 * matrix - Self explanatory, adds the texture to the object.
	 * 
	 * Orthographic - the way objects literally are Perspective - the way we see
	 * them
	 */

}
