package ca.iamthemodder.a3dgame.main;

import org.lwjgl.opengl.Display;

import ca.iamthemodder.a3dgame.controls.KeyboardManager;
import ca.iamthemodder.a3dgame.player.Player;
import ca.iamthemodder.a3dgame.render.Renderer;
import ca.iamthemodder.a3dgame.window.Window;

public class Main {
	
	public Window window = new Window();
	public Renderer renderer = new Renderer(this);
	public Player mainPlayer = new Player();
	public KeyboardManager kbd = new KeyboardManager(this);
	private boolean running = true;
	
	public Main() {
		Logging.info("Initialising...");
		if(init() > 0)
			Logging.warn("Initialisation completed with errors.");
		else 
			Logging.info("Initialisation complete!");
		Logging.info("Starting game engine...");
		startThreads();
		Logging.info("Game engine started!");
		Logging.info("Entering render loop!");
		renderLoop();
		stop();
	}
	
	/**
	 * @author Alex Martin
	 * <p>Starts game threads.</p>
	 */
	private void startThreads() {
		new Thread(kbd).start();
	}

	/**
	 * @author Alex Martin
	 * <p>The primary render loop, not to be messed with.</p>
	 */
	private void renderLoop() {
		while(running) {
			if(Display.isCloseRequested()) {
				Logging.info("Window closed, stopping!");
				running = false;
			}
			
			if(Display.wasResized())
				window.resizeViewport();
			
			renderer.render();
		}
	}

	/**
	 * @return The error level (0 if no errors were encountered)
	 */
	private int init() {
		int t = 0;
		t = t + window.create();
		// Startup Section Begin
		renderer.setup();
		window.resizeViewport();
		// Startup Section End
		return t;
	}
	
	/**
	 * @author Alex Martin
	 * <p>Stops all threads, destroys resources and destroys display.</p>
	 */
	private void stop() {
		Logging.info("Stopping!");
		running = false;
		kbd.stop();
		window.destroy();
		Logging.info("Close.");
	}
}