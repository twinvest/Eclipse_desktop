package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //��ü ����â�� ũ�⸦ 1280 720���� �����.
		setResizable(false); //�ѹ� ������� â�� ������ �� ����.
		setLocationRelativeTo(null); //���������� ����â ���߾ӿ� �߰��ϱ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ���������� ��ü���α׷� ����. �̰� �ȳ־��ָ� ����â������ ��ǻ�� ���������� ���α׷��� ��� ���ư��Ե�.
		setVisible(true); //�⺻���� false �̰� true�� �ϹǷν� �츮�� ��������� ȭ�鿡 ��µ� �� �ְԲ� ����.
	}

}
