package com.practice.engine2;

public class MainComponent {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Engine Practice";
	public static final double FRAME_CAP = 500.0;

	private boolean isRunning;
	private Game game;

	public MainComponent() {
		RenderUtils.initGraphics();
		isRunning = false;
		game = new Game();
		
	}

	public void start() {
		if (isRunning)
			return;

		run();
	}

	public void stop() {
		isRunning = false;
	}

	private void run() {
		isRunning = true;
		
		int frames = 0;
		long frameCounter = 0;

		final double frameTime = 1.0 / FRAME_CAP;
		// Time that previous frame start drawing
		long lastTime = Time.getTime();
		double unprocessedTime = 0;

		while (isRunning) {
			boolean render = false;

			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			unprocessedTime += passedTime / (double) Time.SECOND;
			
			frameCounter += passedTime;
			
			while (unprocessedTime > frameTime) {
				render = true;

				unprocessedTime -= frameTime;

				if (Window.isCloseRequested())
					stop();
				
				Time.setDelta(frameTime);
				
				game.input();
				//Update Input and the game
				Input.update();
				game.update();

				if(frameCounter >= Time.SECOND)
				{
					System.out.println(frames);
					
					frames = 0;
					frameCounter = 0;
				}

			}
			if (render)
			{
				render();
				frames ++;
			}
			else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		cleanUp();
	}

	private void render() {
		RenderUtils.clearScreen();
		game.render();
		Window.render();
		

	}

	private void cleanUp() {
		Window.dispose();
	}

	public static void main(String[] args) {
		Window.createWindow(WIDTH, HEIGHT, TITLE);

		MainComponent game = new MainComponent();

		game.start();
	}

}
