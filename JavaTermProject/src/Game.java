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
	
	//여행을 떠나는 함수
	void takeTravel() {
		for(int i = 3 ; i>0; i--) {			
			System.out.printf("%d초...\n", i);  //sleep 함수를 이용해 시간의 흐름을 표시
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		Poketmon randomMonster = selectRandomMonster(); //selectRandomMonster() 메소드를 호출하면 랜덤한 포켓몬 객체가 반환됨.
		gofightPrint(randomMonster);                    //gofightPrint()메소드를 호출하면서 인자로 랜덤으로 생성된 포켓몬을 같이 넘긴다.
	}
	
	void gofightPrint(Poketmon randomMonster) {
		while(true) {
			System.out.println("1.공격 2.도망치기 3.가방열기");
			System.out.println("==============================================");
			System.out.print(">>");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.println("==============================================");
				System.out.println("공격을 시작합니다!!!!");
				//0이나 1이나 2를 반환. 0은 누군가 진것을 의미. 1은 아직 싸울 수 있음을 의미. 2는 다른 포켓몬을 내보내는 것을 의미.
				int num = gofight(randomMonster); 
				if(num == 0) break;
			}
			else if(select == 2) {
				int num = runaway(randomMonster); //1이면 성공 0이면 실패
				if(num == 1) break;
			}
			else if(select == 3) {
				int num = inventory.checkMyInventory(randomMonster, this); //포켓몬 잡으면 while문 탈출.
				if(num == 1) break;
			}
			else {
				System.out.println("1또는 2또는 3을 눌러주세요!");
			}			
		}
	}
	
	int throwPoketmonBall(Poketmon randomMonster){
		int num = generateRandomNumber("r");
		int per = randomMonster.initial_hp / 100; //1%를 의미
		System.out.println("==============================================");
		System.out.println("가라 몬스터보올!!!!!");
		//System.out.printf("싸이즈 확인 : %d\n\n\n", inventory.myPoketmonlist.size());
		--inventory.numofmonsterball; //일단 몬스터볼 하나 감소.
		
		int ballnumber = inventory.listIsEmpty(); //myPoketmonlist의 null값인 곳을 찾아서 반환. 만약, 다 차있으면 싸이즈 반환.
		Monsterball b = inventory.myPoketmonlist.get(ballnumber);  //myPoketmonlist에서 몬스터볼을 하나 얻어오면서
		if(ballnumber == inventory.myPoketmonlist.size() || inventory.numofmonsterball<=0) {
			System.out.println("더 이상 사용할 수 있는 몬스터볼이 없습니다.");
		}
			
		if(randomMonster.hp > randomMonster.initial_hp/2) {  //체력이 50%이상일때
			System.out.println("체력을 더 깎아주세요...");
			inventory.myPoketmonlist.remove(inventory.myPoketmonlist.size()-1); //제일 뒷 요소 삭제
			return 0;
		} else{                                    
			if(randomMonster.hp >= per * 30 && randomMonster.hp< per * 50) { //30~50%
				if(num<=30 && num>=1) {
					System.out.println("넌 내꺼얌!!!"); 
					myPoketmon.hp=myPoketmon.initial_hp;
					randomMonster.hp = randomMonster.initial_hp;
					b.p=randomMonster;
					return 1;
				} else {
					System.out.println("포켓몬이 들어가지 않았다...");
					if(ballnumber != inventory.myPoketmonlist.size()) {
						inventory.myPoketmonlist.remove(inventory.myPoketmonlist.size()-1); //제일 뒷 요소 삭제
						//System.out.printf("싸이즈 확인 : %d\n\n\n", inventory.myPoketmonlist.size());
					}
					return 0; 
				}
			}else if(randomMonster.hp >= per * 10 && randomMonster.hp < per * 30) {//10~30%
				if(num<=60 && num>=1) {
					System.out.println("넌 내꺼얌!!!"); 
					myPoketmon.hp=myPoketmon.initial_hp;
					randomMonster.hp = randomMonster.initial_hp;
					b.p=randomMonster;
					
					return 1;
					}
				else {
					System.out.println("포켓몬이 들어가지 않았다...");
					//--inventory.numofmonsterball;
					if(ballnumber != inventory.myPoketmonlist.size()) {
						inventory.myPoketmonlist.remove(inventory.myPoketmonlist.size()-1); //제일 뒷 요소 삭제
						//System.out.printf("싸이즈 확인 : %d\n\n\n", inventory.myPoketmonlist.size());
					}
					return 0; 
					}
			}else if(randomMonster.hp > 0 && randomMonster.hp < per * 10) {//0~10%
				if(num<=90 && num>=1) {
					System.out.println("넌 내꺼얌!!!"); 
					myPoketmon.hp=myPoketmon.initial_hp;
					randomMonster.hp = randomMonster.initial_hp;
					b.p=randomMonster;
					return 1;
					}
				else {
					System.out.println("포켓몬이 들어가지 않았다...");
					//--inventory.numofmonsterball;
					if(ballnumber != inventory.myPoketmonlist.size()) {
						inventory.myPoketmonlist.remove(inventory.myPoketmonlist.size()-1); //제일 뒷 요소 삭제
						//System.out.printf("싸이즈 확인 : %d\n\n\n", inventory.myPoketmonlist.size());
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
		if(randomMonster.hp == randomMonster.initial_hp) { //상대방의 체력이 만땅일때는 10%의 확률로 도망칠 수 있음.
			if(num<=10 && num>=1) {System.out.println("도망치기에 성공했습니다."); return 1;}
			else {System.out.println("도망치기에 실패 했습니다."); return 0; }
		} else if(randomMonster.hp >= (randomMonster.initial_hp)/2 && randomMonster.hp < randomMonster.initial_hp) {
			if(num<=40 && num>=1) {System.out.println("도망치기에 성공했습니다."); return 1;}
			else {System.out.println("도망치기에 실패 했습니다."); return 0;}
		} else if(randomMonster.hp >= (randomMonster.initial_hp)/4 && randomMonster.hp < randomMonster.initial_hp/2) {
			if(num<=70 && num>=1) {System.out.println("도망치기에 성공했습니다."); return 1;}
			else {System.out.println("도망치기에 실패 했습니다."); return 0;}
		} else if(randomMonster.hp < randomMonster.initial_hp/4) {   
			if(num<=90 && num>=1) {System.out.println("도망치기에 성공했습니다."); return 1;}
			else {System.out.println("도망치기에 실패 했습니다."); return 0;}
		} else {
			System.out.println("도망치기에 실패 했습니다.");
			return 0;
		}
		
	}
	
	int gofight(Poketmon randomMonster) {
		if(myPoketmon.hp<=0 || randomMonster.hp<=0) {
			System.out.printf("%s가 죽었습니다...", (myPoketmon.hp <= 0) ? "내" : "상대");
			myPoketmon.hp=myPoketmon.initial_hp; //내 포켓몬이 죽으면 체력 초기화.
			randomMonster.hp = randomMonster.initial_hp; //상대방도 체력 초기화.
			System.out.println("전투를 종료합니다.");
			return 0;
		}
		else {			
			System.out.printf("[나의 체력 : %d][상대의 체력 : %d]\n",myPoketmon.hp, randomMonster.hp);
			System.out.println("<나의 공격 정보>");
			randomMonster.hp = randomMonster.hp - myPoketmon.attack;
			System.out.printf("상대방의 체력이 %d 만큼 감소해 %d가 됐습니다.\n", myPoketmon.attack, randomMonster.hp);
			System.out.println("<상대의 공격 정보>");
			myPoketmon.hp = myPoketmon.hp - randomMonster.attack;
			System.out.printf("나의 체력이 %d 만큼 감소해 %d가 됐습니다.\n", randomMonster.attack, myPoketmon.hp);
			return 1;
		}
	}
	
	//랜덤 몬스터 생성 메소드
	Poketmon selectRandomMonster() {
		int size = monster.size();                     //몬스터 arrayList의 사이즈를 반환받고
		int randnum = generateRandomNumber(size+"");   //사이즈를 인자값으로 넘겨주며 0부터 size사이의 랜덤 숫자를 반환받는다.
		Poketmon m = monster.get(randnum);             //몬스터 arrayList에서 생성된 랜덤넘버의 index를 가진 객체를 하나 뽑아온다.
		System.out.println("==============================================");
		System.out.printf("야생의 포캣몬 <%s>이 나타났따!\n", m.name);
		m.print();
		return m;                                      //호출한 곳으로 랜덤몬스터 객체를 반환해준다.
	}
	
	public void goNewGame() {
		selectMyPoketmon(); // 내 포켓몬을 정하는 메소드
		while (true) {
			int select = takeTravelPrint(); // 1또는 2또는 3을 반환. (1은 여행)(2는 종료)(3은 상점)(4는 인벤토리)
			if (select == 1) {
				takeTravel();
			} else if (select == 2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (select == 3) {
				shop.visitShop(inventory);
			} else if (select == 4){
				inventory.showMyInventory();
			} else if(select == 5) {
				searchPoketmon();
			} else if(select == 6) {
				System.out.println("포켓몬을 세 마리 이상 모았습니다. 이제 본격적인 여행에 떠날 수 있습니다.");
				System.out.println("Good Bye!");
				break;
			}else
				System.out.println("1 또는 2또는 3을 입력해주세요.");
		}
	}

	void searchPoketmon(){
		while(true) {
			System.out.println("==============================================");
			System.out.println("1. 야생 포켓몬 검색");
			System.out.println("2. 내가 잡은 포켓몬 검색");
			System.out.println("3. 전력 검색");
			System.out.println("4. 검색 나가기");
			System.out.println("==============================================");
			System.out.print(">>");
			int select = scan.nextInt();
			
			if(select == 1) {
				System.out.println("<이름 타입 전투력 체력 중 아무거나 입력해주세요>");
				System.out.print(">>");
				String kwd = scan.next();
				for(Poketmon p: monster)  //랜덤의 야생 포켓몬 검색
					if(p.match(kwd)) 
						p.print();
			} else if(select == 2) {
				System.out.println("<이름 타입 전투력 체력 중 아무거나 입력해주세요>");
				System.out.print(">>");
				String kwd = scan.next();
				for(Monsterball b: inventory.myPoketmonlist)  //내가 잡은 포켓몬 목록 검색
					if(b.match(kwd)) 
						b.print();
			} else if(select == 3) {
				int count = 0;
				System.out.println("<내가 이길 가능성이 높은 몬스터들입니다. 이 몬스터를 만나거든 도망치지 마세요!>");  //전력비교
				Monsterball m = inventory.myPoketmonlist.get(0); //주머니에서 몬스터볼을 빼옴.
				Poketmon my = m.p;  							//몬스터볼에서 포켓몬을 꺼냄.
				System.out.println("==============================================");
				System.out.println("체력적 우위");
				for(Poketmon p: monster) {  //랜덤의 야생 포켓몬 검색
					if(p.hp <= my.hp){    //내 체력이 상대의 체력보다 높으면
						p.print();
						count++;
					}
				}
				System.out.printf("%d마리는 나보다 체력이 낮습니다.\n", count);
				count = 0;
				System.out.println("==============================================");
				System.out.println("==============================================");
				System.out.println("공격적 우위");
				for(Poketmon p: monster) {  //랜덤의 야생 포켓몬 검색
					if(p.attack <= my.attack){ //내 공격력이 상대의 공격력보다 높으면
						p.print();
						count++;
					}
				}
				System.out.printf("%d마리는 나보다 공격력이 낮습니다.\n", count);
				System.out.println("==============================================");
			}else if(select == 4)
				break;
		}
	}
	
	
	public int takeTravelPrint() {
		if(inventory.listIsEmpty()>2) //잡은 포켓몬의 개수 반환
			return 6;
		System.out.println("==============================================");
		System.out.println("여행을 떠나시겠습니까?");
		System.out.println("1.네 2.아니오 3.상점가기 4.인벤토리보기 5.포켓몬 도감 검색"); // 1선택시 여행을 떠남. 2선택시 저장여부를 물어봄. 3선택시 몬스터볼하고 물약등을 살 수 있음.
		System.out.println("==============================================");
		while (true) {
			System.out.print(">>");
			int select = scan.nextInt();
			if (select > 0 && select < 6)
				return select;
			else
				System.out.println("1 또는 2 또는 3 또는 4 또는 5를 입력해주세요.");
		}
	}

	public void selectMyPoketmon() {
		System.out.println("어느 포켓몬을 고르시겠습니까?\n 1.파이리 2.이상해씨 3.꼬부기");
		System.out.print(">>");
		while (true) {
			int select = scan.nextInt();
			if (select == 1) {
				myPoketmon = new Poketmon("파이리", "불", generateRandomNumber("attack"), generateRandomNumber("hp"));
				myFirstMonsterBall.p = myPoketmon;   //게임을 시작하면 최초로 주어진 몬스터볼에 내가 선택한 포켓몬을 집어넣는다.
				inventory.myPoketmonlist.add(myFirstMonsterBall); //그리고 그 몬스터볼을 내 인벤토리의 myPoketmonlist에 집어넣는다.
				break;
			} else if (select == 2) {
				myPoketmon = new Poketmon("이상해씨", "풀", generateRandomNumber("attack"), generateRandomNumber("hp"));
				myFirstMonsterBall.p = myPoketmon;
				inventory.myPoketmonlist.add(myFirstMonsterBall);
				break;
			}
			else if (select == 3) {
				myPoketmon = new Poketmon("꼬부기", "물", generateRandomNumber("attack"), generateRandomNumber("hp"));
				myFirstMonsterBall.p = myPoketmon;
				inventory.myPoketmonlist.add(myFirstMonsterBall);
				break;
			} else
				System.out.println("1 또는 2 또는 3을 입력해주세요.");
		}
		System.out.println("==============================================");
		System.out.println("내가 선택한 포켓몬은!!!");
		myPoketmon.print();
		System.out.println("==============================================");
		System.out.println();
	}

	public int generateRandomNumber(String type) {
		if (type.equals("hp")) {
			return (int) (Math.random() * 500) + 500; // 500~999까지의 랜덤숫자
		} else if(type.equals("attack")){
			return (int) (Math.random() * 50) + 200; // 200~249까지의 랜덤숫자
		} else if(type.equals("r")) {
			return (int) (Math.random() * 100);
		}else {
			int size = Integer.parseInt(type);
			return (int) (Math.random() * size);
		}
	}

	public void init() {
		System.out.println("포켓몬스터");
		System.out.println("press enter key to start");
		scan.nextLine();
		readMonster(); // 앞으로 여행을 떠나면서 등장할 몬스터들을 읽어오는 메소드
		//printMonster(); //랜덤으로 등장할 포켓몬들의 리스트
		inventory = new Inventory(20000); // 새로하기 누르면 일단 인벤토리 만원주고 생성
	}

	public void readMonster() {
		Scanner filein = openFile("C:\\Users\\taewoo\\Desktop\\자바\\자바 프로젝트 제안서\\poketmon_list.txt");

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
