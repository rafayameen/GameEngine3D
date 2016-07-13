package com.practice.engine2;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;


public class Mesh 
{
	private int vbo;
	private int size;
	
	public Mesh()
	{
		vbo = GL15.glGenBuffers();
		size = 0;
	}
	
	//get vertices to render and add to vbo
	public void addVertices(Vertex[] vertices)
	{
		size = vertices.length;	//every element of vertices has 3 points
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);	//Bind array of buffer with vbo
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL15.GL_STATIC_DRAW);
		
	}
	
	public void draw()
	{
		GL20.glEnableVertexAttribArray(0);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, Vertex.SIZE * 4, 0);
		
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, size);
		GL20.glDisableVertexAttribArray(0);
	}

}
