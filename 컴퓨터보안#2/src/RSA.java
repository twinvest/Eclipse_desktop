import java.math.BigInteger;
import java.util.Stack;

public class RSA {
	
	public static void main(String[] args) {
		BigInteger N = new BigInteger("3174654383");
		BigInteger e = new BigInteger("65537");
		BigInteger C = new BigInteger("2487688703");

		BigInteger p = new BigInteger("2");
		BigInteger q = new BigInteger("0");
		BigInteger d = new BigInteger("0");

		BigInteger tmp = new BigInteger("0"); // (p-1)*(q-1)
		BigInteger M = new BigInteger("0");
		
		BigInteger eightBit = new BigInteger("256");
		BigInteger divisor[];
		Stack<BigInteger> stack = new Stack<BigInteger>();

		while (true) {
			if (N.mod(p).equals(BigInteger.ZERO)) { //n mod p가 0일때만 진입. 33행으로 계속 갈 것임. p가 디버깅해보면 52673일때 진입.
				if (isPrime(p)) {                   //그리고 52673일때 isPrime메소드에서 true값이 반환됨.
					q = N.divide(p);                // 3174654383/52673 = 60271    따라서 q의 값은 60271가 된다.
					if(isPrime(q)) {                // 그리고 q(60271)도 소수인지 확인해보니 true가 반환됨. 
						tmp = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); //tmp = (p-1) * (q-1)
						if(e.gcd(tmp).equals(BigInteger.ONE)) // e(65537)와 tmp(3174541440)의 최대공약수가 1이라면 즉, 둘이 서로소라면 탈출!(약속)
							break;
					}
				}
			}
			p=p.add(BigInteger.ONE);    //p에다가 1 더한다.
		}
		System.out.println("알고 있는 정보C(암호문): "+C);
		System.out.println("알고 있는 정보N(public key, p*q): "+N);
		System.out.println("알고 있는 정보e(public key, p-1 * q-1과 서로소): "+e);
		System.out.println();
		System.out.println("p(소수): "+p); //위 while문에서 구해진 p출력
		System.out.println("q(소수): "+q); //위 while문에서 구해진 q출력
		System.out.println();
		d=e.modInverse(tmp);         // ed = 1 mod (p-1)*(q-1),  65537*d = 1 mod 3174541440, (65537*801567233)%3174541440 이거 계산하면 1 나옴. 디버깅하면 d는 801567233.
		System.out.println("d(private key): "+d);  //d출력
		M = C.modPow(d, N);          // M = C^d mod n, M= 2487688703^801567233 mod 3174654383. 디버깅하면 1198485348.
		System.out.println("M(평문): "+M);
		/**    M           몫                  나머지
		 * 1198485348    4681583      100   
		 *  4681583       18287       111
		 *   18287         71         111
		 *    71            0          71
		 *     0            0           0   
		 */
		while(!M.mod(eightBit).equals(BigInteger.ZERO)) {
			divisor = M.divideAndRemainder(eightBit); //divideAndRemainder메소드는 길이가 2인 배열 반환. [0]에는 M/256, [1]에는 M%256저장.
			M= divisor[0];                            //몫은 다시 나누기 위해 M에 초기화.
			stack.push(divisor[1]);             //나머지는 스택에 집어넣어버림. 100
		}

		System.out.printf("평문 : ");
		while(!stack.isEmpty()) {    //스택 빌 때 까지 pop
			System.out.print((char)stack.pop().intValue());
		}
	}
	public static boolean isPrime(BigInteger in) {  //소수인지 판별 메소드.
		boolean isPrime = false;
		BigInteger compute = new BigInteger("2");

		while (!compute.equals(in)) {
			if (in.mod(compute).equals(BigInteger.ZERO))
				return isPrime;
			compute = compute.add(BigInteger.ONE);
		}
		isPrime = true;
		return isPrime;
	}
}