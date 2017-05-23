package processamentoSequenze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class LettoreFile {

	private double[] parteReale = new double[1000];
	private double[] parteImmaginaria = new double[1000];

	//legge il segnale dal file selezionato
	public void leggi(double valoreSNR, int sequenzaScelta) {
		File file = null;
		FileReader reader = null;
		//per cambiare il file di input modificare qui
		try {
			String indirizzo = null;	
			switch(sequenzaScelta) {
			//caso in cui la sequenza scelta sia la numero 1
			case 1: if(valoreSNR == -13) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_1/output_4.dat"; }  //in base all'SNR scelto cambiano i valori dell'indirizzo 
			if(valoreSNR == -8) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_1/output_3.dat"; }
			if(valoreSNR == -5) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_1/output_1.dat"; }
			if(valoreSNR == +2) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_1/output_2.dat"; }
			break;
			//caso in cui la sequenza scelta sia la numero 2		
			case 2: if(valoreSNR == -13) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_2/output_4.dat"; } 
			if(valoreSNR == -8) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_2/output_3.dat"; }
			if(valoreSNR == -5) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_2/output_1.dat"; }
			if(valoreSNR == +2) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_2/output_2.dat"; }
			break;
			//caso in cui la sequenza scelta sia la numero 3		
			case 3: if(valoreSNR == -13) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_3/output_4.dat"; } 
			if(valoreSNR == -8) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_3/output_3.dat"; }
			if(valoreSNR == -5) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_3/output_1.dat"; }
			if(valoreSNR == +2) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_3/output_2.dat"; }
			break;
			}	

			file = new File(indirizzo);
			reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			while(line != null) {
				this.separaStringhe(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException exc) {
			System.out.println("FILE ASSENTE!");
		}
	}

	//
	//	public void streamSegnale() throws IOException {
	//		try {
	//			BufferedReader br = new BufferedReader(this.reader);
	//			String line = br.readLine();
	//			while(line != null) {
	//				this.separaStringhe(line);
	//				line = br.readLine();
	//			}
	//			br.close();
	//		} catch (IOException exc) {
	//			System.out.print("Qualcosa è nullo in Danimarca!");
	//		}
	//		
	//	}

	private void separaStringhe(String campione) {
//		double[] result = new double[2];
		int i = 0;
		while(campione != null) {
			Scanner scanner = new Scanner(campione);
			while(i < 1000 && scanner.hasNext()) {
//				result[0] = Double.parseDouble(scanner.next());
//				result[1] = Double.parseDouble(scanner.next());
				this.parteReale[i] = Double.parseDouble(scanner.next());
				this.parteImmaginaria[i] = Double.parseDouble(scanner.next());;
				i++;
			}
			scanner.close();
		}
	}

	public double[] getParteReale() {
		return this.parteReale;
	}

	public double[] getParteImmaginaria() {
		return this.parteImmaginaria;
	}
}

//out 1 = -3, out 2 = 2, out 3 = -8,  out 4 = -13
//creiamo 1000 sequenze da 1000