package main;

import calcoloSoglia.CalcolatoreSoglia;

public class EnergyDetectorMain {

	public static void main(String[] args) {
		
		//NB: probabilità di falso allarme pari a 10/1000, per cambiarla vedere CalcolatoreSoglia
		int[] valoriSNR = {-13, -8, -5, +2};
				
		CalcolatoreSoglia calcolatore = new CalcolatoreSoglia();	
		double[] soglie = calcolatore.calcolaSoglie(valoriSNR);

	}

} 