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

	private Handler handler;

	public Mappa mappa;

	public Mappa getMappa() {
		return mappa;
	}

	public GameDLV() {

		init();
		startGameDLV();
	}

	public void init() {
		handler = new DesktopHandler(new DLVDesktopService("source/dlv.x86-64-linux-elf-static.bin"));
		mappa = new Mappa();
	}

	public void startGameDLV() {

		// STEP 1 FASE TERRITORI

		// inputProgram.addProgram("a(1). a(2)." + "a(3):-a(1),a(2).");
		// //programma dlv, se + guess più input
		InputProgram inputAssegnTerritori = new ASPInputProgram();
		inputAssegnTerritori.addFilesPath("source/assegnazioneTerritori.txt");
		// inputProgram.addProgram();//-->OBIETTIVO PROSSIMA VOLTA

		handler.addProgram(inputAssegnTerritori);
		String outputAssegnTerritori = startAssegnazioneTerritori();
		handler.removeProgram(inputAssegnTerritori);

		// STEP 2 FASE PEDINE

		InputProgram inputAssegnPedine = new ASPInputProgram(outputAssegnTerritori);
		inputAssegnPedine.addFilesPath("source/assegnazionePedine.txt");

		handler.addProgram(inputAssegnPedine);
		String outputAssegnPedine = startAssegnazionePedine();
		// handler.removeProgram(outputAssegnPedine);

		// handler.addProgram(new altroInput);

	}

	public String startAssegnazioneTerritori() {
		handler.addOption(new OptionDescriptor("-filter=territorioIN "));
		handler.addOption(new OptionDescriptor("-n=1 "));

		// avvia dlv.mingw.exe e il risultato lo mette in output
		Output output = handler.startSync();
		AnswerSets answerSets = (AnswerSets) output;

		// mettere un numero random al posto dello 0
		AnswerSet a = answerSets.getAnswersets().get(0);

		// così saranno letti come fatti in input
		String stringaInputProssimoDLV = new String();

		for (int i = 0; i < a.getAnswerSet().size(); i++) {
			stringaInputProssimoDLV += a.getAnswerSet().get(i) + ".";
		}

		System.out.println("ASSGN-TERRITORI TOKENIZZATA=> " + stringaInputProssimoDLV);

		String answerTokenizzataMappa = stringaInputProssimoDLV;
		mappa.tokenTerritoriIn(answerTokenizzataMappa);

		return answerTokenizzataMappa;
	}

	public String startAssegnazionePedine() {
		handler.removeOption(0);
		handler.removeOption(1);
		handler.addOption(new OptionDescriptor("-filter=pedineAssegnate "));
		handler.addOption(new OptionDescriptor("-n=1 "));

		// avvia dlv.mingw.exe e il risultato lo mette in output
		Output output = handler.startSync();
		AnswerSets answerSets = (AnswerSets) output;

		// mettere un numero random al posto dello 0
		AnswerSet answersetPedine = answerSets.getAnswersets().get(0);

		// System.out.println(answersetPedine.toString());

		// così saranno letti come fatti in input
		String stringaInputProssimoDLV = new String();

		for (int i = 0; i < answersetPedine.getAnswerSet().size(); i++) {
			stringaInputProssimoDLV += answersetPedine.getAnswerSet().get(i) + ".";
		}

		System.out.println("ASSGN-PEDINE TOKENIZZATA=> " + stringaInputProssimoDLV);

		String answerTokenizzataMappa = stringaInputProssimoDLV;
		mappa.tokenPedineAssegnate(answerTokenizzataMappa);
		mappa.print();

		return answerTokenizzataMappa;
	}

	public static void main(String[] args) {

		GameDLV dlv = new GameDLV();
	}

}
