

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ObjectSend {

	Socket socket = null;
	ObjectOutputStream oos = null;

	public ObjectSend(String ServerIP, int port) throws UnknownHostException, IOException {

		socket = new Socket(ServerIP, port);

	}


	public void sender(Object data) throws IOException {

		if (data != null) {

				oos = new ObjectOutputStream(socket.getOutputStream());

				// oos.reset();

				oos.writeObject(data);

				System.out.println("sender");
				oos.flush();


		}
	}
	
	public void close() throws IOException {
		oos.close();
		socket.close();
	}
}
