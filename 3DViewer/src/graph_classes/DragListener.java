package graph_classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import math_classes.Matrix;
import math_classes.Model;

public class DragListener implements MouseListener, MouseMotionListener {

	private GraphModel gm;
	private int xm, ym;
	private boolean on;

	public DragListener(GraphModel gm) {
		this.gm = gm;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getButton() == MouseEvent.BUTTON1)
		System.out.println("coucou");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
			xm += e.getX();
			ym += e.getY();
			Model model = gm.getModel();
			Matrix m = Matrix.homogeneous(model.getMatrix());
			try {
				m = Matrix.multiplyByMatrix(
						Matrix.getRotationMatrixX(xm * Math.PI / 16), m);
				model.setMatrix(m);
				gm = new GraphModel(model);
				gm.repaint();
			} catch (Exception a) {

		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
