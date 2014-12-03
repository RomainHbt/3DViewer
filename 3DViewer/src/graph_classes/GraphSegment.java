package graph_classes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import math_classes.Segment;

public class GraphSegment extends JPanel {

	private Segment segment;
	
	public GraphSegment(Segment segment) {
		this.segment = segment;
		setSize(700, 500);
		setVisible(true);
	}
	
	public Segment getSegment() {
		return this.segment;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.drawLine((int)segment.getP1().getX()*14+350, (int)segment.getP1().getY()*14+250, (int)segment.getP2().getX()*14+350, (int)segment.getP2().getY()*14+250);
	}
}
