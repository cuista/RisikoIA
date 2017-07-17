package progettoCore;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

public class Mappa
{
	private TerritorioIN[] territori;

	private boolean spostandoFase2 = false;

	public static int getNumTerritori()
	{
		return NUM_TERRITORI;
	}

	private PedineAssegnate[] pedine;
	private Adiacenti adiacenti;
	// Numero territori correnti per giocatore, si modificherà dopo
	// l'inizializzazione
	private int[] territoriTotali = new int[4];
	private int[] pedineTotali = new int[4];

	private int pedineMosseFase2;

	private static final int NUM_TERRITORI = 43;

	public Mappa()
	{
		territori = new TerritorioIN[NUM_TERRITORI];

		pedine = new PedineAssegnate[NUM_TERRITORI];
		for (int i = 0; i < pedine.length; i++)
		{
			pedine[i] = new PedineAssegnate(NomiTerritori.getNome(i), 0);
		}

		// inizializzazione territoriTotali
		assegnaTerritori();

		for (int i = 0; i < 4; i++)
		{
			pedineTotali[i] = 30;
		}

		adiacenti = new Adiacenti();

	}

	public void tokenPedineAssegnate(String stringDaParserizzare)
	{
		String[] pedineAssegnate = stringDaParserizzare.split("[).]");
		// facciamo +=2 perchè splitta l'insieme vuoto tra ) e .
		for (int i = 0; i < pedineAssegnate.length; i += 2)
		{
			String token = pedineAssegnate[i];
			String[] values = token.split("[(]")[1].split("[,]");
			pedine[Integer.parseInt(values[0])].setNumPedine(Integer.parseInt(values[1]));
		}
	}

	public void tokenPedineDaAggiungere(String stringDaParserizzare)
	{
		String[] pedineAssegnate = stringDaParserizzare.split("[).]");
		// facciamo +=2 perchè splitta l'insieme vuoto tra ) e .
		for (int i = 0; i < pedineAssegnate.length; i += 2)
		{
			String token = pedineAssegnate[i];
			String[] values = token.split("[(]")[1].split("[,]");

			pedine[Integer.parseInt(values[0])].aggiungiPedine(Integer.parseInt(values[1]));

		}
	}

	private void assegnaTerritori()
	{
		int countDieci = 2, countUndici = 2;
		for (int i = 0; i < 4; i++)
		{
			if (countDieci == 0)
			{
				territoriTotali[i] = 11;
				countUndici--;
			} else if (countUndici == 0)
			{
				territoriTotali[i] = 10;
				countDieci--;
			} else
			{
				territoriTotali[i] = (int) ((Math.random() * 2) + 10);
				if (territoriTotali[i] == 10)
				{
					countDieci--;
				} else
				{
					countUndici--;
				}
			}
		}
		//////////////////////////////////
		// serve per l assegnazione pedine
		/////////////////////////////////
		int[] copiarella = new int[4];
		for (int i = 0; i < 4; i++)
		{
			copiarella[i] = territoriTotali[i];
		}

		for (int i = 1; i < NUM_TERRITORI; i++)
		{
			int giocatoreTemporaneo = (int) ((Math.random() * 4));
			while (copiarella[giocatoreTemporaneo] == 0)
			{
				// System.out.println("giocTemp: " + giocatoreTemporaneo);
				giocatoreTemporaneo = ((int) (Math.random() * 4));
			}
			territori[i] = new TerritorioIN(NomiTerritori.getNome(i), giocatoreTemporaneo + 1, 1);
			copiarella[giocatoreTemporaneo]--;
		}
		/////////////////////////////////
	}

	public void print()
	{
		for (int i = 1; i < territori.length; i++)
		{
			TerritorioIN territorioIN = territori[i];
			// System.out.println(
			// territorioIN.getNodo() + "," + territorioIN.getGiocatore() + "
			// pedine:" + pedine[i].getNumPedine());
		}
	}

	public String getInputDlvTerritoriIn()
	{
		String input = new String();
		for (int i = 1; i < territori.length; i++)
		{
			input += "territorioIN(" + (i) + "," + territori[i].getGiocatore() + ").";
		}
		return input;
	}

	public String getInputDlvPedineAssegnate()
	{
		String input = new String();
		for (int i = 1; i < pedine.length; i++)
		{
			input += "pedineAssegnate(" + NomiTerritori.getNum(pedine[i].getTerritorio()) + ","
					+ pedine[i].getNumPedine() + ").";
		}
		return input;
	}

