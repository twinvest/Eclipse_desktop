import java.util.Scanner;

public class MyFriendInfoBook {
	public static void main(String[] args)
	{
		FriendInfoHandler handler=new FriendInfoHandler(10);
		
		while(true)
		{
			System.out.println("***메뉴선택***");
			System.out.println("1. 고교정보저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 기본 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.println("선택>> ");
			
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
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

}
