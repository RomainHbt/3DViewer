package model_classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import listeners.CenterMenuListener;
import listeners.FacesMenuListener;
import listeners.PointsMenuListener;
import listeners.SegmentsMenuListener;

public class ModelMenu extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	private Model model;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public ModelMenu(Model model) {
		super();
		this.model = model;
		JLabel title = new JLabel("Affichage");
		JCheckBoxMenuItem faces = new JCheckBoxMenuItem("Faces",
				model.isFaces());
		faces.addActionListener(new FacesMenuListener(model));
		JCheckBoxMenuItem points = new JCheckBoxMenuItem("Points",
				model.isPoints());
		points.addActionListener(new PointsMenuListener(model));
		JCheckBoxMenuItem segments = new JCheckBoxMenuItem("Segments",
				model.isSegments());
		segments.addActionListener(new SegmentsMenuListener(model));
		JMenuItem center = new JMenuItem("Recenter");
		center.addActionListener(new CenterMenuListener(model));
		add(title);
		addSeparator();
		add(faces);
		add(segments);
		add(points);
		addSeparator();
		add(center);
	}
}
