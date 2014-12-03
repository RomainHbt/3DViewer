package graph_classes;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import math_classes.Face;
import math_classes.Model;

public class GraphModel extends JPanel {

	private Model model;
	private Set<GraphFace> lsFace;
	
	public GraphModel(Model model) {
		this.model = model;
		this.lsFace = new HashSet<GraphFace>();
		for (Face face : model.getFaces())  {
			System.out.println(face);
			this.lsFace.add(new GraphFace(face));
		}
		addMouseListener(new DragListener(this));
		setSize(700, 500);
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public void paint(Graphics g) {
		for (GraphFace f : this.lsFace)
			f.paint(g);
	}
}
