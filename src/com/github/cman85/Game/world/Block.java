package com.github.cman85.Game.world;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Block {

   private BlockType type;
   private Location loc;

   public Block(BlockType type, Location loc) {
      this.type = type;
      this.loc = loc;
   }

   public void draw() {
      glPushMatrix();
      {
         glTranslatef(loc.getX(), loc.getY(), loc.getZ());
         //glRotatef(x, 1, 1, 0);
         glBegin(GL_QUADS);
         {
            // FrontFace
            glColor3f(1f, 0.0f, 0.0f);
            glVertex3f(- 1, - 1, 1);
            glVertex3f(- 1, 1, 1);
            glVertex3f(1, 1, 1);
            glVertex3f(1, - 1, 1);

            // BackFace
            glColor3f(0.0f, 1f, 0.0f);
            glVertex3f(- 1, - 1, - 1);
            glVertex3f(- 1, 1, - 1);
            glVertex3f(1, 1, - 1);
            glVertex3f(1, - 1, - 1);

            // BottomFace
            glColor3f(0f, 0f, 1f);
            glVertex3f(- 1, - 1, - 1);
            glVertex3f(- 1, - 1, 1);
            glVertex3f(- 1, 1, 1);
            glVertex3f(- 1, 1, - 1);

            // TopFace
            glColor3f(1f, 1f, 0f);
            glVertex3f(1, - 1, - 1);
            glVertex3f(1, - 1, 1);
            glVertex3f(1, 1, 1);
            glVertex3f(1, 1, - 1);

            // LeftFace
            glColor3f(0f, 1f, 1f);
            glVertex3f(- 1, - 1, - 1);
            glVertex3f(1, - 1, - 1);
            glVertex3f(1, - 1, 1);
            glVertex3f(- 1, - 1, 1);

            // Right Face
            glColor3f(1f, 0f, 1f);
            glVertex3f(- 1, 1, - 1);
            glVertex3f(1, 1, - 1);
            glVertex3f(1, 1, 1);
            glVertex3f(- 1, 1, 1);
         }
         glEnd();
      }
      glPopMatrix();
   }
}
