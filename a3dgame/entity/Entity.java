/**
 * @author Alex Martin
 */
package ca.iamthemodder.a3dgame.entity;

/**
 * @author Alex Martin
 *
 */
public abstract class Entity {
	
	private double x, y, z, xMov, yMov, zMov;
	private double accel = 1;
	private String name = "Player";
	private double rot;
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getY() {
		return y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setRot(double rot) {
		this.rot = rot;
	}
	
	public double getRot() {
		return rot;
	}
	
	public void moveForward() {
		x++;
	}
	
	public void moveBackward() {
		x--;
	}
	
	public void moveLeft() {
		y++;
	}
	
	public void moveRight() {
		y--;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}