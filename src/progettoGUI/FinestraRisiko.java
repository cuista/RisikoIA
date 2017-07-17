package progettoGUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FinestraRisiko extends JFrame
{

	static int WIDTH = 1280;
	static int HEIGHT = 720;

	final PannelloMenu menuPanel = new PannelloMenu(this);

	PannelloDiGioco gamePanel;

	public FinestraRisiko()
	{

		showMenu();
		setVisible(true);
		setTitle("Trump Simulator");
		setMinimumSize(new Dimension(WIDTH + 15, HEIGHT + 20));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void showGame()
	{
		gamePanel = new PannelloDiGioco(this);

		getContentPane().removeAll();
		getContentPane().add(gamePanel);
		gamePanel.startGame();
	}

	public void showMenu()
	{
		getContentPane().removeAll();
		getContentPane().add(menuPanel);
	}

	public static void main(String[] args)
	{
		final FinestraRisiko mf = new FinestraRisiko();
	}

	public void close()
	{
		System.exit(0);

	}
}