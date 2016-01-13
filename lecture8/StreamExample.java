import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class StreamExample{

	public static void main(String args[]) {

		try { 
			BufferedReader in = 
				new BufferedReader(new FileReader("MyFile.txt")); 
			
			String newLine; 
			
			newLine = in.readLine();
			System.out.println(newLine);
			newLine = in.readLine();
			System.out.println(newLine);
			newLine = in.readLine();
			System.out.println(newLine);
			
			in.close(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}
}


