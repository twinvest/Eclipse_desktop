import java.io.*;


class Circle implements Serializable
{
	int xPos;
	int yPos;
	double rad;
	
	public Circle(int x, int y, double r)
	{
		this.xPos=x;
		this.yPos=y;
		this.rad=r;
	}
	
	public void showCircleInfo()
	{
		System.out.printf("[%d, %d]\n", xPos, yPos);
		System.out.println("rad :"+rad);
	}
	
}


public class ObjectSerializable {

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		/*인스턴스 저장*/
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C:\\JavaStudy\\twtw.java"));
		
		out.writeObject(new Circle(1, 1, 2.4));
		out.writeObject(new Circle(2, 2, 4.8));
		out.writeObject("태우천재"); //new String("태우천재")대신 "태우천재"가 인자로 전달되도 됨 
		
		/*인스턴스 복원*/
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\JavaStudy\\twtw.java"));
		
		Circle cl1=(Circle)in.readObject();
		Circle cl2=(Circle)in.readObject();
		String message=(String) in.readObject();
		
		/*복원된 정보 출력*/
		cl1.showCircleInfo();
		cl2.showCircleInfo();
		System.out.println(message);

	}

}
