package com.github.cman85.Game.Event;

public class MoveEvent extends Event implements Cancellable {

   private float fromX;
   private float fromY;
   private float fromZ;
   private float toX;
   private float toY;
   private float toZ;
   private boolean cancel = false;

   public MoveEvent(float fromX, float fromY, float fromZ, float toX, float toY, float toZ) {
      this.fromX = fromX;
      this.fromY = fromY;
      this.fromZ = fromZ;
      this.toX = toX;
      this.toY = toY;
      this.toZ = toZ;
   }

   public float getFromX() {
      return fromX;
   }

   public float getFromY() {
      return fromY;
   }

   public float getToX() {
      return toX;
   }

   public float getToY() {
      return toY;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancel = cancel;
   }

   @Override
   public boolean isCancelled() {
      return this.cancel;
   }

   public float getFromZ() {
      return fromZ;
   }

   public float getToZ() {
      return toZ;
   }

   public void setToX(float toX) {
      this.toX = toX;
   }

   public void setToY(float toY) {
      this.toY = toY;
   }

   public void setToZ(float toZ) {
      this.toZ = toZ;
   }

}
