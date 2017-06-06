package progettoCore;

import it.unical.mat.embasp.languages.Param;

public class PedineAssegnate {
	@Param(0)
	private String territorio;
	@Param(1)
	private int numPedine;

	public PedineAssegnate(String t, int p) {
		territorio = t;
		numPedine = p;
	}

	public String getTerritorio() {
		return territorio;
	}

	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}

	public int getNumPedine() {
		return numPedine;
	}

	public void setNumPedine(int numPedine) {
		this.numPedine = numPedine;
	}

}
