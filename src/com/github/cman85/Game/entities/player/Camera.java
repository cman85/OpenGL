package com.github.cman85.Game.entities.player;


import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import com.github.cman85.Game.world.Location;

public class Camera {
	
	private Location loc;
	
	private float FOV;
	private float aspect_ratio;
	private float near_clipping_plane;
	private float far_clipping_plane;
	
	
	public Camera(Location loc, float FOV, float aspect_ratio, float near, float far){
		this.loc = loc;
		this.setFOV(FOV);
		this.setAspectRatio(aspect_ratio);
		this.setNearClippingPlane(near);
		this.setFarClippingPlane(far);
	}

	public void useView(){
		glRotatef(loc.getPitch(), 1, 0, 0);
		glRotatef(loc.getYaw(), 0, 1, 0);
		glTranslatef(loc.getX(), loc.getY(), loc.getZ());
	}

	public void initProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		
		gluPerspective(getFOV(), getAspectRatio(), getNearClippingPlane(), getFarClippingPlane());
		glMatrixMode(GL_MODELVIEW);
		
		glEnable(GL_DEPTH_TEST);
	}
	
	
	public void rotateY(float amt){
		float nextPitch = loc.getPitch() + amt;
		if(nextPitch > 90) nextPitch = 90;
		else if(nextPitch < -90) nextPitch = -90;
		loc.setPitch(nextPitch);
	}
	public void rotateX(float amt){
		float nextYaw = loc.getYaw() + amt;
		loc.setYaw(nextYaw);
	}

	public float getFOV() {
		return FOV;
	}

	public void setFOV(float fOV) {
		FOV = fOV;
	}

	public float getAspectRatio() {
		return aspect_ratio;
	}

	public void setAspectRatio(float aspect_ratio) {
		this.aspect_ratio = aspect_ratio;
	}

	public float getNearClippingPlane() {
		return near_clipping_plane;
	}

	public void setNearClippingPlane(float near_clipping_plane) {
		this.near_clipping_plane = near_clipping_plane;
	}

	public float getFarClippingPlane() {
		return far_clipping_plane;
	}

	public void setFarClippingPlane(float far_clipping_plane) {
		this.far_clipping_plane = far_clipping_plane;
	}

}
