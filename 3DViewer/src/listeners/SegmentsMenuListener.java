package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model_classes.Model;

public class SegmentsMenuListener implements ActionListener {

	private Model model;
		
	public SegmentsMenuListener(Model model) {
		super();
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.isSegments()) {
			model.disableSegments();
		} else {
			model.enableSegments();
		}
	}
}
