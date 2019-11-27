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
			System.out.printf("현재 소유 금액 : %d\n", inventory.money);
			System.out.printf("현재 소유 몬스터볼 : %d\n", inventory.numofmonsterball);
			System.out.printf("현재 소유 회복물약 : %d\n", inventory.numofpotion);
			System.out.println("==================");
			System.out.println("어떤 아이템을 사시겠습니까?");
			System.out.println("1. 몬스터볼 1000원");
			System.out.println("2. 회복물약 2500원");
			System.out.println("3. 상점  나가기");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("몬스터볼 몇 개를 구매하시겠습니까?");
				int num = scan.nextInt();
				System.out.printf("%d개를 정말 구매하시겠습니까?", num);
				if (scan.next().equals("y") && inventory.money - 1000 * num >= 0) {
					inventory.money = inventory.money - 1000 * num;
					inventory.numofmonsterball = inventory.numofmonsterball + num;  
					for (int i = 0; i < num; i++) {
						Monsterball ball = new Monsterball();
						inventory.list.add(ball);
					}
					System.out.println("구매에 성공했습니다.");
				} else if (scan.next().equals("n")) {
					System.out.println("구매를 취소 했습니다.");
				} else if (inventory.money - 1000 * num < 0) {
					System.out.println("금액이 모자릅니다.");
				}
			} else if (select == 2) {
				System.out.print("물약 몇 개를 구매하시겠습니까?");
				int num = scan.nextInt();
				System.out.printf("%d개를 정말 구매하시겠습니까?", num);
				if (scan.next().equals("y") && inventory.money - 2500 * num >= 0) {
					inventory.money = inventory.money - 2500 * num;
					inventory.numofpotion = inventory.numofpotion + num;
					System.out.println("구매에 성공했습니다.");
				} else if (scan.next().equals("n")) {
					System.out.println("구매를 취소 했습니다.");
				} else if (inventory.money - 2500 * num < 0) {
					System.out.println("금액이 모자릅니다.");
				}
			} else if (select == 3) {
				System.out.println("상점을 나갑니다.");
				break;
			} else {
				System.out.println("1 또는 2또는 3을 입력해주세요.");
			}
		}
	}
	
	void takeTravel() {
		for(int i = 3 ; i>0; i--) {			
			System.out.printf("%d초...\n", i);
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
			System.out.println("1.공격 2.도망치기 3.가방열기");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.println("전투를 시작합니다!!!!");
				//0이나 1이나 2를 반환. 0은 누군가 진것을 의미. 1은 아직 싸울 수 있음을 의미. 2는 다른 포켓몬을 내보내는 것을 의미.
				int num = gofight(randomMonster); 
				if(num == 0) break;
			}
			else if(select == 2) {
				int num = runaway(randomMonster); //1이면 성공 0이면 실패
				if(num == 1) break;
			}
			else if(select == 3) {
				int num = checkMyInventory(randomMonster); //포켓몬 잡으면 while문 탈출.
				if(num == 1) break;
			}
			else {
				System.out.println("1또는 2또는 3을 눌러주세요!");
			}			
		}
	}
	
	int checkMyInventory(Poketmon randomMonster){
		if(inventory.numofmonsterball <= 0 || inventory.numofpotion <= 0) {
			System.out.println("가방이 비었습니다.");
			return 0;
		}else {
			System.out.printf("1. 몬스터 볼  x %d\n", inventory.numofmonsterball);
			System.out.printf("2. 회복 물약  x %d\n", inventory.numofpotion);
			System.out.println("어떤 아이템을 사용하시겠습니까?");
			int select = scan.nextInt();
			if(select == 1) {
				int num = throwPoketmonBall(randomMonster); //1은 잡은거 0은 못잡은거
				if(num == 1) return 1;
				else return 0;
			} 				
			else if(select == 2) { drinkpotion(); return 0;}
			return 0;
		}
	}
	
	void drinkpotion() {
		int per = myPoketmon.initial_hp / 100;
		myPoketmon.hp = myPoketmon.hp + (per * 30); //30퍼센트 회복.
		inventory.numofpotion--;
	}
	
	int throwPoketmonBall(Poketmon randomMonster){
		int num = generateRandomNumber("r");
		int per = randomMonster.initial_hp / 100; //1%를 의미
		System.out.println("가라 몬스터보올!!!!!");	
		Monsterball b = inventory.list.get(--inventory.numofmonsterball);
		if(randomMonster.hp > randomMonster.initial_hp/2) {  //체력이 50%이상일때
			System.out.println("체력을 더 깎아주세요...");
			return 0;
		} else{                                    
			if(randomMonster.hp >= per * 30 && randomMonster.hp< per * 50) { //30~50%
				if(num<=30 && num>=1) {System.out.println("넌 내꺼얌!!!"); return 1;}
				else {System.out.println("포켓몬이 들어가지 않았다..."); return 0; }
			}else if(randomMonster.hp >= per * 10 && randomMonster.hp < per * 30) {//10~30%
				if(num<=60 && num>=1) {System.out.println("넌 내꺼얌!!!"); return 1;}
				else {System.out.println("포켓몬이 들어가지 않았다..."); return 0; }
			}else if(randomMonster.hp > 0 && randomMonster.hp < per * 10) {//0~10%
				if(num<=90 && num>=1) {System.out.println("넌 내꺼얌!!!"); return 1;}
				else {System.out.println("포켓몬이 들어가지 않았다..."); return 0; }
			}else {
				return 0;
			}
		}
	}
	
	int runaway(Poketmon randomMonster) {
		int num = generateRandomNumber("r");
		if(randomMonster.hp == randomMonster.initial_hp) { //상대방의 체력이 만땅일때는 10%의 확률로 도망칠 수 있음.
			if(num<=10 && num>=1) {System.out.println("도망치기에 성공했습니다."); return 1;}
			else {System.out.println("도망치기에 실패 했습니다."); return 0; }
		} else if(randomMonster.hp >= (randomMonster.initial_hp)/2 && randomMonster.hp < randomMonster.initial_hp) {
			if(num<=40 && num>=1) {System.out.println("도망치기에 성공했습니다."); return 1;}
			else {System.out.println("도망치기에 실패 했습니다."); return 0;}
		} else if(randomMonster.hp >= (randomMonster.initial_hp)/4 && randomMonster.hp < randomMonster.initial_hp/2) {
			if(num<=70 && num>=1) {System.out.println("도망치기에 성공했습니다."); return 1;}
			else {System.out.println("도망치기에 실패 했습니다."); return 0;}
		} else {   //if(randomMonster.hp < randomMonster.initial_hp/4)
			if(num<=90 && num>=1) {System.out.println("도망치기에 성공했습니다."); return 1;}
			else {System.out.println("도망치기에 실패 했습니다."); return 0;}
		}
	}
	
	int gofight(Poketmon randomMonster) {
		if(myPoketmon.hp<=0 || randomMonster.hp<=0) {
			System.out.printf("%s가 죽었습니다...", (myPoketmon.hp <= 0) ? "내" : "상대");
			System.out.println("전투를 종료합니다.");
			return 0;
		}
		else {			
			System.out.printf("[나의 체력 : %d][상대의 체력 : %d]\n",myPoketmon.hp, randomMonster.hp);
			System.out.println("나의 선공!! 죽어라");
			randomMonster.hp = randomMonster.hp - myPoketmon.attack;
			System.out.printf("상대방의 체력이 %d 만큼 감소해 %d가 됐습니다.\n", myPoketmon.attack, randomMonster.hp);
			System.out.println("상대의 공격!! 으 아프다...");
			myPoketmon.hp = myPoketmon.hp - randomMonster.attack;
			System.out.printf("나의 체력이 %d 만큼 감소해 %d가 됐습니다.\n", randomMonster.attack, myPoketmon.hp);
			return 1;
		}	
	}
	Poketmon selectRandomMonster() {
		int size = monster.size();
		int randnum = generateRandomNumber(size+"");
		Poketmon m = monster.get(randnum);
		System.out.printf("야생의 포캣몬 <%s>이 나타났따!\n", m.name);
		m.print();
		return m;
	}
	
	public void goNewGame() {
		selectMyPoketmon(); // 내 포켓몬을 정하는 메소드
		while (true) {
			int select = takeTravelPrint(); // 1또는 2또는 3을 반환. (1은 여행)(2는 종료 및 저장여부선택)(3은 상점)
			if (select == 1) {
				takeTravel();  //이 부분 구현ㄱㄱ
	
			} else if (select == 2) {
				System.out.println("프로그램을 종료합니다.");
			} else if (select == 3) {
				goShop();
			} else
				System.out.println("1 또는 2또는 3을 입력해주세요.");
		}
	}

	public void goStoredGame() {
		
	}

	public int takeTravelPrint() {
		System.out.println("여행을 떠나시겠습니까?");
		System.out.println("1.네 2.아니오 3.상점가기"); // 1선택시 여행을 떠남. 2선택시 저장여부를 물어봄. 3선택시 몬스터볼하고 물약등을 살 수 있음.
		while (true) {
			int select = scan.nextInt();
			if (select == 1)
				return 1;
			else if (select == 2)
				return 2;
			else if (select == 3)
				return 3;
			else
				System.out.println("1 또는 2또는 3을 입력해주세요.");
		}
	}

	public void selectMyPoketmon() {
		System.out.println("어느 포켓몬을 고르시겠습니까?\n 1.파이리 2.이상해씨 3.꼬부기");
		System.out.print(">>");
		while (true) {
			int select = scan.nextInt();
			if (select == 1) {
				myPoketmon = new Poketmon("파이리", "불", generateRandomNumber("attack"), generateRandomNumber("hp"));
				break;
			} else if (select == 2) {
				myPoketmon = new Poketmon("이상해씨", "풀", generateRandomNumber("attack"), generateRandomNumber("hp"));
				break;
			}
			else if (select == 3) {
				myPoketmon = new Poketmon("꼬부기", "물", generateRandomNumber("attack"), generateRandomNumber("hp"));
				break;
			} else
				System.out.println("1 또는 2 또는 3을 입력해주세요.");
		}
		System.out.println("=================");
		System.out.println("나의 포켓몬은!!!");
		myPoketmon.print();
		System.out.println("=================");
		System.out.println();
	}

	public int generateRandomNumber(String type) {
		if (type.equals("hp")) {
			return (int) (Math.random() * 500) + 500; // 500~999까지의 랜덤숫자
		} else if(type.equals("attack")){
			return (int) (Math.random() * 50) + 100; // 100~149까지의 랜덤숫자
		} else if(type.equals("r")) {
			return (int) (Math.random() * 100);
		}else {
			int size = Integer.parseInt(type);
			return (int) (Math.random() * size);
		}
	}

	public int init() {
		System.out.println("포켓몬스터");
		System.out.println("press enter key to start");
		scan.nextLine();
		System.out.println("1. 새로하기");
		System.out.println("2. 이어하기");
		while (true) {
			int select = scan.nextInt();
			if (select == 1) {
				inventory = new Inventory(10000); // 새로하기 누르면 일단 인벤토리 만원주고 생성
				return 1;
			} else if (select == 2)
				return 2;
			else
				System.out.println("1 또는 2를 입력해주세요.");
		}
	}

	public void readMonster() {
		Scanner filein = openFile("C:\\Users\\Administrator\\Documents\\카카오톡 받은 파일\\poketmon_list.txt");

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
