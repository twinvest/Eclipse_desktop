

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   ArrayList<Poketmon> monster = new ArrayList<>();
   Poketmon myPoketmon;
   Scanner scan = new Scanner(System.in);
   Inventory inventory;
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Main main = new Main();
      main.mymain();
   }

   void mymain() {
	  Game game = new Game();
      game.readMonster(); // ������ ������ �����鼭 ������ ���͵��� �о���� �޼ҵ�
      //game.printMonster();
      int choiceNumber = game.init(); // ù ����� �ʱ�ȭ ���� �� ��� �ؽ�Ʈ. �� �� 1�Ǵ� 2�� ��ȯ�ϴµ� 1�� �����ϱ⸦ �ǹ�. 2�� �̾��ϱ⸦ �ǹ�.
      if (choiceNumber == 1)
         game.goNewGame(); // 1�̸� �����ϱ�.
      else
         game.goStoredGame(); // 2�̸� ����� �����ϱ�.
   }
}