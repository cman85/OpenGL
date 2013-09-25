package com.github.cman85.Game.Event;

public interface Cancellable {

   public void setCancelled(boolean cancel);
   public boolean isCancelled();
}
