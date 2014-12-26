package ihm;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ModelPane extends JPanel {

	private JPanel model, infos;

	public ModelPane(JPanel model, JPanel infos) {
		super();
		this.model = model;
		this.infos = infos;
		setLayout(new BorderLayout());
		add(model, BorderLayout.CENTER);
		add(infos, BorderLayout.SOUTH);
	}	
}
