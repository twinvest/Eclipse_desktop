import java.util.Random;

public class Print {

	public static void main(String[] args) {
		System.out.println("--");
		System.out.println("�ִ����� : "+Integer.MAX_VALUE);
		
		Random rand=new Random(1);//���尪 1
		
		for(int i=0; i<10; i++)
			System.out.println(rand.nextInt(100)); //0~100������ 10���� ��¥����.
		
		
		System.out.println(System.currentTimeMillis());// 1970����� ��ǻ���� ����ð� �и���
		System.out.println(Math.random()); //MathŬ������ ���� ���� �޼ҵ� random
		

		

	}

}
