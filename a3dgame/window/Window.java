package ca.iamthemodder.a3dgame.window;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import ca.iamthemodder.a3dgame.main.Logging;

public class Window {
	
	public int create() {
		int t = 0;
		if(!Display.isCreated()) {
			t = t + update();
			try {
				Display.create();
			} catch (LWJGLException e) {
				t = t + 1;
				e.printStackTrace();
			}
		} else {
			Logging.warn("CANNOT CREATE 2 DISPLAYS!");
			return 1;
		}
		return t;
	}
	
	public int update() {
		try {
			Display.setResizable(true);
			Display.setTitle(WindowProps.windowName);
			Display.setDisplayMode(new DisplayMode(WindowProps.width, WindowProps.height));
			Display.setFullscreen(WindowProps.isFullscreen);
			Display.setVSyncEnabled(WindowProps.vSync);
		} catch (LWJGLException e) {
			e.printStackTrace();
			return 1;
		}
		return 0;
	}
	
	public void resizeViewport() {
		WindowProps.width = Display.getWidth();
		WindowProps.height = Display.getHeight();
		GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
	}
	
	public void destroy() {
		Display.destroy();
	}
}