import java.util.Scanner;

public class Poketmon {
   String name;
   String type;
   int attack;
   int hp;
   int initial_hp;
   
   Poketmon(){}; //����Ʈ ������
   Poketmon(String name, String type, int attack, int hp){ //������ �����ε�
      this.name = name;
      this.type = type;
      this.attack = attack;
      this.hp = hp;
      this.initial_hp = hp;
   }
   
   //�̸� �˻�, Ÿ�԰˻�, ü�� ���ݷ� �˻�
   boolean match(String kwd) {
	   int kwdint = -1000;
	   if(kwd.matches("[0-9]+")) {//kwd�� ������ ���¶��
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
      System.out.printf("[�̸� : %s] [Ÿ�� : %s] [���ݷ� : %d] [ü�� : %d]\n", name, type, attack, hp);
   }
}