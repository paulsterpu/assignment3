package graphics;

import visualiser.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public final class Renderer extends JFrame {
	// TODO(5.2): Implementati clasa Renderer cu ajutorul Fluent Builder pattern.
	
	private List<Point> points = new ArrayList<Point>();
	private float circleSize;
	
	public List<Point> getPoints() {
		return points;
	}
	
	public float getCircleSize() {
		return circleSize;
	}
	
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void setCircleSize(float circleSize) {
		this.circleSize = circleSize;
	}
	
	public void draw() {
		setVisible(true);
	}
	
	public void addPoint(float x, float y, visualiser.Color color) {
		// TODO(5.2): Adaugati listei curente de puncte ce trebuiesc desenate, un nou punct cu
		// dimensiunea si culoarea primite ca parametrii.
		
		PointBuilder builder = new PointBuilder();
		
		builder
			.x(x)
			.y(y)
			.c(color);
		
		points.add(builder.build());
		
	}
	
	@Override
	public void paint(Graphics g) {
		Shape circle;
		Graphics2D ga = (Graphics2D)g;
		for (Point p : points) {
			circle = new Ellipse2D.Float(p.getX(), p.getY(), circleSize, circleSize);
		  	ga.draw(circle);
		  	ga.setPaint(getColor(p));
		  	ga.fill(circle);
		}
	}

	private Color getColor(Point p) {
		// TODO(5.2): Returnati culoarea (Color) din pachetul awt, aferenta punctului curent.
		// Hint: utilizati o mapare visualisation.Color -> awt.Color.
		
		return Main.m.get(p.getC());
		
	}
	
	
}
