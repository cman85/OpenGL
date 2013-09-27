package com.github.cman85.Game.Main;

public enum CachedBoolean {

   TRUE(true), FALSE(false), UNSURE(false);

   private boolean val;

   private CachedBoolean(boolean b) {
       val = b;
   }

   public boolean value(){
      return val;
   }
}
