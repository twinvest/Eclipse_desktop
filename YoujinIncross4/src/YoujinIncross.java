import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;




/*class Strings
{
	String a1;
	public Strings(String a) {this.a1=a;}
	
	public boolean isEquals(Strings b)
	{
		if(this.a1==b.a1)
			return true;
		else
			return false;
	}
}*/





public class YoujinIncross {

	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException, NullPointerException {
		BufferedReader ina=new BufferedReader(new FileReader("D:\\������adid\\youjin1.csv"));
		BufferedReader inb=new BufferedReader(new FileReader("D:\\������adid\\youjin2.csv"));
		Scanner scan=new Scanner(inb);
		
		
		
			
			String[] str1=new String[274];
			
			for(int i=0; i<str1.length; i++)
			{
				str1[i]=ina.readLine().trim();
				//System.out.println(str1[i]);
			}
					
			
			
			String[] str2=new String[1048576];
			
			for(int j=0; j<str2.length; j++)
			{
				str2[j]=inb.readLine().trim();
			    //System.out.println(str2[j]);
			}
		
		
				
		
		HashMap<String, String> hMap = new HashMap<String, String>();
		
						
		hMap.put(str1[0], str2[0]);
		
		System.out.println(hMap.get(str1[0]));
		
		
		
		
		}
		
        		
		
		
		
		
		
		
		/*String[] str1=new String[274];
		
		for(int i=0; i<str1.length; i++)
		{
			str1[i]=ina.readLine().trim();
			//System.out.println(str1[i]);
		}*/
		
      
		
		
		
		
		//�ؽ���
		/*HashMap<String[], String[]> hMap=new HashMap<String[], String[]>();
		
		
		hMap.put(str1, str2);
		
		if*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		//if(hSet.add(ina.readLine())=null)
		//break;
		
		
		
		
		
		/*int count=0;
		
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
					count++;
				
			}
			
		}
		
		System.out.println(count);
		
		
		
		ina.close();
		inb.close();*/
		
		
		
		
		/*for(int i=0; i<str1.length; i++)
	      {
	         //System.out.println("���� i�� :"+i);
	         
	         for(int j=0; j<str2.length; j++)
	         {
	            //System.out.println("���� j�� :"+j);
	           //System.out.println(str1[i]);
	           //System.out.println(str2[j]);
	            if(str1[i].equals(str2[j]))
	               count++;
	            //System.out.println(count);            
	         } */  //�����ڵ�.
		
		
		
		
		
		
		/*String str1;
		String str2;
		
		
		str1=ina.readLine();
		str2=ina.readLine();
		
		System.out.println(str1);
		System.out.println(str2);*/
		
		
		//����b�� String a�� �����ϸ鼭 ���� b�� ������ ��.
		
	/*	int count=0;
		String a;
		while(true) 
		{
						
			
			
			for(int i=0; i<str.length; i++)
			{
				a = inb.readLine();
				if(str[i]==a)
				{
					
					count++;
				
				System.out.println(count);
				}
				
				if(a==null)
					 break;
				
			}
			
			
			
			
		}*/
		
		
		
		
		
		
		/*for(int i=0; i<str.length; i++) {
			int count=0;
			
			while(true){
			String a = inb.readLine();
			if(a==null)
			 break;
			
			else if(str[i]==a)
				count++;
			System.out.println(count);
			}
		}
		
		
		*/
		
		
		
		
		
	}

}
