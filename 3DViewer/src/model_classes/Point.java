package model_classes;

public class Point implements Comparable<Point>{
	
	public Point(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	private double x, y, z;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public int compareTo(Point arg0) {
		return ((Double)this.getZ()).compareTo(arg0.getZ());
	}
	
	@Override
	public String toString() {
		return x + " " + y + " " + z;
	}
}
