package 자바텀프로젝트;

import java.util.Scanner;

public class Poketmon {
	String name;
	String type;
	int attack;
	int hp;
	
	Poketmon(){}; //디폴트 생성자
	Poketmon(String name, String type, int attack, int hp){ //생성자 오버로딩
		this.name = name;
		this.type = type;
		this.attack = attack;
		this.hp = hp;
	}
	
	void read(Scanner scan) {
		name = scan.next();
		type = scan.next();
		attack = scan.nextInt();
		hp = scan.nextInt();
	}
	
	void print() {
		System.out.printf("[이름 : %s] [타입 : %s] [공격력 : %d] [체력 : %d]\n", name, type, attack, hp);
	}
}
