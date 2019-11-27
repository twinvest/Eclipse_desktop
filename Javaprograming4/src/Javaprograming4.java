///////////////////////////////////////////////////////////////////////////////
// Title : Javaprograming4
// Files : Javaprograming4.java
// Semester : 2019-1�б�
//
// Author : ���¿�/ twinvest@naver.com
// Class : ��123
//// �ۼ��� : 2019-03-29 
// Ű����: �迭��ü
//
// �������� : �迭��ü�� ���� ���� �� Ŭ������ ���� 
// �����ϼ����� : �ϼ�
// �̿ϼ���� : ����
///////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Javaprograming4 {
	boolean wrong = false;
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Javaprograming4 java = new Javaprograming4();
		java.mymain();
	}

	void mymain() {
		int numOfproduct = scan.nextInt();
		Product[] list = new Product[numOfproduct];

		Read(list, numOfproduct);
		Print(list, numOfproduct);
		
		while(true) {
			int[] check = Check(numOfproduct);
			if(wrong == false)
				PrintOrder(list, check, numOfproduct);
			wrong = false;
		}
	}

	String isMan(char gender) {
		String gen;
		if (gender == 'f') {
			gen = "Woman";
			return gen;
		}
		if (gender == 'c') {
			gen = "Common";
			return gen;
		}
		gen = "Man";
		return gen;
	}

	void Read(Product[] list, int numOfproduct) {
		for (int i = 0; i < numOfproduct; i++) {
			list[i] = new Product();
			list[i].setProductName(scan.next());
			list[i].setProductPrice(scan.nextInt());
			list[i].setTypeOfProduct(scan.next().trim().charAt(0));
		}
	}

	void Print(Product[] list, int numOfproduct) {
		System.out.println();
		System.out.println("=========== ��ǰ����Ʈ ==============");
		for (int i = 0; i < numOfproduct; i++) {
			System.out.printf("[ %d] ", i + 1);
			System.out.print(list[i].getProductName() + " ");
			System.out.printf("[%s] ", isMan(list[i].getTypeOfProduct()));
			System.out.print(list[i].getProductPrice() + "��");
			System.out.println();
		}
	}

	int[] Check(int numOfproduct) {
		int index = 0;
		System.out.println();
		System.out.print(">>");
		int[] check = new int[numOfproduct];
		while (true) {
			check[index++] = scan.nextInt(); // �Է¹ޱ�
			if (check[index - 1] > numOfproduct) { // �߸��� ��ȣ�� ����
				System.out.printf("%d�� �߸��� ��ȣ�Դϴ�...\n", check[index - 1]);
				wrong = true;
			}
			if (check[0] == 0) { // ù��° ���� 0�̸� ����
				System.out.println("Bye!");
				System.exit(0);
			}
			if (check[index - 1] == 0) { // �߸��� ��ȣ�� ���� ù��° ���� 0�� �ƴϸ鼭 �ε����� 0�� ��� Ż��.
				break;
			}
		}
		return check;
	}

	void PrintOrder(Product[] list, int[] check, int numOfproduct) {
		int sum = 0;
		int index = 0;
		System.out.println("�ֹ��� ��ǰ:");
		while (true) {
			int i = check[index++];
			if (check[index - 1] == 0)
				break;
			System.out.print(list[i - 1].getProductName() + " ");
			System.out.printf("[%s] ", isMan(list[i - 1].getTypeOfProduct()));
			System.out.print(list[i - 1].getProductPrice() + "��");
			System.out.println();
			sum = sum + list[i - 1].getProductPrice();
		}
		System.out.printf("�հ� : %d��\n", sum);
	}
}