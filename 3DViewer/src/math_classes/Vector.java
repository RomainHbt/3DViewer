package math_classes;
public class Vector {

	private double x, y, z;

	public Vector() {
	};

	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public static Vector getCrossProduct(Vector v1, Vector v2) {
		Vector res = new Vector();
		res.setX(v1.getY() * v2.getZ() - v1.getZ() * v2.getY());
		res.setY(v1.getY() * v2.getX() - v1.getX() * v2.getY());
		res.setZ(v1.getX() * v2.getY() - v1.getY() * v2.getX());
		return res;
	}
}