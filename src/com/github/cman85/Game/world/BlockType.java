package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Engine;
import org.newdawn.slick.opengl.Texture;

import java.io.IOException;

public enum BlockType{

	DIRT("dirt"),
	STONE("stone");

	private Texture texture;

	private BlockType(String textureName){
		try{
			texture = Engine.loadTexture(textureName);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public Texture getTexture(){
		return texture;
	}
	public void setTexture(Texture texture){
		this.texture = texture;
	}
}

