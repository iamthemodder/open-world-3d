/**
 * @author Alex Martin
 */
package ca.iamthemodder.a3dgame.controls;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;

import ca.iamthemodder.a3dgame.main.Logging;
import ca.iamthemodder.a3dgame.main.Main;

/**
 * @author Alex Martin
 *
 */
public class KeyboardManager implements Runnable {
	
	private Main main;
	private HashMap<Character, Runnable> keyBindings = new HashMap();
	private boolean running = true;
	
	public KeyboardManager(Main main) {
		this.main = main;
		
		keyBindings.put('w', () -> main.mainPlayer.moveForward());
		keyBindings.put('a', () -> main.mainPlayer.moveLeft());
		keyBindings.put('s', () -> main.mainPlayer.moveBackward());
		keyBindings.put('d', () -> main.mainPlayer.moveRight());
	}
	
	public void update() {
		while(running) {
			if(Keyboard.next()) {
				if(Keyboard.getEventKeyState()) {
					char key = Keyboard.getEventCharacter();
					if(keyBindings.containsKey(key))
						keyBindings.get(key).run();
				}
			}
		}
	}
	
	public void stop() {
		running = false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		update();
	}
}