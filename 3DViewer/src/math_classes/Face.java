package math_classes;

import java.util.HashSet;
import java.util.Set;

public class Face implements Comparable<Face> {
	private Segment s1, s2, s3;

	public Face(Segment s1, Segment s2, Segment s3) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	/**
	 * Calcule le barycentre de la face
	 * 
	 * @return un point representant le barycentre de la face
	 */
	public Point getBarycentre() {
		double x = 0.0, y = 0.0, z = 0.0;
		Set<Point> s = new HashSet<Point>();
		s.add(s1.getP1());
		s.add(s1.getP2());
		s.add(s2.getP1());
		s.add(s2.getP2());
		s.add(s3.getP1());
		s.add(s3.getP2());
		for (Point p : s) {
			x += p.getX();
			y += p.getY();
			z += p.getZ();
		}
		return new Point(x, y, z);
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
	
	public Matrix getMatrix() {
		return null;
	}

	@Override
	public int compareTo(Face arg0) {
		return -this.getBarycentre().compareTo(arg0.getBarycentre());
	}
	
	public String toString() {
		return new String(s1.toString() + " | " + s2.toString() + " | " + s3.toString() + "\n");
	}
}