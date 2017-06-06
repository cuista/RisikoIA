package progettoGUI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProvider {

	private static Image mappa;

	public ImageProvider() {
	}

	static {
		try {
			mappa = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("img/risiko.jpg"));
		} catch (IOException e) {
			System.err.println("ERRORE CARICAMENTO ImageProvider");
		}
	}

	static Image getMappa() {
		return mappa;
	}
}
