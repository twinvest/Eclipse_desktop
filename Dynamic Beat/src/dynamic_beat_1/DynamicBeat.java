package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //전체 게임창의 크기를 1280 720으로 만들기.
		setResizable(false); //한번 만들어진 창은 조절할 수 없음.
		setLocationRelativeTo(null); //실행했을때 게임창 정중앙에 뜨게하기.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료했을때 전체프로그램 종료. 이걸 안넣어주면 게임창을꺼도 컴퓨터 내부적으로 프로그램이 계속 돌아가게됨.
		setVisible(true); //기본값은 false 이걸 true로 하므로써 우리가 만든게임이 화면에 출력될 수 있게끔 해줌.
	}

}
