import java.util.Scanner;

public class MyFriendInfoBook {
	public static void main(String[] args)
	{
		FriendInfoHandler handler=new FriendInfoHandler(10);
		
		while(true)
		{
			System.out.println("***�޴�����***");
			System.out.println("1. ����������");
			System.out.println("2. ���� ģ�� ����");
			System.out.println("3. ��ü ���� ���");
			System.out.println("4. �⺻ ���� ���");
			System.out.println("5. ���α׷� ����");
			System.out.println("����>> ");
			
			Scanner sc=new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1 : case 2 :
				handler.addFriend(choice);
				break;
			
			case 3 :
				handler.showAllData();
				break;
			
			case 4 :
				handler.showAllSimpleData();
				break;
				
			case 5 :
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}
	}

}
