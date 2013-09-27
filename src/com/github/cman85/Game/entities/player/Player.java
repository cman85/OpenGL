package com.github.cman85.Game.entities.player;

import com.github.cman85.Game.Event.MoveEvent;
import com.github.cman85.Game.Main.Main;
import com.github.cman85.Game.entities.Entity;
import com.github.cman85.Game.world.Location;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Player extends Entity {

   private Camera camera;

   public Player(Location loc) {
      super(loc);
      camera = new Camera(getLocation(), 70, (float)Display.getWidth() / (float)Display.getHeight(), 0.3f, 1000f);
      Mouse.setGrabbed(true);

   }

   public void handleInput() {
      if(Keyboard.isKeyDown(Keyboard.KEY_W))
         this.move(0.2f, 1);
      if(Keyboard.isKeyDown(Keyboard.KEY_S))
         this.move(- 0.2f, 1);
      if(Keyboard.isKeyDown(Keyboard.KEY_A))
         this.move(0.2f, 0);
      if(Keyboard.isKeyDown(Keyboard.KEY_D))
         this.move(- 0.2f, 0);
      if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
         this.moveY(0.2f);
      // else if(this.getLocation().getY() > 0)
      //   this.moveY(- 0.04f);
      if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
         this.moveY(- 0.2f);

      //Gravity - s(t) = -16t^2 + vt + s
      //s is original height t is time and v is velocity

      while(Keyboard.next()) {
         if(Keyboard.getEventKey() == Keyboard.KEY_ESCAPE && Keyboard.getEventKeyState())
            if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
               Main.setRunning(false);
            else
               Mouse.setGrabbed(! Mouse.isGrabbed());
      }

      if(Mouse.isGrabbed()) {
         getCamera().rotateY(- Mouse.getDY());
         getCamera().rotateX(Mouse.getDX());
      }
   }

   @Override
   public void onMove(MoveEvent event) {
      //TODO check physics

   }

   public Camera getCamera() {
      return camera;
   }

}
