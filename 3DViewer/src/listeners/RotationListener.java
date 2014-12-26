package listeners;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import math_classes.Matrix;
import math_classes.Vector;
import model_classes.Model;
import model_classes.Point;

public class RotationListener implements MouseMotionListener, MouseListener {

	private Model model;
	private int x, y;
	private Matrix mTranslation;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public RotationListener(Model model) {
		super();
		this.model = model;
		Point centroid = model.getModelCentroid();
		mTranslation = Matrix.getTranslationMatrix(new Vector(-centroid.getX(),
				-centroid.getY(), -centroid.getZ()));
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		model.getMenu().setVisible(false);
		model.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		Matrix m = Matrix.homogeneous(model.getMatrix());
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			double angle = Math.PI / 50;
			Matrix mRotationX = null, mRotationY = null;
			if (y > arg0.getY() + 2)
				mRotationX = Matrix.getRotationMatrixX(angle);
			else if (y < arg0.getY() - 2)
				mRotationX = Matrix.getRotationMatrixX(-angle);
			else
				mRotationX = Matrix.getIdentityMatrix(4);
			if (x > arg0.getX() + 2)
				mRotationY = Matrix.getRotationMatrixY(angle);
			else if (x < arg0.getX() - 2)
				mRotationY = Matrix.getRotationMatrixY(-angle);
			else
				mRotationY = Matrix.getIdentityMatrix(4);
			try {
				model.center();
				m = Matrix.homogeneous(model.getMatrix());
				m = Matrix.multiplyByMatrix(mRotationX, m);
				m = Matrix.multiplyByMatrix(mRotationY, m);
				m = Matrix.multiplyByMatrix(mTranslation, m);
				model.setFacesByMatrix(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (SwingUtilities.isRightMouseButton(arg0)) {
			try {
				System.out.println(model.getModelCentroid());
				Matrix mTranslate = Matrix.getTranslationMatrix(new Vector(
						-(x - arg0.getX()), -(y - arg0.getY()), 0));
				mTranslation.matrix[0][3] += mTranslate.matrix[0][3];
				mTranslation.matrix[1][3] += mTranslate.matrix[1][3];
				mTranslation.matrix[2][3] += mTranslate.matrix[2][3];
				m = Matrix.multiplyByMatrix(mTranslate, m);
				model.setFacesByMatrix(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		x = arg0.getX();
		y = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
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
		x = arg0.getX();
		y = arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		x = arg0.getX();
		y = arg0.getY();
	}

	public Matrix getmTranslation() {
		return mTranslation;
	}

	public void setmTranslation(Matrix mTranslation) {
		this.mTranslation = mTranslation;
	}
	

}
