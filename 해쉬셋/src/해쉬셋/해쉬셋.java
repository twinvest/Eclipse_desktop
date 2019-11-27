package 해쉬셋;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class 해쉬셋 {

	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException, NullPointerException  {
		BufferedReader ina=new BufferedReader(new FileReader("D:\\유진이adid\\youjin1.csv"));
		BufferedReader inb=new BufferedReader(new FileReader("D:\\유진이adid\\youjin2.csv"));
		
		String[] str1=new String[274];
		String[] str2=new String[1048576];
		int count1=0;
		int count2=0;
		
		
		for(int i=0; i<str1.length; i++)
		{
		   str1[i]=ina.readLine();
		}
				
		for(int i=0; i<str2.length; i++)
		{
			str2[i]=inb.readLine();
		}
		
		HashSet<String> hSet1=new HashSet<String>();
		HashSet<String> hSet2=new HashSet<String>();
		
		for(String e : str1)
		{
			hSet1.add(e);
		}
		
		for(String e : str2)
		{
			hSet2.add(e);
			if(hSet1.add(e)==false)
			{
				count1++;
				System.out.println(e);
			}
			else
			{
				count2++;
			}
			
		}
		
		System.out.println(count1);
		System.out.println(count2);
	
	}

}