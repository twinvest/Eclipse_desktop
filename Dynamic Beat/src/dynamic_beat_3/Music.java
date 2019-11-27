package dynamic_beat_3;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	
	private Player player; //�츮�� ���� �ڹٶ��̺귯��
	private boolean isLoop; //�츮�� ���� ���� ���ѹݺ� �ǰԲ�.
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { //������, ���� ����� �� �ش���� ���ѹݺ������� ���ڷ� ����.
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
	
	public int getTime() { //�޼ҵ� �߰�, ���� ����ǰ� �ִ� ������ � ��ġ���� ����Ǵ��� �˷��ִ� �޼ҵ�
		if(player==null)
			return 0;
		
		return player.getPosition();
	}
	
	public void close() { //�׻� �����Ҽ��ֵ��� �����ִ� �޼ҵ�. ��̰� ��� �ٸ������� �ٲܶ� �ڷΰ��� ��ư�� ������ close�޼ҵ带 �����Ű�鼭 ������.
		isLoop = false;
		player.close();
		this.interrupt(); //�ش� �����带 �������·�. ������� �ϳ��� ���� ���α׷�. �� ��� ���� ���α׷��� �����Ѵٰ� ��������.
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
