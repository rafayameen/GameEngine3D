package com.practice.engine2;

//import org.lwjgl.input.Keyboard;

public class Game {
	
	private Mesh triangle;
	
	public Game()
	{
		triangle = new Mesh();
		
		Vertex[] triangleVertices = new Vertex[] {new Vertex(new Vector3f(-1,-1,0)),
				new Vertex(new Vector3f(0,1,0)),
				new Vertex(new Vector3f(1,-1,0))};
		
		triangle.addVertices(triangleVertices);
	}
	
	public void input()
	{
//		if(Input.getKeyDown(Keyboard.KEY_UP))
//			System.out.println("Up Key Pressed!");
//		if(Input.getKeyUp(Keyboard.KEY_UP))
//			System.out.println("Up Key Released!");
		
		//Mouse Test
		if(Input.getMouseDown(1))
			System.out.println("Right Mouse Pressed at " + Input.getMousePosition().toString());
		if(Input.getMouseUp(1))
			System.out.println("Right Mouse Released!");
	}
	
	public void update()
	{}
	
	public void render()
	{
		triangle.draw();
	}

}
