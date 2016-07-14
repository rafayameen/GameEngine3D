package com.practice.engine2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ResourceLoader 
{
	public static String loadResource(String fileName)
	{
		StringBuilder shaderSource = new StringBuilder();
		BufferedReader shaderReader = null;
		
		try {
				shaderReader = new BufferedReader(new FileReader("./res/shaders/" + fileName));
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
	
	public static Mesh loadMesh(String fileName)
	{
		String[] splitArray = fileName.split("\\.");
		String ext = splitArray[splitArray.length - 1];
		
		if(!ext.contentEquals("obj"))
		{
			System.err.println("Error: File Format not supported for mesh data : " + ext);
			new Exception().printStackTrace();
			System.exit(1);
		}
		
		BufferedReader meshReader = null;
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		try {
			meshReader = new BufferedReader(new FileReader("./res/models/" + fileName));
				String line;
				
				while((line = meshReader.readLine()) != null)
				{
					String[] tokens = line.split(" ");
					tokens = Util.removeEmptyStrings(tokens);
					
					if(tokens.length == 0 | tokens[0].equals("#"))
						continue;
					else if(tokens[0].equals("v"))
					{
						vertices.add(new Vertex(new Vector3f(Float.valueOf(tokens[1]),
															 Float.valueOf(tokens[2]),
															 Float.valueOf(tokens[3]	
																	 ))));
					}
					else if(tokens[0].equals("f"))
					{
						indices.add(Integer.parseInt(tokens[1]) - 1);
						indices.add(Integer.parseInt(tokens[2]) - 1);
						indices.add(Integer.parseInt(tokens[3]) - 1);
					}
					
					
				}
				
				
				
				Mesh res = new Mesh();
				Vertex[] vertexData = new Vertex[vertices.size()];
				vertices.toArray(vertexData);
				
				Integer[] indexData = new Integer[indices.size()];
				indices.toArray(indexData);
				
				res.addVertices(vertexData, Util.toIntArray(indexData));
				
				return res;
				
				
				
		} catch (Exception e) {
			
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			try
			{
				meshReader.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
