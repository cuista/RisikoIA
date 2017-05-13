package progettoCore;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

//import it.unical.mat.embasp.languages.???

//Change @Predicate and @Term in @Id and @Param

@Id("TerritorioIN")
public class TerritorioIN {
	@Param(0)
	private String nodo;
	@Param(1)
	private String giocatore;
	@Param(2)
	private int pedine;

	public TerritorioIN(String n, String g, int p) {
		nodo = n;
		giocatore = g;
		pedine = p;
	}

	public String getNodo() {
		return nodo;
	}

	public void setNodo(String nodo) {
		this.nodo = nodo;
	}

	public String getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(String giocatore) {
		this.giocatore = giocatore;
	}

	public int getPedine() {
		return pedine;
	}

	public void setPedine(int pedine) {
		this.pedine = pedine;
	}

}
