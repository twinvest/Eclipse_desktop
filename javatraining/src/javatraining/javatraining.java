package javatraining;

public class javatraining {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("931105-1200114");
		str.deleteCharAt(str.indexOf("-"));
		//str.reverse();
		System.out.println(str);

	}
	
	public static int toBinary(int decimal) {
		if(decimal>0)
		{
			int bin;
			bin=decimal%2;
			decimal/=2;
			toBinary(decimal);
			System.out.println(bin);
		}
		return 0;
	}

}
