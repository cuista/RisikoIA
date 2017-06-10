package progettoGUI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProvider {

	private static Image mappa;

	private static Image carroRosso;
	private static Image carroNero;
	private static Image carroBlu;
	private static Image carroVerde;

	public ImageProvider() {
	}

	static {
		try {
			mappa = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/risikoVuota.jpg"));

			carroRosso = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/redTank.png"));
			carroNero = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/blackTank.png"));
			carroBlu = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/blueTank.png"));
			carroVerde = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/greenTank.png"));
		} catch (IOException e) {
			System.err.println("ERRORE CARICAMENTO ImageProvider");
		}
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
