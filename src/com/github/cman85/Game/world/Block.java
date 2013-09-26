package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Renderable;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;

public class Block implements Renderable{

	private BlockType type;
	private Location loc;

	private static int amt = 0;

	private boolean hasBeenRendered = false;
	private float x = 0;
	private boolean canDraw = false;

	public Block(BlockType type, Location loc){
		this.type = type;
		this.loc = loc;
	}

	@Override
	public void render(){
	 /* if(amt == 0 ){
         canDraw = true;
         amt++;
      }
      if(!canDraw) return;  */

		glPushMatrix();
		{
			glTranslatef(loc.getX(), loc.getY(), loc.getZ());
			// glRotatef(x += 3f, 1, 1, 0);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

			//glBindTexture(GL_TEXTURE, type.getTexture().getTextureID());
			glBindTexture(GL_TEXTURE_2D, type.getTexture().getTextureID());

			glBindBuffer(GL_ARRAY_BUFFER, type.getPhysicsShape().getVertexVBO());
			glVertexPointer(type.getPhysicsShape().getVertexSize(), GL_FLOAT, 0, 0L);

			glBindTexture(GL_ARRAY_BUFFER, type.getPhysicsShape().getVertexVBO());
			glTexCoordPointer(type.getPhysicsShape().getTextureSize(), GL_FLOAT, 0, 0L);

			glEnableClientState(GL_VERTEX_ARRAY);
			glEnableClientState(GL_TEXTURE_COORD_ARRAY);
			glDrawArrays(GL_QUADS, 0, type.getPhysicsShape().getAmountOfVertices());
			glDisableClientState(GL_TEXTURE_COORD_ARRAY);
			glDisableClientState(GL_VERTEX_ARRAY);

		}
		glPopMatrix();
	}

	public boolean shouldBeRendered(){
		return true;//TODO
	}

	public Block getRelative(BlockFace face){
		Location otherBlock = new Location(loc.getWorld(), loc.getX() + face.x, loc.getY() + face.y, loc.getZ() + face.z);
		return loc.getWorld().getBlockAt(otherBlock);
	}
}
