import java.util.Scanner;

public class Shop {
	Scanner scan = new Scanner(System.in);
	Monsterball ball;
	int potion = Integer.MAX_VALUE;
	
	public void visitShop(Inventory inventory) {
		while (true) {
			System.out.println();
			System.out.println("==============================================");
			System.out.println("item list");
			System.out.printf("현재 소유 금액 : %d\n", inventory.money);
			System.out.printf("현재 사용가능한 몬스터볼 : %d\n", inventory.numofmonsterball);
			System.out.printf("현재 사용가능한 회복물약 : %d\n", inventory.numofpotion);
			System.out.println("==============================================");
			
			System.out.println("어떤 아이템을 사시겠습니까?");
			System.out.println("1. 몬스터볼 1000원");
			System.out.println("2. 회복물약 2500원");
			System.out.println("3. 상점  나가기");
			System.out.print(">>");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("몬스터볼 몇 개를 구매하시겠습니까?");
				int num = scan.nextInt();
				System.out.printf("%d개를 정말 구매하시겠습니까?(y/n)", num);
				String choice = scan.next();
				if (choice.equals("y") && inventory.money - 1000 * num >= 0) {
					inventory.money = inventory.money - 1000 * num;
					inventory.numofmonsterball = inventory.numofmonsterball + num;  
					for (int i = 0; i < num; i++) {
						Monsterball ball = new Monsterball();
						inventory.myPoketmonlist.add(ball);
					}
					System.out.println("구매에 성공했습니다.");
				} else if (choice.equals("n")) {
					System.out.println("구매를 취소 했습니다.");
				} else if (inventory.money - 1000 * num < 0) {
					System.out.println("금액이 모자릅니다.");
				}
			} else if (select == 2) {
				System.out.print("물약 몇 개를 구매하시겠습니까?");
				int num = scan.nextInt();
				System.out.printf("%d개를 정말 구매하시겠습니까?(y/n)", num);
				String choice = scan.next();
				if (choice.equals("y") && inventory.money - 2500 * num >= 0) {
					inventory.money = inventory.money - 2500 * num;
					inventory.numofpotion = inventory.numofpotion + num;
					System.out.println("구매에 성공했습니다.");
				} else if (choice.equals("n")) {
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
	
}