

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
      game.init(); // 첫 실행시 초기화 과정 및 출력 텍스트. 그 후 1또는 2를 반환하는데 1은 새로하기를 의미. 2는 이어하기를 의미.
      game.goNewGame(); // 1이면 새로하기.
   }
}