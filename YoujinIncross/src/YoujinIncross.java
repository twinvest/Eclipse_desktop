import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
		BufferedReader ina=new BufferedReader(new FileReader("D:\\������adid\\youjin1.csv"));
		BufferedReader inb=new BufferedReader(new FileReader("D:\\������adid\\youjin2.csv"));
		
		
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		
		//���� a�� �迭 �����.
	
		String[] str1=new String[274];
		
		for(int i=0; i<str1.length; i++)
		{
			str1[i]=ina.readLine();
			//System.out.println(str1[i]);
		}
				
		//���� b�� �迭�����
		
		String[] str2=new String[1048576];
		
		for(int j=0; j<str2.length; j++)
		{
			str2[j]=inb.readLine();
		    //System.out.println(str2[j]);
		    //count++;
		    //System.out.println(count);
		    //System.out.println(count1);
		    
		    //if(str2[j]==null) {
		    	//System.out.println("����!!");
		    	//count1++;
		    //}
		}
		
	
		
		for(int i=0; i<str1.length; i++)
		{
			
			
			for(int j=0; j<str2.length; j++)
			{
								
				if(str1[i]==null)
				
				    count1++;
								
				else if(str2[j]==null)
				
					count2++;
					
				if(str1[i].equals(str2[j]))
				    //System.out.println(str1[i]);
		    	    //System.out.println(str2[j]);
		    		
		    	    count3++;
		    	
		      
		    	
		    	
				
			}
			
		}
		
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
		
		
		
		ina.close();
		inb.close();
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
	         }*/
		
		
		
		
		
		
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
