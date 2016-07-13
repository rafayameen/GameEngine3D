package com.practice.engine2;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;



public class Shader 
{
	private int program;
	
	public Shader()
	{
		program = glCreateProgram();
		
		if(program == 0)
		{
			System.err.println("Failed to create Shader: Could not find valid memory location");
			System.exit(1);
		}
	}
	
	public void addVertexShader(String text)
	{
		addProgram(text, GL_VERTEX_SHADER);
	}
	
	public void addGeometryShader(String text)
	{
		addProgram(text, GL_GEOMETRY_SHADER);
	}
	
	public void addFragmentShader(String text)
	{
		addProgram(text, GL_FRAGMENT_SHADER);
	}
	
	public void compileShader()
	{
		glLinkProgram(program);
		
		if(glGetShader(program, GL_LINK_STATUS) == 0)
		{
			System.err.print(glGetShaderInfoLog(program, 1024));
			System.exit(1);
		}
		
		glValidateProgram(program);
		
		if(glGetShader(program, GL_VALIDATE_STATUS) == 0)
		{
			System.err.print(glGetShaderInfoLog(program, 1024));
			System.exit(1);
		}
	}
	
	public void bind()
	{
		glUseProgram(program);
	}
	
	private void addProgram(String text, int type)
	{
		int shader = glCreateShader(type);
		
		if(shader == 0)
		{
			System.err.println("Failed to create shader: Could not find valid memory location while adding shader");
			System.exit(1);
		}
		
		glShaderSource(shader, text);
		glCompileShader(shader);
		
		if(glGetShader(shader, GL_COMPILE_STATUS) == 0)
		{
			System.err.print(glGetShaderInfoLog(shader, 1024));
			System.exit(1);
		}
		
		glAttachShader(shader, program);
	}

}
