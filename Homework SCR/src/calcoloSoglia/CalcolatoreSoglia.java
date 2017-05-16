package calcoloSoglia;

import java.util.Arrays;

public class CalcolatoreSoglia {

	private double[] soglie;
	private double[] potenzeRumore;

	public CalcolatoreSoglia() {
		this.soglie = new double[4];
	}

	//calcola la soglia usando le potenze delle sequenze generate in NoiseGenerator
	public double[] calcolaSoglie(int[] valoriSNR) { 	
		for(int i = 0; i <= valoriSNR.length; i++) { 					//in questo modo calcola i valori da solo per tutti gli SNR
			getSequenzePotenzeRumoreOrdinate(valoriSNR[i]); 			//comando di calcolare l'array di potenze
			soglie[i] = this.potenzeRumore[989];						//prendo il 990° valore (probFA = 10/1000) <-- CAMBIARE QUESTO VALORE PER ALTERARE LA Pfa DEL NOISE GENERATOR
		}
		return soglie;
	}

	//fa generare le potenze a NoiseGenerator e poi le ordina
	public double[] getSequenzePotenzeRumoreOrdinate(int valoreSNR) {
		int j = 1;
		double potenzaRumore;									//per salvare il valore di una singola potenza
		NoiseGenerator generator = new NoiseGenerator();
		while(j <= 1000) { 										//mi servono 1000 sequenze per ogni SNR
			generator.noise(valoreSNR, 1000); 					//genero la sequenza
			potenzaRumore = generator.getPotenzaRumore(generator.getParteReale(), generator.getPerteImmaginaria()); //ne calcolo la potenza
			this.potenzeRumore[j] = potenzaRumore; 				//salvo la potenza calcolata dentro l'array di potenze;
		}
		Arrays.sort(this.potenzeRumore); 						//le ordino
		return this.potenzeRumore;
	}


//	public double[] ordinaSequenzeRumore(int[] valoriSNR) {
//		double potenzaRumore = 0;
//		for(int j = 0; j <= 999; j++) {
//			NoiseGenerator generator = new NoiseGenerator();
//			generator.noise(valoriSNR[i], 1000);
//			this.parteReale = generator.getParteReale();
//			this.parteImmaginaria = generator.getPerteImmaginaria();
//			potenzaRumore = generator.getPotenzaRumore(this.parteReale, this.parteImmaginaria);
//		}
//		potenzeRumore[i] = potenzaRumore;
//
//		return potenzeRumore;
//	}

}
