package progettoCore;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv.desktop.DLVDesktopService;

public class GameDLV {

	// inizializzazione handler windows
	// public static Handler handler = new DesktopHandler(new
	// DLVDesktopService("source/dlv.mingw.exe"));

	// inizializzazione handler linux
	public static Handler handler = new DesktopHandler(new DLVDesktopService("source/dlv.x86-64-linux-elf-static.bin"));

	private boolean gameOver;

	private boolean terminaTurno;

	public Mappa mappa;

	private boolean provandoAttacco = false;

	private boolean spostandoFase3 = false;

	private int territorioAttaccante = 0;

	private int territorioDifensore = 0;

	public GameDLV() {
		mappa = new Mappa();
		gameOver = false;
		// handler = new DesktopHandler(new
		// DLVDesktopService("source/dlv.mingw.exe"));
	}

	public static void main(String[] args) {
		GameDLV dlv = new GameDLV();
	}

	public void faseTre(int giocatore) {
		handler.addOption(new OptionDescriptor("-filter=sposta "));
		handler.addOption(new OptionDescriptor("-n=1 "));

		String inputFase3 = mappa.getInputDlvTerritoriIn() + mappa.getInputDlvPedineAssegnate() + "giocatoreCorrente("
				+ (giocatore + 1) + ").";

		InputProgram inputProgram = new ASPInputProgram(inputFase3);

		inputProgram.addFilesPath("source/adiacenze.txt");
		inputProgram.addFilesPath("source/faseTre.txt");

		handler.addProgram(inputProgram);

		// avvia dlv.mingw.exe e il risultato lo mette in output
		Output output = handler.startSync();
		AnswerSets answerSets = (AnswerSets) output;

		// se non ci sono territori adiacenti non pu� far spostamenti
		if (!(answerSets.getAnswersets().size() == 0)) {
			AnswerSet answersetFase3 = answerSets.getAnswersets().get(0);
			String outputFase3 = answersetFase3.getAnswerSet().get(0);
			String[] values = outputFase3.split("[(]")[1].split("[,)]");

			mappa.getPedine()[Integer.parseInt(values[0])].eliminaPedine(Integer.parseInt(values[2]));
			mappa.getPedine()[Integer.parseInt(values[1])].aggiungiPedine(Integer.parseInt(values[2]));
		}

		// pulisco l'handler
		handler.removeProgram(inputProgram);
		handler.removeOption(0);
		handler.removeOption(1);
	}

	public void faseDue(int giocatore) {
		handler.addOption(new OptionDescriptor("-filter=attacca "));
		handler.addOption(new OptionDescriptor("-n=1 "));

		String inputFase2 = mappa.getInputDlvTerritoriIn() + mappa.getInputDlvPedineAssegnate() + "giocatoreCorrente("
				+ (giocatore + 1) + ").";

		System.out.println("inputFase2: " + inputFase2);

		InputProgram inputProgram = new ASPInputProgram(inputFase2);

		inputProgram.addFilesPath("source/adiacenze.txt");
		inputProgram.addFilesPath("source/faseDue.txt");

		handler.addProgram(inputProgram);

		// avvia dlv.mingw.exe e il risultato lo mette in output
		Output output = handler.startSync();
		AnswerSets answerSets = (AnswerSets) output;
		// mettere un numero random al posto dello 0
		if (answerSets.getAnswersets().size() == 0) {
			terminaTurno = true;
			// pulisco l'handler
			handler.removeProgram(inputProgram);
			handler.removeOption(0);
			handler.removeOption(1);
		} else {
			AnswerSet answersetFase2 = answerSets.getAnswersets().get(0);

			String outputFase2 = answersetFase2.getAnswerSet().get(0);

			// parserizzazione outputFase2
			String[] values = outputFase2.split("[(]")[1].split("[,)]");
			territorioAttaccante = Integer.parseInt(values[0]);
			territorioDifensore = Integer.parseInt(values[1]);

			setProvandoAttacco(true);

			// pulisco l'handler
			handler.removeProgram(inputProgram);
			handler.removeOption(0);
			handler.removeOption(1);

			terminaTurno = mappa.eseguiAttacco(territorioAttaccante, territorioDifensore);
			if (mappa.getTerritoriTotali()[giocatore] == 24) {
				gameOver = true;
			}
		}

	}

