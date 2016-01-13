import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderExample {
	public static void readFile() throws IOException {
		FileReader fr = new FileReader("test.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(" ");
			int left = Integer.parseInt(parts[0]);
			int right = Integer.parseInt(parts[1]) ;
			int sum =  left + right;
			System.out.println(parts[0] + " + " + parts[1] + " = " + sum);
		}		
	}	
	
	public static void main(String[] args) {
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
