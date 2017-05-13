package progettoGUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {

		final MyPanel p = new MyPanel(this);
		getContentPane().add(p);
		setVisible(true);
		setMinimumSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		final MyFrame mf = new MyFrame();

	}
}