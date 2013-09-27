package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Renderable;

import java.util.HashMap;
import java.util.Map;

public class World implements Renderable {

   private Location spawnLocation;
   //TODO shit system
   private Map<Location, Chunk> loadedChunks = new HashMap<Location, Chunk>();

   private static final int LOADED_CHUNK_RADIUS = 3;

   public World() {
      spawnLocation = new Location(this, 0, Chunk.CHUNK_Y, 0);

      int maxX = LOADED_CHUNK_RADIUS * Chunk.CHUNK_X;
      int maxZ = LOADED_CHUNK_RADIUS * Chunk.CHUNK_Z;
      int dx = - maxX;
      int dz = - maxZ;
      for(int i = 0; i < Math.pow(LOADED_CHUNK_RADIUS * 2 + 1, 2); i++) {
         loadedChunks.put(
             new Location(this, ((dx += Chunk.CHUNK_X) - (dx % Chunk.CHUNK_X)) / Chunk.CHUNK_X,
                 0,
                 (dz - (dz % Chunk.CHUNK_Z)) / Chunk.CHUNK_Z),
             new Chunk(this, dx, dz));
         if(dx > maxX) {
            dx = - maxX;
            dz += Chunk.CHUNK_Z;
            if(dz > maxZ)
               break;
         }
      }
   }

   public void render() {
      Map<Location, Chunk> chunks = getChunks();
      for(Chunk chunk : chunks.values()) {
         chunk.render();
      }

   }

   public Location getSpawnLocation() {
      return spawnLocation;
   }

   public void setSpawnLocation(Location spawnLocation) {
      this.spawnLocation = spawnLocation;
   }

   public Block getBlockAt(Location loc) {
      Chunk chunk = getChunkAt(loc);
      float posXrelative = loc.getX() % 16;
      float posYrelative = loc.getY();
      float posZrelative = loc.getZ() % 16;

      if(chunk == null) return null;
      try {
         return chunk.getBlockAt((int)posXrelative, (int)posYrelative, (int)posZrelative);
      } catch (Chunk.BlockNotFoundException e) {
      }
      return null;
   }

   public Chunk getChunkAt(Location loc) {
      Location chunkLoc = new Location(loc);
      float chunkX = (chunkLoc.getX() - (chunkLoc.getX() % Chunk.CHUNK_X)) / Chunk.CHUNK_X;
      float chunkZ = (chunkLoc.getZ() - (chunkLoc.getZ() % Chunk.CHUNK_Z)) / Chunk.CHUNK_Z;
      System.out.println(String.format("Chunk X: %f, Chunk Z: %f", chunkX, chunkZ));

      chunkLoc.setX(chunkX);
      chunkLoc.setZ(chunkZ);
      chunkLoc.setY(0);

      Chunk c = loadedChunks.get(chunkLoc);
      System.out.println(c);
      return c;
   }

   public Map<Location, Chunk> getChunks() {
      return loadedChunks;
   }

}
