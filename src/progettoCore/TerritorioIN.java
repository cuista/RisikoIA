package progettoCore;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

//import it.unical.mat.embasp.languages.???

//Change @Predicate and @Term in @Id and @Param

@Id("TerritorioIN")
public class TerritorioIN
{
	@Param(0)
	private String territorio;
	@Param(1)
	private int giocatore;

	public TerritorioIN(String n, int g, int p)
	{
		territorio = n;
		giocatore = g;
	}

	public String getNodo()
	{
		return territorio;
	}

	public void setNodo(String nodo)
	{
		this.territorio = nodo;
	}

	public int getGiocatore()
	{
		return giocatore;
	}

	public void setGiocatore(int giocatore)
	{
		System.out.println(
				"STO CAMBIANDO IL GIOCATORE DEL TERRITORIO " + this.territorio + " con il giocatore " + giocatore);
		this.giocatore = giocatore;
	}

}
