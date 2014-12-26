package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model_classes.Loader;
import model_classes.Model;

public class InfoPane extends JPanel{

	private Model model;
	private JLabel modelTitle, nPoints, nSegments, nFaces;

	public InfoPane(Model model) {
		super();
		this.model = model;
		modelTitle = new JLabel(model.getFile());
		nPoints = new JLabel(((Integer)(model.getnPoints())).toString()+" points");
		nSegments = new JLabel(((Integer)(model.getnSegments())).toString()+" segments");
		nFaces = new JLabel(((Integer)(model.getnFaces())).toString()+" faces");
		setBackground(new Color(140, 140, 140));
		setPreferredSize(new Dimension(480, 15));
		setLayout(new GridLayout(1, 4));
		add(modelTitle);
		add(nPoints);
		add(nSegments);
		add(nFaces);
	}
}
