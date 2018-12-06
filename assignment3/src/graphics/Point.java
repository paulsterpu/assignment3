package graphics;

import java.io.ObjectInputStream.GetField;

import visualiser.Color;

public final class Point {
	// TODO(5.1): Implementati clasa Point cu ajutorul Fluent Builder Pattern.
	
	private float x,y;
	
	private Color c;

	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public Color getC() {
		return c;
	}
	
	public void setC(Color c) {
		this.c = c;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
}
