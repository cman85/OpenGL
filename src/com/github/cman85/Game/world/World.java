package com.github.cman85.Game.world;

public class World {

   private Location spawnLocation;
   private Block[][][] blocks = new Block[20][40][20];

   public World() {
      spawnLocation = new Location(this, 0, 64, 0);
      for(int x = 0; x < 20; x++){
            for(int z = 0; z < 20; z++){
               for(int y = 0; y < 40; y++){
                  blocks[x][y][z] = new Block(BlockType.DIRT, new Location(this, x, y, z));
            }
         }
      }
   }

   public Location getSpawnLocation() {
      return spawnLocation;
   }

   public void setSpawnLocation(Location spawnLocation) {
      this.spawnLocation = spawnLocation;
   }

   public Block[][][] getBlocks() {
      return blocks;
   }

   public void setBlocks(Block[][][] blocks) {
      this.blocks = blocks;
   }


}
