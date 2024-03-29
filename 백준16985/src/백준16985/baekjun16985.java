package 백준16985;

import java.io.*;
import java.util.*;

public class baekjun16985 {

	private static final int[] dz = new int[] { 0, 0, 0, 0, -1, 1 };
	private static final int[] dy = new int[] { -1, 0, 1, 0, 0, 0 };
	private static final int[] dx = new int[] { 0, 1, 0, -1, 0, 0 };

	private static boolean[][][] origin, map;
	private static boolean[] select;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		origin = new boolean[5][5][5];
		map = new boolean[5][5][5];
		for (int z = 0; z < 5; z++) {
			for (int y = 0; y < 5; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < 5; x++) {
					origin[z][y][x] = (st.nextToken().charAt(0) == '1') ? true : false;
					map[z][y][x] = origin[z][y][x];
				}
			}
		}

		select = new boolean[5];
		answer = bfs();
		for (int a = 0; a < 4; a++) {
			rotate(0);
			for (int b = 0; b < 4; b++) {
				rotate(1);
				for (int c = 0; c < 4; c++) {
					rotate(2);
					for (int d = 0; d < 4; d++) {
						rotate(3);
						for (int e = 0; e < 4; e++) {
							rotate(4);
							dfs(0);
						}
					}
				}
			}
		}

		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}

	private static void dfs(int n) {
		if (n == 5) { //로테이션 돈게 전부 map에 반영이 되면 (복사되면) bfs조진다.
			answer = Math.min(answer, bfs());
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (select[i])
				continue;

			select[i] = true;
			map[n] = origin[i]; //origin을 맵에 복사.
			dfs(n + 1);
			select[i] = false;
		}
	}

	private static int bfs() {
		if (!map[0][0][0] || !map[4][4][4])  //둘 중 하나라도 false면 maxvalue리턴.
			return Integer.MAX_VALUE;

		Queue<Point> q = new LinkedList<>(); //암기
		boolean[][][] visited = new boolean[5][5][5];
		q.add(new Point(0, 0, 0, 0)); //처음에 0000넣어줌.
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Point u = q.poll(); //큐에 있는거 끄내기.
			if (u.z == 4 && u.y == 4 && u.x == 4) //끝이면
				return u.count;                   //count 리턴.

			for (int i = 0; i < 6; i++) {
				int z = u.z + dz[i];
				int y = u.y + dy[i];
				int x = u.x + dx[i];
				//범위 벗어나거나 방문을 했거나 들어갈 수 없는 칸(문제에서0인 부분 또는 여기서 정의한걸로는 false인 부분)이면 다시 반복문 처음으로!!
				if (z < 0 || z >= 5 || y < 0 || y >= 5 || x < 0 || x >= 5 || visited[z][y][x] || !map[z][y][x])  
					continue;

				visited[z][y][x] = true;
				q.add(new Point(z, y, x, u.count + 1));
			}
		}

		return Integer.MAX_VALUE;
	}

	private static void rotate(int z) {
		boolean[][] temp = new boolean[5][5];
		for (int y = 0; y < 5; y++)
			for (int x = 0; x < 5; x++)
				temp[y][x] = origin[z][4 - x][y];

		origin[z] = temp;
	}

	private static class Point {
		public int z, y, x, count;

		public Point(int z, int y, int x, int count) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
} 