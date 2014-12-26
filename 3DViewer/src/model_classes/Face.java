package model_classes;

import java.awt.Color;
import java.awt.Polygon;

import math_classes.Segment;
import math_classes.Vector;


public class Face implements Comparable<Face> {

	private Point p1, p2, p3;
	private Model model;

	public Face(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public Face(Segment s1, Segment s2, Segment s3) {
		p1 = s1.getP1();
		p2 = s1.getP2();
		if (!s2.getP1().equals(p1) && !s2.getP1().equals(p2))
			p3 = s2.getP1();
		else if (!s2.getP2().equals(p1) && !s2.getP2().equals(p2))
			p3 = s2.getP2();
		else if (!s3.getP1().equals(p1) && !s3.getP1().equals(p2))
			p3 = s3.getP1();
		else if (!s3.getP2().equals(p1) && !s3.getP2().equals(p2))
			p3 = s3.getP2();
	}
	
	public void setModel(Model m) {
		this.model = m;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	public Point getCentroid() {
		return new Point((p1.getX() + p2.getX() + p3.getX()) / 3, 
				(p1.getY() + p2.getY() + p3.getY()) / 3,
				(p1.getZ() + p2.getZ() + p3.getZ()) / 3);
	}
	
	public Vector getVector() {
		Vector v1 = new Vector(p1.getX()-p2.getX(),
				p1.getY()-p2.getY(),
				p1.getZ()-p2.getZ());
		Vector v2 = new Vector(p2.getX()-p3.getX(),
				p2.getY()-p3.getY(),
				p2.getZ()-p3.getZ());
		return Vector.getCrossProduct(v1, v2);
	}

	public double getRadian() {
		Vector v2 = getVector();
		Vector v1 = new Vector(0, 0, 1);
		double num = Math.abs(v1.getX() * v2.getX() + v1.getY() * v2.getY()
				+ v1.getZ() * v2.getZ());
		double den = Math.sqrt(Math.pow(v1.getX(), 2) + Math.pow(v1.getY(), 2)
				+ Math.pow(v1.getZ(), 2))
				* Math.sqrt(Math.pow(v2.getX(), 2) + Math.pow(v2.getY(), 2)
						+ Math.pow(v2.getZ(), 2));
		return num / den;
	}
	
	public Color getColor() {
		return new Color((int)(getRadian()*255/3), (int)(getRadian()*255/3), (int)(getRadian()*255/3));
	}

	@Override
	public int compareTo(Face o) {
		return getCentroid().compareTo(o.getCentroid());
	}
	
	public Polygon getTriangle() {
		return new Polygon(new int[]{(int)(p1.getX()+model.getWidth()/2), (int)(p2.getX()+model.getWidth()/2), (int)(p3.getX()+model.getWidth()/2)},
				new int[]{(int)(p1.getY()+model.getHeight()/2), (int)(p2.getY()+model.getHeight()/2), (int)(p3.getY()+model.getHeight()/2)},
				3);
	}
}
