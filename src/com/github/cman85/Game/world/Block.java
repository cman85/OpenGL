package com.github.cman85.Game.world;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

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

			int amountOfVertices = 24;
			int vertexSize = 3;
			int textureSize = 2;

			FloatBuffer vertexData = BufferUtils.createFloatBuffer(amountOfVertices * vertexSize);
			vertexData.put(new float[]{
				-1, -1, 1,
				1, -1, 1,
				1, 1, 1,
				-1, 1, 1,

				-1, -1, -1,
				-1, 1, -1,
				1, 1, -1,
				1, -1, -1,

				-1, -1, -1,
				-1, -1, 1,
				-1, 1, 1,
				-1, 1, -1,

				1, -1, -1,
				1, -1, 1,
				1, 1, 1,
				1, 1, -1,

				-1, -1, -1,
				1, -1, -1,
				1, -1, 1,
				-1, -1, 1,

				-1, 1, -1,
				1, 1, -1,
				1, 1, 1,
				-1, 1, 1
			});
			vertexData.flip();

			FloatBuffer textureData = BufferUtils.createFloatBuffer(amountOfVertices * textureSize);
			vertexData.put(new float[]{
				0, 0, 0, 1, 1, 1, 1, 0,
				0, 0, 0, 1, 1, 1, 1, 0,
				0, 0, 0, 1, 1, 1, 1, 0,
				0, 0, 0, 1, 1, 1, 1, 0,
				0, 0, 0, 1, 1, 1, 1, 0,
				0, 0, 0, 1, 1, 1, 1, 0,

			});
			textureData.flip();

			int vboVertexHandle = glGenBuffers();
			glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
			glBufferData(GL_ARRAY_BUFFER, vertexData, GL_STATIC_DRAW);
			glBindBuffer(GL_ARRAY_BUFFER, 0);
			//glTexCoordPointer();  Use this instead of the color one

			int vboTextureHandle = glGenBuffers();
			glBindBuffer(GL_ARRAY_BUFFER, vboTextureHandle);
			glBufferData(GL_ARRAY_BUFFER, textureData, GL_STATIC_DRAW);
			glBindBuffer(GL_ARRAY_BUFFER, 0);

			glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
			glVertexPointer(vertexSize, GL_FLOAT, 0, 0L);

			glBindBuffer(GL_ARRAY_BUFFER, vboTextureHandle);
			glTexCoordPointer(textureSize, GL_FLOAT, 0, 0L);

			glEnableClientState(GL_VERTEX_ARRAY);
			glEnableClientState(GL_TEXTURE_COORD_ARRAY);
			glDrawArrays(GL_QUADS, 0, amountOfVertices);
			glDisableClientState(GL_TEXTURE_COORD_ARRAY);
			glDisableClientState(GL_VERTEX_ARRAY);

			/*glBegin(GL_QUADS);
			{
				//FrontFace
				glTexCoord2f(0, 0);
				glVertex3f(-1, -1, 1);
				glTexCoord2f(0, 1);
				glVertex3f(1, -1, 1);
				glTexCoord2f(1, 1);
				glVertex3f(1, 1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(-1, 1, 1);

				//BackFace
				glTexCoord2f(0, 0);
				glVertex3f(-1, -1, -1);
				glTexCoord2f(0, 1);
				glVertex3f(-1, 1, -1);
				glTexCoord2f(1, 1);
				glVertex3f(1, 1, -1);
				glTexCoord2f(1, 0);
				glVertex3f(1, -1, -1);

				//BottomFace
				glTexCoord2f(0, 0);
				glVertex3f(-1, -1, -1);
				glTexCoord2f(0, 1);
				glVertex3f(-1, -1, 1);
				glTexCoord2f(1, 1);
				glVertex3f(-1, 1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(-1, 1, -1);

				//TopFace
				glTexCoord2f(0, 0);
				glVertex3f(1, -1, -1);
				glTexCoord2f(0, 1);
				glVertex3f(1, -1, 1);
				glTexCoord2f(1, 1);
				glVertex3f(1, 1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(1, 1, -1);

				//LeftFace
				glTexCoord2f(0, 0);
				glVertex3f(-1, -1, -1);
				glTexCoord2f(0, 1);
				glVertex3f(1, -1, -1);
				glTexCoord2f(1, 1);
				glVertex3f(1, -1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(-1, -1, 1);

				//Right Face
				glTexCoord2f(0, 0);
				glVertex3f(-1, 1, -1);
				glTexCoord2f(0, 1);
				glVertex3f(1, 1, -1);
				glTexCoord2f(1, 1);
				glVertex3f(1, 1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(-1, 1, 1);

				type.getTexture().release();
			}
			glEnd();  */
		}
		glPopMatrix();
	}

	public Block getRelative(BlockFace face){
		return null;
	}
}
