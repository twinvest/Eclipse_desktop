import java.util.Scanner;

public class Javaprograming2 {

	public static void main(String[] args) {
		
		int N=0, K=0, result=0, group = 0, temp1=0, temp2=0, carry=0;
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			N = scan.nextInt();
			K = scan.nextInt();
			if(N>=0 && N<=100 && K>=1 && K<=50)
				break;
		}
		for(int i=0; i<N; i++)
		{
			temp1 = scan.nextInt();
			result = temp1 + temp2;
			if(temp1==K)
			{
				group++;
				continue;
			}
				
			if(result > K)
			{
				if(temp1 > K)
				{
					carry = K - temp2;
					group++;
					result = 0;
					temp2 = temp1-carry;
					while(true)
					{
						if(temp2<K)
							break;
						else
						{
							group++;
							result=0;
							temp2 = temp2-K;
						}
						
					}
				}
				else
				{
					group++; 
					result=0;
					temp2 = temp1;
				}
			}
			else
			{
				temp2 = result;
				continue;
			}
		}
		if(temp2>0)
			group++;
		System.out.println(group);
	}
}