package com.practice.engine2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceLoader 
{
	public static String loadResource(String fileName)
	{
		StringBuilder shaderSource = new StringBuilder();
		BufferedReader shaderReader = null;
		
		try {
				shaderReader = new BufferedReader(new FileReader(".res/shaders" + fileName));
				String line;
				
				while((line = shaderReader.readLine()) != null)
				{
					shaderSource.append(line).append("\n");
				}
		} catch (Exception e) {
			
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			try {
				shaderReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return shaderSource.toString();
	}

}
