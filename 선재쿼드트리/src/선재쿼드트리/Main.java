package 선재쿼드트리;

import java.util.Scanner;

public class Main {

	private static String[][] Quad_Tree = null;
	private static int N;

	private static void compression() 
	{
		for (int i = 0; i < N / 2; i++) 
		{
			for (int j = 0; j < N / 2; j++) 
			{
				Quad_Tree[i][j] = "" + Quad_Tree[2 * i][2 * j] + Quad_Tree[2 * i][2 * j + 1]
						+ Quad_Tree[2 * i + 1][2 * j] + Quad_Tree[2 * i + 1][2 * j + 1];
				if (Quad_Tree[i][j].equals("1111")) {
					Quad_Tree[i][j] = "1";
				} else if (Quad_Tree[i][j].equals("0000")) {
					Quad_Tree[i][j] = "0";
				} else {
					Quad_Tree[i][j] = "(" + Quad_Tree[i][j] + ")";
				}
			}
		}
		N /= 2;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = Integer.parseInt(input.nextLine()); //input.nextLine으로 받은 문자열을 숫자로바꿔줌.
		Quad_Tree = new String[64][64];
		if (N >= 1 && N <= 64) 
		{	
			Quad_Tree = new String[N][N];
			for (int i = 0; i < N; i++) 
			{
				String line = input.nextLine(); //input.nexLine으로 문자열 받아서 line에 저장.
				int j = 0;
				for (char tmp : line.toCharArray()) 
				{
					Quad_Tree[i][j++] = "" + tmp;
				}
			}
			input.close();
			while(N != 1) 
			{
				compression();
			}
			System.out.println((Quad_Tree[0][0]));
		}
	}
}
