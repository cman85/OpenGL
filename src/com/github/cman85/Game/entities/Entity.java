package com.github.cman85.Game.entities;

import com.github.cman85.Game.Event.MoveEvent;
import com.github.cman85.Game.Main.Engine;
import com.github.cman85.Game.world.Location;

public abstract class Entity {

   private Location loc;
   private float speed = 0.03f;

   public Entity(Location loc) {
      this.setLocation(loc);
   }

   public Location getLocation() {
      return loc;
   }

   public void setLocation(Location loc) {
      this.loc = loc;
   }

   public void move(float amt, float direction) {
      final float newZ = (float)(getLocation().getZ() + (getSpeed() * amt * Engine.getDelta() * Math.sin(Math.toRadians(getLocation().getYaw() + 90 * direction))));
      final float newX = (float)(getLocation().getX() + (getSpeed() * amt * Engine.getDelta() * Math.cos(Math.toRadians(getLocation().getYaw() + 90 * direction))));

      MoveEvent event = new MoveEvent(
          getLocation().getX(), getLocation().getY(), getLocation().getZ(),
          newX, getLocation().getY(), newZ
      );
      onMove(event);
      if(! event.isCancelled()) {
         getLocation().setX(event.getToX());
         getLocation().setZ(event.getToZ());
      }
      // Display.setTitle(String.format("Location x:%f, y:%f, z:%f", getLocation().getX(), getLocation().getY(), getLocation().getZ()));
   }

   public void moveY(float amt) {
      float newY = getLocation().getY() + amt;
      MoveEvent moveEvent = new MoveEvent(
          getLocation().getX(), getLocation().getY(), getLocation().getZ(),
          getLocation().getX(), newY, getLocation().getZ()
      );
      onMove(moveEvent);
      if(! moveEvent.isCancelled())
         getLocation().setY(moveEvent.getToY());
   }

   public abstract void onMove(MoveEvent event);

   public float getSpeed() {
      return speed;
   }

   public void setSpeed(float speed) {
      this.speed = speed;
   }

}
