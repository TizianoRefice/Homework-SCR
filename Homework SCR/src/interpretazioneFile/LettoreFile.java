package interpretazioneFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LettoreFile {

	public static void main(String[] args) throws IOException {
		List<String[]> sequenza = new ArrayList<>();  
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Tiziano\\Downloads\\Sequenza_1\\output_1.dat"));
		String line = reader.readLine();
		while(line!=null) {
		}
	}
		
}