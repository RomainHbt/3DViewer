package graph_classes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

import math_classes.Face;
import math_classes.Point;

public class GraphFace extends JComponent {

	private Face face;
	private GraphSegment s1, s2, s3;
	private int[] xpoints, ypoints;
	
	public GraphFace(Face face) {
		this.s1 = new GraphSegment(face.getS1());
		this.s2 = new GraphSegment(face.getS2());
		this.s3 = new GraphSegment(face.getS3());
		Set<Point> points = new HashSet<Point>();
		points.add(this.s1.getSegment().getP1());
		points.add(this.s1.getSegment().getP2());
		points.add(this.s1.getSegment().getP1());
		points.add(this.s2.getSegment().getP2());
		points.add(this.s1.getSegment().getP1());
		points.add(this.s3.getSegment().getP2());
		this.xpoints = new int[points.size()];
		this.ypoints = new int[points.size()];
		int i=0;
		for (Point p : points) {
			this.xpoints[i] = (int)p.getX()*14+350;
			this.ypoints[i] = (int)p.getY()*14+250;
			i++;
		}
		add(s1);
		add(s2);
		add(s3);
		setSize(700, 500);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillPolygon(this.xpoints, this.ypoints, xpoints.length);
		paintChildren(g);
	}
}
