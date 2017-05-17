package processamentoSequenze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LettoreFile {

	public void leggi() throws IOException {
		List<String[]> sequenza = new ArrayList<>();  
		BufferedReader reader = new BufferedReader(new FileReader("C:/Users/trefi/Desktop/SCR/Sequenza_1/output_1"));
		String line = reader.readLine();
		while(line!=null) {
		}
	}
		
}