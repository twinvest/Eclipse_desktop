import java.util.Scanner;

public class Shop {
	Scanner scan = new Scanner(System.in);
	Monsterball ball;
	int potion = Integer.MAX_VALUE;
	
	public void visitShop(Inventory inventory) {
		while (true) {
			System.out.println();
			System.out.println("==============================================");
			System.out.println("item list");
			System.out.printf("���� ���� �ݾ� : %d\n", inventory.money);
			System.out.printf("���� ��밡���� ���ͺ� : %d\n", inventory.numofmonsterball);
			System.out.printf("���� ��밡���� ȸ������ : %d\n", inventory.numofpotion);
			System.out.println("==============================================");
			
			System.out.println("� �������� ��ðڽ��ϱ�?");
			System.out.println("1. ���ͺ� 1000��");
			System.out.println("2. ȸ������ 2500��");
			System.out.println("3. ����  ������");
			System.out.print(">>");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("���ͺ� �� ���� �����Ͻðڽ��ϱ�?");
				int num = scan.nextInt();
				System.out.printf("%d���� ���� �����Ͻðڽ��ϱ�?(y/n)", num);
				String choice = scan.next();
				if (choice.equals("y") && inventory.money - 1000 * num >= 0) {
					inventory.money = inventory.money - 1000 * num;
					inventory.numofmonsterball = inventory.numofmonsterball + num;  
					for (int i = 0; i < num; i++) {
						Monsterball ball = new Monsterball();
						inventory.myPoketmonlist.add(ball);
					}
					System.out.println("���ſ� �����߽��ϴ�.");
				} else if (choice.equals("n")) {
					System.out.println("���Ÿ� ��� �߽��ϴ�.");
				} else if (inventory.money - 1000 * num < 0) {
					System.out.println("�ݾ��� ���ڸ��ϴ�.");
				}
			} else if (select == 2) {
				System.out.print("���� �� ���� �����Ͻðڽ��ϱ�?");
				int num = scan.nextInt();
				System.out.printf("%d���� ���� �����Ͻðڽ��ϱ�?(y/n)", num);
				String choice = scan.next();
				if (choice.equals("y") && inventory.money - 2500 * num >= 0) {
					inventory.money = inventory.money - 2500 * num;
					inventory.numofpotion = inventory.numofpotion + num;
					System.out.println("���ſ� �����߽��ϴ�.");
				} else if (choice.equals("n")) {
					System.out.println("���Ÿ� ��� �߽��ϴ�.");
				} else if (inventory.money - 2500 * num < 0) {
					System.out.println("�ݾ��� ���ڸ��ϴ�.");
				}
			} else if (select == 3) {
				System.out.println("������ �����ϴ�.");
				break;
			} else {
				System.out.println("1 �Ǵ� 2�Ǵ� 3�� �Է����ּ���.");
			}
		}
	}
	
}