package calcoloSoglia;

import java.util.Random;

public class NoiseGenerator {
	
	private int length;
	private double[] parteReale;
	private double[] parteImmaginaria;
	private double potRumore;
	
	private NoiseGenerator() {
	}
	
	public void noise(double snr, int length) {
	Random campione = null;
	double snrLinearizzato = Math.pow(10, snr/10);
	this.potRumore = 1/snrLinearizzato;
	this.length = length;
	
	this.parteReale = new double[length];
	for(int i = 0; i < this.length; i++) {
		campione = new Random();
		parteReale[i] = campione.nextGaussian() * Math.sqrt(potRumore/2);
	}
	
	this.parteImmaginaria = new double[length];
	for(int j = 0; j < this.length; j++) {
		campione = new Random();
		parteImmaginaria[j] = campione.nextGaussian() * Math.sqrt(potRumore/2);
	}
	}
	
}
