/**
 * @author Alex Martin
 */
package ca.iamthemodder.a3dgame.render;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import ca.iamthemodder.a3dgame.main.Main;
import ca.iamthemodder.a3dgame.window.WindowProps;

public class Renderer {
	
	private Main main;
	
	public Renderer(Main main) {
		this.main = main;
	}
	
	public void setup() {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glClearColor(0f, 0f, 0f, 0f);
	}
	
	/**
	 * @author Alex Martin
	 * <h2>Main Render Function</h2>
	 * <p style="margin: 0; font-weight: bold; color: red;">DO NOT CALL UNLESS IN RENDER LOOP</p>
	 */
	public void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		GL11.glRotated(90, main.mainPlayer.getX(), main.mainPlayer.getY(), 1);
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glColor3f(1, 0, 0);
		GL11.glVertex3f(0.5f, 0.5f, 0);
		GL11.glColor3f(0, 1, 0);
		GL11.glVertex3f(0, 0, 0);
		GL11.glColor3f(0, 0, 1);
		GL11.glVertex3f(0, 0.5f, 0);
		GL11.glEnd();
		
		GL11.glBegin(GL11.GL_LINE_LOOP);
		GL11.glColor3f(1, 1, 1);
		GL11.glVertex3f(-1, 0, 0);
		GL11.glVertex3f(-0.75f, 0.75f, 0);
		GL11.glVertex3f(-0.5f, 0, 0);
		GL11.glVertex3f(-0.625f, 0.6f, 0);
		GL11.glVertex3f(-0.875f, 0.6f, 0);
		GL11.glEnd();
		
		Display.update();
		if(WindowProps.rateLock > 0)
			Display.sync(WindowProps.rateLock);
	}
}