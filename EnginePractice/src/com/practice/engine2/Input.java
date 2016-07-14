package com.practice.engine2;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input
{
	// ASCII CODES
	public static final int NUM_KEYCODES = 256;
	public static final int NUM_MOUSEBUTTONS = 5;

	// KeyBoard
	private static ArrayList<Integer> currentKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> downKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> upKeys = new ArrayList<Integer>();
	// Mouse
	private static ArrayList<Integer> currentMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> downMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> upMouse = new ArrayList<Integer>();

	public static void update()
	{

		///////////// MOUSE////////////////////////////
		// clear up keys
		upMouse.clear();
		// if the key was pressed previous frame
		// and we are not pressing it any more the add to upKeys
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
		{
			if (!getMouse(i) && currentMouse.contains(i))
				upMouse.add(i);
		}

		// clear downKeys
		downMouse.clear();
		// if key is pressed and was not pressed in previous frame
		// then add the key to downKeys of current frame
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
		{
			if (getMouse(i) && !currentMouse.contains(i))
				downMouse.add(i);
		}

		currentMouse.clear();

		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
		{
			if (getMouse(i))
				currentMouse.add(i);
		}

		///////////// END MOUSE////////////////////////////

		///////////// KEYBOARD ////////////////////////////
		// clear upKeys
		upKeys.clear();
		for (int i = 0; i < NUM_KEYCODES; i++)
		{
			if (!getKey(i) && currentKeys.contains(i))
				upKeys.add(i);
		}

		// clear downKeys
		downKeys.clear();

		for (int i = 0; i < NUM_KEYCODES; i++)
		{
			if (getKey(i) && !currentKeys.contains(i))
				downKeys.add(i);
		}

		// clear currentKeys
		currentKeys.clear();

		// iterate through all ascii
		// if any key is found pressed in single frame add
		// to the arraylist

		for (int i = 0; i < NUM_KEYCODES; i++)
		{
			if (getKey(i))
				currentKeys.add(i);
		}
		///////////// END KEYBOARD////////////////////////////

	}

	// KeyBoard
	// which key is pressed
	public static boolean getKey(int keyCode)
	{
		return Keyboard.isKeyDown(keyCode);
	}

	// key is pressed down for first frame
	// nor pressed in previous frame
	public static boolean getKeyDown(int keyCode)
	{
		return downKeys.contains(keyCode);

	}

	// key just released
	public static boolean getKeyUp(int keyCode)
	{
		return upKeys.contains(keyCode);

	}
	///////////////// end keyboard////////////////////

	// Mouse
	// which key is pressed
	public static boolean getMouse(int mouseButton)
	{
		return Mouse.isButtonDown(mouseButton);
	}

	// key is pressed down for first frame
	// nor pressed in previous frame
	public static boolean getMouseDown(int mouseButton)
	{
		return downMouse.contains(mouseButton);

	}

	// key just released
	public static boolean getMouseUp(int mouseButton)
	{
		return upMouse.contains(mouseButton);

	}

	// GET X, Y COORDINATED OF MOUSE
	public static Vector2f getMousePosition()
	{
		return new Vector2f(Mouse.getX(), Mouse.getY());
	}
	//////////////// end mouse/////////////////////////

}
