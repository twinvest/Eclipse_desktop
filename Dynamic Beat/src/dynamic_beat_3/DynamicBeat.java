package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;       //더블 버퍼링을 위한 인스턴스.
	private Graphics screenGraphic; //더블 버퍼링을 위한 인스턴스2. 
	                                //그냥 자바에서 제공하는 이미지 읽어들이는 방식으로는 너무 느림. 
	                                //따라서 더블버퍼링 프로그래밍 기법을 이용. 더블버퍼링이란 현재 화면에 크기에 맞는 이미지를 매순간마다 생성해서 출력하는 방법. 즉, 버퍼에 이미지를 담아 매순간마다 갱신.
	
	private Image 토끼; //우리가 아까 가져왔던 이미지를 담으려는 객체.
	
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //전체 게임창의 크기를 1280 720으로 만들기.
		setResizable(false); //한번 만들어진 창은 조절할 수 없음.
		setLocationRelativeTo(null); //실행했을때 게임창 정중앙에 뜨게하기.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료했을때 전체프로그램 종료. 이걸 안넣어주면 게임창을꺼도 컴퓨터 내부적으로 프로그램이 계속 돌아가게됨.
		setVisible(true); //기본값은 false 이걸 true로 하므로써 우리가 만든게임이 화면에 출력될 수 있게끔 해줌.
		
	    
		토끼 = new ImageIcon(Main.class.getResource("../images/토끼.jpg")).getImage(); //생성자.
		
		//메인 클래스의 위치를 기반으로해서 토끼.jpg라는 이미지 파일을 얻어오고(getResource메소드), 그것의 이미지 인스턴스를(getImage메소드) 토끼라는 이미지 변수에다가 초기화.
		
		Music introMusic = new Music("DONii - 토강송 2 (Feat. Hollow Chic.k).mp3", true);
		introMusic.start();
		
	} 
	
	public void paint(Graphics g) {                                           //하나의 약속된 메소드, paint메소드는 jFrame을 상속받은 이러한 gui게임에서 가장 첫번째로 화면을 그려주는 함수.
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);     //높이 넓이 만들어서 screenImage변수에 넣어줌.
		screenGraphic = screenImage.getGraphics();                              //scrrenImage를 이용해서 그래픽얻어와서 screenGraphic변수에 넣어줌.
		screenDraw(screenGraphic);                                           //screenDraw는 우리가 직접 만듦.
		g.drawImage(screenImage, 0, 0, null);                                //screenImage를 0,0컴퓨터 중앙에 drawImage를 통해 호출.
	}
	
	public void screenDraw(Graphics g) {    
		g.drawImage(토끼, 0, 0, null);          //토끼를 0,0위치에 그려줌
		this.repaint();                      //repaint는 전체화면 이미지를 매순간마다 프로그램이 종료되는 순간까지 계속 왔다갔다하면서 그려주는것.
	}

}
