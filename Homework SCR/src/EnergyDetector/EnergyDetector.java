package EnergyDetector;

import java.io.File;

import calcoloSoglia.CalcolatoreSoglia;
import processamentoSequenze.LettoreFile;

public class EnergyDetector {

	public static void esegui(double[] valoriSNR) {
		
		CalcolatoreSoglia calcolatore = new CalcolatoreSoglia(); //	
		double[] soglie = calcolatore.calcolaSoglie(valoriSNR);	 // calcolo le soglie in ipotesi H0
		
		LettoreFile lettore = new LettoreFile();
		lettore.leggi();
		
	}
}
