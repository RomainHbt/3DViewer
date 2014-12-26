package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model_classes.Model;

public class FacesMenuListener implements ActionListener {

	private Model model;
	
	public FacesMenuListener(Model model) {
		super();
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.isFaces()) {
			model.disableFaces();
		} else {
			model.enableFaces();
		}
	}
}
