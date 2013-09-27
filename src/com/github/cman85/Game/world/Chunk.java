package com.github.cman85.Game.world;

import com.github.cman85.Game.Main.Renderable;

public class Chunk implements Renderable {

   public static final int CHUNK_X = 16;
   public static final int CHUNK_Y = 4;
   public static final int CHUNK_Z = 16;

   private float x;
   private float z;

   private World world;
   private Block[][][] blocks = new Block[CHUNK_X][CHUNK_Y][CHUNK_Z];

   public Chunk(World world, float x, float z) {
      this.world = world;
      this.x = x;
      this.z = z;
      generateBlocks();
   }

   private void generateBlocks() {
      for(int x = 0; x < CHUNK_X; x++) {
         for(int z = 0; z < CHUNK_Z; z++) {
            for(int y = 0; y < CHUNK_Y; y++) {
               blocks[x][y][z] = new Block(BlockType.DIRT, new Location(this.world, x + this.x, y, z + this.z));
            }
         }
      }
   }

   public void render() {
      Block[][][] blocks = getBlocks();
      for(int x = 0; x < CHUNK_X; x++) {
         for(int z = 0; z < CHUNK_Z; z++) {
            for(int y = 0; y < CHUNK_Y; y++) {
               blocks[x][y][z].render();
            }
         }
      }

   }

   public Block getBlockAt(int x, int y, int z) throws BlockNotFoundException {
      //TODO this sucks
      if(x < 0 || x >= CHUNK_X) throw new BlockNotFoundException(String.format("X cannot be less than 0 or greater than %d, given %d", CHUNK_X, x));
      if(y < 0 || y >= CHUNK_Y) throw new BlockNotFoundException(String.format("Y cannot be less than 0 or greater than %d, given %d", CHUNK_Y, y));
      if(z < 0 || z >= CHUNK_Z) throw new BlockNotFoundException(String.format("Z cannot be less than 0 or greater than %d, given %d", CHUNK_Z, z));

      return getBlocks()[x][y][z];
   }

   public Block[][][] getBlocks() {
      return blocks;
   }

   public void setBlocks(Block[][][] blocks) {
      this.blocks = blocks;
   }

   public World getWorld() {
      return world;
   }

   public void setWorld(World world) {
      this.world = world;
   }

   public float getChunkX() {
      return x / Chunk.CHUNK_X;
   }

   public float getChunkZ() {
      return z / Chunk.CHUNK_Z;
   }

   class BlockNotFoundException extends Exception {
      private BlockNotFoundException(String message){
         super(message);
      }
   }
}
