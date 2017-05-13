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

		public class DLV {

			private Handler handler;

			public DLV() {

				handler = new DesktopHandler(new DLVDesktopService("/home/tyrionlannister/workspaceIA2/intelligenzaProva/dlv.x86-64-linux-elf-static.bin"));

				// STEP INIT TERRITORI

				// inputProgram.addProgram("a(1). a(2)." + "a(3):-a(1),a(2).");
				// //programma dlv, se + guess più input
				InputProgram inputAssegnTerritori = new ASPInputProgram();
				inputAssegnTerritori.addFilesPath("source/assegnazioneTerritori.txt");
				// inputProgram.addProgram();//-->OBIETTIVO PROSSIMA VOLTA

				handler.addProgram(inputAssegnTerritori);
				String outputAssegnTerritori = startAssegnazioneTerritori();
				handler.removeProgram(inputAssegnTerritori);

				// STEP 2 INIT PEDINE

				InputProgram inputAssegnPedine = new ASPInputProgram(outputAssegnTerritori);
				inputAssegnPedine.addFilesPath("source/prova2.txt");

				handler.addProgram(inputAssegnPedine);
				String outputAssegnPedine = startAssegnazionePedine();
				// handler.removeProgram(outputAssegnPedine);

				// handler.addProgram(new altroInput);

			}

			public String startAssegnazioneTerritori() {
				handler.addOption(new OptionDescriptor("-filter=territorioIN "));
				handler.addOption(new OptionDescriptor("-n=1 "));
				Output output = handler.startSync(); // avvia dlv.mingw.exe e il
														// risultato lo mette in output
				AnswerSets answerSets = (AnswerSets) output;
				AnswerSet a = answerSets.getAnswersets().get(0); // mettere un numero
																	// random al posto
																	// dello 0
				System.out.println(a.toString());

				String answerTokenizzata = new String();
				for (int i = 0; i < a.getAnswerSet().size(); i++) {
					answerTokenizzata += a.getAnswerSet().get(i);
					answerTokenizzata += ".";
				}
				System.out.println("SONO TUTTA TOKENIZZATA=> " + answerTokenizzata);

				return answerTokenizzata;
			}

			public String startAssegnazionePedine() {
				handler.removeOption(0);//rendere più chiari
				handler.removeOption(1);
				handler.addOption(new OptionDescriptor("-filter=a "));
				handler.addOption(new OptionDescriptor("-n=1 "));
				Output output = handler.startSync(); // avvia dlv.mingw.exe e il
														// risultato lo mette in output
				AnswerSets answerSets = (AnswerSets) output;
				// AnswerSet a = answerSets.getAnswersets().get(0); // mettere un numero
				// random al posto
				// dello 0
				System.out.println(answerSets.getAnswersets());

				// String answerTokenizzata=new String();
				// for (int i = 0; i < a.getAnswerSet().size(); i++) {
				// answerTokenizzata+=a.getAnswerSet().get(i);
				// answerTokenizzata+=".";
				// }
				// System.out.println("SONO TUTTA TOKENIZZATA=> "+answerTokenizzata);
				//
				// return answerTokenizzata;
				return " ";
			}

			public static void main(String[] args) {

				DLV dlv = new DLV();
			}

		}