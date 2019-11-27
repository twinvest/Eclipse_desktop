package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;       //���� ���۸��� ���� �ν��Ͻ�.
	private Graphics screenGraphic; //���� ���۸��� ���� �ν��Ͻ�2. 
	                                //�׳� �ڹٿ��� �����ϴ� �̹��� �о���̴� ������δ� �ʹ� ����. 
	                                //���� ������۸� ���α׷��� ����� �̿�. ������۸��̶� ���� ȭ�鿡 ũ�⿡ �´� �̹����� �ż������� �����ؼ� ����ϴ� ���. ��, ���ۿ� �̹����� ��� �ż������� ����.
	
	private Image �䳢; //�츮�� �Ʊ� �����Դ� �̹����� �������� ��ü.
	
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //��ü ����â�� ũ�⸦ 1280 720���� �����.
		setResizable(false); //�ѹ� ������� â�� ������ �� ����.
		setLocationRelativeTo(null); //���������� ����â ���߾ӿ� �߰��ϱ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ���������� ��ü���α׷� ����. �̰� �ȳ־��ָ� ����â������ ��ǻ�� ���������� ���α׷��� ��� ���ư��Ե�.
		setVisible(true); //�⺻���� false �̰� true�� �ϹǷν� �츮�� ��������� ȭ�鿡 ��µ� �� �ְԲ� ����.
		
	    
		�䳢 = new ImageIcon(Main.class.getResource("../images/�䳢.jpg")).getImage(); //������.
		
		//���� Ŭ������ ��ġ�� ��������ؼ� �䳢.jpg��� �̹��� ������ ������(getResource�޼ҵ�), �װ��� �̹��� �ν��Ͻ���(getImage�޼ҵ�) �䳢��� �̹��� �������ٰ� �ʱ�ȭ.
		
		Music introMusic = new Music("DONii - �䰭�� 2 (Feat. Hollow Chic.k).mp3", true);
		introMusic.start();
		
	} 
	
	public void paint(Graphics g) {                                           //�ϳ��� ��ӵ� �޼ҵ�, paint�޼ҵ�� jFrame�� ��ӹ��� �̷��� gui���ӿ��� ���� ù��°�� ȭ���� �׷��ִ� �Լ�.
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);     //���� ���� ���� screenImage������ �־���.
		screenGraphic = screenImage.getGraphics();                              //scrrenImage�� �̿��ؼ� �׷��Ⱦ��ͼ� screenGraphic������ �־���.
		screenDraw(screenGraphic);                                           //screenDraw�� �츮�� ���� ����.
		g.drawImage(screenImage, 0, 0, null);                                //screenImage�� 0,0��ǻ�� �߾ӿ� drawImage�� ���� ȣ��.
	}
	
	public void screenDraw(Graphics g) {    
		g.drawImage(�䳢, 0, 0, null);          //�䳢�� 0,0��ġ�� �׷���
		this.repaint();                      //repaint�� ��üȭ�� �̹����� �ż������� ���α׷��� ����Ǵ� �������� ��� �Դٰ����ϸ鼭 �׷��ִ°�.
	}

}
