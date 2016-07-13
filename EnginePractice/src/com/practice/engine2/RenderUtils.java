package com.practice.engine2;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

import org.lwjgl.opengl.GL11;

public class RenderUtils 
{
	public static void clearScreen()
	{
		//TODO: stencil buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static void initGraphics()
	{
		glClearColor(0.0f, 0.0f, 0.0f,0.0f);
		
		glFrontFace(GL_CW);	
		glCullFace(GL_BACK);
		GL11.glEnable(0);
		glEnable(GL_DEPTH_TEST);
		
		//TODO: depth clamp
		glEnable(GL_FRAMEBUFFER_SRGB);
	}
	
	public static String getOpenGLVersion()
	{
		return glGetString(GL_VERSION);
	}

}