	public void faseUno(int giocatore) {
		handler.addOption(new OptionDescriptor("-filter=nuovePedineTerritorio "));
		handler.addOption(new OptionDescriptor("-n=1 "));

		int pedineDaAggiungere = (mappa.getTerritoriTotali()[giocatore] / 3) == 0 ? 1
				: (mappa.getTerritoriTotali()[giocatore] / 3);

		String inputFase1 = mappa.getInputDlvTerritoriIn() + mappa.getInputDlvPedineAssegnate();
		inputFase1 += "pedineTotGiocatore(" + mappa.getPedineTotali()[giocatore] + ").pedineDaAggiungere("
				+ pedineDaAggiungere + ").giocatoreCorrente(" + (giocatore + 1) + ").";

		InputProgram inputProgram = new ASPInputProgram(inputFase1);
		inputProgram.addFilesPath("source/adiacenze.txt");
		inputProgram.addFilesPath("source/faseUno.txt");

		handler.addProgram(inputProgram);

		// avvia dlv.mingw.exe e il risultato lo mette in output
		Output output = handler.startSync();
		AnswerSets answerSets = (AnswerSets) output;

		// ?
		System.out.println("answersetFase1 size ----> " + answerSets.getAnswersets().size());
		System.out.println("answersetFase1: " + answerSets.getAnswersets().get(0));
		AnswerSet answersetFase1 = answerSets.getAnswersets().get(0);

		// fine fase e update delle strutture dati
		mappa.getPedineTotali()[giocatore] += pedineDaAggiungere;

		String outputFase1 = new String();
		for (int i = 0; i < answersetFase1.getAnswerSet().size(); i++) {
			outputFase1 += answersetFase1.getAnswerSet().get(i) + ".";
		}

		mappa.tokenPedineDaAggiungere(outputFase1);

		// pulisco l'handler
		handler.removeProgram(inputProgram);
		handler.removeOption(0);
		handler.removeOption(1);

	}

	public void assegnazionePedine() {

		handler.addOption(new OptionDescriptor("-filter=pedineAssegnate "));
		handler.addOption(new OptionDescriptor("-n=1 "));

		String territoriTokenizzati = mappa.getInputDlvTerritoriIn();

		InputProgram inputAssegnPedine = new ASPInputProgram(territoriTokenizzati);
		inputAssegnPedine.addFilesPath("source/adiacenze.txt");
		inputAssegnPedine.addFilesPath("source/assegnazionePedine.txt");
		handler.addProgram(inputAssegnPedine);

		// avvia dlv.mingw.exe e il risultato lo mette in output
		Output output = handler.startSync();
		AnswerSets answerSets = (AnswerSets) output;

		// mettere un numero random al posto dello 0
		AnswerSet answersetPedine = answerSets.getAnswersets().get(0);

		// cos� saranno letti come fatti in input
		String stringaInputProssimoDLV = new String();

		for (int i = 0; i < answersetPedine.getAnswerSet().size(); i++) {
			stringaInputProssimoDLV += answersetPedine.getAnswerSet().get(i) + ".";
		}
		mappa.tokenPedineAssegnate(stringaInputProssimoDLV);
		// System.out.println("OutPut assegnazione Pedina: " +
		// stringaInputProssimoDLV);

		// rimuoviamo il vecchio programma dentro l'handler per avviarne un
		// altro (vedi fase1)
		handler.removeProgram(inputAssegnPedine);
		handler.removeOption(0);
		handler.removeOption(1);

	}

	public Mappa getMappa() {
		return mappa;
	}

	public int getTerritorioAttaccante() {
		return territorioAttaccante;
	}

	public int getTerritorioDifensore() {
		return territorioDifensore;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setTerminaTurno(boolean terminaTurno) {
		this.terminaTurno = terminaTurno;

	}

	public boolean isProvandoAttacco() {
		return provandoAttacco;
	}

	public void setProvandoAttacco(boolean provandoAttacco) {
		this.provandoAttacco = provandoAttacco;
	}

	public void setSpostandoFase3(boolean spostandoFase3) {
		this.spostandoFase3 = spostandoFase3;
	}

	public boolean isTerminaTurno() {
		return terminaTurno;
	}

}
