package com.practice.engine2;

public class Vertex 
{
	public static final int SIZE = 3;		//3 vertices of a triangles
	private Vector3f pos;
	
	public Vertex(Vector3f pos)
	{
		this.pos = pos;
	}

	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

}
