package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Engine;
import com.github.cman85.Game.Physics.PhysicsShape;
import org.newdawn.slick.opengl.Texture;

import java.io.IOException;

public enum BlockType{

   AIR(),
	DIRT("dirt"),
	STONE("stone");

	private Texture texture;
   private PhysicsShape shape;

	private BlockType(String textureName){
		 this(textureName, PhysicsShape.BLOCK);
	}

   private BlockType(String textureName, PhysicsShape shape){
      try{
         texture = Engine.loadTexture(textureName);
      }catch(IOException e){
         e.printStackTrace();
      }
      this.shape = shape;
   }

   private BlockType(){

   }

	public Texture getTexture(){
		return texture;
	}
	public void setTexture(Texture texture){
		this.texture = texture;
	}

   public PhysicsShape getPhysicsShape() {
      return shape;
   }
}

