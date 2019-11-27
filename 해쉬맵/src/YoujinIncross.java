import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;





public class YoujinIncross {

	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException, NullPointerException {
		BufferedReader ina=new BufferedReader(new FileReader("D:\\유진이adid\\youjin1.csv"));
		BufferedReader inb=new BufferedReader(new FileReader("D:\\유진이adid\\youjin2.csv"));
		
		
		 String[] str1 = new String[274];

	      for (int i = 0; i < str1.length; i++) {
	         str1[i] = ina.readLine();
	         // System.out.println(str1[i]);
	      }

	      String[] str2 = new String[1048576];

	      for (int j = 0; j < str2.length; j++) {
	         str2[j] = inb.readLine();
	         // System.out.println(str2[j]);
	      }

	      Hashtable<String, Integer> adidAndCount = new Hashtable<String, Integer>();

	      for (String e : str1) {
	         Integer count = adidAndCount.get(e);
	         if (count == null) {
	            adidAndCount.put(e, 1);
	         } else {
	            adidAndCount.put(e, ++count);
	         }
	      }
	      for (String e : str2) {
	         Integer count = adidAndCount.get(e);
	         if (count == null) {
	            adidAndCount.put(e, 1);
	         } else {
	            adidAndCount.put(e, ++count);
	         }
	      }
	      Set<Entry<String,Integer>> entrySet = adidAndCount.entrySet();
	      for(Entry<String,Integer> entry : entrySet) {
	         if(entry.getValue()>1) {
	            System.out.printf("duplicate element '%s',and count '%d'\n",entry.getKey(),entry.getValue());
	         }
	      }
	   }
	}