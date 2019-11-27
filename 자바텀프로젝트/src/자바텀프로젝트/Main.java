package 자바텀프로젝트;

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
		readMonster(); // 앞으로 여행을 떠나면서 등장할 몬스터들을 읽어오는 메소드
		// printMonster();
		int choiceNumber = init(); // 첫 실행시 초기화 과정 및 출력 텍스트. 그 후 1또는 2를 반환하는데 1은 새로하기를 의미. 2는 이어하기를 의미.
		if (choiceNumber == 1)
			goNewGame(); // 1이면 새로하기.
		else
			goStoredGame(); // 2이면 저장된 게임하기.
	}

	void goNewGame() {
		selectMyPoketmon(); // 내 포켓몬을 정하는 메소드
		int select = takeTravel(); // 1또는 2또는 3을 반환. (1은 여행)(2는 종료 및 저장여부선택)(3은 상점)
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

	void selectMyPoketmon() {
		System.out.println("어느 포켓몬을 고르시겠습니까?\n 1.파이리 2.이상해씨 3.꼬부기");
		System.out.print(">>");
		while (true) {
			int select = scan.nextInt();
			if (select == 1) {
				myPoketmon = new Poketmon("파이리", "불", generateRandomNumber("attack"), generateRandomNumber("hp"));
				break;
			}

			else if (select == 2) {
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

	int generateRandomNumber(String type) {
		if (type.equals("hp")) {
			return (int) (Math.random() * 500) + 500; // 500~999까지의 랜덤숫자
		} else {
			return (int) (Math.random() * 50) + 100; // 100~149까지의 랜덤숫자
		}
	}

	int init() {
		System.out.println("포켓몬스터");
		System.out.println("press enter key to start");
		scan.nextLine();
		System.out.println("1. 새로하기");
		System.out.println("2. 이어하기");
		while (true) {
			int select = scan.nextInt();
			if (select == 1)
				return 1;
			else if (select == 2)
				return 2;
			else
				System.out.println("1 또는 2를 입력해주세요.");
		}

	}

	void readMonster() {
		Scanner filein = openFile("C:\\Users\\taewoo\\Desktop\\자바\\자바 프로젝트 제안서\\poketmon_list.txt");

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
