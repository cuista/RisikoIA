package progettoGUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FinestraRisiko extends JFrame {

	static int WIDTH = 800;
	static int HEIGHT = 600;

	public FinestraRisiko() {

		final PannelloDiGioco p = new PannelloDiGioco(this);
		getContentPane().add(p);
		setVisible(true);
		setTitle("RisikoIA");
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		final FinestraRisiko mf = new FinestraRisiko();

	}
}