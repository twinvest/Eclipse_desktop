package dynamic_beat_3;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	
	private Player player; //우리가 받은 자바라이브러리
	private boolean isLoop; //우리가 받은 곡이 무한반복 되게끔.
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { //생성자, 곡의 제목과 그 해당곡이 무한반복인지를 인자로 전달.
		try {
			this.isLoop=isLoop;
			file = new File(Main.class.getResource("../music/"+ name).toURI()); 
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	} 
	
	public int getTime() { //메소드 추가, 현재 실행되고 있는 음악이 어떤 위치에서 실행되는지 알려주는 메소드
		if(player==null)
			return 0;
		
		return player.getPosition();
	}
	
	public void close() { //항상 종료할수있도록 도와주는 메소드. 재미가 없어서 다른곡으로 바꿀때 뒤로가기 버튼을 누르면 close메소드를 실행시키면서 곡종료.
		isLoop = false;
		player.close();
		this.interrupt(); //해당 쓰레드를 중지상태로. 쓰레드는 하나의 작은 프로그램. 곡 재생 작은 프로그램을 중지한다고 이해하자.
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
