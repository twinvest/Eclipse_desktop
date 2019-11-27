import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectReceiver {

	Object list = null;
	ServerSocket serverSocket = null;
	Socket socket = null;
	ObjectInputStream ois = null;

	public ObjectReceiver(int port) throws IOException {
		
			serverSocket = new ServerSocket(port);
			socket = serverSocket.accept();

	}

	public Object ObjectDataReceiver() throws IOException, ClassNotFoundException {

		ois = new ObjectInputStream(socket.getInputStream());
		ObjectData od = (ObjectData) ois.readObject();
		list = od.getList();
		
		return list;
	}
	
	public void close() throws IOException {
		serverSocket.close();
		System.out.println("Á¾·á..");
	}
}
