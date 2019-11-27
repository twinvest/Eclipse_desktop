import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Main {
	
	private static final int port = 8888;
	
	private static final String IP = "192.168.0.35";
	
	private static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		ObjectSend send =  new ObjectSend(IP,port);
		
		ObjectData data = new ObjectData();
		
		for(int i = 0; i <10; i++) {
			list.add(i);
		}
		
		
		data.setList(list);
		send.sender(data);
		
	}
}
