package com.github.cman85.Game.world;

import static org.lwjgl.opengl.GL11.*;

public class Block{

	private BlockType type;
	private Location loc;

	public Block(BlockType type, Location loc){
		this.type = type;
		this.loc = loc;
	}

	public void draw(){
		glPushMatrix();
		{
			glTranslatef(loc.getX(), loc.getY(), loc.getZ());
			//glRotatef(x, 1, 1, 0);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			type.getTexture().bind();

			glBegin(GL_QUADS);
			{
				//FrontFace
				glTexCoord2f(0,0); glVertex3f(-1,-1,1);
				glTexCoord2f(0,1); glVertex3f(1,-1,1);
				glTexCoord2f(1,1); glVertex3f(1,1,1);
				glTexCoord2f(1,0); glVertex3f(-1,1,1);

				//BackFace
				glTexCoord2f(0,0); glVertex3f(-1,-1,-1);
				glTexCoord2f(0,1); glVertex3f(-1,1,-1);
				glTexCoord2f(1,1); glVertex3f(1,1,-1);
				glTexCoord2f(1,0); glVertex3f(1,-1,-1);

				//BottomFace
				glTexCoord2f(0,0); glVertex3f(-1,-1,-1);
				glTexCoord2f(0,1); glVertex3f(-1,-1,1);
				glTexCoord2f(1,1); glVertex3f(-1,1,1);
				glTexCoord2f(1,0); glVertex3f(-1,1,-1);

				//TopFace
				glTexCoord2f(0,0); glVertex3f(1,-1,-1);
				glTexCoord2f(0,1); glVertex3f(1,-1,1);
				glTexCoord2f(1,1); glVertex3f(1,1,1);
				glTexCoord2f(1,0); glVertex3f(1,1,-1);

				//LeftFace
				glTexCoord2f(0,0); glVertex3f(-1,-1,-1);
				glTexCoord2f(0,1); glVertex3f(1,-1,-1);
				glTexCoord2f(1,1); glVertex3f(1,-1,1);
				glTexCoord2f(1,0); glVertex3f(-1,-1,1);

				//Right Face
				glTexCoord2f(0,0); glVertex3f(-1,1,-1);
				glTexCoord2f(0,1); glVertex3f(1,1,-1);
				glTexCoord2f(1,1); glVertex3f(1,1,1);
				glTexCoord2f(1,0); glVertex3f(-1,1,1);

				type.getTexture().release();
			}
			glEnd();
		}
		glPopMatrix();
	}

	public Block getRelative(BlockFace face){
		return null;
	}
}
