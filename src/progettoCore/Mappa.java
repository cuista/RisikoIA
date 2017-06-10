package progettoCore;

public class Mappa {
	private TerritorioIN[] territori;
	private PedineAssegnate[] pedine;
	private static final int NUM_TERRITORI = 43;

	public Mappa() {
		territori = new TerritorioIN[NUM_TERRITORI];
		pedine = new PedineAssegnate[NUM_TERRITORI];
		for (int i = 0; i < NUM_TERRITORI; i++) {
			territori[i] = new TerritorioIN(NomiTerritori.getNome(i), 0, 0);
			pedine[i] = new PedineAssegnate(NomiTerritori.getNome(i), 0);
		}
	}

	public void tokenTerritoriIn(String stringDaParserizzare) {
		// splitta anche l'insieme vuoto tra ')' e '.' =>per questo i+=2
		String[] territoriIN = stringDaParserizzare.split("[).]");
		for (int i = 0; i < territoriIN.length; i += 2) {
			String token = territoriIN[i];
			String[] values = token.split("[(]")[1].split("[,]");
			territori[Integer.parseInt(values[0])].setGiocatore(Integer.parseInt(values[1]));
		}
	}

	public void tokenPedineAssegnate(String stringDaParserizzare) {
		// splitta anche l'insieme vuoto tra ')' e '.' =>per questo i+=2
		String[] pedineAssegnate = stringDaParserizzare.split("[).]");
		for (int i = 0; i < pedineAssegnate.length; i += 2) {
			String token = pedineAssegnate[i];
			String[] values = token.split("[(]")[1].split("[,]");
			pedine[Integer.parseInt(values[0])].setNumPedine(Integer.parseInt(values[1]));
		}
	}

	public void tokenPedine(String stringDaParserizzare) {

	}

	public void print() {
		for (int i = 1; i < territori.length; i++) {
			TerritorioIN territorioIN = territori[i];
			System.out.println(
					territorioIN.getNodo() + "," + territorioIN.getGiocatore() + " pedine:" + pedine[i].getNumPedine());
		}
	}

	public int getGiocatore(int numeroTerr) {
		return territori[numeroTerr].getGiocatore();
	}

	public int getPedine(int numeroTerr) {
		return pedine[numeroTerr].getNumPedine();
	}

}
