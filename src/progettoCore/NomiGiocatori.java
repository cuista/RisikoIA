package progettoCore;

public enum NomiGiocatori {
	NON_VALIDO, GIOCATORE1, GIOCATORE2, GIOCATORE3, GIOCATORE4;
	public static String getNome(int i) {
		return NomiGiocatori.values()[i].toString();
	}
}