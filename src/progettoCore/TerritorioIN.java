package progettoCore;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

//import it.unical.mat.embasp.languages.???

//Change @Predicate and @Term in @Id and @Param

@Id("TerritorioIN")
public class TerritorioIN {
	@Param(0)
	private String territorio;
	@Param(1)
	private int giocatore;
	@Param(2)
	private int pedine;

	public TerritorioIN(String n, int g, int p) {
		territorio = n;
		giocatore = g;
		pedine = p;
	}

	public String getNodo() {
		return territorio;
	}

	public void setNodo(String nodo) {
		this.territorio = nodo;
	}

	public int getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(int giocatore) {
		this.giocatore = giocatore;
	}

	public int getPedine() {
		return pedine;
	}

	public void setPedine(int pedine) {
		this.pedine = pedine;
	}

}