	public boolean eseguiAttacco(int territorioAttaccante, int territorioDifensore)
	{
		int dadoAttaccante = (int) (Math.random() * 6) + 1;
		int dadoDifensore = (int) (Math.random() * 6) + 1;

		System.out.println("Dado Attaccante = " + dadoAttaccante + "        dado Difensore = " + dadoDifensore);

		System.out.println("pedine territorio attaccante preattacco: " + pedine[territorioAttaccante].getNumPedine());
		if (dadoAttaccante > dadoDifensore)
		{
			pedineTotali[getGiocatore(territorioDifensore) - 1]--;

			if (pedine[territorioDifensore].getNumPedine() == 1)
			{
				// cambio territoriTotali
				territoriTotali[getGiocatore(territorioDifensore) - 1]--;
				territoriTotali[getGiocatore(territorioAttaccante) - 1]++;

				// cambio territorioIn
				territori[territorioDifensore].setGiocatore(territori[territorioAttaccante].getGiocatore());

				// mette la pedina obbligatoria nel territorio conquistato
				pedine[territorioAttaccante].eliminaPedine(1);

				int pedineDaMuovereInPiu = fase2Spostamento(territorioAttaccante, territorioDifensore);

				spostandoFase2 = true;
				pedineMosseFase2 = pedineDaMuovereInPiu;

				// elimino una pedina dal territorio attaccante
				pedine[territorioAttaccante].eliminaPedine(pedineDaMuovereInPiu);
				pedine[territorioDifensore].aggiungiPedine(pedineDaMuovereInPiu);

				// ferma l'attacco e passa alla fase3
				return true;
			} else
			{
				// elimino una pedina dal territorio difensore
				pedine[territorioDifensore].eliminaPedine(1);

			}
		} // FINE VINCE ATTACCO
		else
		{
			pedineTotali[getGiocatore(territorioAttaccante) - 1]--;
			// elimino una pedina dal territorio attaccante
			pedine[territorioAttaccante].eliminaPedine(1);
			System.out.println(
					"pedine territorio attaccante post attacco: " + pedine[territorioAttaccante].getNumPedine());
		}
		return false;

	}

	private int fase2Spostamento(int territorioAttaccante, int territorioDifensore)
	{

		String inputFase2Spostamento = getInputDlvTerritoriIn() + getInputDlvPedineAssegnate() + "giocatoreCorrent("
				+ getGiocatore(territorioAttaccante) + ").territorioAttaccante(" + territorioAttaccante
				+ ").territorioDifensore(" + territorioDifensore + ").";

		System.out.println("inputfase2Spostament: " + inputFase2Spostamento);

		// sposto N pedine dal territorio attaccante
		Handler handler = GameDLV.handler;
		handler.addOption(new OptionDescriptor("-filter=pedineDaSpostare "));
		handler.addOption(new OptionDescriptor("-n=1 "));

		InputProgram inputProgram = new ASPInputProgram(inputFase2Spostamento);
		inputProgram.addFilesPath("source/adiacenze.txt");
		inputProgram.addFilesPath("source/faseDueSpostamento.txt");

		handler.addProgram(inputProgram);

		// avvia dlv.mingw.exe e il risultato lo mette in output
		Output output = handler.startSync();
		AnswerSets answerSets = (AnswerSets) output;

		int pedineDaSpostare = 0;
		// non abbiamo pedine da poter spostare
		// ho conquistato con un territorio da 2 pedine
		if (answerSets.getAnswersets().size() != 0)
		{
			AnswerSet answersetFase2Spostamento = answerSets.getAnswersets().get(0);

			String outputFase2Spostamento = answersetFase2Spostamento.getAnswerSet().get(0);
			// parserizzazione outputFase2
			String[] values = outputFase2Spostamento.split("[(]")[1].split("[)]");
			pedineDaSpostare = Integer.parseInt(values[0]);
		}

		// pulisci handler
		handler.removeProgram(inputProgram);
		handler.removeOption(0);
		handler.removeOption(1);

		return pedineDaSpostare;
	}

	public int getGiocatore(int numeroTerr)
	{
		return territori[numeroTerr].getGiocatore();
	}

	public int getPedine(int numeroTerr)
	{
		return pedine[numeroTerr].getNumPedine();
	}

	public TerritorioIN[] getTerritori()
	{
		return territori;
	}

	public PedineAssegnate[] getPedine()
	{
		return pedine;
	}

	public Adiacenti getAdiacenti()
	{
		return adiacenti;
	}

	public int[] getTerritoriTotali()
	{
		return territoriTotali;
	}

	public int[] getPedineTotali()
	{
		return pedineTotali;
	}

	public void setSpostandoFase2(boolean spostandoFase2)
	{
		this.spostandoFase2 = spostandoFase2;
	}

	public boolean isSpostandoFase2()
	{
		return spostandoFase2;
	}

	public int getPedineMosseFase2()
	{
		return pedineMosseFase2;
	}

}
