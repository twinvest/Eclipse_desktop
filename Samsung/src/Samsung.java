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
				} else if (input.compareTo(list.element()) >= 0)// 대상 문자열 (메서드가 호출된 문자열)이 매개변수로 받은 문자열보다 사전순으로 뒤질 경우 양수를
																// 반환.
				{
					list.addFirst(input);
					// System.out.println(list.peek());
				} else if (input.compareTo(list.element()) < 0) // 대상문자열(메소드가 호출된 문자열)이 매개변수로 받은 문자열보다 사전 순으로 앞선 경우 음수를
																// 반환.
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
