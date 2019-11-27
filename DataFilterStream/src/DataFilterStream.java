import java.io.*;



public class DataFilterStream {

	public static void main(String[] args) throws IOException {
		/*OutputStream out=new FileOutputStream("C:\\\\Users\\\\taewoo\\\\Desktop\\\\유진이 파이썬\\\\taewoo.csv");
		DataOutputStream filterOut=new DataOutputStream(out);
		
		filterOut.writeInt(275);
		filterOut.writeDouble(45.79);
		filterOut.close();
		
		InputStream in=new FileInputStream("C:\\\\Users\\\\taewoo\\\\Desktop\\\\유진이 파이썬\\\\taewoo.csv");
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
		out.close(); //windows운영체제의 인코딩 방식과 자바프로그램의 인코딩 방식이 달라 window에 파일을 만들어낼때 windows운영체제를 기준으로 인코딩 결과값을 넣어줘야함. windows에서 65는 대문자 A 66은 대문자B.*/
		
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
		
		out.write("박지성 - 메시 멈추게 하는데 집중하겠다.");
		out.newLine();
		out.write("올 시즌은 나에게 있어 최고의 시즌이다.");
		out.newLine();
		out.write("팀이 승리하는것을 돕기 위해 최선을 다하겠다.");
		out.newLine();
		out.write("환상적인 결승전이 될 것이다.");
		out.newLine();
		out.newLine();
		out.write("기사 제보 및 보도자료");
		out.newLine();
		out.write("twinvest@twinvest.kr");
		out.newLine();
		out.close();
		System.out.println("기사 입력완료.");*/
		
		
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
		
		out.printf("제 나이는 %d입니다.", 24);
		out.println();
		
		out.println("저는 자바가 좋습니다.");
		out.print("특히 io부분에서 많은 매력을 느낍니다.");
		out.print("태우짱짱맨");
		
		out.close();*/
		
	

	}

}
