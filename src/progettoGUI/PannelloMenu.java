package progettoGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PannelloMenu extends JPanel {

	private FinestraRisiko switcher;

	boolean startButton = false;
	boolean exitButton = false;

	public PannelloMenu(FinestraRisiko switcher) {
		super();
		this.switcher = switcher;
		this.setVisible(true);
		this.setSize(FinestraRisiko.WIDTH, FinestraRisiko.HEIGHT);
		setBackground(Color.CYAN);

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX() + "," + e.getY());
				if (e.getX() >= 1070 && e.getX() <= 1270 && e.getY() >= 270 && e.getY() <= 470) {
					System.out.println("sono nello start ");
					switcher.showGame();
				}
				if (e.getX() >= 1070 && e.getX() <= 1270 && e.getY() >= 490 && e.getY() <= 690) {
					System.out.println("sono nella exit ");
					switcher.exit();
				}

			}
		});
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

				if (e.getX() >= 1070 && e.getX() <= 1270 && e.getY() >= 270 && e.getY() <= 470) {
					startButton = true;
					exitButton = false;
				} else if (e.getX() >= 1070 && e.getX() <= 1270 && e.getY() >= 490 && e.getY() <= 690) {
					exitButton = true;
					startButton = false;
				} else {
					startButton = false;
					exitButton = false;
				}
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getTrumpSimulatorMenu().getScaledInstance(FinestraRisiko.WIDTH, FinestraRisiko.HEIGHT,
				Image.SCALE_SMOOTH), 0, 0, null);
		g.drawImage(ImageProvider.getTrumpWantsEverything(), 190, FinestraRisiko.HEIGHT - 300, null);
		g.drawImage(ImageProvider.getKimDance(), 400, FinestraRisiko.HEIGHT - 500, null);
		g.drawImage(ImageProvider.getPutinDance(), 250, FinestraRisiko.HEIGHT - 600, null);
		if (!startButton) {
			g.drawImage(ImageProvider.getPallaRossaStart().getScaledInstance(200, 200, Image.SCALE_SMOOTH),
					FinestraRisiko.WIDTH - 210, FinestraRisiko.HEIGHT - 450, null);
		} else {
			g.drawImage(ImageProvider.getPallaRossa().getScaledInstance(200, 200, Image.SCALE_SMOOTH),
					FinestraRisiko.WIDTH - 210, FinestraRisiko.HEIGHT - 450, null);
			g.drawImage(ImageProvider.getTrumpButton(), FinestraRisiko.WIDTH - 210, FinestraRisiko.HEIGHT - 450, null);
		}
		if (!exitButton) {
			g.drawImage(ImageProvider.getPallaRossaExit().getScaledInstance(200, 200, Image.SCALE_SMOOTH),
					FinestraRisiko.WIDTH - 210, FinestraRisiko.HEIGHT - 230, null);
		} else {
			g.drawImage(ImageProvider.getPallaRossa().getScaledInstance(200, 200, Image.SCALE_SMOOTH),
					FinestraRisiko.WIDTH - 210, FinestraRisiko.HEIGHT - 230, null);
			g.drawImage(ImageProvider.getPutinButton(), FinestraRisiko.WIDTH - 190, FinestraRisiko.HEIGHT - 210, null);
		}
		repaint();
	}

}
