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
   
   void read(Scanner scan) {
      name = scan.next();
      type = scan.next();
      attack = scan.nextInt();
      hp = scan.nextInt();
   }
   
   void print() {
      System.out.printf("[�̸� : %s] [Ÿ�� : %s] [���ݷ� : %d] [ü�� : %d]\n", name, type, attack, hp);
   }
}