package progettoGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import progettoCore.GameDLV;

public class PannelloDiGioco extends JPanel {
	private JFrame frame;

	public PannelloDiGioco(JFrame frame) {

		super();
		this.frame = frame;
		init();
		setBackground(Color.WHITE);
		setVisible(true);
	}

	private void init() {
		GameDLV gameManager = new GameDLV();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawImage(ImageProvider.getMappa().getScaledInstance(FinestraRisiko.WIDTH, FinestraRisiko.HEIGHT,
				Image.SCALE_SMOOTH), 0, 0, null);
	}
}
