package main;

import EnergyDetector.EnergyDetector;
import calcoloSoglia.CalcolatoreSoglia;

public class Main {

	//NB: probabilità di falso allarme pari a 10/1000, per cambiarla vedere CalcolatoreSoglia
	
	public static void main(String[] args) {
		
		double[] valoriSNR = {-13, -8, -5, +2};
		
		EnergyDetector.esegui(valoriSNR);
	}

} 

/*qui ci andranno solo le invocazioni ai metodi!!
 * 
 * 
 * 
*/