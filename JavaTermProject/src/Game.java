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
	Monsterball myFirstMonsterBall = new Monsterball();
	
	//������ ������ �Լ�
	void takeTravel() {
		for(int i = 3 ; i>0; i--) {			
			System.out.printf("%d��...\n", i);  //sleep �Լ��� �̿��� �ð��� �帧�� ǥ��
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		Poketmon randomMonster = selectRandomMonster(); //selectRandomMonster() �޼ҵ带 ȣ���ϸ� ������ ���ϸ� ��ü�� ��ȯ��.
		gofightPrint(randomMonster);                    //gofightPrint()�޼ҵ带 ȣ���ϸ鼭 ���ڷ� �������� ������ ���ϸ��� ���� �ѱ��.
	}
	
	void gofightPrint(Poketmon randomMonster) {
		while(true) {
			System.out.println("1.���� 2.����ġ�� 3.���濭��");
			System.out.println("==============================================");
			System.out.print(">>");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.println("==============================================");
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
				int num = inventory.checkMyInventory(randomMonster, this); //���ϸ� ������ while�� Ż��.
				if(num == 1) break;
			}
			else {
				System.out.println("1�Ǵ� 2�Ǵ� 3�� �����ּ���!");
			}			
		}
	}
	
	int throwPoketmonBall(Poketmon randomMonster){
		int num = generateRandomNumber("r");
		int per = randomMonster.initial_hp / 100; //1%�� �ǹ�
		System.out.println("==============================================");
		System.out.println("���� ���ͺ���!!!!!");
		//System.out.printf("������ Ȯ�� : %d\n\n\n", inventory.myPoketmonlist.size());
		--inventory.numofmonsterball; //�ϴ� ���ͺ� �ϳ� ����.
		
		int ballnumber = inventory.listIsEmpty(); //myPoketmonlist�� null���� ���� ã�Ƽ� ��ȯ. ����, �� �������� ������ ��ȯ.
		Monsterball b = inventory.myPoketmonlist.get(ballnumber);  //myPoketmonlist���� ���ͺ��� �ϳ� �����鼭
		if(ballnumber == inventory.myPoketmonlist.size() || inventory.numofmonsterball<=0) {
			System.out.println("�� �̻� ����� �� �ִ� ���ͺ��� �����ϴ�.");
		}
			
		if(randomMonster.hp > randomMonster.initial_hp/2) {  //ü���� 50%�̻��϶�
			System.out.println("ü���� �� ����ּ���...");
			inventory.myPoketmonlist.remove(inventory.myPoketmonlist.size()-1); //���� �� ��� ����
			return 0;
		} else{                                    
			if(randomMonster.hp >= per * 30 && randomMonster.hp< per * 50) { //30~50%
				if(num<=30 && num>=1) {
					System.out.println("�� ������!!!"); 
					myPoketmon.hp=myPoketmon.initial_hp;
					randomMonster.hp = randomMonster.initial_hp;
					b.p=randomMonster;
					return 1;
				} else {
					System.out.println("���ϸ��� ���� �ʾҴ�...");
					if(ballnumber != inventory.myPoketmonlist.size()) {
						inventory.myPoketmonlist.remove(inventory.myPoketmonlist.size()-1); //���� �� ��� ����
						//System.out.printf("������ Ȯ�� : %d\n\n\n", inventory.myPoketmonlist.size());
					}
					return 0; 
				}
			}else if(randomMonster.hp >= per * 10 && randomMonster.hp < per * 30) {//10~30%
				if(num<=60 && num>=1) {
					System.out.println("�� ������!!!"); 
					myPoketmon.hp=myPoketmon.initial_hp;
					randomMonster.hp = randomMonster.initial_hp;
					b.p=randomMonster;
					
					return 1;
					}
				else {
					System.out.println("���ϸ��� ���� �ʾҴ�...");
					//--inventory.numofmonsterball;
					if(ballnumber != inventory.myPoketmonlist.size()) {
						inventory.myPoketmonlist.remove(inventory.myPoketmonlist.size()-1); //���� �� ��� ����
						//System.out.printf("������ Ȯ�� : %d\n\n\n", inventory.myPoketmonlist.size());
					}
					return 0; 
					}
			}else if(randomMonster.hp > 0 && randomMonster.hp < per * 10) {//0~10%
				if(num<=90 && num>=1) {
					System.out.println("�� ������!!!"); 
					myPoketmon.hp=myPoketmon.initial_hp;
					randomMonster.hp = randomMonster.initial_hp;
					b.p=randomMonster;
					return 1;
					}
				else {
					System.out.println("���ϸ��� ���� �ʾҴ�...");
					//--inventory.numofmonsterball;
					if(ballnumber != inventory.myPoketmonlist.size()) {
						inventory.myPoketmonlist.remove(inventory.myPoketmonlist.size()-1); //���� �� ��� ����
						//System.out.printf("������ Ȯ�� : %d\n\n\n", inventory.myPoketmonlist.size());
					}
					return 0; 
					}
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
		} else if(randomMonster.hp < randomMonster.initial_hp/4) {   
			if(num<=90 && num>=1) {System.out.println("����ġ�⿡ �����߽��ϴ�."); return 1;}
			else {System.out.println("����ġ�⿡ ���� �߽��ϴ�."); return 0;}
		} else {
			System.out.println("����ġ�⿡ ���� �߽��ϴ�.");
			return 0;
		}
		
	}
	
	int gofight(Poketmon randomMonster) {
		if(myPoketmon.hp<=0 || randomMonster.hp<=0) {
			System.out.printf("%s�� �׾����ϴ�...", (myPoketmon.hp <= 0) ? "��" : "���");
			myPoketmon.hp=myPoketmon.initial_hp; //�� ���ϸ��� ������ ü�� �ʱ�ȭ.
			randomMonster.hp = randomMonster.initial_hp; //���浵 ü�� �ʱ�ȭ.
			System.out.println("������ �����մϴ�.");
			return 0;
		}
		else {			
			System.out.printf("[���� ü�� : %d][����� ü�� : %d]\n",myPoketmon.hp, randomMonster.hp);
			System.out.println("<���� ���� ����>");
			randomMonster.hp = randomMonster.hp - myPoketmon.attack;
			System.out.printf("������ ü���� %d ��ŭ ������ %d�� �ƽ��ϴ�.\n", myPoketmon.attack, randomMonster.hp);
			System.out.println("<����� ���� ����>");
			myPoketmon.hp = myPoketmon.hp - randomMonster.attack;
			System.out.printf("���� ü���� %d ��ŭ ������ %d�� �ƽ��ϴ�.\n", randomMonster.attack, myPoketmon.hp);
			return 1;
		}
	}
	
	//���� ���� ���� �޼ҵ�
	Poketmon selectRandomMonster() {
		int size = monster.size();                     //���� arrayList�� ����� ��ȯ�ް�
		int randnum = generateRandomNumber(size+"");   //����� ���ڰ����� �Ѱ��ָ� 0���� size������ ���� ���ڸ� ��ȯ�޴´�.
		Poketmon m = monster.get(randnum);             //���� arrayList���� ������ �����ѹ��� index�� ���� ��ü�� �ϳ� �̾ƿ´�.
		System.out.println("==============================================");
		System.out.printf("�߻��� ��Ĺ�� <%s>�� ��Ÿ����!\n", m.name);
		m.print();
		return m;                                      //ȣ���� ������ �������� ��ü�� ��ȯ���ش�.
	}
	
	public void goNewGame() {
		selectMyPoketmon(); // �� ���ϸ��� ���ϴ� �޼ҵ�
		while (true) {
			int select = takeTravelPrint(); // 1�Ǵ� 2�Ǵ� 3�� ��ȯ. (1�� ����)(2�� ����)(3�� ����)(4�� �κ��丮)
			if (select == 1) {
				takeTravel();
			} else if (select == 2) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if (select == 3) {
				shop.visitShop(inventory);
			} else if (select == 4){
				inventory.showMyInventory();
			} else if(select == 5) {
				searchPoketmon();
			} else if(select == 6) {
				System.out.println("���ϸ��� �� ���� �̻� ��ҽ��ϴ�. ���� �������� ���࿡ ���� �� �ֽ��ϴ�.");
				System.out.println("Good Bye!");
				break;
			}else
				System.out.println("1 �Ǵ� 2�Ǵ� 3�� �Է����ּ���.");
		}
	}

	void searchPoketmon(){
		while(true) {
			System.out.println("==============================================");
			System.out.println("1. �߻� ���ϸ� �˻�");
			System.out.println("2. ���� ���� ���ϸ� �˻�");
			System.out.println("3. ���� �˻�");
			System.out.println("4. �˻� ������");
			System.out.println("==============================================");
			System.out.print(">>");
			int select = scan.nextInt();
			
			if(select == 1) {
				System.out.println("<�̸� Ÿ�� ������ ü�� �� �ƹ��ų� �Է����ּ���>");
				System.out.print(">>");
				String kwd = scan.next();
				for(Poketmon p: monster)  //������ �߻� ���ϸ� �˻�
					if(p.match(kwd)) 
						p.print();
			} else if(select == 2) {
				System.out.println("<�̸� Ÿ�� ������ ü�� �� �ƹ��ų� �Է����ּ���>");
				System.out.print(">>");
				String kwd = scan.next();
				for(Monsterball b: inventory.myPoketmonlist)  //���� ���� ���ϸ� ��� �˻�
					if(b.match(kwd)) 
						b.print();
			} else if(select == 3) {
				int count = 0;
				System.out.println("<���� �̱� ���ɼ��� ���� ���͵��Դϴ�. �� ���͸� �����ŵ� ����ġ�� ������!>");  //���º�
				Monsterball m = inventory.myPoketmonlist.get(0); //�ָӴϿ��� ���ͺ��� ����.
				Poketmon my = m.p;  							//���ͺ����� ���ϸ��� ����.
				System.out.println("==============================================");
				System.out.println("ü���� ����");
				for(Poketmon p: monster) {  //������ �߻� ���ϸ� �˻�
					if(p.hp <= my.hp){    //�� ü���� ����� ü�º��� ������
						p.print();
						count++;
					}
				}
				System.out.printf("%d������ ������ ü���� �����ϴ�.\n", count);
				count = 0;
				System.out.println("==============================================");
				System.out.println("==============================================");
				System.out.println("������ ����");
				for(Poketmon p: monster) {  //������ �߻� ���ϸ� �˻�
					if(p.attack <= my.attack){ //�� ���ݷ��� ����� ���ݷº��� ������
						p.print();
						count++;
					}
				}
				System.out.printf("%d������ ������ ���ݷ��� �����ϴ�.\n", count);
				System.out.println("==============================================");
			}else if(select == 4)
				break;
		}
	}
	
	
	public int takeTravelPrint() {
		if(inventory.listIsEmpty()>2) //���� ���ϸ��� ���� ��ȯ
			return 6;
		System.out.println("==============================================");
		System.out.println("������ �����ðڽ��ϱ�?");
		System.out.println("1.�� 2.�ƴϿ� 3.�������� 4.�κ��丮���� 5.���ϸ� ���� �˻�"); // 1���ý� ������ ����. 2���ý� ���忩�θ� ���. 3���ý� ���ͺ��ϰ� ������� �� �� ����.
		System.out.println("==============================================");
		while (true) {
			System.out.print(">>");
			int select = scan.nextInt();
			if (select > 0 && select < 6)
				return select;
			else
				System.out.println("1 �Ǵ� 2 �Ǵ� 3 �Ǵ� 4 �Ǵ� 5�� �Է����ּ���.");
		}
	}

	public void selectMyPoketmon() {
		System.out.println("��� ���ϸ��� ���ðڽ��ϱ�?\n 1.���̸� 2.�̻��ؾ� 3.���α�");
		System.out.print(">>");
		while (true) {
			int select = scan.nextInt();
			if (select == 1) {
				myPoketmon = new Poketmon("���̸�", "��", generateRandomNumber("attack"), generateRandomNumber("hp"));
				myFirstMonsterBall.p = myPoketmon;   //������ �����ϸ� ���ʷ� �־��� ���ͺ��� ���� ������ ���ϸ��� ����ִ´�.
				inventory.myPoketmonlist.add(myFirstMonsterBall); //�׸��� �� ���ͺ��� �� �κ��丮�� myPoketmonlist�� ����ִ´�.
				break;
			} else if (select == 2) {
				myPoketmon = new Poketmon("�̻��ؾ�", "Ǯ", generateRandomNumber("attack"), generateRandomNumber("hp"));
				myFirstMonsterBall.p = myPoketmon;
				inventory.myPoketmonlist.add(myFirstMonsterBall);
				break;
			}
			else if (select == 3) {
				myPoketmon = new Poketmon("���α�", "��", generateRandomNumber("attack"), generateRandomNumber("hp"));
				myFirstMonsterBall.p = myPoketmon;
				inventory.myPoketmonlist.add(myFirstMonsterBall);
				break;
			} else
				System.out.println("1 �Ǵ� 2 �Ǵ� 3�� �Է����ּ���.");
		}
		System.out.println("==============================================");
		System.out.println("���� ������ ���ϸ���!!!");
		myPoketmon.print();
		System.out.println("==============================================");
		System.out.println();
	}

	public int generateRandomNumber(String type) {
		if (type.equals("hp")) {
			return (int) (Math.random() * 500) + 500; // 500~999������ ��������
		} else if(type.equals("attack")){
			return (int) (Math.random() * 50) + 200; // 200~249������ ��������
		} else if(type.equals("r")) {
			return (int) (Math.random() * 100);
		}else {
			int size = Integer.parseInt(type);
			return (int) (Math.random() * size);
		}
	}

	public void init() {
		System.out.println("���ϸ���");
		System.out.println("press enter key to start");
		scan.nextLine();
		readMonster(); // ������ ������ �����鼭 ������ ���͵��� �о���� �޼ҵ�
		//printMonster(); //�������� ������ ���ϸ���� ����Ʈ
		inventory = new Inventory(20000); // �����ϱ� ������ �ϴ� �κ��丮 �����ְ� ����
	}

	public void readMonster() {
		Scanner filein = openFile("C:\\Users\\taewoo\\Desktop\\�ڹ�\\�ڹ� ������Ʈ ���ȼ�\\poketmon_list.txt");

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
