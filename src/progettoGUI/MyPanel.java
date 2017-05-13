package progettoGUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private JFrame frame;

	public MyPanel(JFrame frame) {

		super();
		this.frame = frame;
		init();
		setBackground(Color.WHITE);
		setVisible(true);
	}

	private void init() {

	}
}
