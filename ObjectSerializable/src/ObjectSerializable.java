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
		/*�ν��Ͻ� ����*/
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C:\\JavaStudy\\twtw.java"));
		
		out.writeObject(new Circle(1, 1, 2.4));
		out.writeObject(new Circle(2, 2, 4.8));
		out.writeObject("�¿�õ��"); //new String("�¿�õ��")��� "�¿�õ��"�� ���ڷ� ���޵ǵ� �� 
		
		/*�ν��Ͻ� ����*/
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\JavaStudy\\twtw.java"));
		
		Circle cl1=(Circle)in.readObject();
		Circle cl2=(Circle)in.readObject();
		String message=(String) in.readObject();
		
		/*������ ���� ���*/
		cl1.showCircleInfo();
		cl2.showCircleInfo();
		System.out.println(message);

	}

}
