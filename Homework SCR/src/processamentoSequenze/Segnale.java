package processamentoSequenze;

import java.util.Arrays;

public class Segnale {

	private double[] immaginaria;
	private double[] reale;

	public Segnale(double[] parteReale, double[] parteImmaginaria) {
		this.reale = parteReale;
		this.immaginaria = parteImmaginaria;
	}
	
	//restituisce l'array con le potenze del segnale
	public double[] getPotenza() {
		double[] arrayPotenze = new double[1000];
		int c = 0; //gestione dei blocchi
		for(int k = 0; k < 1000;k++) { // k = numero dei blocchi
			double potenza = 0;
			for(int i = 0 + c; i < 1000 + c; i++ ) {
				potenza += Math.pow(reale[i], 2) + Math.pow(immaginaria[i], 2);
			}
			arrayPotenze[k] = potenza / 1000;
			c += 1000; //passo al blocco successivo
		}
		return this.ordinaPotenze(arrayPotenze);	
	}

	//ordina le potenze in ordine crescente
	public double[] ordinaPotenze(double[] arrayPotenze) {
		Arrays.sort(arrayPotenze);
		return arrayPotenze;
	}

	public double[] getImmaginaria() {
		return immaginaria;
	}

	public double[] getReale() {
		return reale;
	}
	
}
