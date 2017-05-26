package processamentoSequenze;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class LettoreFile {

	private double[] parteReale = new double[1000000];
	private double[] parteImmaginaria = new double[1000000];

	//legge il segnale dal file selezionato
	public Segnale leggi(double valoreSNR, int sequenzaScelta) throws IOException {
		double[] parteReale = new double[1000000];
		double[] parteImmaginaria = new double[1000000];
		String indirizzo = null;
		//in base all'SNR scelto cambiano i valori dell'indirizzo 
		switch(sequenzaScelta) {
		//caso in cui la sequenza scelta sia la numero 1
		case 1: if(valoreSNR == -13) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_1/output_4.dat"; }  // <-- CAMBIARE QUI tutti gli indirizzi
				if(valoreSNR == -8) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_1/output_3.dat"; }
				if(valoreSNR == -5) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_1/output_1.dat"; }
				if(valoreSNR == +2) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_1/output_2.dat"; }
				break;
		//caso in cui la sequenza scelta sia la numero 2		
		case 2: if(valoreSNR == -13) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_2/output_4.dat"; } 
				if(valoreSNR == -8) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_2/output_3.dat"; }
				if(valoreSNR == -5) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_2/output_1.dat"; }
				if(valoreSNR == +2) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_2/output_2.dat"; }
				break;
		//caso in cui la sequenza scelta sia la numero 3		
		case 3: if(valoreSNR == -13) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_3/output_4.dat"; } 
				if(valoreSNR == -8) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_3/output_3.dat"; }
				if(valoreSNR == -5) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_3/output_1.dat"; }
				if(valoreSNR == +2) { indirizzo = "C:/Users/Tiziano/Desktop/Università/SCR/Sequenze Homework/Sequenza_3/output_2.dat"; }
				break;
		}	
		//sposta la sequenza letta da file in due array 
		Scanner scanner = new Scanner(Paths.get(indirizzo));
		for(int i = 0; i < 1000000; i++) {
			parteReale[i] = Double.parseDouble(scanner.next());
			parteImmaginaria[i] = Double.parseDouble(scanner.next());
		}
		scanner.close();
		
		this.setParteImmaginaria(parteReale);
		this.setParteReale(parteImmaginaria);
		
		Segnale segnale = new Segnale(parteReale, parteImmaginaria);
		return segnale;
		
	}

	public void setParteReale(double[] parteReale) {
		this.parteReale = parteReale;
	}

	public void setParteImmaginaria(double[] parteImmaginaria) {
		this.parteImmaginaria = parteImmaginaria;
	}

	public double[] getParteReale() {
		return this.parteReale;
	}

	public double[] getParteImmaginaria() {
		return this.parteImmaginaria;
	}
}