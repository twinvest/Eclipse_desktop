
public class StringEquals {

	public static void main(String[] args) {
		String str1="Hi my string";
		String str2="Hi my string";
		
		if(str1==str2)
			System.out.println("동일");
		else
			System.out.println("다름");
		
		if(str1.equals(str2))
			System.out.println("인스턴스동일");
		else
			System.out.println("인스턴스다름");
		
	}

}
