

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
      game.init(); // ù ����� �ʱ�ȭ ���� �� ��� �ؽ�Ʈ. �� �� 1�Ǵ� 2�� ��ȯ�ϴµ� 1�� �����ϱ⸦ �ǹ�. 2�� �̾��ϱ⸦ �ǹ�.
      game.goNewGame(); // 1�̸� �����ϱ�.
   }
}