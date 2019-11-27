import java.io.ObjectOutputStream;
import java.net.Socket;


public class ObjectSend {

	
	public void sender(String ServerIP, int port, Object data) {

		if (data != null) {

			Socket socket = null;
			ObjectOutputStream oos = null;

			try {
				socket = new Socket(ServerIP, port);
				oos = new ObjectOutputStream(socket.getOutputStream());

				//oos.reset();

				oos.writeObject(data);
				
				System.out.println("sender");
				oos.flush();

				oos.close();
				socket.close();

			} catch (Exception e) {
				
				e.printStackTrace();
				// logger.error("#"+e.toString());
			} finally {
				System.out.println("finally");
			}
		}
	}
}
