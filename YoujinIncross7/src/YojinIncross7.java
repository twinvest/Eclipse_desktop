import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class YojinIncross7 {

	public static void main(String[] args) throws IOException, NullPointerException {

		BufferedReader in = new BufferedReader(new FileReader("D:\\������adid\\�¿캯��.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("D:\\\\������adid\\\\�¿캯��2.txt"));
		
		
		
		String str;
		
		
		int count=0;
		
		while(true) {
			str=in.readLine().trim();
			System.out.println(str);
			out.write(str);
			out.flush();
			
			if(str==null)
				break;
								
			
		}
		
		in.close();
		out.close();
		
		
		
			
			
			
					
			
		}
	
}


