package energyDetector;

import java.io.IOException;

import calcoloSoglia.CalcolatoreSoglia;
import processamentoSequenze.CalcolatorePotenzeSegnali;
import processamentoSequenze.LettoreFile;

public class EnergyDetector {

	private double soglia;
	private double[] potenze;
	
	public EnergyDetector() {}
	
	//confronta le potenze calcolate con la soglia
	//se più del 50% non supera la soglia, dico che il PU non è presente --> POSSIAMO TRASMETTERE
	public void verificaPresenzaPU(double valoreSNR, int sequenzaScelta) throws IOException {
		System.out.println("RISULTATI:");
		LettoreFile lf = new LettoreFile();
		lf.leggi(valoreSNR, sequenzaScelta);
		CalcolatoreSoglia cs = new CalcolatoreSoglia();
		CalcolatorePotenzeSegnali cps = new CalcolatorePotenzeSegnali();
		this.soglia = cs.calcolaSoglia(valoreSNR, sequenzaScelta);	//calcolare la soglia in H0
		//prendere le sequenze del segnale in entrata e calcolarne la potenza (saranno 1000)
		for(int j = 0; j < 1000; j++) {
			this.potenze[j] = cps.calcolaPotenzaSegnale(lf.getParteReale(), lf.getParteImmaginaria());
		}
		double contatore = 0;
		double probabilita = 0;
		for(int i = 0; i < this.potenze.length; i++) {
			if(potenze[i] < soglia) {
				contatore++;
			}
		}
		probabilita = (contatore/1000) * 100;
		if(probabilita > 50) {
			System.out.println("Il Primary User non è presente, possiamo trasmettere");
		} else
			System.out.println("Il Primary User è presente, non possiamo trasmettere");
	}
	
}

