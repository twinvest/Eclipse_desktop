///////////////////////////////////////////////////////////////////////////////
// Title : Javaprograming4
// Files : Javaprograming4.java
// Semester : 2019-1학기
//
// Author : 김태우/ twinvest@naver.com
// Class : 월123
//// 작성일 : 2019-03-29 
// 키워드: 배열객체
//
// 과제설명 : 배열객체에 대한 이해 및 클래스의 이해 
// 과제완성여부 : 완성
// 미완성기능 : 없음
///////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Javaprograming4 {
	boolean wrong = false;
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Javaprograming4 java = new Javaprograming4();
		java.mymain();
	}

	void mymain() {
		int numOfproduct = scan.nextInt();
		Product[] list = new Product[numOfproduct];

		Read(list, numOfproduct);
		Print(list, numOfproduct);
		
		while(true) {
			int[] check = Check(numOfproduct);
			if(wrong == false)
				PrintOrder(list, check, numOfproduct);
			wrong = false;
		}
	}

	String isMan(char gender) {
		String gen;
		if (gender == 'f') {
			gen = "Woman";
			return gen;
		}
		if (gender == 'c') {
			gen = "Common";
			return gen;
		}
		gen = "Man";
		return gen;
	}

	void Read(Product[] list, int numOfproduct) {
		for (int i = 0; i < numOfproduct; i++) {
			list[i] = new Product();
			list[i].setProductName(scan.next());
			list[i].setProductPrice(scan.nextInt());
			list[i].setTypeOfProduct(scan.next().trim().charAt(0));
		}
	}

	void Print(Product[] list, int numOfproduct) {
		System.out.println();
		System.out.println("=========== 상품리스트 ==============");
		for (int i = 0; i < numOfproduct; i++) {
			System.out.printf("[ %d] ", i + 1);
			System.out.print(list[i].getProductName() + " ");
			System.out.printf("[%s] ", isMan(list[i].getTypeOfProduct()));
			System.out.print(list[i].getProductPrice() + "원");
			System.out.println();
		}
	}

	int[] Check(int numOfproduct) {
		int index = 0;
		System.out.println();
		System.out.print(">>");
		int[] check = new int[numOfproduct];
		while (true) {
			check[index++] = scan.nextInt(); // 입력받기
			if (check[index - 1] > numOfproduct) { // 잘못된 번호면 종료
				System.out.printf("%d는 잘못된 번호입니다...\n", check[index - 1]);
				wrong = true;
			}
			if (check[0] == 0) { // 첫번째 값이 0이면 종료
				System.out.println("Bye!");
				System.exit(0);
			}
			if (check[index - 1] == 0) { // 잘못된 번호가 없고 첫번째 값이 0이 아니면서 인덱스가 0인 경우 탈출.
				break;
			}
		}
		return check;
	}

	void PrintOrder(Product[] list, int[] check, int numOfproduct) {
		int sum = 0;
		int index = 0;
		System.out.println("주문한 상품:");
		while (true) {
			int i = check[index++];
			if (check[index - 1] == 0)
				break;
			System.out.print(list[i - 1].getProductName() + " ");
			System.out.printf("[%s] ", isMan(list[i - 1].getTypeOfProduct()));
			System.out.print(list[i - 1].getProductPrice() + "원");
			System.out.println();
			sum = sum + list[i - 1].getProductPrice();
		}
		System.out.printf("합계 : %d원\n", sum);
	}
}