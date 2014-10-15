package maths_classes;

public class Point {
	private double x, y, z;
	private int nom;

	/**
	 * Constructeur d'un point avec ses coordonnees
	 * @param x Axe des x
	 * @param y Axe des y
	 * @param z Axe des z
	 */
	public Point(double x, double y, double z, int nom){
		this.x = x;
		this.y = y;
		this.z = z;
		this.nom = nom;
	}
	
	public Point(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getNom() {
		return nom;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
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

	/**
	 * Retourne une chaine de caractere avec les coordonnes des points
	 */
	public String toString(){
		return "("+x+", "+y+", "+z+")";
	}
}
