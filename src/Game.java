import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
	Shop shop = new Shop();
	Scanner scan = new Scanner(System.in);
	ArrayList<Poketmon> monster = new ArrayList<>();
	Poketmon myPoketmon;
	Inventory inventory;

	public void goShop() {
		while (true) {
			System.out.println("==================");
			System.out.printf("���� ���� �ݾ� : %d\n", inventory.money);
			System.out.printf("���� ���� ���ͺ� : %d\n", inventory.numofmonsterball);
			System.out.printf("���� ���� ȸ������ : %d\n", inventory.numofpotion);
			System.out.println("==================");
			System.out.println("� �������� ��ðڽ��ϱ�?");
			System.out.println("1. ���ͺ� 1000��");
			System.out.println("2. ȸ������ 2500��");
			System.out.println("3. ����  ������");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("���ͺ� �� ���� �����Ͻðڽ��ϱ�?");
				int num = scan.nextInt();
				System.out.printf("%d���� ���� �����Ͻðڽ��ϱ�?", num);
				if (scan.next().equals("y") && inventory.money - 1000 * num >= 0) {
					inventory.money = inventory.money - 1000 * num;
					inventory.numofmonsterball = inventory.numofmonsterball + num;  
					for (int i = 0; i < num; i++) {
						Monsterball ball = new Monsterball();
						inventory.list.add(ball);
					}
					System.out.println("���ſ� �����߽��ϴ�.");
				} else if (scan.next().equals("n")) {
					System.out.println("���Ÿ� ��� �߽��ϴ�.");
				} else if (inventory.money - 1000 * num < 0) {
					System.out.println("�ݾ��� ���ڸ��ϴ�.");
				}
			} else if (select == 2) {
				System.out.print("���� �� ���� �����Ͻðڽ��ϱ�?");
				int num = scan.nextInt();
				System.out.printf("%d���� ���� �����Ͻðڽ��ϱ�?", num);
				if (scan.next().equals("y") && inventory.money - 2500 * num >= 0) {
					inventory.money = inventory.money - 2500 * num;
					inventory.numofpotion = inventory.numofpotion + num;
					System.out.println("���ſ� �����߽��ϴ�.");
				} else if (scan.next().equals("n")) {
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
	
	void takeTravel() {
		for(int i = 3 ; i>0; i--) {			
			System.out.printf("%d��...\n", i);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		Poketmon randomMonster = selectRandomMonster();
		gofightPrint(randomMonster);
	}
	
	void gofightPrint(Poketmon randomMonster) {
		while(true) {
			System.out.println("1.���� 2.����ġ�� 3.���濭��");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.println("������ �����մϴ�!!!!");
				//0�̳� 1�̳� 2�� ��ȯ. 0�� ������ ������ �ǹ�. 1�� ���� �ο� �� ������ �ǹ�. 2�� �ٸ� ���ϸ��� �������� ���� �ǹ�.
				int num = gofight(randomMonster); 
				if(num == 0) break;
			}
			else if(select == 2) {
				int num = runaway(randomMonster); //1�̸� ���� 0�̸� ����
				if(num == 1) break;
			}
			else if(select == 3) {
				int num = checkMyInventory(randomMonster); //���ϸ� ������ while�� Ż��.
				if(num == 1) break;
			}
			else {
				System.out.println("1�Ǵ� 2�Ǵ� 3�� �����ּ���!");
			}			
		}
	}
	
	int checkMyInventory(Poketmon randomMonster){
		if(inventory.numofmonsterball <= 0 || inventory.numofpotion <= 0) {
			System.out.println("������ ������ϴ�.");
			return 0;
		}else {
			System.out.printf("1. ���� ��  x %d\n", inventory.numofmonsterball);
			System.out.printf("2. ȸ�� ����  x %d\n", inventory.numofpotion);
			System.out.println("� �������� ����Ͻðڽ��ϱ�?");
			int select = scan.nextInt();
			if(select == 1) {
				int num = throwPoketmonBall(randomMonster); //1�� ������ 0�� ��������
				if(num == 1) return 1;
				else return 0;
			} 				
			else if(select == 2) { drinkpotion(); return 0;}
			return 0;
		}
	}
	
	void drinkpotion() {
		int per = myPoketmon.initial_hp / 100;
		myPoketmon.hp = myPoketmon.hp + (per * 30); //30�ۼ�Ʈ ȸ��.
		inventory.numofpotion--;
	}
	
	int throwPoketmonBall(Poketmon randomMonster){
		int num = generateRandomNumber("r");
		int per = randomMonster.initial_hp / 100; //1%�� �ǹ�
		System.out.println("���� ���ͺ���!!!!!");	
		Monsterball b = inventory.list.get(--inventory.numofmonsterball);
		if(randomMonster.hp > randomMonster.initial_hp/2) {  //ü���� 50%�̻��϶�
			System.out.println("ü���� �� ����ּ���...");
			return 0;
		} else{                                    
			if(randomMonster.hp >= per * 30 && randomMonster.hp< per * 50) { //30~50%
				if(num<=30 && num>=1) {System.out.println("�� ������!!!"); return 1;}
				else {System.out.println("���ϸ��� ���� �ʾҴ�..."); return 0; }
			}else if(randomMonster.hp >= per * 10 && randomMonster.hp < per * 30) {//10~30%
				if(num<=60 && num>=1) {System.out.println("�� ������!!!"); return 1;}
				else {System.out.println("���ϸ��� ���� �ʾҴ�..."); return 0; }
			}else if(randomMonster.hp > 0 && randomMonster.hp < per * 10) {//0~10%
				if(num<=90 && num>=1) {System.out.println("�� ������!!!"); return 1;}
				else {System.out.println("���ϸ��� ���� �ʾҴ�..."); return 0; }
			}else {
				return 0;
			}
		}
	}
	
	int runaway(Poketmon randomMonster) {
		int num = generateRandomNumber("r");
		if(randomMonster.hp == randomMonster.initial_hp) { //������ ü���� �����϶��� 10%�� Ȯ���� ����ĥ �� ����.
			if(num<=10 && num>=1) {System.out.println("����ġ�⿡ �����߽��ϴ�."); return 1;}
			else {System.out.println("����ġ�⿡ ���� �߽��ϴ�."); return 0; }
		} else if(randomMonster.hp >= (randomMonster.initial_hp)/2 && randomMonster.hp < randomMonster.initial_hp) {
			if(num<=40 && num>=1) {System.out.println("����ġ�⿡ �����߽��ϴ�."); return 1;}
			else {System.out.println("����ġ�⿡ ���� �߽��ϴ�."); return 0;}
		} else if(randomMonster.hp >= (randomMonster.initial_hp)/4 && randomMonster.hp < randomMonster.initial_hp/2) {
			if(num<=70 && num>=1) {System.out.println("����ġ�⿡ �����߽��ϴ�."); return 1;}
			else {System.out.println("����ġ�⿡ ���� �߽��ϴ�."); return 0;}
		} else {   //if(randomMonster.hp < randomMonster.initial_hp/4)
			if(num<=90 && num>=1) {System.out.println("����ġ�⿡ �����߽��ϴ�."); return 1;}
			else {System.out.println("����ġ�⿡ ���� �߽��ϴ�."); return 0;}
		}
	}
	
	int gofight(Poketmon randomMonster) {
		if(myPoketmon.hp<=0 || randomMonster.hp<=0) {
			System.out.printf("%s�� �׾����ϴ�...", (myPoketmon.hp <= 0) ? "��" : "���");
			System.out.println("������ �����մϴ�.");
			return 0;
		}
		else {			
			System.out.printf("[���� ü�� : %d][����� ü�� : %d]\n",myPoketmon.hp, randomMonster.hp);
			System.out.println("���� ����!! �׾��");
			randomMonster.hp = randomMonster.hp - myPoketmon.attack;
			System.out.printf("������ ü���� %d ��ŭ ������ %d�� �ƽ��ϴ�.\n", myPoketmon.attack, randomMonster.hp);
			System.out.println("����� ����!! �� ������...");
			myPoketmon.hp = myPoketmon.hp - randomMonster.attack;
			System.out.printf("���� ü���� %d ��ŭ ������ %d�� �ƽ��ϴ�.\n", randomMonster.attack, myPoketmon.hp);
			return 1;
		}	
	}
	Poketmon selectRandomMonster() {
		int size = monster.size();
		int randnum = generateRandomNumber(size+"");
		Poketmon m = monster.get(randnum);
		System.out.printf("�߻��� ��Ĺ�� <%s>�� ��Ÿ����!\n", m.name);
		m.print();
		return m;
	}
	
	public void goNewGame() {
		selectMyPoketmon(); // �� ���ϸ��� ���ϴ� �޼ҵ�
		while (true) {
			int select = takeTravelPrint(); // 1�Ǵ� 2�Ǵ� 3�� ��ȯ. (1�� ����)(2�� ���� �� ���忩�μ���)(3�� ����)
			if (select == 1) {
				takeTravel();  //�� �κ� ��������
	
			} else if (select == 2) {
				System.out.println("���α׷��� �����մϴ�.");
			} else if (select == 3) {
				goShop();
			} else
				System.out.println("1 �Ǵ� 2�Ǵ� 3�� �Է����ּ���.");
		}
	}

	public void goStoredGame() {
		
	}

	public int takeTravelPrint() {
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

	public void selectMyPoketmon() {
		System.out.println("��� ���ϸ��� ���ðڽ��ϱ�?\n 1.���̸� 2.�̻��ؾ� 3.���α�");
		System.out.print(">>");
		while (true) {
			int select = scan.nextInt();
			if (select == 1) {
				myPoketmon = new Poketmon("���̸�", "��", generateRandomNumber("attack"), generateRandomNumber("hp"));
				break;
			} else if (select == 2) {
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

	public int generateRandomNumber(String type) {
		if (type.equals("hp")) {
			return (int) (Math.random() * 500) + 500; // 500~999������ ��������
		} else if(type.equals("attack")){
			return (int) (Math.random() * 50) + 100; // 100~149������ ��������
		} else if(type.equals("r")) {
			return (int) (Math.random() * 100);
		}else {
			int size = Integer.parseInt(type);
			return (int) (Math.random() * size);
		}
	}

	public int init() {
		System.out.println("���ϸ���");
		System.out.println("press enter key to start");
		scan.nextLine();
		System.out.println("1. �����ϱ�");
		System.out.println("2. �̾��ϱ�");
		while (true) {
			int select = scan.nextInt();
			if (select == 1) {
				inventory = new Inventory(10000); // �����ϱ� ������ �ϴ� �κ��丮 �����ְ� ����
				return 1;
			} else if (select == 2)
				return 2;
			else
				System.out.println("1 �Ǵ� 2�� �Է����ּ���.");
		}
	}

	public void readMonster() {
		Scanner filein = openFile("C:\\Users\\Administrator\\Documents\\īī���� ���� ����\\poketmon_list.txt");

		while (filein.hasNext()) {
			Poketmon poketmon = new Poketmon();
			poketmon.read(filein);
			monster.add(poketmon);
		}
		filein.close();
	}

	public void printMonster() {
		for (Poketmon p : monster) {
			p.print();
		}
	}

	public Scanner openFile(String filename) {
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
