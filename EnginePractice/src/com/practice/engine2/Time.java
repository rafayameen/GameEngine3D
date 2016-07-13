package com.practice.engine2;

public class Time 
{
	public static final long SECOND = 1000000000L;
	
	public static double delta;
	
	public static long getTime()
	{
		return System.nanoTime();
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
	  Time.delta = delta;
	}
	
	

}
