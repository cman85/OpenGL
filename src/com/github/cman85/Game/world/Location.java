package com.github.cman85.Game.world;

public class Location {
	
	public float x;
	public float y;
	public float z;
	public float yaw;   //Up and down
	public float pitch; //Left and right
	
	public Location(float x, float y, float z, float pitch, float yaw){
		this.setX(x);
		this.setY(y); 
		this.setZ(z);
		this.setPitch(pitch);
		this.setYaw(yaw);
	}
	
	public Location(float x, float y, float z){
		this(x, y, z, 0, 0);
	}
	

	public float getX() {
		return x;
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

}
