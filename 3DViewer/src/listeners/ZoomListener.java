package listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import math_classes.Matrix;
import model_classes.Model;

public class ZoomListener implements MouseWheelListener {

	private Model model;

	public ZoomListener(Model model) {
		super();
		this.model = model;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		Matrix m = null;
		double n = (double) e.getScrollAmount() - 1.80;
		if (e.getWheelRotation() > 0) {
			m = Matrix.multiplyByDouble(model.getMatrix(), 1 / n);
			RotationListener ls = model.getLs();
			Matrix mTranslation = ls.getmTranslation();
			mTranslation.matrix[0][3] *= 1/n;
			mTranslation.matrix[1][3] *= 1/n;
			mTranslation.matrix[2][3] *= 1/n;
			ls.setmTranslation(mTranslation);
			model.setLs(ls);
		} else {
			m = Matrix.multiplyByDouble(model.getMatrix(), n);
			RotationListener ls = model.getLs();
			Matrix mTranslation = ls.getmTranslation();
			mTranslation.matrix[0][3] *= n;
			mTranslation.matrix[1][3] *= n;
			mTranslation.matrix[2][3] *= n;
			ls.setmTranslation(mTranslation);
			model.setLs(ls);
		}
		model.setFacesByMatrix(m);
		model.sort();
	}

}
