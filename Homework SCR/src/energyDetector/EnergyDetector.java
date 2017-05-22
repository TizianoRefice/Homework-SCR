package energyDetector;

import calcoloSoglia.CalcolatoreSoglia;
import processamentoSequenze.CalcolatorePotenzeSegnali;
import processamentoSequenze.LettoreFile;


public class EnergyDetector {

	public static void esegui(double valoreSNR, int sequenzaScelta){

		CalcolatoreSoglia calcolatore = new CalcolatoreSoglia(); //	
		double soglia = calcolatore.calcolaSoglia(valoreSNR);	 // calcolo la soglia in ipotesi H0
		
		LettoreFile lettore = new LettoreFile();				 // leggo da file la sequenza e la divido in parte reale e parte immaginaria
		lettore.leggi(valoreSNR, sequenzaScelta);		

		CalcolatorePotenzeSegnali calcolatorePotenzaSegnali = new CalcolatorePotenzeSegnali();										     //
		double[] potenzaSegnale = new double[1000];																					  	 //
		for(int i = 0; i < 10000; i++) {																							  	 // creo la lista dove andrò a salvare le potenze delle 1000 sequenze del segnale
			potenzaSegnale[i] = calcolatorePotenzaSegnali.calcolaPotenzaSegnale(lettore.getParteReale(), lettore.getParteImmaginaria()); // calcolo la potenza della porzione di segnale ricevuto e la salvo nella lista
		}

		//confrontiamo i valori delle soglie con le mille sequenze del segnale ricevuto in cui abbiamo diviso il segnale ricevuto
		int contatore = 0;
		double probabilita;
		for(int i = 0; i < 1000; i++) {
			if(potenzaSegnale[i] < soglia)
				System.out.println("stampa di controllo"); //controllo!! eliminare alla fine
				contatore++;
		}
		probabilita = (contatore/1000) * 100;
		System.out.println("Percentuale di detection: " + probabilita + "%");
		if(probabilita > 50) {
			System.out.println("Non è presente il Primary User, possiamo trasmettere!");
		} else {
			System.out.println("E' presente il Primary User, non possiamo trasmettere!");
		}
	}
}

//creare 1000 sequenze da 1000
//out 1 = -3, out 2 = 2, out 3 = -8,  out 4 = -13