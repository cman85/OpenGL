package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Renderable;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

public class Block implements Renderable{

	private BlockType type;
	private Location loc;

	private static int amt = 0;

	private boolean hasBeenRendered = false;
	private int amountOfVertices;
	private int vertexSize;
	private int textureSize;
	private int vboVertexHandle;
	private int vboTextureHandle;
	private boolean canDraw = false;

	public Block(BlockType type, Location loc){
		this.type = type;
		this.loc = loc;

		initRendering();
	}
	private void initRendering(){

		amountOfVertices = 24;
		vertexSize = 3;
		textureSize = 2;

		FloatBuffer vertexData = BufferUtils.createFloatBuffer(amountOfVertices * vertexSize);
		float[] vertices = {
				//  X     Y     Z           R     G     B
				// face 0:
				1.0f, 1.0f, 1.0f,       // vertex 0
				-1.0f, 1.0f, 1.0f,        // vertex 1
				-1.0f, -1.0f, 1.0f,        // vertex 3
				1.0f, -1.0f, 1.0f,        // vertex 2

				// face 1:
				1.0f, 1.0f, 1.0f,       // vertex 0
				1.0f, -1.0f, 1.0f,       // vertex 1
				1.0f, -1.0f, -1.0f,       // vertex 3
				1.0f, 1.0f, -1.0f,        // vertex 2


				// face 2:
				1.0f, 1.0f, 1.0f,      // vertex 0
				1.0f, 1.0f, -1.0f,       // vertex 1
				-1.0f, 1.0f, -1.0f,       // vertex 3
				-1.0f, 1.0f, 1.0f,       // vertex 2


				// face 3:
				1.0f, 1.0f, -1.0f,     // vertex 0
				1.0f, -1.0f, -1.0f,      // vertex 1
				-1.0f, -1.0f, -1.0f,        // vertex 3
				-1.0f, 1.0f, -1.0f,       // vertex 2

				// face 4:
				-1.0f, 1.0f, 1.0f,      // vertex 0
				-1.0f, 1.0f, -1.0f,       // vertex 1
				-1.0f, -1.0f, -1.0f,     // vertex 3
				-1.0f, -1.0f, 1.0f,    // vertex 2

				// face 5:
				1.0f, -1.0f, 1.0f,      // vertex 0
				-1.0f, -1.0f, 1.0f,     // vertex 1
				-1.0f, -1.0f, -1.0f,     // vertex 3
				1.0f, -1.0f, -1.0f,     // vertex 2
				// 6 faces with 4 vertices with 6 components (floats)

		};
		System.out.println(vertices.length);
		vertexData.put(vertices);


		vertexData.flip();


		FloatBuffer textureData = BufferUtils.createFloatBuffer(amountOfVertices * textureSize);
		textureData.put(new float[]{
				1, 1, 0, 1, 0, 0, 1, 0,

				1, 1, 0, 1, 0, 0, 1, 0,

				1, 1, 0, 1, 0, 0, 1, 0,

				1, 1, 0, 1, 0, 0, 1, 0,

				1, 1, 0, 1, 0, 0, 1, 0,

				1, 1, 0, 1, 0, 0, 1, 0,
		});
		textureData.flip();

		vboVertexHandle = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
		glBufferData(GL_ARRAY_BUFFER, vertexData, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);


		vboTextureHandle = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vboTextureHandle);
		glBufferData(GL_ARRAY_BUFFER, textureData, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}

	@Override
	public void render(){
		//	if(!hasBeenRendered){


		canDraw = true;
		glPushMatrix();
		{
			glTranslatef(loc.getX(), loc.getY(), loc.getZ());
			//glRotatef(x, 1, 1, 0);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

			//glBindTexture(GL_TEXTURE, type.getTexture().getTextureID());
			glBindTexture(GL_TEXTURE_2D, type.getTexture().getTextureID());


			glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
			glVertexPointer(vertexSize, GL_FLOAT, 0, 0L);

			glBindTexture(GL_ARRAY_BUFFER, vboTextureHandle);
			glTexCoordPointer(textureSize, GL_FLOAT, 0, 0L);

			glEnableClientState(GL_VERTEX_ARRAY);
			glEnableClientState(GL_TEXTURE_COORD_ARRAY);
			glDrawArrays(GL_QUADS, 0, amountOfVertices);
			glDisableClientState(GL_TEXTURE_COORD_ARRAY);
			glDisableClientState(GL_VERTEX_ARRAY);

		}

		glPopMatrix();
		//	hasBeenRendered = true;
		//}
	}

	private void destroy(){
		glDeleteTextures(vboTextureHandle);
		glDeleteBuffers(vboVertexHandle);
	}

	public Block getRelative(BlockFace face){
		return null;
	}
}
