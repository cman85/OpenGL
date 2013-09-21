package com.github.cman85.Game.world;

public class World{

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
