package com.practice.engine2;

//import org.lwjgl.input.Keyboard;

public class Game {
	
	private Mesh triangle;
	
	public Game()
	{
		triangle = new Mesh();
		
		Vertex[] data = new Vertex[] {new Vertex(new Vector3f(-1,-1,0)),
				new Vertex(new Vector3f(0,1,0)),
				new Vertex(new Vector3f(1,-1,0))};
		
		triangle.addVertices(data);
		
	}
	
	public void input()
	{
	}
	
	public void update()
	{}
	
	public void render()
	{
		triangle.draw();
	}

}
