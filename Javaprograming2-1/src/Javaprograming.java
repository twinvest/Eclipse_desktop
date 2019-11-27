import java.util.Scanner;

public class Javaprograming {
	
	public static void main(String[] args) {
		int N;
		int K;
		int currentpeople;
		int group=0;
		
		Scanner scan = new Scanner(System.in);
		Bus bus = new Bus();
		System.out.print(">>");
		while(true)  //입력받기
		{
			N = scan.nextInt();
			K = scan.nextInt();
			if(N>=0 && N<=100 && K>=1 && K<=50)
				break;
		}
		System.out.print(">> ");
		for(int i=0; i<N; i++)
		{
			currentpeople = scan.nextInt();
			group = group + bus.recursiveFunc(currentpeople, K);
		}
		if(Bus.people%K != 0)
			group++;
		System.out.println("정답: "+group+"회");
	}
}

class Bus
{
	public static int people;		
	int recursiveFunc(int currentpeople, int limit)
	{
		int previouspeople;
		int group=0;
		int carry;
		
		people = people + currentpeople;
		if(limit == people)
		{
			people = 0;
			group++;
		}
		else if(people>limit)
		{
			if(currentpeople == limit)//여기가 잘못됨
			{
				previouspeople = 0;
				people=0;
				group = recursiveFunc(previouspeople, limit);
				group++;
				group++;
			}
			else if(currentpeople>limit)
			{
				people = people - currentpeople;
				carry = limit - people;
				previouspeople = currentpeople - carry;
				people=0;
				group = recursiveFunc(previouspeople, limit);
				group++;
			}
			
			else
			{
				previouspeople = currentpeople;
				people=0;
				group = recursiveFunc(previouspeople, limit);
				group++;
			}
		}
		return group;
	}
}