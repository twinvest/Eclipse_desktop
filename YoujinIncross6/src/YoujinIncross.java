import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


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
		
		
		/*String[] str1=new String[274];
		
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
		
		
		
		HashSet<String> hSet1=new HashSet<String>();
		HashSet<String> hSet2=new HashSet<String>();
		
		int count1=0;
		
		
		
		
		for(String e : str1) 
		{
			hSet1.add(e);
		}
		
		
		
	    for(String e : str2)
	    {
	    	hSet2.add(e);
	    	if(hSet1.add(e)==false)
	    	{
	    		System.out.println(e);
	    		count1++;
	    	}
	    	
	    }
	    	    
		System.out.println(count1);
		
		ina.close();
		inb.close();*/
		
        String[] str1=new String[274];
		
		for(int i=0; i<str1.length; i++)
		{
			str1[i]=ina.readLine().trim();
			//System.out.println(str1[i]);
		}
		
      
		/*String[] str2=new String[1048576];
		
		for(int j=0; j<str2.length; j++)
		{
			str2[j]=inb.readLine().trim();
		    //System.out.println(str2[j]);
		}*/
		
		int count=0;
		
		HashSet<String> hSet1=new HashSet<String>();
		
		while(true)
		{
			hSet1.add(inb.readLine());
			for(int i=0; i<str1.length; i++)
			if(hSet1.contains(str1[i]))
			    count++;
			if(hSet1==null)
				break;
		}
		
		System.out.println(count);
		
				
		
		
		/*for(String e : str1) 
		{
			hSet1.add(e);
		}
		
		
		
	    for(String e : str2)
	    {
	    	hSet2.add(e);
	    	if(hSet1.add(e)==false)
	    	{
	    		System.out.println(e);
	    		count1++;
	    	}
	    	
	    }
	    	    
		System.out.println(count1);*/
		
		ina.close();
		inb.close();
		
	
		
		
		
		/*HashMap<String, String> hMap = new HashMap<String, String>();
		

		int count=0;
		
		
		for(String e2 : str2) //str1�� string�迭�̴ϱ� e�� string
		{
			//System.out.println(e);
			for(String e1 : str1)
			
				if(e1.equals(e2))
					count++;
				
			
		}
		
		System.out.println(count);*/
		
		
		
		
		/*int count=0;
		
		while(true)
		{
		String a=ina.readLine();
		
		for(int i=0; i<str2.length; i++)
			if(a.equals(str2[i]))
				count++;
			
		if(a==null)
			break;
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
