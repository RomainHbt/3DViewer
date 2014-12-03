package graph_classes;

import java.io.File;

import javax.swing.JFrame;

import load_and_save_classes.Loader;

public class Test {

	public static void main(String[] args) {
		JFrame f = new JFrame("Test");
		f.setSize(700, 500);
		Loader loader = new Loader(new File("models/cube.gts"));
		f.setLayout(null);
		System.out.println(loader.load().getMatrix());
		f.add(new GraphModel(loader.load()));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
