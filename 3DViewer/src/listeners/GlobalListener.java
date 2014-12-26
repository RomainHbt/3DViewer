package listeners;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import model_classes.Model;

public class GlobalListener implements MouseListener {

	private Model model;
	private boolean bufPoints, bufSegments, bufFaces;

	public GlobalListener(Model model) {
		super();
		this.model = model;
		bufPoints = model.isPoints();
		bufSegments = model.isSegments();
		bufFaces = model.isFaces();
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (SwingUtilities.isRightMouseButton(arg0)) {
			model.getMenu().setLocation(arg0.getX(), arg0.getY());
			model.getMenu().setVisible(true);
		} else {
			model.getMenu().setVisible(false);
		}
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
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			bufPoints = model.isPoints();
			bufSegments = model.isSegments();
			bufFaces = model.isFaces();
			model.enableSegments();
			model.disableFaces();
			model.disablePoints();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		model.setCursor(Cursor.getDefaultCursor());
		model.setPoints(bufPoints);
		model.setSegments(bufSegments);
		model.setFaces(bufFaces);
	}

}
