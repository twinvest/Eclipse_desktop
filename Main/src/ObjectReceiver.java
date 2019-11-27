package File;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import DTO.WordCountBean;

public class ObjectReceiver {

	ArrayList<WordCountBean> list;

	public ObjectReceiver() {
		list = null;
	}

	public ArrayList<WordCountBean> ObjectDataReceiver(int port) {

		try {

			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			// socket.setKeepAlive(true);

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			// logger.info("incoming data");
			try {
				// 객체 직렬활를 이용한 입력
				// 파일 서버로 부터 정보를 받는다. 리스트 객체를 직렬화를 통해 소켓으로 받음

				ObjectData od = (ObjectData) ois.readObject();
				list = (ArrayList<WordCountBean>) od.getRsList();

				Thread.sleep(50);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			serverSocket.close();

		} catch (IOException e) {

		} finally {

		}
		return list;
	}

}
