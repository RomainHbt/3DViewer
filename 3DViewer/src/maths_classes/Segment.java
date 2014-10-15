package maths_classes;

public class Segment {
	private Point p1, p2;
	int nom;
	
	public Segment(Point p1, Point p2, int nom){
		this.p1 = p1;
		this.p2 = p2;
		this.nom = nom;
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	public int getNom() {
		return nom;
	}
	
}
