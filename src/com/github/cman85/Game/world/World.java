package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Renderable;

import java.util.HashSet;
import java.util.Set;

public class World implements Renderable {

   private Location spawnLocation;
   private Set<Chunk> loadedChunks = new HashSet<Chunk>();

   private int LOADED_CHUNK_RADIUS = 3;

   public World() {
      spawnLocation = new Location(this, 0, Chunk.CHUNK_Y, 0);

      int maxX = LOADED_CHUNK_RADIUS * Chunk.CHUNK_X;
      int maxZ = LOADED_CHUNK_RADIUS * Chunk.CHUNK_Z;
      int dx = - maxX;
      int dz = - maxZ;
      for(int i = 0; i < Math.pow(LOADED_CHUNK_RADIUS * 2 + 1, 2 ); i++) {
         loadedChunks.add(new Chunk(this, dx += Chunk.CHUNK_X, dz));
         if(dx > maxX) {
            dx = - maxX;
            dz += Chunk.CHUNK_Z;
            if(dz > maxZ)
               break;
         }
      }
   }

   public void render() {
      Set<Chunk> chunks = getChunks();
      for(Chunk chunk : chunks) {
         chunk.render();
      }
   }

   public Location getSpawnLocation() {
      return spawnLocation;
   }

   public void setSpawnLocation(Location spawnLocation) {
      this.spawnLocation = spawnLocation;
   }

   public Set<Chunk> getChunks() {
      return loadedChunks;
   }

}
