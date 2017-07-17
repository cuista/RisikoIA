package progettoCore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Adiacenti {
	public static ArrayList<LinkedList<Integer>> adiacenze = new ArrayList<>();

	static {

		for (int i = 0; i < 43; i++) {
			adiacenze.add(new LinkedList<>());
		}
		inserisciAdiacenti(1, 2);
		inserisciAdiacenti(1, 4);
		inserisciAdiacenti(1, 30);
		inserisciAdiacenti(2, 1);
		inserisciAdiacenti(2, 3);
		inserisciAdiacenti(2, 4);
		inserisciAdiacenti(2, 5);
		inserisciAdiacenti(3, 2);
		inserisciAdiacenti(3, 5);
		inserisciAdiacenti(3, 6);
		inserisciAdiacenti(3, 14);
		inserisciAdiacenti(4, 1);
		inserisciAdiacenti(4, 2);
		inserisciAdiacenti(4, 5);
		inserisciAdiacenti(4, 7);
		inserisciAdiacenti(5, 3);
		inserisciAdiacenti(5, 2);
		inserisciAdiacenti(5, 6);
		inserisciAdiacenti(5, 7);
		inserisciAdiacenti(5, 8);
		inserisciAdiacenti(6, 3);
		inserisciAdiacenti(6, 5);
		inserisciAdiacenti(6, 8);
		inserisciAdiacenti(7, 4);
		inserisciAdiacenti(7, 5);
		inserisciAdiacenti(7, 8);
		inserisciAdiacenti(7, 9);
		inserisciAdiacenti(8, 7);
		inserisciAdiacenti(8, 5);
		inserisciAdiacenti(8, 6);
		inserisciAdiacenti(8, 9);
		inserisciAdiacenti(9, 7);
		inserisciAdiacenti(9, 8);
		inserisciAdiacenti(9, 10);
		inserisciAdiacenti(10, 9);
		inserisciAdiacenti(10, 11);
		inserisciAdiacenti(10, 12);
		inserisciAdiacenti(11, 10);
		inserisciAdiacenti(11, 12);
		inserisciAdiacenti(11, 13);
		inserisciAdiacenti(11, 21);
		inserisciAdiacenti(12, 10);
		inserisciAdiacenti(12, 11);
		inserisciAdiacenti(12, 13);
		inserisciAdiacenti(13, 11);
		inserisciAdiacenti(13, 12);
		inserisciAdiacenti(14, 3);
		inserisciAdiacenti(14, 15);
		inserisciAdiacenti(14, 16);
		inserisciAdiacenti(15, 14);
		inserisciAdiacenti(15, 16);
		inserisciAdiacenti(15, 17);
		inserisciAdiacenti(15, 18);
		inserisciAdiacenti(16, 14);
		inserisciAdiacenti(16, 15);
		inserisciAdiacenti(16, 18);
		inserisciAdiacenti(16, 19);
		inserisciAdiacenti(17, 15);
		inserisciAdiacenti(17, 18);
		inserisciAdiacenti(17, 20);
		inserisciAdiacenti(17, 21);
		inserisciAdiacenti(18, 15);
		inserisciAdiacenti(18, 16);
		inserisciAdiacenti(18, 17);
		inserisciAdiacenti(18, 19);
		inserisciAdiacenti(18, 20);
		inserisciAdiacenti(19, 16);
		inserisciAdiacenti(19, 18);
		inserisciAdiacenti(19, 20);
		inserisciAdiacenti(19, 27);
		inserisciAdiacenti(19, 33);
		inserisciAdiacenti(19, 36);
		inserisciAdiacenti(20, 17);
		inserisciAdiacenti(20, 18);
		inserisciAdiacenti(20, 19);
		inserisciAdiacenti(20, 36);
		inserisciAdiacenti(20, 21);
		inserisciAdiacenti(20, 22);
		inserisciAdiacenti(21, 11);
		inserisciAdiacenti(21, 17);
		inserisciAdiacenti(21, 20);
		inserisciAdiacenti(21, 22);
		inserisciAdiacenti(21, 23);
		inserisciAdiacenti(21, 24);
		inserisciAdiacenti(22, 20);
		inserisciAdiacenti(22, 21);
		inserisciAdiacenti(22, 24);
		inserisciAdiacenti(22, 36);
		inserisciAdiacenti(23, 21);
		inserisciAdiacenti(23, 24);
		inserisciAdiacenti(23, 25);
		inserisciAdiacenti(24, 21);
		inserisciAdiacenti(24, 22);
		inserisciAdiacenti(24, 23);
		inserisciAdiacenti(24, 25);
		inserisciAdiacenti(24, 26);
		inserisciAdiacenti(25, 23);
		inserisciAdiacenti(25, 24);
		inserisciAdiacenti(25, 26);
		inserisciAdiacenti(26, 24);
		inserisciAdiacenti(26, 25);
		inserisciAdiacenti(27, 19);
		inserisciAdiacenti(27, 28);
		inserisciAdiacenti(27, 33);
		inserisciAdiacenti(27, 35);
		inserisciAdiacenti(28, 29);
		inserisciAdiacenti(28, 27);
		inserisciAdiacenti(28, 31);
		inserisciAdiacenti(28, 34);
		inserisciAdiacenti(28, 35);
		inserisciAdiacenti(29, 28);
		inserisciAdiacenti(29, 30);
		inserisciAdiacenti(29, 31);
		inserisciAdiacenti(30, 1);
		inserisciAdiacenti(30, 29);
		inserisciAdiacenti(30, 31);
		inserisciAdiacenti(30, 34);
		inserisciAdiacenti(30, 32);
		inserisciAdiacenti(31, 28);
		inserisciAdiacenti(31, 29);
		inserisciAdiacenti(31, 30);
		inserisciAdiacenti(31, 34);
		inserisciAdiacenti(32, 30);
		inserisciAdiacenti(32, 34);
		inserisciAdiacenti(33, 19);
		inserisciAdiacenti(33, 27);
		inserisciAdiacenti(33, 35);
		inserisciAdiacenti(33, 36);
		inserisciAdiacenti(34, 28);
		inserisciAdiacenti(34, 31);
		inserisciAdiacenti(34, 30);
		inserisciAdiacenti(34, 32);
		inserisciAdiacenti(34, 35);
		inserisciAdiacenti(35, 33);
		inserisciAdiacenti(35, 27);
		inserisciAdiacenti(35, 28);
		inserisciAdiacenti(35, 34);
		inserisciAdiacenti(35, 38);
		inserisciAdiacenti(35, 37);
		inserisciAdiacenti(35, 36);
		inserisciAdiacenti(36, 20);
		inserisciAdiacenti(36, 33);
		inserisciAdiacenti(36, 19);
		inserisciAdiacenti(36, 33);
		inserisciAdiacenti(36, 35);
		inserisciAdiacenti(36, 37);
		inserisciAdiacenti(36, 22);
		inserisciAdiacenti(37, 36);
		inserisciAdiacenti(37, 35);
		inserisciAdiacenti(37, 38);
		inserisciAdiacenti(38, 37);
		inserisciAdiacenti(38, 35);
		inserisciAdiacenti(38, 39);
		inserisciAdiacenti(39, 38);
		inserisciAdiacenti(39, 40);
		inserisciAdiacenti(39, 41);
		inserisciAdiacenti(40, 39);
		inserisciAdiacenti(40, 41);
		inserisciAdiacenti(40, 42);
		inserisciAdiacenti(41, 40);
		inserisciAdiacenti(41, 39);
		inserisciAdiacenti(41, 42);
		inserisciAdiacenti(42, 41);
		inserisciAdiacenti(42, 40);
	}

	static void inserisciAdiacenti(int i, int j) {
		adiacenze.get(i).add(j);
	}

	public static LinkedList<Integer> getAdiacenze(int t1) {
		return adiacenze.get(t1);
	}

	public static boolean sonoAdiacenti(int t1, int t2) {

		LinkedList<Integer> adiacentiTerritorioT1 = adiacenze.get(t1);

		for (Iterator iterator = adiacentiTerritorioT1.iterator(); iterator.hasNext();) {
			Integer territorioT1 = (Integer) iterator.next();
			if (territorioT1 == t2) {
				return true;
			}
		}

		LinkedList<Integer> adiacentiTerritorioT2 = adiacenze.get(t2);

		for (Iterator iterator = adiacentiTerritorioT2.iterator(); iterator.hasNext();) {
			Integer territorioT2 = (Integer) iterator.next();
			if (territorioT2 == t1) {
				return true;
			}
		}

		return false;

	}

}
