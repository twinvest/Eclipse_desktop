package �ڹ���������Ʈ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Poketmon> monster = new ArrayList<>();
	Poketmon myPoketmon;
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.mymain();
	}

	void mymain() {
		readMonster(); // ������ ������ �����鼭 ������ ���͵��� �о���� �޼ҵ�
		// printMonster();
		int choiceNumber = init(); // ù ����� �ʱ�ȭ ���� �� ��� �ؽ�Ʈ. �� �� 1�Ǵ� 2�� ��ȯ�ϴµ� 1�� �����ϱ⸦ �ǹ�. 2�� �̾��ϱ⸦ �ǹ�.
		if (choiceNumber == 1)
			goNewGame(); // 1�̸� �����ϱ�.
		else
			goStoredGame(); // 2�̸� ����� �����ϱ�.
	}

	void goNewGame() {
		selectMyPoketmon(); // �� ���ϸ��� ���ϴ� �޼ҵ�
		int select = takeTravel(); // 1�Ǵ� 2�Ǵ� 3�� ��ȯ. (1�� ����)(2�� ���� �� ���忩�μ���)(3�� ����)
		if(select == 1) {
			
		}
		else if(select == 2) {
			
		}
		else {
			
		}
	}

	void goStoredGame() {

	}

	int takeTravel() {
		System.out.println("������ �����ðڽ��ϱ�?");
		System.out.println("1.�� 2.�ƴϿ� 3.��������"); // 1���ý� ������ ����. 2���ý� ���忩�θ� ���. 3���ý� ���ͺ��ϰ� ������� �� �� ����.
		while (true) {
			int select = scan.nextInt();
			if (select == 1)
				return 1;
			else if (select == 2)
				return 2;
			else if (select == 3)
				return 3;
			else
				System.out.println("1 �Ǵ� 2�Ǵ� 3�� �Է����ּ���.");
		}
	}

	void selectMyPoketmon() {
		System.out.println("��� ���ϸ��� ���ðڽ��ϱ�?\n 1.���̸� 2.�̻��ؾ� 3.���α�");
		System.out.print(">>");
		while (true) {
			int select = scan.nextInt();
			if (select == 1) {
				myPoketmon = new Poketmon("���̸�", "��", generateRandomNumber("attack"), generateRandomNumber("hp"));
				break;
			}

			else if (select == 2) {
				myPoketmon = new Poketmon("�̻��ؾ�", "Ǯ", generateRandomNumber("attack"), generateRandomNumber("hp"));
				break;
			}

			else if (select == 3) {
				myPoketmon = new Poketmon("���α�", "��", generateRandomNumber("attack"), generateRandomNumber("hp"));
				break;
			} else
				System.out.println("1 �Ǵ� 2 �Ǵ� 3�� �Է����ּ���.");
		}
		System.out.println("=================");
		System.out.println("���� ���ϸ���!!!");
		myPoketmon.print();
		System.out.println("=================");
		System.out.println();
	}

	int generateRandomNumber(String type) {
		if (type.equals("hp")) {
			return (int) (Math.random() * 500) + 500; // 500~999������ ��������
		} else {
			return (int) (Math.random() * 50) + 100; // 100~149������ ��������
		}
	}

	int init() {
		System.out.println("���ϸ���");
		System.out.println("press enter key to start");
		scan.nextLine();
		System.out.println("1. �����ϱ�");
		System.out.println("2. �̾��ϱ�");
		while (true) {
			int select = scan.nextInt();
			if (select == 1)
				return 1;
			else if (select == 2)
				return 2;
			else
				System.out.println("1 �Ǵ� 2�� �Է����ּ���.");
		}

	}

	void readMonster() {
		Scanner filein = openFile("C:\\Users\\taewoo\\Desktop\\�ڹ�\\�ڹ� ������Ʈ ���ȼ�\\poketmon_list.txt");

		while (filein.hasNext()) {
			Poketmon poketmon = new Poketmon();
			poketmon.read(filein);
			monster.add(poketmon);
		}
		filein.close();
	}

	void printMonster() {
		for (Poketmon p : monster) {
			p.print();
		}
	}

	Scanner openFile(String filename) {
		File f = new File(filename);
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return s;
	}

}
