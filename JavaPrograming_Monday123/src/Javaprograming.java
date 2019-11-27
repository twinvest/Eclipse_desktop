
///////////////////////////////////////////////////////////////////////////////
// Title: Javaprograming
// Files: Javaprograming.java
// Semester: 2019��1�븰湲�
//
// Author: 源��깭�슦/ twinvest@naver.com
// Class:�썡123
//// �옉�꽦�씪: 2019��03��05 (1二� �떎�뒿)
// �궎�썙�뱶: 泥ル쾲吏� 怨쇱젣(蹂꾩컢湲�)
//
// 怨쇱젣�꽕紐�: 蹂꾩텧�젰�쓣 �쐞�빐 for臾멸낵 if臾몄쓣 �솢�슜�븯怨� 媛앹껜�깮�꽦�쓣 �넻�븳 printstar 硫붿냼�뱶 �샇異� 
// 怨쇱젣�셿�꽦�뿬遺�: �셿�꽦
// 誘몄셿�꽦 湲곕뒫: �뾾�쓬
///////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Javaprograming {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Writestar ws = new Writestar();
		while (true) {
			System.out.print("넓이: ");
			int j = scan.nextInt();
			System.out.print("높이: ");
			int i = scan.nextInt();
			ws.printstar(i, j);
		}
	}
}

class Writestar {
	int realx, realy, point;

	void printstar(int i, int j) {
		if (i % 2 == 0)
			realy = (i / 2) - 1;
		else
			realy = i / 2;
		realx = j - 4;
		point = ((j - 7) / 2) + 1;
		for (int a = 0; a < i; a++) {
			for (int k = 0; k < 3; k++) {
				if (k == 0)
					printstar1(j);
				else if (k == 1)
					printstar2(a, i, j);
				else
					printstar3(a, i, j);
				makeblank(j);
			}
			System.out.println();
		}
	}

	void printstar1(int j) {
		for (int b = 0; b < j; b++)
			System.out.print("*");
	}

	void printstar2(int a, int i, int j) {
		for (int b = 0; b < j; b++) {
			if (a == 0 || a == i - 1 || b == 0 || b == j - 1)
				System.out.print("*");
			else
				System.out.print(" ");
		}
	}

	void printstar3(int a, int i, int j) {
		if (a == realy) {
			for (int b = 0; b < realx; b++) {
				if (a == 0 || a == i - 1 || b == 0 || b == realx - 1)
					System.out.print("*");
				else if (a == realy && b == point)
					System.out.print("twkim");
				else
					System.out.print(" ");
			}
		} else {
			for (int b = 0; b < j; b++) {
				if (a == 0 || a == i - 1 || b == 0 || b == j - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
		}
	}

	void makeblank(int j) {
		for (int b = 0; b < j; b++)
			System.out.print(" ");
	}
}