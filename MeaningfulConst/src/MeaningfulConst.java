import java.util.Scanner;

public class MeaningfulConst {

	public static void main(String[] args) {
		System.out.println("������ ������ �����ϼ���. ");
		System.out.println("1.������, 2.ȭ����, 3.������, 4.����� ");
		System.out.println("5.�ݿ���, 6.�����, 7.�Ͽ��� ");
		System.out.println("���� : ");
		
		Scanner sc=new Scanner(System.in);
		int sel=sc.nextInt();
		
		
		switch(sel)
		{
		case Week.MON :
			System.out.println("�ְ�ȸ�ǰ� �ֽ��ϴ�.");
			break;
		case Week.TUE :
			System.out.println("������Ʈ ��ȹ ȸ�ǰ� �ֽ��ϴ�.");
			break;
		case Week.WED :
			System.out.println("������� �����ϴ� ���Դϴ�.");
			break;
		case Week.THU :
			System.out.println("�系�౸������ �ִ� ���Դϴ�.");
			break;
		case Week.FRI :
			System.out.println("������Ʈ �������Դϴ�.");
			break;
		case Week.SAT :
			System.out.println("������ �Բ� ��ſ� �ð��� ��������.");
			break;
		case Week.SUN :
			System.out.println("������ �����Դϴ�.");
			break;
		}
		
	}

}
