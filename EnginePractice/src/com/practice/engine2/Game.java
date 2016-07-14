package com.practice.engine2;


//import org.lwjgl.input.Keyboard;

public class Game
{

	private Mesh mesh;
	private Shader shader;
	private Transform transform;

	public Game()
	{
		mesh = ResourceLoader.loadMesh("cube.obj");
		shader = new Shader();
		transform = new Transform();

		//drawPyramid(mesh);
		//drawCube(mesh);

		shader.addVertexShader(ResourceLoader.loadResource("basicVertex.vert"));
		shader.addFragmentShader(ResourceLoader.loadResource("basicFragment.frag"));

		shader.compileShader();
		
		shader.addUniform("transform");
	}

	public void input()
	{
	}
	
	float temp = 0.0f;

	public void update()
	{
		temp += Time.getDelta() + 0.001;
		
		float sinTemp = (float)Math.sin(temp);
		
		transform.setTranslation(sinTemp, 0, 0);
		transform.setRotation(0, sinTemp * 180, 0);
		//transform.setScale(sinTemp, sinTemp, sinTemp);
	}

	public void render()
	{
		shader.bind();
		shader.setUniform("transform", transform.getTransformation());
		mesh.draw();
	}
	


}
