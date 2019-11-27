import java.util.Scanner;

public class Poketmon {
   String name;
   String type;
   int attack;
   int hp;
   int initial_hp;
   
   Poketmon(){}; //디폴트 생성자
   Poketmon(String name, String type, int attack, int hp){ //생성자 오버로딩
      this.name = name;
      this.type = type;
      this.attack = attack;
      this.hp = hp;
      this.initial_hp = hp;
   }
   
   //이름 검색, 타입검색, 체력 공격력 검색
   boolean match(String kwd) {
	   int kwdint = -1000;
	   if(kwd.matches("[0-9]+")) {//kwd가 숫자의 형태라면
		    kwdint = Integer.parseInt(kwd);  
	   } 
		return name.equals(kwd) || type.contains(kwd) || (kwdint>= hp || kwdint>=attack) ? true : false;
   }
   
   void read(Scanner scan) {
      name = scan.next();
      type = scan.next();
      attack = scan.nextInt();
      hp = scan.nextInt();
      this.initial_hp = hp;
   }
   
   void print() {
      System.out.printf("[이름 : %s] [타입 : %s] [공격력 : %d] [체력 : %d]\n", name, type, attack, hp);
   }
}