package processamentoSequenze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class LettoreFile {
	
	private LineNumberReader reader;
	private double[] parteReale;
	private double[] parteImmaginaria;
	private String[] sequenzaSegnale = new String[10000];

	//legge il segnale dal file selezionato
	public void leggi(double valoreSNR, int sequenzaScelta) {
		File file = null;
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
			this.reader = new LineNumberReader(new FileReader(file));
		} catch (IOException exc) {
			System.out.println("FILE ASSENTE!");
		}
	}
	
	//
	public void streamSegnale() throws IOException {
		BufferedReader br = new BufferedReader(this.reader);
		int i = 0;
		String line = br.readLine();
		while(line != null) {
			this.sequenzaSegnale[i] = line;
			i++;
			line = br.readLine();
		}
	}
	
	public void separaStringhe(String sequenzaSegnale) {
		double[] result = new double[2];
		int i = 0;
		Scanner scanner = null;
		while(this.sequenzaSegnale[i] != null) {
			scanner = new Scanner(this.sequenzaSegnale[i]);
			result[0] = Double.parseDouble(scanner.next());
			result[1] = Double.parseDouble(scanner.next());
			this.parteReale[i] = result[0];
			this.parteImmaginaria[i] = result[1];
			i++;
		}
		scanner.close();
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