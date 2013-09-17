package com.github.cman85.Game.world;

public enum BlockFace{
	NORTH(0, 0, 1),
	SOUTH(0, 0, -1),
	EAST(1, 0, 0),
	WEST(-1, 0, 0),
	UP(0, 1, 0),
	DOWN(0, -1, 0);

	public int x, y, z;
	private BlockFace(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
