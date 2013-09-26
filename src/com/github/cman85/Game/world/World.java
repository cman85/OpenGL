package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Renderable;
import org.lwjgl.util.vector.Vector3f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class World implements Renderable{

	private Location spawnLocation;
	private Map<Location, Chunk> loadedChunks = new HashMap<Location, Chunk>();

	private static final int LOADED_CHUNK_RADIUS = 3;

	public World(){
		spawnLocation = new Location(this, 0, Chunk.CHUNK_Y, 0);

		int maxX = LOADED_CHUNK_RADIUS * Chunk.CHUNK_X;
		int maxZ = LOADED_CHUNK_RADIUS * Chunk.CHUNK_Z;
		int dx = -maxX;
		int dz = -maxZ;
		for(int i = 0; i < Math.pow(LOADED_CHUNK_RADIUS * 2 + 1, 2); i++){
			loadedChunks.put(new Location(this, dx + Chunk.CHUNK_X, 0, dz), new Chunk(this, dx += Chunk.CHUNK_X, dz));
			if(dx > maxX){
				dx = -maxX;
				dz += Chunk.CHUNK_Z;
				if(dz > maxZ)
					break;
			}
		}
	}

	public void render(){
		Map<Location, Chunk> chunks = getChunks();
		for(Chunk chunk : chunks.values()){
			chunk.render();
		}

	}

	public Location getSpawnLocation(){
		return spawnLocation;
	}

	public void setSpawnLocation(Location spawnLocation){
		this.spawnLocation = spawnLocation;
	}

	public Block getBlockAt(Location loc){
		return null;
	}

	public Map<Location, Chunk> getChunks(){
		return loadedChunks;
	}

}
