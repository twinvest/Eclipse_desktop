import java.io.*;



public class DataFilterStream {

	public static void main(String[] args) throws IOException {
		/*OutputStream out=new FileOutputStream("C:\\\\Users\\\\taewoo\\\\Desktop\\\\������ ���̽�\\\\taewoo.csv");
		DataOutputStream filterOut=new DataOutputStream(out);
		
		filterOut.writeInt(275);
		filterOut.writeDouble(45.79);
		filterOut.close();
		
		InputStream in=new FileInputStream("C:\\\\Users\\\\taewoo\\\\Desktop\\\\������ ���̽�\\\\taewoo.csv");
		DataInputStream filterIn=new DataInputStream(in);
		int num1=filterIn.readInt();
		double num2=filterIn.readDouble();
		filterIn.close();
		
		System.out.println(num1);
		System.out.println(num2);*/
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*OutputStream out=new FileOutputStream("c:\\javastudy\\hyper.txt");
		out.write(65);
		out.write(66);
		out.close(); //windows�ü���� ���ڵ� ��İ� �ڹ����α׷��� ���ڵ� ����� �޶� window�� ������ ������ windows�ü���� �������� ���ڵ� ������� �־������. windows���� 65�� �빮�� A 66�� �빮��B.*/
		
		/*char ch1='A';
		char ch2='B';
		
		Writer out=new FileWriter("c:\\javastudy\\tw.txt");
		out.write(ch1);
		out.write(ch2);
		out.close();*/
		
		/*char[] cbuf=new char[10];
		int readCnt;
		
		Reader in=new FileReader("c:\\javastudy\\tw.txt");
		readCnt=in.read(cbuf, 0, cbuf.length);
		for(int i=0; i<10; i++)
			System.out.println(cbuf[i]);
		
		in.close();*/
		
		/*BufferedWriter out=new BufferedWriter(new FileWriter("c:\\javastudy\\String.txt"));
		
		out.write("������ - �޽� ���߰� �ϴµ� �����ϰڴ�.");
		out.newLine();
		out.write("�� ������ ������ �־� �ְ��� �����̴�.");
		out.newLine();
		out.write("���� �¸��ϴ°��� ���� ���� �ּ��� ���ϰڴ�.");
		out.newLine();
		out.write("ȯ������ ������� �� ���̴�.");
		out.newLine();
		out.newLine();
		out.write("��� ���� �� �����ڷ�");
		out.newLine();
		out.write("twinvest@twinvest.kr");
		out.newLine();
		out.close();
		System.out.println("��� �Է¿Ϸ�.");*/
		
		
		/*BufferedReader in=new BufferedReader(new FileReader("c:\\javastudy\\String.txt"));
		
		String str;
		while(true)
		{
			str=in.readLine();
			if(str==null)
				break;
			System.out.println(str);
			
		}
		in.close();*/
		
		
		/*PrintWriter out = new PrintWriter(new FileWriter("c:\\javastudy\\twtw.txt"));
		
		out.printf("�� ���̴� %d�Դϴ�.", 24);
		out.println();
		
		out.println("���� �ڹٰ� �����ϴ�.");
		out.print("Ư�� io�κп��� ���� �ŷ��� �����ϴ�.");
		out.print("�¿�¯¯��");
		
		out.close();*/
		
	

	}

}
