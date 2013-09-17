package com.github.cman85.Game.world;

public class Chunk{

	private float x;
	private float z;

	private World world;
	private Block[][][] blocks = new Block[16][64][16];


	public Chunk(World world, float x, float z){
		this.world = world;
		this.x = x;
		this.z = z;
		generateBlocks();
	}
	private void generateBlocks(){
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				for(int y = 0; y < 64; y++){
					blocks[x][y][z] = new Block(BlockType.DIRT, new Location(this.world, x, y, z));
				}
			}
		}
	}

	public Block[][][] getBlocks(){
		return blocks;
	}

	public void setBlocks(Block[][][] blocks){
		this.blocks = blocks;
	}

	public World getWorld(){
		return world;
	}
	public void setWorld(World world){
		this.world = world;
	}
	public float getX(){
		return x;
	}
	public void setX(float x){
		this.x = x;
	}
}
