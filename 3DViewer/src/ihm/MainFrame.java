package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import listeners.OpenListener;

public class MainFrame extends JFrame {
	
	private JTabbedPane models;

	public JTabbedPane getModels() {
		return models;
	}

	public void setModels(JTabbedPane model) {
		this.models = model;
	}

	public MainFrame(String title) {
		super(title);
		models = new JTabbedPane();
		this.setExtendedState(this.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMenu();
		add(models);
		setVisible(true);
	}
	
	public void addMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu files = new JMenu("Fichier");
		
		JMenuItem open = new JMenuItem("Ouvrir");
		open.addActionListener(new OpenListener(this));
		JMenuItem exit = new JMenuItem("Quitter");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		files.add(open);
		files.addSeparator();
		files.add(exit);
		menu.add(files);
		setJMenuBar(menu);
	}
	
}
