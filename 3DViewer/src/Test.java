import ihm.MainFrame;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model_classes.Loader;


public class Test {

	public static void main(String[] args) {
		/*JFrame f = new JFrame("Test");
		Loader loader = new Loader("./models/X-Wings.gts");
		f.setLayout(new BorderLayout());
		f.add(loader.load(), BorderLayout.CENTER);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);*/
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Loader loader = new Loader("./models/Tie.gts");
		MainFrame f = new MainFrame("3DViewer");
	}
}
