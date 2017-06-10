package progettoGUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FinestraRisiko extends JFrame {

	static int WIDTH = 1280;
	static int HEIGHT = 720;

	final PannelloDiGioco gamePanel = new PannelloDiGioco();

	public FinestraRisiko() {

		getContentPane().add(gamePanel);
		setVisible(true);
		setTitle("RisikoIA");
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void showGame() {
		gamePanel.startGame();
	}

	public static void main(String[] args) {
		final FinestraRisiko mf = new FinestraRisiko();
		mf.showGame();
	}
}