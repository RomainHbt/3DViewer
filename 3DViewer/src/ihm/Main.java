package ihm;

import javax.swing.JFrame;

public class Main {

	public static JFrame f;

	public static void main(String[] args) {
		f = new JFrame();

		//JPanel panel1 = new NbColor();
		f.setTitle("3DViewer");
		f.setResizable(true);
		f.setLocationRelativeTo(null);
		//f.getContentPane().add(panel1);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);

	}

}