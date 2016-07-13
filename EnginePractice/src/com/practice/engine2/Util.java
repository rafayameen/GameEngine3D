package com.practice.engine2;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class Util 
{
	public static FloatBuffer createFloatBuffer(int size)
	{
		return BufferUtils.createFloatBuffer(size);
	}
	
	public static FloatBuffer createFlippedBuffer(Vertex[] vertices)
	{
		//create FloatBuffer
		FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);
		//add data to buffer
		for(int i = 0; i < vertices.length; i++)
		{
			buffer.put(vertices[i].getPos().getX());
			buffer.put(vertices[i].getPos().getY());
			buffer.put(vertices[i].getPos().getZ());
		}
		
		//flip and return
		buffer.flip();
		
		return buffer;
	}

}
