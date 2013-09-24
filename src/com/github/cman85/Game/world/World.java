package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Game;
import com.github.cman85.Game.Main.Renderable;

public class World implements Renderable{

	private Location spawnLocation;
	private Chunk[] loadedChunks = new Chunk[5];

	public World(){
		spawnLocation = new Location(this, 0, 64, 0);
		int x = 0;
		int z = 0;
		for(int i = 0; i < loadedChunks.length; i++){
			loadedChunks[i] = new Chunk(this, x += 16, z += 16);
		}
	}

	public void render(){
		Chunk[] chunks = getChunks();
		for(int i = 0; i < chunks.length; i++){
			chunks[i].render();
		}
	}
	public Location getSpawnLocation(){
		return spawnLocation;
	}

	public void setSpawnLocation(Location spawnLocation){
		this.spawnLocation = spawnLocation;
	}

	public Chunk[] getChunks(){
		return loadedChunks;
	}


}
