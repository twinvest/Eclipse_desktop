import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class Samsung {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test_case;
		test_case = scan.nextInt();
		for (int k = 0; k < test_case; k++) 
		{

			LinkedList<String> list = new LinkedList<String>();
			int num;
			num = scan.nextInt();

			for (int i = 0; i < num; i++) {
				String input;
				input = scan.next();
				if (list.isEmpty()) {
					list.addFirst(input);
					// System.out.println(list.peek());
				} else if (input.compareTo(list.element()) >= 0)// ��� ���ڿ� (�޼��尡 ȣ��� ���ڿ�)�� �Ű������� ���� ���ڿ����� ���������� ���� ��� �����
																// ��ȯ.
				{
					list.addFirst(input);
					// System.out.println(list.peek());
				} else if (input.compareTo(list.element()) < 0) // ����ڿ�(�޼ҵ尡 ȣ��� ���ڿ�)�� �Ű������� ���� ���ڿ����� ���� ������ �ռ� ��� ������
																// ��ȯ.
				{
					list.addLast(input);
					// System.out.println(list.peek());
				}

			}
			
			while (!list.isEmpty()) {
				System.out.print(list.remove() + " ");
			}
			
		}

	}
}
