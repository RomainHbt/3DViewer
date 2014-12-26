package model_classes;

import ihm.InfoPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import listeners.GlobalListener;
import listeners.RotationListener;
import listeners.ZoomListener;
import math_classes.Matrix;
import math_classes.Vector;

public class Model extends JPanel {

	private static final long serialVersionUID = 305810048032430634L;

	private List<Face> lsFaces;
	private Thread refresh;
	private ModelMenu menu;
	private boolean points, segments, faces;
	private double maxX, minX, maxY, minY;
	private double zoomFactor;
	private RotationListener ls;
	private int nPoints, nSegments, nFaces;
	private String file;

	public Model(List<Face> lsFaces, double maxX, double minX, double maxY, double minY, int nPoints,int nSegments,int nFaces, String file) {
		super();
		this.maxX = maxX;
		this.minX = minX;
		this.maxY = maxY;
		this.minY = minY;
		this.nPoints = nPoints;
		this.nSegments = nSegments;
		this.nFaces = nFaces;
		this.file = file;
		points = true;
		segments = true;
		faces = true;
		this.lsFaces = lsFaces;
		for (Face f : this.lsFaces)
			f.setModel(this);
		center();
		ls = new RotationListener(this);
		addListeners();
		menu = new ModelMenu(this);
		refresh = new RefreshThread(this);
		refresh.start();
	}

	public RotationListener getLs() {
		return ls;
	}

	public void setLs(RotationListener ls) {
		removeMouseListener(this.ls);
		removeMouseMotionListener(this.ls);
		this.ls = ls;
		addMouseListener(ls);
		addMouseMotionListener(ls);
	}

	public int getnPoints() {
		return nPoints;
	}

	public void setnPoints(int nPoints) {
		this.nPoints = nPoints;
	}

	public int getnSegments() {
		return nSegments;
	}

	public void setnSegments(int nSegments) {
		this.nSegments = nSegments;
	}

	public int getnFaces() {
		return nFaces;
	}

	public void setnFaces(int nFaces) {
		this.nFaces = nFaces;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public double getMaxX() {
		return maxX;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public double getMinX() {
		return minX;
	}

	public void setMinX(double minX) {
		this.minX = minX;
	}

	public double getMaxY() {
		return maxY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	public double getMinY() {
		return minY;
	}

	public void setMinY(double minY) {
		this.minY = minY;
	}

	public Model() {
		this.lsFaces = new ArrayList<Face>();
	}

	public ModelMenu getMenu() {
		return menu;
	}

	public void setMenu(ModelMenu menu) {
		this.menu = menu;
	}

	public void sort() {
		Collections.sort(lsFaces);
	}

	public List<Face> getLsFaces() {
		return lsFaces;
	}

	public void setLsFaces(List<Face> lsFaces) {
		this.lsFaces = lsFaces;
	}

	public void addListeners() {
		addMouseWheelListener(new ZoomListener(this));
		addMouseListener(ls);
		addMouseListener(new GlobalListener(this));
		addMouseMotionListener(ls);
	}

	public void stopRefresh() {
		refresh.interrupt();
	}

	public Matrix getMatrix() {
		Matrix m = new Matrix(3, lsFaces.size() * 3);
		int i = 0;
		for (Face f : lsFaces) {
			m.matrix[0][i] = f.getP1().getX();
			m.matrix[1][i] = f.getP1().getY();
			m.matrix[2][i] = f.getP1().getZ();
			m.matrix[0][i + 1] = f.getP2().getX();
			m.matrix[1][i + 1] = f.getP2().getY();
			m.matrix[2][i + 1] = f.getP2().getZ();
			m.matrix[0][i + 2] = f.getP3().getX();
			m.matrix[1][i + 2] = f.getP3().getY();
			m.matrix[2][i + 2] = f.getP3().getZ();
			i += 3;
		}
		return m;
	}

	public void setFacesByMatrix(Matrix m) {
		lsFaces.clear();
		Point p1, p2, p3;
		for (int i = 0; i < m.getWidth(); i += 3) {
			p1 = new Point(m.matrix[0][i], m.matrix[1][i], m.matrix[2][i]);
			p2 = new Point(m.matrix[0][i + 1], m.matrix[1][i + 1],
					m.matrix[2][i + 1]);
			p3 = new Point(m.matrix[0][i + 2], m.matrix[1][i + 2],
					m.matrix[2][i + 2]);
			Face f = new Face(p1, p2, p3);
			f.setModel(this);
			lsFaces.add(f);
		}
	}

	public double getZoomFactor() {
		return zoomFactor;
	}

	public void setZoomFactor(double zoomFactor) {
		this.zoomFactor = zoomFactor;
	}

	public Point getModelCentroid() {
		double xsum = 0, ysum = 0, zsum = 0;
		for (Face f : lsFaces) {
			xsum += f.getCentroid().getX();
			ysum += f.getCentroid().getY();
			zsum += f.getCentroid().getZ();
		}
		return new Point(xsum / lsFaces.size(), ysum / lsFaces.size(), zsum
				/ lsFaces.size());
	}

	public void enablePoints() {
		points = true;
	}

	public void disablePoints() {
		points = false;
	}

	public void enableSegments() {
		segments = true;
	}

	public void disableSegments() {
		segments = false;
	}

	public void enableFaces() {
		faces = true;
	}

	public void disableFaces() {
		faces = false;
	}
	
	public boolean isPoints() {
		return points;
	}

	public boolean isSegments() {
		return segments;
	}

	public boolean isFaces() {
		return faces;
	}

	public void setPoints(boolean points) {
		this.points = points;
	}

	public void setSegments(boolean segments) {
		this.segments = segments;
	}

	public void setFaces(boolean faces) {
		this.faces = faces;
	}
	
	
	public void center() {
		Point centroid = getModelCentroid();
		Matrix centroidMatrix = Matrix.getTranslationMatrix(new Vector(
				-centroid.getX(), -centroid.getY(), -centroid.getZ()));
		;
		Matrix m;
		try {
			m = Matrix.multiplyByMatrix(centroidMatrix, Matrix.homogeneous(getMatrix()));
			setFacesByMatrix(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		sort();
		Graphics2D p = (Graphics2D) g;
		p.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_OFF);
		p.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_SPEED);
		p.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
				RenderingHints.VALUE_COLOR_RENDER_SPEED);
		super.paint(p);
		for (Face f : lsFaces) {
			if (faces) {
				p.setColor(f.getColor());
				p.fillPolygon(f.getTriangle());
			}
			if (segments) {
				p.setColor(Color.BLACK);
				p.drawPolygon(f.getTriangle());
			}
			if (points) {
				p.setColor(Color.BLACK);
				p.drawOval((int) (f.getP1().getX()+getWidth()/2), (int) (f.getP1()
						.getY()+getHeight()/2), 1, 1);
				p.drawOval((int) (f.getP2().getX()+getWidth()/2), (int) (f.getP2()
						.getY()+getHeight()/2), 1, 1);
				p.drawOval((int) (f.getP3().getX()+getWidth()/2), (int) (f.getP3()
						.getY()+getHeight()/2), 1, 1);
			}
		}
		p.dispose();
	}
}
