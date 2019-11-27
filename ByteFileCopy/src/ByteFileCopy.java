import java.io.*;

public class ByteFileCopy {

	public static void main(String[] args) throws IOException {
		InputStream in=new FileInputStream("C:\\Users\\taewoo\\Desktop\\유진이 파이썬\\feb.csv");
		OutputStream out=new FileOutputStream("C:\\\\Users\\\\taewoo\\\\Desktop\\\\유진이 파이썬\\\\taewoo.csv");
		
		
		BufferedInputStream bin=new BufferedInputStream(in);
		BufferedOutputStream bout=new BufferedOutputStream(out);
				
		int copyByte=0;
		byte bData;
		
		while(true)
		{
			bData=(byte) bin.read();
			if(bData==-1)
				break;
			bout.write(bData);
			copyByte++;
		}
		
		in.close();
		out.close();
		System.out.println("복사된 바이트 크기 :"+ copyByte);

	}

}
