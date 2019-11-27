import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	
	Scanner scan = new Scanner(System.in);
	int money;
	int numofmonsterball;
	int numofpotion;
	ArrayList<Monsterball> myPoketmonlist = new ArrayList<>();
	Inventory(){};
	Inventory(int money){this.money = money;}
		
	int listIsEmpty() {
		int i = -1;
		for(Monsterball b : myPoketmonlist) {
			i++;
			if(b.isEmpty()) return i; //���� ���� ��ȯ.
		}
		return myPoketmonlist.size(); //��á��.
	}
	
	void showMyInventory() {
		System.out.println("==============================================");
		System.out.printf("���� �����ϰ� �ִ� �� : %d\n", money);
		System.out.printf("���� ��밡���� ���ͺ� : %d\n", numofmonsterball);
		System.out.printf("���� ��밡���� ���� : %d\n", numofpotion);
		System.out.println("���� ������ ���ͺ� ����");
		
		for(Monsterball p : myPoketmonlist) { //���ͺ��� ����ִ� ���ϸ���� �������.
			p.print();
		}
		System.out.println("==============================================");
	}
	
	int checkMyInventory(Poketmon randomMonster, Game game){
		if(this.numofmonsterball <= 0 && this.numofpotion <= 0) {
			System.out.println("������ ������ϴ�.");
			return 0;
		}else {
			System.out.printf("1. ���� ��  x %d\n", this.numofmonsterball);
			System.out.printf("2. ȸ�� ����  x %d\n", this.numofpotion);
			System.out.println("� �������� ����Ͻðڽ��ϱ�?");
			System.out.println("==============================================");
			System.out.println(">>");
			int select = scan.nextInt();
			if(select == 1) {
				int num = game.throwPoketmonBall(randomMonster); //1�� ������ 0�� ��������
				if(num == 1) return 1;
				else return 0;
			} 				
			else if(select == 2) { drinkpotion(game); return 0;}
			return 0;
		}
	}
	
	void drinkpotion(Game game) {
		int per = game.myPoketmon.initial_hp / 100;
		game.myPoketmon.hp = game.myPoketmon.hp + (per * 30); //30�ۼ�Ʈ ȸ��.
		this.numofpotion--;
	}
	
}