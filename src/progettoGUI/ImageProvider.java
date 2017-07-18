package progettoGUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProvider {

	private static Image mappa;

	private static Image carroRosso;
	private static Image carroNero;
	private static Image carroBlu;
	private static Image carroVerde;
	private static Image pallaRossa;
	private static Image pallaRossaExit;
	private static Image pallaRossaStart;
	private static Image putinButton;
	private static Image trumpButton;
	private static Image trumpButtonGame;
	private static Image trumpSimulatorMenu;
	private static Image putinDance;
	private static Image kimDance;
	private static Image razziDance;

	private static Image trumpWantsEverything;

	public ImageProvider() {
	}

	static {
		try { // mappa
			mappa = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/risikoVuota.jpg"));
			// tank
			carroRosso = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/redTank.png"));
			carroNero = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/blackTank.png"));
			carroBlu = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/blueTank.png"));
			carroVerde = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/greenTank.png"));

			// bottoni
			pallaRossa = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/PallaRossa.png"));
			pallaRossaExit = ImageIO
					.read(Thread.currentThread().getContextClassLoader().getResource("img/PallaRossaExit.png"));
			pallaRossaStart = ImageIO
					.read(Thread.currentThread().getContextClassLoader().getResource("img/PallaRossaStart.png"));
			putinButton = Toolkit.getDefaultToolkit()
					.getImage(Thread.currentThread().getContextClassLoader().getResource("img/PutinButton2.gif"));
			trumpButton = Toolkit.getDefaultToolkit()
					.getImage(Thread.currentThread().getContextClassLoader().getResource("img/TrumpButton.gif"));
			trumpButtonGame = Toolkit.getDefaultToolkit()
					.getImage(Thread.currentThread().getContextClassLoader().getResource("img/TrumpButtonGame.gif"));
			trumpSimulatorMenu = ImageIO
					.read(Thread.currentThread().getContextClassLoader().getResource("img/TrumpSimulator2.png"));
			trumpWantsEverything = Toolkit.getDefaultToolkit().getImage(
					Thread.currentThread().getContextClassLoader().getResource("img/TrumpWantsEverything.gif"));
			putinDance = Toolkit.getDefaultToolkit()
					.getImage(Thread.currentThread().getContextClassLoader().getResource("img/PutinDance.gif"));
			kimDance = Toolkit.getDefaultToolkit()
					.getImage(Thread.currentThread().getContextClassLoader().getResource("img/kimDance.gif"));
			razziDance = Toolkit.getDefaultToolkit()
					.getImage(Thread.currentThread().getContextClassLoader().getResource("img/trumpface.png"));

		} catch (IOException e) {
			System.err.println("ERRORE CARICAMENTO ImageProvider");
		}
	}

	public static Image getPutinDance() {
		return putinDance;
	}

	public static Image getKimDance() {
		return kimDance;
	}

	public static Image getRazziDance() {
		return razziDance;
	}

	public static Image getPallaRossa() {
		return pallaRossa;
	}

	public static Image getTrumpSimulatorMenu() {
		return trumpSimulatorMenu;
	}

	public static Image getTrumpWantsEverything() {
		return trumpWantsEverything;
	}

	public static Image getPallaRossaExit() {
		return pallaRossaExit;
	}

	public static Image getPallaRossaStart() {
		return pallaRossaStart;
	}

	public static Image getPutinButton() {
		return putinButton;
	}

	public static Image getTrumpButton() {
		return trumpButton;
	}

	public static Image getTrumpButtonGame() {
		return trumpButtonGame;
	}

	public static Image getMappa() {
		return mappa;
	}

	public static Image getCarroRosso() {
		return carroRosso;
	}

	public static Image getCarroNero() {
		return carroNero;
	}

	public static Image getCarroBlu() {
		return carroBlu;
	}

	public static Image getCarroVerde() {
		return carroVerde;
	}
}
