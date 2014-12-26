package model_classes;



public class RefreshThread extends Thread {

	private Model model;

	public RefreshThread(Model model) {
		super();
		this.model = model;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}


	public void run() {
			while (true) {
				model.repaint();
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

}
