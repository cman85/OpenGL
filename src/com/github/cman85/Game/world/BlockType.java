package com.github.cman85.Game.world;

import org.newdawn.slick.opengl.Texture;

public enum BlockType {

   DIRT("dirt"),
   STONE("stone");

   private Texture texture;

   private BlockType(String textureName) {
     /* try {
         texture = Engine.loadTexture(textureName);
      } catch (IOException e) {
         e.printStackTrace();
      }*/
   }
}
