package calcoloSoglia;

import java.util.Arrays;

public class CalcolatoreSoglia {

	public CalcolatoreSoglia() {}

	//calcola la soglia usando le potenze delle sequenze generate in NoiseGenerator
	public double calcolaSoglia(double valoreSNR, int sequenzaScelta) {
		//prendere la sequenza di potenze ordinate
		double[] potenzeOrdinate = this.getPotenzeRumoreOrdinate(valoreSNR, sequenzaScelta);
		//prendere la soglia in modo che solo 10 potenze su 1000 siano al di sopra
		double soglia = potenzeOrdinate[989];
		System.out.println("Valore della soglia: " + soglia);
		return soglia;
	}

	//fa generare le potenze a NoiseGenerator e poi le ordina
	public double[] getPotenzeRumoreOrdinate(double valoreSNR, int sequenzaScelta) {
		double[] potenze = new double[1000];
		NoiseGenerator generator = new NoiseGenerator();
		//far generare le mille sequenze di rumore
		for(int i = 0; i < 1000; i++) {
			//generare una sequenza
			generator.noise(valoreSNR, 1000);
			//farne calcolare la potenze e metterle in un array
			potenze[i] = generator.getPotenzaRumore(generator.getParteReale(), generator.getPerteImmaginaria());  
		} 
		//ordinare l'array e restituirlo
		Arrays.sort(potenze);
		return potenze;
	}	

}
