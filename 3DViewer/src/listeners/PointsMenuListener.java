package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model_classes.Model;

public class PointsMenuListener implements ActionListener {

	private Model model;
	
	public PointsMenuListener(Model model) {
		super();
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.isPoints()) {
			model.disablePoints();
		} else {
			model.enablePoints();
		}
	}
}
