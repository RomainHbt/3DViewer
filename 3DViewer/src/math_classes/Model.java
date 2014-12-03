package math_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {

	private Set<Face> lsFaces;

	public Model(Set<Face> lsFaces) {
		this.lsFaces = lsFaces;
	}
	
	public void setMatrix(Matrix matrix) {
		lsFaces.clear();
		for (int i=0 ; i<matrix.getWidth() ; i+=3) {
			Point pt1 = new Point(matrix.matrix[0][i], matrix.matrix[1][i], matrix.matrix[2][i]);
			Point pt2 = new Point(matrix.matrix[0][i+1], matrix.matrix[1][i+1], matrix.matrix[2][i+1]);
			Point pt3 = new Point(matrix.matrix[0][i+2], matrix.matrix[1][i+2], matrix.matrix[2][i+2]);
			lsFaces.add(new Face(new Segment(pt1, pt2), new Segment(pt2, pt3), new Segment(pt1, pt3)));
		}
	}

	public Model() {
		this.lsFaces = new HashSet<Face>();
	}

	public Set<Face> getFaces() {
		return this.lsFaces;
	}

	public boolean setFace(Face f) {
		return lsFaces.add(f);
	}

	public Matrix getMatrix() {
		List<Point> sPoints = new ArrayList<Point>();
		for (Face f : this.lsFaces) {
				sPoints.add(f.getS1().getP1());
				sPoints.add(f.getS1().getP2());
				sPoints.add(f.getS2().getP1());
				sPoints.add(f.getS2().getP2());
				sPoints.add(f.getS3().getP1());
				sPoints.add(f.getS3().getP2());
		}
		Matrix m = new Matrix(3, sPoints.size());
		int i = 0;
		for (Point p : sPoints) {
			m.matrix[0][i] = p.getX();
			m.matrix[1][i] = p.getY();
			m.matrix[2][i] = p.getZ();
			i++;
		}
		return m;
	}

	public Point getCentre() {
		double x = 0.0, y = 0.0, z = 0.0;
		for (Face f : this.lsFaces) {
			x += f.getBarycentre().getX();
			y += f.getBarycentre().getY();
			z += f.getBarycentre().getZ();
		}
		return new Point(x, y, z);
	}

	public String toString() {
		String result = "";
		for (Face f : this.lsFaces)
			result += f.toString() + "\n";
		return result;
	}
}
