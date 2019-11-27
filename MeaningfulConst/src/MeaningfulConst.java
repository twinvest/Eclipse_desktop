import java.util.Scanner;

public class MeaningfulConst {

	public static void main(String[] args) {
		System.out.println("오늘의 요일을 선택하세요. ");
		System.out.println("1.월요일, 2.화요일, 3.수요일, 4.목요일 ");
		System.out.println("5.금요일, 6.토요일, 7.일요일 ");
		System.out.println("선택 : ");
		
		Scanner sc=new Scanner(System.in);
		int sel=sc.nextInt();
		
		
		switch(sel)
		{
		case Week.MON :
			System.out.println("주간회의가 있습니다.");
			break;
		case Week.TUE :
			System.out.println("프로젝트 기획 회의가 있습니다.");
			break;
		case Week.WED :
			System.out.println("진행사항 보고하는 날입니다.");
			break;
		case Week.THU :
			System.out.println("사내축구시합이 있는 날입니다.");
			break;
		case Week.FRI :
			System.out.println("프로젝트 마감일입니다.");
			break;
		case Week.SAT :
			System.out.println("가족과 함께 즐거운 시간을 보내세요.");
			break;
		case Week.SUN :
			System.out.println("오늘은 휴일입니다.");
			break;
		}
		
	}

}
