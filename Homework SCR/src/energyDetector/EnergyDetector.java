package energyDetector;

import java.io.IOException;

import calcoloSoglia.CalcolatoreSoglia;
import processamentoSequenze.LettoreFile;
import processamentoSequenze.Segnale;

public class EnergyDetector {

	private double soglia;
	
	public EnergyDetector() {}
	
	//confronta le potenze calcolate con la soglia
	//se più del 50% non supera la soglia, dico che il PU non è presente --> POSSIAMO TRASMETTERE
	public void verificaPresenzaPU(double valoreSNR, int sequenzaScelta) throws IOException {
		//stampa a video
		System.out.println("RISULTATI:");
		
		//calcolare la soglia in H0
		CalcolatoreSoglia cs = new CalcolatoreSoglia();
		this.soglia = cs.calcolaSoglia(valoreSNR, sequenzaScelta);
		
		//Legge il segnale in entrata
		Segnale segnaleRicevuto;
		LettoreFile lf = new LettoreFile();
		segnaleRicevuto = lf.leggi(valoreSNR, sequenzaScelta);
		//chiede al segnale di calcolare la potenza delle sue sequenze
		double[] potenze = segnaleRicevuto.getPotenza();
		
		
		double contatore = 0;
		double probabilita = 0;
		for(int i = 0; i < potenze.length; i++) {
			if(potenze[i] < soglia) {
				contatore++;
			}
		}
		probabilita = (contatore/1000) * 100;
		System.out.println("Probabilità di detection: " + probabilita + "%");
		if(probabilita > 50) {
			System.out.println("Il Primary User non è presente, possiamo trasmettere");
		} else
			System.out.println("Il Primary User è presente, non possiamo trasmettere");
	}
	
}

