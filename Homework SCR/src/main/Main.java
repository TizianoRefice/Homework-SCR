package main;

import java.util.Scanner;

import energyDetector.EnergyDetector;

public class Main {

	//NB: probabilità di falso allarme pari a 10/1000, per cambiarla vedere CalcolatoreSoglia
	
	public static void main(String[] args) {
		
		// valori SNR disponibili -13, -8, -5, +2
		//prendo da tastiera il valore dell'SNR selezionato
		System.out.println("Inserire un valore per l'SNR, scegliendo fra: -13, -8, -5, -2");
		Scanner scannerSNR = new Scanner(System.in); 
		double valoreSNR = scannerSNR.nextDouble();
		
		//prendo da tastiera la sequenza selezionata
		System.out.println("Selezionare la sequenza, scegliendo fra: 1, 2, 3");
		Scanner scannerSequenza = new Scanner(System.in);
		int sequenzaScelta = scannerSequenza.nextInt();
		
		
		if(valoreSNR == -13 || valoreSNR == -8 || valoreSNR == -5 || valoreSNR == +2) {
			if(sequenzaScelta == 1 ||  sequenzaScelta == 2 ||  sequenzaScelta == 3) {
					EnergyDetector.esegui(valoreSNR, sequenzaScelta);
			}
		} else {
			System.out.println("Attenzione: un parametro non è corretto!");
		}
		
		scannerSNR.close();
		scannerSequenza.close();
	}

} 

//out 1 = -3, out 2 = 2, out 3 = -8,  out 4 = -13

// ISTRUZIONI: 
// - PER CAMBIARE IL PERCORSO DEI FILE: andare nella classe LettoreFile,
//										e sostituire le stringhe nel blocco switch
// - PER CAMBIAE LA PROBABILITA' DI DETECTION: andare nella classe CalcolatoreSoglia, e sostituire il valore
//											   dell'attributo soglia