package calcoloSoglia;

import java.util.Random;

import processamentoSequenze.Segnale;

public class NoiseGenerator {

	private int length;
	private double potRumore;

	protected NoiseGenerator() {}

	//genera una sequenza randomica di campioni e li inserisce in un oggetto segnale
	public Segnale noise(double snr, int length) {
		double[] parteReale;
		double[] parteImmaginaria;
		Random campione = null;
		double snrLinearizzato = Math.pow(10, snr/10);
		this.potRumore = 1/snrLinearizzato;
		this.length = length;

		parteReale = new double[length];
		for(int i = 0; i < this.length; i++) {
			campione = new Random();
			parteReale[i] = campione.nextGaussian() * Math.sqrt(potRumore/2);
		}

		parteImmaginaria = new double[length];
		for(int j = 0; j < this.length; j++) {
			campione = new Random();
			parteImmaginaria[j] = campione.nextGaussian() * Math.sqrt(potRumore/2);
		}
		
		Segnale rumore = new Segnale(parteReale, parteImmaginaria);
		return rumore;
		
	}
	
	//metodo che calcola potenza della sequenza di rumore generata casualmente
	private double getPotenzaRumore(Segnale rumore) {
		double potenza, sommaProdotti = 0;
		double lunghezza = this.length; 									
		double normalizzatore = 1/lunghezza;
		for(int i = 0; i < lunghezza; i++) {												
			sommaProdotti += Math.pow(rumore.getReale()[i], 2) + Math.pow(rumore.getImmaginaria()[i], 2);	
		}																					
		potenza = normalizzatore * sommaProdotti;										
		return potenza;																	
	}

	//comanda la generazione delle sequenze di rumore
	public double[] generaRumore(double valoreSNR, int length) {
		double[] potenze = new double[1000];
		for(int i = 0; i < 1000; i++) {
			Segnale rumore = this.noise(valoreSNR, length);
			potenze[i] = this.getPotenzaRumore(rumore); 
		}
		return potenze;
	}
}
