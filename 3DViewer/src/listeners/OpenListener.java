package listeners;

import ihm.InfoPane;
import ihm.MainFrame;
import ihm.ModelPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model_classes.Loader;
import model_classes.Model;

public class OpenListener implements ActionListener {

	private String chosenFile;
	private MainFrame mainFrame;

	public OpenListener(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	public String getChosenFile() {
		return chosenFile;
	}

	public void setChosenFile(String chosenFile) {
		this.chosenFile = chosenFile;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Fichiers GTS", "gts");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(mainFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Loader load = new Loader(chooser.getSelectedFile()
					.getAbsolutePath());
			Model model = load.load();
			mainFrame.getModels().addTab(chooser.getSelectedFile().getName(),
					new ModelPane(model, new InfoPane(model)));
		}
	}

}
