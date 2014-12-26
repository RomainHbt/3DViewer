package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import math_classes.Matrix;
import math_classes.Vector;
import model_classes.Model;
import model_classes.Point;

public class CenterMenuListener implements ActionListener {
	
	private Model model;

	public CenterMenuListener(Model model) {
		super();
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Matrix m = Matrix.homogeneous(model.getMatrix());
		Point centroid = model.getModelCentroid();
		Matrix centroidMatrix = Matrix.getTranslationMatrix(new Vector(
				-centroid.getX(), -centroid.getY(), -centroid.getZ()));
		;
		try {
		m = Matrix.multiplyByMatrix(centroidMatrix, m);
		model.setFacesByMatrix(m);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		((JMenuItem)(e.getSource())).getParent().setVisible(false);
		model.removeMouseMotionListener(model.getLs());
		model.removeMouseListener(model.getLs());
		model.setLs(new RotationListener(model));
	}
	
	

}
