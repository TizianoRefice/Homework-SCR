package calcoloSoglia;

import java.util.Arrays;

public class CalcolatoreSoglia {

	public CalcolatoreSoglia() {}

	//calcola la soglia usando le potenze delle sequenze generate in NoiseGenerator
	public double calcolaSoglia(double valoreSNR, int sequenzaScelta) {
		NoiseGenerator generator = new NoiseGenerator();
		double[] potenze = new double[1000];
		//genera la sequenza di mille potenze
		potenze = generator.generaRumore(valoreSNR, 1000);
		//ordino la sequenza
		potenze  = this.ordina(potenze);
		//prendere la soglia in modo che solo 10 potenze su 1000 siano al di sopra
		double soglia = potenze[989];
		System.out.println("Valore della soglia: " + soglia);
		return soglia;
	}

	//ordina una sequenza di potenze di rumore passate come parametro
	public double[] ordina(double[] sequenza) {
		Arrays.sort(sequenza);
		return sequenza;
	}	

}
