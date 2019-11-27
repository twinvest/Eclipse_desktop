package baekjun_tomato;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjun_tomato {
	
	private static Scanner scan = new Scanner(System.in);

	private static int[][] tomatoBox;

	static int day = 0;
	// 마지막에 -1 해준다.

	static int check = 1;

	private static int[] bfs(int row, int column) {

		// 위로 올라가기 ( 제일 위가 아니고 그 위가 익지 않은 토마토 일때 )
		if (row != 0 && tomatoBox[row - 1][column] == 0) {
			tomatoBox[row - 1][column] = 1;
			return new int[]{row - 1,column};
		}

		// 아래로 내려가기 ( 제일 아래가 아니고 그 아래가 익지 않은 토마토 일때 )
		if (row != tomatoBox.length - 1 && tomatoBox[row + 1][column] == 0) {
			tomatoBox[row + 1][column] = 1;
			return new int[]{row + 1,column};
		}

		// 왼쪽으로 가기
		if (column != 0 && tomatoBox[row][column - 1] == 0) {
			tomatoBox[row][column - 1] = 1;
			return new int[]{row,column - 1};

		}

		// 오른쪽으로 가기
		if (column != tomatoBox[row].length - 1 && tomatoBox[row][column + 1] == 0) {
			tomatoBox[row][column + 1] = 1;
			return new int[]{row,column + 1};

		}
		
		return null;
	}

	public static void main(String[] args) {
		Queue<int[]> queue = new LinkedList<>();
		int columns = scan.nextInt(); // 열
		int rows = scan.nextInt(); // 행
		scan.nextLine();

		tomatoBox = new int[rows][columns];

		// 값 등록
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				tomatoBox[row][column] = scan.nextInt();
				if(tomatoBox[row][column] == 1) {
					 int[] tmp = {row, column};
					 queue.add(tmp);
				}
			}
			scan.nextLine();
		}
		
		int dayCheck = queue.size();
		//검사
		while(!queue.isEmpty()) {
			
			for(int i = 0; i < dayCheck; i++) {
				int tomato[] = queue.remove();
				do {
					int bfs[] = bfs(tomato[0], tomato[1]);
					if(bfs == null) {
						break;
					}
					queue.add(bfs);
				}while(true);
			}
			dayCheck = queue.size();
			day++;
		}
		// -1 검사
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if(tomatoBox[row][column] == 0) {
					day = 0;
				}
			}
		}
		day--;
		System.out.println(day);
	}
}
