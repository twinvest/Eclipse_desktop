
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.print(">> ");
			int N = scan.nextInt(), K = scan.nextInt();

			
			if (!check(N, K)) {
				scan.close();
				System.exit(0);
			}

			
			Bus bus = new Bus(K);

			System.out.print(">> ");
			for (; 0 != N; N--) {
				
				bus.rideBus(scan.nextInt());
			}
			
			bus.goLastBus();
		}


	}

	
	static boolean check(int N, int K) {

		if (!(N >= 0 && N <= 100 && K >= 1 && K <= 50)) {
			return false;
		} else if (N == 0) {
			System.out.println(0);
			return false;
		}

		return true;

	}

}
