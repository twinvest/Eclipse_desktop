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
			if (N.mod(p).equals(BigInteger.ZERO)) { //n mod p�� 0�϶��� ����. 33������ ��� �� ����. p�� ������غ��� 52673�϶� ����.
				if (isPrime(p)) {                   //�׸��� 52673�϶� isPrime�޼ҵ忡�� true���� ��ȯ��.
					q = N.divide(p);                // 3174654383/52673 = 60271    ���� q�� ���� 60271�� �ȴ�.
					if(isPrime(q)) {                // �׸��� q(60271)�� �Ҽ����� Ȯ���غ��� true�� ��ȯ��. 
						tmp = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); //tmp = (p-1) * (q-1)
						if(e.gcd(tmp).equals(BigInteger.ONE)) // e(65537)�� tmp(3174541440)�� �ִ������� 1�̶�� ��, ���� ���μҶ�� Ż��!(���)
							break;
					}
				}
			}
			p=p.add(BigInteger.ONE);    //p���ٰ� 1 ���Ѵ�.
		}
		System.out.println("�˰� �ִ� ����C(��ȣ��): "+C);
		System.out.println("�˰� �ִ� ����N(public key, p*q): "+N);
		System.out.println("�˰� �ִ� ����e(public key, p-1 * q-1�� ���μ�): "+e);
		System.out.println();
		System.out.println("p(�Ҽ�): "+p); //�� while������ ������ p���
		System.out.println("q(�Ҽ�): "+q); //�� while������ ������ q���
		System.out.println();
		d=e.modInverse(tmp);         // ed = 1 mod (p-1)*(q-1),  65537*d = 1 mod 3174541440, (65537*801567233)%3174541440 �̰� ����ϸ� 1 ����. ������ϸ� d�� 801567233.
		System.out.println("d(private key): "+d);  //d���
		M = C.modPow(d, N);          // M = C^d mod n, M= 2487688703^801567233 mod 3174654383. ������ϸ� 1198485348.
		System.out.println("M(��): "+M);
		/**    M           ��                  ������
		 * 1198485348    4681583      100   
		 *  4681583       18287       111
		 *   18287         71         111
		 *    71            0          71
		 *     0            0           0   
		 */
		while(!M.mod(eightBit).equals(BigInteger.ZERO)) {
			divisor = M.divideAndRemainder(eightBit); //divideAndRemainder�޼ҵ�� ���̰� 2�� �迭 ��ȯ. [0]���� M/256, [1]���� M%256����.
			M= divisor[0];                            //���� �ٽ� ������ ���� M�� �ʱ�ȭ.
			stack.push(divisor[1]);             //�������� ���ÿ� ����־����. 100
		}

		System.out.printf("�� : ");
		while(!stack.isEmpty()) {    //���� �� �� ���� pop
			System.out.print((char)stack.pop().intValue());
		}
	}
	public static boolean isPrime(BigInteger in) {  //�Ҽ����� �Ǻ� �޼ҵ�.
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