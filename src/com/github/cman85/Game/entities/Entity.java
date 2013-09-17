package com.github.cman85.Game.entities;

import com.github.cman85.Game.Main.Engine;
import com.github.cman85.Game.world.Location;
import org.lwjgl.opengl.Display;

public class Entity {

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
      getLocation().setZ((float)(getLocation().getZ() + (getSpeed() * amt * Engine.getDelta() * Math.sin(Math.toRadians(getLocation().getYaw() + 90 * direction)))));
      getLocation().setX((float)(getLocation().getX() + (getSpeed() * amt * Engine.getDelta() * Math.cos(Math.toRadians(getLocation().getYaw() + 90 * direction)))));
      Display.setTitle(String.format("Location x:%f, y:%f, z:%f", getLocation().getX(), getLocation().getY(), getLocation().getZ()));
   }

   protected void moveY(float amt) {
      getLocation().setY(getLocation().getY() + amt);
   }

   public float getSpeed() {
      return speed;
   }

   public void setSpeed(float speed) {
      this.speed = speed;
   }

}
