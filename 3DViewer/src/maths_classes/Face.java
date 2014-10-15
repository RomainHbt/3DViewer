package maths_classes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Face {
	private Segment s1, s2, s3;
	private Map<Integer, Point> points;
	private int nom;
	
	public Face(Segment s1, Segment s2, Segment s3, int nom){
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.nom = nom;
		
		points = new HashMap<Integer, Point>();
		points.put(s1.getP1().getNom(), s1.getP1());
		points.put(s1.getP2().getNom(), s1.getP2());
		points.put(s2.getP1().getNom(), s2.getP1());
		points.put(s2.getP2().getNom(), s2.getP2());
		points.put(s3.getP1().getNom(), s3.getP1());
		points.put(s3.getP2().getNom(), s3.getP2());
	}
	
	
	
	/**
	 * Calcule le barycentre de la face
	 * @return un point representant le barycentre de la face
	 */
	public Point getBarycentre(){
		double x = 0;
		double y = 0;
		double z = 0;
		Collection<Point> c = points.values();
		
		for(Point p : c){
			x += p.getX();
			y += p.getY();
			z += p.getZ();
		}
		
		return new Point(x/3, y/3, z/3);
	}

	public Segment getS1() {
		return s1;
	}

	public Segment getS2() {
		return s2;
	}

	public Segment getS3() {
		return s3;
	}

	public Map<Integer, Point> getPoints() {
		return points;
	}

	public int getNom() {
		return nom;
	}
}
