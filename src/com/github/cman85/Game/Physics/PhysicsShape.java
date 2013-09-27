package com.github.cman85.Game.Physics;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.glDeleteTextures;
import static org.lwjgl.opengl.GL15.*;

public enum PhysicsShape {

   BLOCK(24, 3, 2);

   private int amountOfVertices, vertexSize, textureSize;

   private PhysicsShape(int amountOfVertices, int vertexSize, int textureSize) {
      this.amountOfVertices = amountOfVertices;
      this.vertexSize = vertexSize;
      this.textureSize = textureSize;
   }

   static Map<PhysicsShape, Integer> verticesVBO = new HashMap<PhysicsShape, Integer>();
   static Map<PhysicsShape, Integer> textureVBO = new HashMap<PhysicsShape, Integer>();

   static {
      for(PhysicsShape shape : PhysicsShape.values()) {
         FloatBuffer vertexData;
         vertexData = BufferUtils.createFloatBuffer(shape.getAmountOfVertices() * shape.getVertexSize());
         float[] vertices;

         FloatBuffer textureData;

         switch (shape) {
            case BLOCK:
               vertices = new float[] {
                   //  X     Y     Z           R     G     B
                   // face 0:
                   1.0f, 1.0f, 1.0f,       // vertex 0
                   - 1.0f, 1.0f, 1.0f,        // vertex 1
                   - 1.0f, - 1.0f, 1.0f,        // vertex 3
                   1.0f, - 1.0f, 1.0f,        // vertex 2

                   // face 1:
                   1.0f, 1.0f, 1.0f,       // vertex 0
                   1.0f, - 1.0f, 1.0f,       // vertex 1
                   1.0f, - 1.0f, - 1.0f,       // vertex 3
                   1.0f, 1.0f, - 1.0f,        // vertex 2

                   // face 2:
                   1.0f, 1.0f, 1.0f,      // vertex 0
                   1.0f, 1.0f, - 1.0f,       // vertex 1
                   - 1.0f, 1.0f, - 1.0f,       // vertex 3
                   - 1.0f, 1.0f, 1.0f,       // vertex 2

                   // face 3:
                   1.0f, 1.0f, - 1.0f,     // vertex 0
                   1.0f, - 1.0f, - 1.0f,      // vertex 1
                   - 1.0f, - 1.0f, - 1.0f,        // vertex 3
                   - 1.0f, 1.0f, - 1.0f,       // vertex 2

                   // face 4:
                   - 1.0f, 1.0f, 1.0f,      // vertex 0
                   - 1.0f, 1.0f, - 1.0f,       // vertex 1
                   - 1.0f, - 1.0f, - 1.0f,     // vertex 3
                   - 1.0f, - 1.0f, 1.0f,    // vertex 2

                   // face 5:
                   1.0f, - 1.0f, 1.0f,      // vertex 0
                   - 1.0f, - 1.0f, 1.0f,     // vertex 1
                   - 1.0f, - 1.0f, - 1.0f,     // vertex 3
                   1.0f, - 1.0f, - 1.0f,     // vertex 2
                   // 6 faces with 4 vertices with 6 components (floats)
               };

               textureData = BufferUtils.createFloatBuffer(shape.getAmountOfVertices() * shape.getTextureSize());
               textureData.put(new float[] {
                   1, 1, 0, 1, 0, 0, 1, 0,

                   1, 1, 0, 1, 0, 0, 1, 0,

                   1, 1, 0, 1, 0, 0, 1, 0,

                   1, 1, 0, 1, 0, 0, 1, 0,

                   1, 1, 0, 1, 0, 0, 1, 0,

                   1, 1, 0, 1, 0, 0, 1, 0,
               });

               break;
            default:
               throw new IllegalArgumentException("Failed to add block shape to vertices initializer");

         }
         vertexData.put(vertices);

         vertexData.flip();
         textureData.flip();

         int vboVertexHandle = glGenBuffers();
         glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
         glBufferData(GL_ARRAY_BUFFER, vertexData, GL_STATIC_DRAW);
         glBindBuffer(GL_ARRAY_BUFFER, 0);

         int vboTextureHandle = glGenBuffers();
         glBindBuffer(GL_ARRAY_BUFFER, vboTextureHandle);
         glBufferData(GL_ARRAY_BUFFER, textureData, GL_STATIC_DRAW);
         glBindBuffer(GL_ARRAY_BUFFER, 0);

         verticesVBO.put(shape, vboVertexHandle);
         textureVBO.put(shape, vboTextureHandle);

      }
   }

   public int getAmountOfVertices() {
      return amountOfVertices;
   }

   public int getVertexSize() {
      return vertexSize;
   }

   public int getTextureSize() {
      return textureSize;
   }

   public int getVertexVBO() {
      return verticesVBO.get(this);
   }

   public int getTextureVBO() {
      return textureVBO.get(this);
   }

   public static void cleanUp() {
      for(int handle : verticesVBO.values()) {
         glDeleteBuffers(handle);
      }
      for(int handle : textureVBO.values()) {
         glDeleteTextures(handle);
      }
   }
}
