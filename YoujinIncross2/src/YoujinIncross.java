import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import com.opencsv.CSVReader;



public class YoujinIncross {

	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException, NullPointerException {
		BufferedReader ina=new BufferedReader(new FileReader("D:\\������adid\\youjin1.csv"));
		BufferedReader inb=new BufferedReader(new FileReader("D:\\������adid\\youjin2.csv"));
		
		int count=0;
		
		//���� a�� �迭 �����.
	
		String[] str1=new String[274];
		
		for(int i=0; i<str1.length; i++)
		{
			str1[i]=ina.readLine().trim();
			//System.out.println(str1[i]);
		}
				
		//���� b�� �迭�����
		
		String[] str2=new String[1048576];
		
		for(int j=0; j<str2.length; j++)
		{
			str2[j]=inb.readLine().trim();
		    //System.out.println(str2[j]);
		}
		
				
		for(int i=0; i<str1.length; i++)
		{
			//System.out.println("���� i�� :"+i);
			
			for(int j=0; j<str2.length; j++)
			{
				//System.out.println("���� j�� :"+j);
				if(str1[i].equals(str2[j]))
				
					System.out.println(str2[j]);
					count++;
				
			}
			
		}
		
		System.out.println(count);
		
		
		
		ina.close();
		inb.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
