
public class InterfaceMark {

	public static void main(String[] args) {
		PointOne pos1=new PointOne(1, 1);
		PointTwo pos2=new PointTwo(2, 2);
		PointOne pos3=new PointOne(3, 3);
		PointTwo pos4=new PointTwo(4, 4);
		
		ClassPrinter.print(pos1);
		ClassPrinter.print(pos2);
		ClassPrinter.print(pos3);
		ClassPrinter.print(pos4);

	}

}
