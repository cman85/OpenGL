package com.github.cman85.Game.Main;

import com.github.cman85.Game.world.World;

public class Game  {

   private static Game game;

   private World loadedWorld;

   private Game(){
      setWorld(new World());
   }

   public static void load(){
     game = new Game();
   }

   public static Game getGame() {
      return game;
   }

   public World getWorld() {
      return loadedWorld;
   }

   public void setWorld(World loadedWorld) {
      this.loadedWorld = loadedWorld;

   }
}
