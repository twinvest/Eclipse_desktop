import java.util.Scanner;

public class Menu {
	String code;
	String name;
	String size;
	double price;
	int real_price; 
	
	
	
	void read(Scanner scan) {
		code = scan.next();
		name = scan.next();
		size = scan.next();
		price = scan.nextDouble()*1000;
		real_price= (int)price;
	}
	
	void print() {
		System.out.printf("%s %s %s %d¿ø\n", code, name, size, real_price);
		//System.out.println(pri);
	}
	
}
