package progettoGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import progettoCore.GameDLV;
import utils.Coordinate;

public class PannelloDiGioco extends JPanel {
	private JFrame frame;
	public int territorioSelezionato = 0;

	public PannelloDiGioco(JFrame frame) {

		super();
		this.frame = frame;
		init();
		setBackground(Color.WHITE);
		setVisible(true);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("(" + e.getX() + ";" + e.getY() + ")");
				if (e.getX() >= 97 && e.getX() <= 143 && e.getY() >= 91 && e.getY() <= 109)
					selezioneTerritorio(1);
				else if (e.getX() >= 171 && e.getX() <= 213 && e.getY() >= 107 && e.getY() <= 146)
					selezioneTerritorio(2);
				else if (e.getX() >= 436 && e.getX() <= 510 && e.getY() >= 53 && e.getY() <= 75)
					selezioneTerritorio(3);
				else if (e.getX() >= 135 && e.getX() <= 183 && e.getY() >= 176 && e.getY() <= 193)
					selezioneTerritorio(4);
				else if (e.getX() >= 233 && e.getX() <= 282 && e.getY() >= 220 && e.getY() <= 238)
					selezioneTerritorio(5);
				else if (e.getX() >= 325 && e.getX() <= 368 && e.getY() >= 235 && e.getY() <= 247)
					selezioneTerritorio(6);
				else if (e.getX() >= 76 && e.getX() <= 146 && e.getY() >= 235 && e.getY() <= 262)
					selezioneTerritorio(7);
				else if (e.getX() >= 158 && e.getX() <= 213 && e.getY() >= 291 && e.getY() <= 311)
					selezioneTerritorio(8);
				else if (e.getX() >= 74 && e.getX() <= 124 && e.getY() >= 295 && e.getY() <= 319)
					selezioneTerritorio(9);
				else if (e.getX() >= 138 && e.getX() <= 201 && e.getY() >= 396 && e.getY() <= 414)
					selezioneTerritorio(10);
				else if (e.getX() >= 225 && e.getX() <= 279 && e.getY() >= 470 && e.getY() <= 490)
					selezioneTerritorio(11);
				else if (e.getX() >= 141 && e.getX() <= 178 && e.getY() >= 507 && e.getY() <= 524)
					selezioneTerritorio(12);
				else if (e.getX() >= 122 && e.getX() <= 183 && e.getY() >= 582 && e.getY() <= 605)
					selezioneTerritorio(13);
				else if (e.getX() >= 527 && e.getX() <= 577 && e.getY() >= 122 && e.getY() <= 144)
					selezioneTerritorio(14);
				else if (e.getX() >= 521 && e.getX() <= 541 && e.getY() >= 193 && e.getY() <= 264)
					selezioneTerritorio(15);
				else if (e.getX() >= 592 && e.getX() <= 636 && e.getY() >= 165 && e.getY() <= 198)
					selezioneTerritorio(16);
				else if (e.getX() >= 428 && e.getX() <= 495 && e.getY() >= 319 && e.getY() <= 342)
					selezioneTerritorio(17);
				else if (e.getX() >= 577 && e.getX() <= 659 && e.getY() >= 255 && e.getY() <= 277)
					selezioneTerritorio(18);
				else if (e.getX() >= 690 && e.getX() <= 742 && e.getY() >= 244 && e.getY() <= 264)
					selezioneTerritorio(19);
				else if (e.getX() >= 564 && e.getX() <= 641 && e.getY() >= 303 && e.getY() <= 328)
					selezioneTerritorio(20);
				else if (e.getX() >= 473 && e.getX() <= 537 && e.getY() >= 431 && e.getY() <= 458)
					selezioneTerritorio(21);
				else if (e.getX() >= 634 && e.getX() <= 686 && e.getY() >= 434 && e.getY() <= 451)
					selezioneTerritorio(22);
				else if (e.getX() >= 593 && e.getX() <= 633 && e.getY() >= 536 && e.getY() <= 553)
					selezioneTerritorio(23);
				else if (e.getX() >= 675 && e.getX() <= 735 && e.getY() >= 498 && e.getY() <= 525)
					selezioneTerritorio(24);
				else if (e.getX() >= 602 && e.getX() <= 687 && e.getY() >= 604 && e.getY() <= 622)
					selezioneTerritorio(25);
				else if (e.getX() >= 740 && e.getX() <= 754 && e.getY() >= 593 && e.getY() <= 650)
					selezioneTerritorio(26);
				else if (e.getX() >= 783 && e.getX() <= 819 && e.getY() >= 199 && e.getY() <= 213)
					selezioneTerritorio(27);
				else if (e.getX() >= 841 && e.getX() <= 885 && e.getY() >= 174 && e.getY() <= 190)
					selezioneTerritorio(28);
				else if (e.getX() >= 915 && e.getX() <= 963 && e.getY() >= 87 && e.getY() <= 107)
					selezioneTerritorio(29);
				else if (e.getX() >= 982 && e.getX() <= 1047 && e.getY() >= 84 && e.getY() <= 99)
					selezioneTerritorio(30);
				else if (e.getX() >= 932 && e.getX() <= 962 && e.getY() >= 170 && e.getY() <= 186)
					selezioneTerritorio(31);
				else if (e.getX() >= 1129 && e.getX() <= 1172 && e.getY() >= 135 && e.getY() <= 179)
					selezioneTerritorio(32);
				else if (e.getX() >= 799 && e.getX() <= 872 && e.getY() >= 273 && e.getY() <= 288)
					selezioneTerritorio(33);
				else if (e.getX() >= 975 && e.getX() <= 1030 && e.getY() >= 214 && e.getY() <= 230)
					selezioneTerritorio(34);
				else if (e.getX() >= 767 && e.getX() <= 820 && e.getY() >= 394 && e.getY() <= 425)
					selezioneTerritorio(35);
				else if (e.getX() >= 989 && e.getX() <= 1039 && e.getY() >= 284 && e.getY() <= 316)
					selezioneTerritorio(36);
				else if (e.getX() >= 916 && e.getX() <= 959 && e.getY() >= 389 && e.getY() <= 417)
					selezioneTerritorio(37);
				else if (e.getX() >= 1030 && e.getX() <= 1072 && e.getY() >= 365 && e.getY() <= 396)
					selezioneTerritorio(38);
				else if (e.getX() >= 1196 && e.getX() <= 1239 && e.getY() >= 494 && e.getY() <= 527)
					selezioneTerritorio(39);
				else if (e.getX() >= 1101 && e.getX() <= 1145 && e.getY() >= 436 && e.getY() <= 495)
					selezioneTerritorio(40);
				else if (e.getX() >= 1056 && e.getX() <= 1128 && e.getY() >= 587 && e.getY() <= 618)
					selezioneTerritorio(41);
				else if (e.getX() >= 1151 && e.getX() <= 1213 && e.getY() >= 621 && e.getY() <= 649)
					selezioneTerritorio(42);
				else
					selezioneTerritorio(0);

			}
		});
	}

	private void init() {
		GameDLV gameManager = new GameDLV();
	}

	private void selezioneTerritorio(int n) {
		territorioSelezionato = n;
	}

	private Coordinate getCoordinateCarro(int territorio) {
		switch (territorio) {
		case 1:
			return new Coordinate(118, 61);
		case 2:
			return new Coordinate(250, 102);
		case 3:
			return new Coordinate(366, 107);
		case 4:
			return new Coordinate(142, 192);
		case 5:
			return new Coordinate(238, 195);
		case 6:
			return new Coordinate(336, 249);
		case 7:
			return new Coordinate(92, 260);
		case 8:
			return new Coordinate(218, 282);
		case 9:
			return new Coordinate(88, 320);
		case 10:
			return new Coordinate(204, 397);
		case 11:
			return new Coordinate(254, 488);
		case 12:
			return new Coordinate(72, 489);
		case 13:
			return new Coordinate(140, 602);
		case 14:
			return new Coordinate(549, 103);
		case 15:
			return new Coordinate(472, 207);
		case 16:
			return new Coordinate(624, 181);
		case 17:
			return new Coordinate(485, 295);
		case 18:
			return new Coordinate(630, 239);
		case 19:
			return new Coordinate(713, 221);
		case 20:
			return new Coordinate(641, 314);
		case 21:
			return new Coordinate(483, 468);
		case 22:
			return new Coordinate(585, 427);
		case 23:
			return new Coordinate(607, 558);
		case 24:
			return new Coordinate(688, 528);
		case 25:
			return new Coordinate(637, 622);
		case 26:
			return new Coordinate(757, 613);
		case 27:
			return new Coordinate(806, 215);
		case 28:
			return new Coordinate(853, 150);
		case 29:
			return new Coordinate(928, 106);
		case 30:
			return new Coordinate(1010, 127);
		case 31:
			return new Coordinate(932, 188);
		case 32:
			return new Coordinate(1137, 183);
		case 33:
			return new Coordinate(827, 289);
		case 34:
			return new Coordinate(951, 233);
		case 35:
			return new Coordinate(954, 301);
		case 36:
			return new Coordinate(803, 375);
		case 37:
			return new Coordinate(922, 411);
		case 38:
			return new Coordinate(1053, 388);
		case 39:
			return new Coordinate(1120, 478);
		case 40:
			return new Coordinate(1225, 526);
		case 41:
			return new Coordinate(1069, 618);
		case 42:
			return new Coordinate(1171, 600);
		default:
			return new Coordinate(0, 0);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getMappa().getScaledInstance(FinestraRisiko.WIDTH, FinestraRisiko.HEIGHT,
				Image.SCALE_SMOOTH), 0, 0, null);
		g.setColor(Color.WHITE);
		g.drawString("TESSERINO-ESENTE: Carlo C.O. & Giacomo A.", 10, 20);
		g.setFont(new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 15));
		for (int i = 1; i <= 42; i++) {
			int x = getCoordinateCarro(i).getX();
			int y = getCoordinateCarro(i).getY();
			if (i < 10)
				g.drawImage(ImageProvider.getCarroBlu().getScaledInstance(50, 25, Image.SCALE_SMOOTH), x, y, null);
			else if (i >= 10 && i < 20)
				g.drawImage(ImageProvider.getCarroNero().getScaledInstance(50, 25, Image.SCALE_SMOOTH), x, y, null);
			else if (i >= 20 && i < 30)
				g.drawImage(ImageProvider.getCarroRosso().getScaledInstance(50, 25, Image.SCALE_SMOOTH), x, y, null);
			else
				g.drawImage(ImageProvider.getCarroVerde().getScaledInstance(50, 25, Image.SCALE_SMOOTH), x, y, null);
			g.drawString("46", x + 32, y + 20);
		}
	}
}
