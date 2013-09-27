package com.github.cman85.Game.world;

public class Location {
	
	public float x;
	public float y;
	public float z;
	public float yaw;   //Up and down
	public float pitch; //Left and right

   private World world;
	
	public Location(World world, float x, float y, float z, float pitch, float yaw){
		this.setX(x);
		this.setY(y); 
		this.setZ(z);
		this.setPitch(pitch);
		this.setYaw(yaw);
      this.setWorld(world);

	}
	
	public Location(World world, float x, float y, float z){
		this(world, x, y, z, 0, 0);
	}

   public Location(Location loc){
      this(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ(), loc.getPitch(), loc.getYaw());
   }

	public float getX() {
		return x;
	}
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}

		Location location = (Location)o;

		if(Float.compare(location.pitch, pitch) != 0){
			return false;
		}
		if(Float.compare(location.x, x) != 0){
			return false;
		}
		if(Float.compare(location.y, y) != 0){
			return false;
		}
		if(Float.compare(location.yaw, yaw) != 0){
			return false;
		}
		if(Float.compare(location.z, z) != 0){
			return false;
		}
		if(world != null ? !world.equals(location.world) : location.world != null){
			return false;
		}

		return true;
	}
	public int hashCode(){
		int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
		result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
		result = 31 * result + (z != +0.0f ? Float.floatToIntBits(z) : 0);
		result = 31 * result + (yaw != +0.0f ? Float.floatToIntBits(yaw) : 0);
		result = 31 * result + (pitch != +0.0f ? Float.floatToIntBits(pitch) : 0);
		result = 31 * result + (world != null ? world.hashCode() : 0);
		return result;
	}
	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

   public World getWorld() {
      return world;
   }

   public void setWorld(World world) {
      this.world = world;
   }
}
